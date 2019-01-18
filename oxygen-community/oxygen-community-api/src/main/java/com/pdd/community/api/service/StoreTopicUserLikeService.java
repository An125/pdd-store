package com.pdd.community.api.service;

import com.pdd.community.common.params.UserLikeParams;
import com.pdd.community.common.vo.UserLikeVo;

public interface StoreTopicUserLikeService {

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月10日
	 * @描述：用户点赞和取消点赞共用
	 */
	public UserLikeVo userLike(UserLikeParams userLikeParams) throws Exception;
	

}
