package com.pdd.community.api.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pdd.common.core.exceptions.BizException;
import com.pdd.community.api.service.StoreTopicUserLikeService;
import com.pdd.community.common.constants.Constants;
import com.pdd.community.common.params.UserLikeParams;
import com.pdd.community.common.po.StoreTopicPost;
import com.pdd.community.common.po.StoreTopicUserLike;
import com.pdd.community.common.po.StoreTopicUserLikeExample;
import com.pdd.community.common.vo.UserLikeVo;
import com.pdd.community.service.mapper.StoreTopicPostMapper;
import com.pdd.community.service.mapper.StoreTopicUserLikeMapper;

@Service("storeTopicUserLikeService")
public class StoreTopicUserLikeServiceImpl implements StoreTopicUserLikeService {

	@Autowired
	private StoreTopicPostMapper storeTopicPostMapper;
	@Autowired
	private StoreTopicUserLikeMapper storeTopicUserLikeMapper;
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月10日
	 * @描述：用户点赞和取消点赞共用
	 */
	@Override
	public UserLikeVo userLike(UserLikeParams userLikeParams) throws Exception {
		StoreTopicUserLike userLike = new StoreTopicUserLike();
		StoreTopicPost topicPost = storeTopicPostMapper.selectByPrimaryKey(userLikeParams.getTopicPostId());
		// 判断是否为有效主帖
		if (topicPost.getType().equals(Constants.DB_STORETOPICPOST_TYPE_TOPIC)
				&& topicPost.getStatus().equals(Constants.DB_STORETOPICPOST_STATUS_BEENPUBLISHED)) {
			StoreTopicUserLikeExample example = new StoreTopicUserLikeExample();
			example.createCriteria().andTopicPostIdEqualTo(userLikeParams.getTopicPostId())
					.andUserIdEqualTo(userLikeParams.getUserId());
			// 查询该用户对该主帖是否已点赞
			List<StoreTopicUserLike> likeList = storeTopicUserLikeMapper.selectByExample(example);
			//该用户没有对给帖子点过赞的情况下
			if (likeList == null || likeList.isEmpty()) {
				userLike.setUserId(userLikeParams.getUserId());
				userLike.setTopicPostId(userLikeParams.getTopicPostId());
				userLike.setStatus(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_LIKE);
				// 插入到数据库
				int count = storeTopicUserLikeMapper.insertSelective(userLike);
				if (count > 0) {
					//帖子表的点赞数加1
					topicPost.setLikeCount(topicPost.getLikeCount() + 1);
					storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
					UserLikeVo vo = new UserLikeVo();
					BeanUtils.copyProperties(userLike, vo);
					//设置点赞数
					vo.setLikeCount(topicPost.getLikeCount());
					return vo;
				} else {
					throw BizException.DB_INSERT_RESULT_0;
				}
			
			//该用户对该帖子点过赞的情况下
			}else {
				for(StoreTopicUserLike list:likeList) {
					//判断状态是否为已取消，是则可以点赞，不是则不能点赞而是取消点赞
					if(list.getStatus().equals(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_NOLIKE)) {
						userLike.setStatus(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_LIKE);
						int count = storeTopicUserLikeMapper.updateByExampleSelective(userLike, example);
						if(count>0) {
							//帖子表的点赞数加1
							topicPost.setLikeCount(topicPost.getLikeCount() + 1);
							storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
							UserLikeVo vo = new UserLikeVo();
							BeanUtils.copyProperties(userLikeParams, vo);
							vo.setId(list.getId());
							vo.setStatus(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_LIKE);
							//设置点赞数
							vo.setLikeCount(topicPost.getLikeCount());
							return vo;
						}else {
							throw BizException.DB_UPDATE_RESULT_0;
						}
					//取          消             点                赞!!!
					}else {
						userLike.setStatus(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_NOLIKE);
						int count = storeTopicUserLikeMapper.updateByExampleSelective(userLike, example);
						if(count>0) {
							//帖子表的点赞数减1
							topicPost.setLikeCount(topicPost.getLikeCount() - 1);
							storeTopicPostMapper.updateByPrimaryKeySelective(topicPost);
							UserLikeVo vo = new UserLikeVo();
							BeanUtils.copyProperties(userLikeParams, vo);
							vo.setId(list.getId());
							vo.setStatus(Constants.DB_STORE_TOPIC_USER_LIKE_STATUS_NOLIKE);
							//设置点赞数
							vo.setLikeCount(topicPost.getLikeCount());
							return vo;
						}else {
							throw BizException.DB_UPDATE_RESULT_0;
						}
					}
				}
			}
		}
		
		return null;
	}
	



}
