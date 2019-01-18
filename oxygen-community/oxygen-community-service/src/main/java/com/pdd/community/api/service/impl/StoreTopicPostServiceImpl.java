package com.pdd.community.api.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.community.api.service.StoreTopicPostService;
import com.pdd.community.common.constants.Constants;
import com.pdd.community.common.params.TopicPostParams;
import com.pdd.community.common.po.StoreGoods;
import com.pdd.community.common.po.StoreGoodsPrice;
import com.pdd.community.common.po.StoreGoodsPriceExample;
import com.pdd.community.common.po.StoreTopicPost;
import com.pdd.community.common.po.StoreTopicPostExample;
import com.pdd.community.common.po.StoreUser;
import com.pdd.community.common.vo.TopicPostVo;
import com.pdd.community.service.mapper.StoreGoodsMapper;
import com.pdd.community.service.mapper.StoreGoodsPriceMapper;
import com.pdd.community.service.mapper.StoreTopicPostMapper;
import com.pdd.community.service.mapper.StoreUserMapper;

@Service("storeTopicPostService")
public class StoreTopicPostServiceImpl implements StoreTopicPostService {
	@Autowired
	private StoreUserMapper storeUserMapper;
	
	@Autowired
	private StoreTopicPostMapper storeTopicPostMapper;
	
	@Autowired
	private StoreGoodsMapper storeGoodsMapper;
	
