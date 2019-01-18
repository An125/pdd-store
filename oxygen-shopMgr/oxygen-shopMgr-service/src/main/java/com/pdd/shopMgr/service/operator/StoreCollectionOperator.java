package com.pdd.shopMgr.service.operator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.pdd.common.core.exceptions.BizException;
import com.pdd.common.core.params.page.Page;
import com.pdd.shopMgr.common.params.CollectionParams;
import com.pdd.shopMgr.common.vo.CollectionVo;
import com.pdd.shopMgr.common.vo.GoodsVo;
import com.pdd.shopMgr.service.mapper.StoreCollectionMapper;
import com.pdd.shopMgr.service.mapper.StoreGoodsMapper;
import com.pdd.shopMgr.service.mapper.StoreShopGoodsRelationMapper;
import com.pdd.shopMgr.service.mapper.StoreUserMapper;
import com.pdd.shopMgr.service.po.StoreCollection;
import com.pdd.shopMgr.service.po.StoreCollectionExample;
import com.pdd.shopMgr.service.po.StoreGoods;
import com.pdd.shopMgr.service.po.StoreGoodsExample;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelation;
import com.pdd.shopMgr.service.po.StoreShopGoodsRelationExample;
import com.pdd.shopMgr.service.po.StoreUser;
import com.pdd.shopMgr.service.po.StoreUserExample;

/**
 * 
 * @作者： ppx
 * @日期：2018年9月13日
 * @描述：收藏夹相关业务 ---- 服务层
 */
@Service("storeCollectionOperator")
public class StoreCollectionOperator {
	
	@Autowired
	private StoreUserMapper storeUserMapper;
	
	@Autowired
	private StoreCollectionMapper storeCollectionMapper;
	
	@Autowired
	private StoreShopGoodsRelationMapper storeShopGoodsRelationMapper;
	