	@Autowired
	private StoreGoodsPriceMapper storeGoodsPriceMapper;
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月6日
	 * @描述：商户发帖
	 */
	@Override
	public TopicPostVo postAdd(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost topicPost = new StoreTopicPost();
		// 查询用户
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(topicPostParams.getUserId());
		// 判断用户身份，普通用户的情况下
		if (storeUser.getType().equals(Constants.DB_STOREUSER_TYPE_ORDINARY)) {
			return null;
			// 用户是商家的情况下
		} else {
			// 文字限制为500字
			if (topicPostParams.getContent().length() <= 500) {
				topicPost.setUserId(topicPostParams.getUserId());
				// 类型设为主帖
				topicPost.setType(Constants.DB_STORETOPICPOST_TYPE_TOPIC);
				// 设置为待发布---需要审核通过后改为已发布
				topicPost.setStatus(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED);
				//设置置顶，默认不置顶
				topicPost.setTop(Constants.DB_STORETOPICPOST_TOP_NOTOP);
				// 设置标题---选填
				topicPost.setTitle(topicPostParams.getTitle());
				// 设置内容
				topicPost.setContent(topicPostParams.getContent());
				// 设置产品id---选填
				topicPost.setGoodId(topicPostParams.getGoodId());
				// 设置图片---选填
				topicPost.setPics(topicPostParams.getPics());
				// 设置视频链接---选填
				topicPost.setVideo(topicPostParams.getVideo());
				// 设置主帖id（如果type=0，则为-1,表示该帖子为主帖；如果type=1，则为id，表示主帖为id下的跟帖）
				topicPost.setTopicId(Constants.DB_STORETOPICPOST_TOPICID_TOPIC);
				Date date = new Date();
				topicPost.setCreateTime(date);
				// 插入到数据库
				int count = storeTopicPostMapper.insertSelective(topicPost);
				if (count > 0) {
					TopicPostVo vo = new TopicPostVo();
					BeanUtils.copyProperties(topicPost, vo);
					return vo;
				} else {
					throw BizException.DB_INSERT_RESULT_0;
				}
			}
			return null;
		}

	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月7日
	 * @描述：普通用户跟帖（评论）
	 */
	@Override
	public TopicPostVo commentAdd(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost topicPost = new StoreTopicPost();
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(topicPostParams.getUserId());
		// 判断是否为普通用户
		if (storeUser.getType().equals(Constants.DB_STOREUSER_TYPE_ORDINARY)) {
			// 根据id查主帖
			StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
			if (post != null&&post.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)) {
				// 文字限制100字
				if (topicPostParams.getContent().length() <=100) {
					topicPost.setUserId(topicPostParams.getUserId());
					// 设为跟帖（评论）
					topicPost.setType(Constants.DB_STORETOPICPOST_TYPE_COMMENT);
					// 把TopicId设为id 表示该评论是主帖为id下的评论
					topicPost.setTopicId(topicPostParams.getId());
					// 设置为待发布---需要审核通过后改为已发布
					topicPost.setStatus(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED);
					// 设置内容
					topicPost.setContent(topicPostParams.getContent());
					// 设置图片---选填
					topicPost.setPics(topicPostParams.getPics());
					Date date = new Date();
					topicPost.setCreateTime(date);
					
					// 插入到数据库
					int count = storeTopicPostMapper.insertSelective(topicPost);
					if (count > 0) {
						TopicPostVo vo = new TopicPostVo();
						BeanUtils.copyProperties(topicPost, vo);
						
						//对主帖进行操作
						StoreTopicPost storeTopicPost = new StoreTopicPost();
						BeanUtils.copyProperties(topicPostParams, storeTopicPost);
						//主帖的回帖数加1
						storeTopicPost.setReplyCount(post.getReplyCount() + 1);
						storeTopicPostMapper.updateByPrimaryKeySelective(storeTopicPost);
						return vo;
					} else {
						throw BizException.DB_INSERT_RESULT_0;
					}
				}
			}
			return null;

			
		} 
			return null;

		
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月8日
	 * @描述：分页查询所有主帖并排序（排序类型，0时间，1热度---回帖数+点赞数）
	 * 		type为0是主帖
	 */
	@Override
	public Page<TopicPostVo> postPagingQuery(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPostExample example = new StoreTopicPostExample();
		// type为0才是主帖，且状态必须是已发布
		example.createCriteria().andTypeEqualTo(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				.andStatusEqualTo(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED);

		// 判断排序类型 :如果传入的参数sortType为0，则按时间降序
		if (topicPostParams.getSortType().equals(Constants.SORTTYPE_BYTIME)) {
			// Mybatis+PageHelper查询结果排序两种方式：
			// 方法一：使用Mybatis排序 :第一个参数为排序依据的字段名，第二个参数为排序规律，desc为降序，asc为升序。中间空格隔开
			example.setOrderByClause(Constants.ORDERSTRING_BYTIME + " " + Constants.ORDERDIRECTION_DESC);
			// 查询有效总条数
			int rowCount = storeTopicPostMapper.countByExample(example);

			// 分页插件处理
			PageHelper.startPage(topicPostParams.getPageNo(), topicPostParams.getPageSize());
			/*
			 * //方法二：使用PageHelper排序(Pagehelper的版本需在5.1.2及以上)
			 * ：第一个为排序依据的字段名，第二个为排序规律，desc为降序，asc为升序。
			 * PageHelper.orderBy("create_time desc"); //或者一步到位 String
			 * orderBy="create_time desc"; PageHelper.startPage(pageNum, pageSize, orderBy);
			 */

			List<StoreTopicPost> postList = storeTopicPostMapper.selectByExample(example);
			if (postList == null || postList.isEmpty()) {
				return null;
			}

			Iterator<StoreTopicPost> iterator = postList.iterator();
			List<TopicPostVo> list = new ArrayList<TopicPostVo>(topicPostParams.getPageSize());
			StoreTopicPost storeTopicPost = null;
			TopicPostVo topicPostVo = null;
			// 迭代器遍历list集合
			while (iterator.hasNext()) {
				// next()方法获取下一个元素
				storeTopicPost = iterator.next();
				topicPostVo = new TopicPostVo();
				BeanUtils.copyProperties(storeTopicPost, topicPostVo);

				// 根据迭代器遍历得到的userId查询出用户名、头像信息随Vo返回出去
				StoreUser storeUser = storeUserMapper.selectByPrimaryKey(topicPostVo.getUserId());
				// 这里不要使用BeanUtils.copyProperties()来复制属性值，否则StoreUser里id会覆盖TopicPostVo里id，且俩id是不同的
				topicPostVo.setUsername(storeUser.getUsername());
				topicPostVo.setTxpath(storeUser.getTxpath());

				// 判断遍历得到的商品id是否为空
				if (storeTopicPost.getGoodId() != null) {
					// 根据遍历得到的商品id查询商品信息
					StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeTopicPost.getGoodId());
					topicPostVo.setGoodName(storeGoods.getGoodName());
					topicPostVo.setGoodIntroduce(storeGoods.getGoodIntroduce());
					topicPostVo.setPicUrl(storeGoods.getPicUrl());
					//根据遍历得到的商品id和绑定在用户下的shopId查询商品价格表中的报价
					StoreGoodsPriceExample priceExample = new StoreGoodsPriceExample();
					priceExample.createCriteria().andGoodIdEqualTo(storeTopicPost.getGoodId()).andShopIdEqualTo(storeUser.getShopId());
					List<StoreGoodsPrice> priceList = storeGoodsPriceMapper.selectByExample(priceExample);
					for(StoreGoodsPrice price : priceList) {
						topicPostVo.setQuotePrice(price.getQuotePrice());
					}
				}
				list.add(topicPostVo);
			}
			// 当PageParam里接收参数没有设默认值时，且请求参数未携带pageNo、pageSize，导致pageNo、pageSize为0，把Page对象里的值覆盖，日志出现“by zero”
			// 2018-08-09 14:56:08 [INFO]-[com.pdd.community.webServer.controller.PostPagingQueryController] / by zero
			Page<TopicPostVo> page = new Page<TopicPostVo>(topicPostParams.getPageNo(), topicPostParams.getPageSize(),
					rowCount, list);

			return page;
		 
		//如果传入的参数sortType为1，则按热度降序
		}else if(topicPostParams.getSortType().equals(Constants.SORTTYPE_BYHOT)) {
			// 排序
			example.setOrderByClause(Constants.ORDERSTRING_BYHOT + " " + Constants.ORDERDIRECTION_DESC);
			// 查询有效总条数
			int rowCount = storeTopicPostMapper.countByExample(example);
			// 分页插件处理
			PageHelper.startPage(topicPostParams.getPageNo(), topicPostParams.getPageSize());
			List<StoreTopicPost> postList = storeTopicPostMapper.selectByExample(example);
			if (postList == null || postList.isEmpty()) {
				return null;
			}
			Iterator<StoreTopicPost> iterator = postList.iterator();
			List<TopicPostVo> list = new ArrayList<TopicPostVo>(topicPostParams.getPageSize());
			StoreTopicPost storeTopicPost = null;
			TopicPostVo topicPostVo = null;
			while (iterator.hasNext()) {
				storeTopicPost = iterator.next();
				topicPostVo = new TopicPostVo();
				BeanUtils.copyProperties(storeTopicPost, topicPostVo);

				// 根据迭代器遍历得到的userId查询出用户名、头像信息随Vo返回出去
				StoreUser storeUser = storeUserMapper.selectByPrimaryKey(topicPostVo.getUserId());
				// 这里不要使用BeanUtils.copyProperties()来复制属性值，否则StoreUser里id会覆盖TopicPostVo里id，且俩id是不同的
				topicPostVo.setUsername(storeUser.getUsername());
				topicPostVo.setTxpath(storeUser.getTxpath());
				// 判断遍历得到的商品id是否为空
				if (storeTopicPost.getGoodId() != null) {

					// 根据遍历得到的商品id查询商品信息
					StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeTopicPost.getGoodId());
					topicPostVo.setGoodName(storeGoods.getGoodName());
					topicPostVo.setGoodIntroduce(storeGoods.getGoodIntroduce());
					topicPostVo.setPicUrl(storeGoods.getPicUrl());
					//根据遍历得到的商品id和绑定在用户下的shopId查询商品价格表中的报价
					StoreGoodsPriceExample priceExample = new StoreGoodsPriceExample();
					priceExample.createCriteria().andGoodIdEqualTo(storeTopicPost.getGoodId()).andShopIdEqualTo(storeUser.getShopId());
					List<StoreGoodsPrice> priceList = storeGoodsPriceMapper.selectByExample(priceExample);
					for(StoreGoodsPrice price : priceList) {
						topicPostVo.setQuotePrice(price.getQuotePrice());
					}
				}

				list.add(topicPostVo);
			}
			Page<TopicPostVo> page = new Page<TopicPostVo>(topicPostParams.getPageNo(), topicPostParams.getPageSize(),
					rowCount, list);
			return page;
		}

		return null;
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月10日
	 * @描述：分页查询跟帖（评论）
	 */
	@Override
	public Page<TopicPostVo> commentPagingQuery(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPostExample example = new StoreTopicPostExample();
		// 根据id查询帖子
		StoreTopicPost topicPost = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为有效的主帖
		if (topicPost.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				&& topicPost.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED)) {
			// 查询评论 id=topicId才是评论,且状态必须是已发布
			example.createCriteria().andTopicIdEqualTo(topicPostParams.getId())
					.andStatusEqualTo(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED);
			// 默认按时间降序 ,第一个参数为排序依据的字段名，第二个参数为排序规律，desc为降序，asc为升序。中间空格隔开
			example.setOrderByClause(Constants.ORDERSTRING_BYTIME + " " + Constants.ORDERDIRECTION_DESC);
			// 查询有效总条数
			int rowCount = storeTopicPostMapper.countByExample(example);
			// 分页插件处理
			PageHelper.startPage(topicPostParams.getPageNo(), topicPostParams.getPageSize());
			List<StoreTopicPost> commentList = storeTopicPostMapper.selectByExample(example);
			if (commentList == null || commentList.isEmpty()) {
				return null;
			}
			Iterator<StoreTopicPost> iterator = commentList.iterator();
			List<TopicPostVo> list = new ArrayList<TopicPostVo>(topicPostParams.getPageSize());
			StoreTopicPost storeTopicPost = null;
			TopicPostVo topicPostVo = null;
			while (iterator.hasNext()) {
				storeTopicPost = iterator.next();
				topicPostVo = new TopicPostVo();
				BeanUtils.copyProperties(storeTopicPost, topicPostVo);
				
				//根据迭代器遍历得到的userId查询出用户名、头像信息随Vo返回出去
				StoreUser storeUser = storeUserMapper.selectByPrimaryKey(storeTopicPost.getUserId());
				//这里不要使用BeanUtils.copyProperties()来复制属性值，否则StoreUser里id会覆盖TopicPostVo里id，且俩id是不同的
				topicPostVo.setUsername(storeUser.getUsername());
				topicPostVo.setTxpath(storeUser.getTxpath());
				
				list.add(topicPostVo);
			}
			// 当PageParam里接收参数没有设默认值时，且请求参数未携带pageNo、pageSize，导致pageNo、pageSize为0，把Page对象里的值覆盖，日志出现“by zero”
			// 2018-08-09 14:56:08 [INFO]-[com.pdd.community.webServer.controller.PostPagingQueryController] /by zero
			Page<TopicPostVo> page = new Page<TopicPostVo>(topicPostParams.getPageNo(), topicPostParams.getPageSize(),
					rowCount, list);
			return page;
		}
		return null;
	}

	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：审核帖子和评论（待发布）---后台
	 */
	@Override
	public int postVerify(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为待发布的主帖或评论
		if (post.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED)) {
			StoreTopicPost topicPost = new StoreTopicPost();
			//把id属性值赋给topicPost的id
			BeanUtils.copyProperties(topicPostParams, topicPost);
			topicPost.setStatus(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED);
			return storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
		}
		return 0;
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：修改主帖（必须是待发布，已发布、已删除不可修改）---后台
	 */
	@Override
	public int topicPostModify(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost topicPost = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为待发布的主帖
		if (topicPost.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				&& topicPost.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED)) {
			StoreTopicPost storeTopicPost = new StoreTopicPost();
			//复制参数属性值
			BeanUtils.copyProperties(topicPostParams, storeTopicPost);
			int count = storeTopicPostMapper.updateByPrimaryKeySelective(storeTopicPost);
			if(count>0) {
				return count;
			}else {
				throw BizException.DB_UPDATE_RESULT_0;
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：修改评论（必须是待发布，已发布、已删除不可修改）---后台
	 */
	@Override
	public int commentModify(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为待发布的评论
		if (post.getType().equals(Constants.DB_STORETOPICPOST_TYPE_COMMENT)
				&& post.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED)) {
			StoreTopicPost storeTopicPost = new StoreTopicPost();
			//复制参数属性值
			BeanUtils.copyProperties(topicPostParams, storeTopicPost);
			int count = storeTopicPostMapper.updateByPrimaryKeySelective(storeTopicPost);
			if(count>0) {
				return count;
			}else {
				throw BizException.DB_UPDATE_RESULT_0;
			}
		}
		return 0;
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：删除帖子和评论（必须是待发布，已发布不可删除）---后台
	 */
	@Override
	public int postRemove(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为待发布的主帖或评论
		if (post.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_UNPUBLISHED)) {
			StoreTopicPost topicPost = new StoreTopicPost();
			//把接受参数id属性值赋给topicPost的id
			BeanUtils.copyProperties(topicPostParams, topicPost);
			topicPost.setStatus(Constants.DB_STORETOPICPOST_STATUS_BEENDELETED);
			return storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
		}
		return 0;
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月15日
	 * @描述：主帖置顶---后台
	 */
	@Override
	public int setTop(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为已发布的主帖
		if (post.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				&& post.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED)) {
			//判断是否已经置顶
			if(post.getTop().equals(Constants.DB_STORETOPICPOST_TOP_NOTOP)) {
			StoreTopicPost topicPost = new StoreTopicPost();
			// 把接收参数id属性值赋给topicPost的id
			BeanUtils.copyProperties(topicPostParams, topicPost);
			//修改top为置顶
			topicPost.setTop(Constants.DB_STORETOPICPOST_TOP_SETTOP);
			return storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
			}
		}
		return 0;
	}

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：取消置顶---后台
	 */
	@Override
	public int removeTop(TopicPostParams topicPostParams) throws Exception {
		StoreTopicPost post = storeTopicPostMapper.selectByPrimaryKey(topicPostParams.getId());
		// 判断是否为已发布的主帖
		if (post.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				&& post.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED)) {
			//判断是否已经置顶
			if(post.getTop().equals(Constants.DB_STORETOPICPOST_TOP_SETTOP)) {
			StoreTopicPost topicPost = new StoreTopicPost();
			// 把接收参数id属性值赋给topicPost的id
			BeanUtils.copyProperties(topicPostParams, topicPost);
			//修改top为置顶
			topicPost.setTop(Constants.DB_STORETOPICPOST_TOP_NOTOP);
			return storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
			}
		}
		return 0;
	}



	
	
}