	@Autowired
	private StoreGoodsMapper storeGoodsMapper;
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月12日
	 * @描述：收藏和取消收藏共用---用户只能收藏绑定的商铺下的商品
	 */
	public CollectionVo addOrRemoveCollection(CollectionParams collectionParams) {
		StoreUserExample userExample = new StoreUserExample();
		userExample.createCriteria().andIdEqualTo(collectionParams.getUserId()).andTypeEqualTo(0);
		// 查询普通用户（type为0）是否存在
		List<StoreUser> userList = storeUserMapper.selectByExample(userExample);
		if (userList == null || userList.isEmpty())
			return null;
		for (StoreUser user : userList) {
			StoreShopGoodsRelationExample relationExample = new StoreShopGoodsRelationExample();
			// 添加条件：shopId、goodId、isEnable
			relationExample.createCriteria().andShopIdEqualTo(user.getShopId())
					.andGoodIdEqualTo(collectionParams.getGoodId()).andIsEnableEqualTo((byte) 1);
			// 查询店铺的上架商品
			List<StoreShopGoodsRelation> relationList = storeShopGoodsRelationMapper.selectByExample(relationExample);
			if (relationList == null || relationList.isEmpty())
				return null;
		}
		StoreCollectionExample collectionExample = new StoreCollectionExample();
		collectionExample.createCriteria().andUserIdEqualTo(collectionParams.getUserId())
				.andGoodIdEqualTo(collectionParams.getGoodId());
		// 查询该用户是否收藏过该商品
		List<StoreCollection> collectionList = storeCollectionMapper.selectByExample(collectionExample);
		// 该用户没有收藏的情况
		StoreCollection storeCollection = new StoreCollection();
		if (collectionList == null || collectionList.isEmpty()) {
			// 复制参数属性值
			BeanUtils.copyProperties(collectionParams, storeCollection);
			storeCollection.setStatus(1);
			int count = storeCollectionMapper.insertSelective(storeCollection);
			if (count > 0) {
				CollectionVo vo = new CollectionVo();
				BeanUtils.copyProperties(storeCollection, vo);
				return vo;
			} else {
				throw BizException.DB_INSERT_RESULT_0;
			}

		// 该用户收藏过该商品的情况
		} else {
			for (StoreCollection collection : collectionList) {
				// 判断状态是否为已取消，是则可以收藏，不是则不能收藏而是取消收藏
				if (collection.getStatus().equals(0)) {
					storeCollection.setStatus(1);
					int count = storeCollectionMapper.updateByExampleSelective(storeCollection, collectionExample);
					if (count > 0) {
						CollectionVo vo = new CollectionVo();
						BeanUtils.copyProperties(collection, vo);
						vo.setStatus(1);
						return vo;
					} else {
						throw BizException.DB_UPDATE_RESULT_0;
					}
				// 取 消 收 藏！！！
				} else {
					storeCollection.setStatus(0);
					int count = storeCollectionMapper.updateByExampleSelective(storeCollection, collectionExample);
					if (count > 0) {
						CollectionVo vo = new CollectionVo();
						BeanUtils.copyProperties(collection, vo);
						vo.setStatus(0);
						return vo;
					} else {
						throw BizException.DB_UPDATE_RESULT_0;
					}
				}
			}
			
		}
		return null;
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年9月13日
	 * @描述：分页查询收藏夹（有效的 status==1），也可按类别查询（0失效；1低库存；2降价）
	 */
	public Page<CollectionVo> getCollectionPaging(CollectionParams collectionParams) {
		//查询是否普通用户
		StoreUser storeUser = storeUserMapper.selectByPrimaryKey(collectionParams.getUserId());
		if(storeUser!=null&&storeUser.getType().equals(0)) {
		//没有传入queryType，查询全部
		if(collectionParams.getQueryType()==null) {
			StoreCollectionExample collectionExample = new StoreCollectionExample();
			collectionExample.createCriteria().andUserIdEqualTo(collectionParams.getUserId()).andStatusEqualTo(1);
			//有效总记录数
			int rowCount = storeCollectionMapper.countByExample(collectionExample);
			//分页插件处理
			PageHelper.startPage(collectionParams.getPageNo(), collectionParams.getPageSize());
			//查询收藏的商品
			List<StoreCollection> collectionList = storeCollectionMapper.selectByExample(collectionExample);
			if(collectionList==null||collectionList.isEmpty()) return null;
			Iterator<StoreCollection> iterator = collectionList.iterator();
			//声明一个集合，容量为pageSize，存放vo
			List<CollectionVo> list = new ArrayList<CollectionVo>(collectionParams.getPageSize());
			StoreCollection storeCollection;
			CollectionVo vo;
			//遍历
			while (iterator.hasNext()) {
				storeCollection = iterator.next();
				vo= new CollectionVo();
				BeanUtils.copyProperties(storeCollection, vo);
				//查询商品详情
				StoreGoods storeGoods = storeGoodsMapper.selectByPrimaryKey(storeCollection.getGoodId());
				vo.setGoodName(storeGoods.getGoodName());
				vo.setGoodIntroduce(storeGoods.getGoodIntroduce());
				vo.setPicUrl(storeGoods.getPicUrl());
				//查询商铺商品中间表的出售价格
				StoreShopGoodsRelationExample relationExample = new StoreShopGoodsRelationExample();
				relationExample.createCriteria().andShopIdEqualTo(storeUser.getShopId()).andGoodIdEqualTo(storeCollection.getGoodId());
				List<StoreShopGoodsRelation> relationList = storeShopGoodsRelationMapper.selectByExample(relationExample);
				for(StoreShopGoodsRelation relation : relationList) {
					vo.setPrice(relation.getPrice());
				}
				list.add(vo);
			}
			Page<CollectionVo> page = new Page<CollectionVo>(collectionParams.getPageNo(), collectionParams.getPageSize(), rowCount, list);
			return page;
		//查询失效的	
		}else if(collectionParams.getQueryType().equals(0)) {
			//业务后续加上。。。
			return null;
		//查询低库存的	
		}else if(collectionParams.getQueryType().equals(1)) {
			//业务后续加上。。。
			return null;
		//查询降价的
		}else if(collectionParams.getQueryType().equals(2)) {
			//业务后续加上。。。
			return null;
		}
		}
		return null;
	}
}
