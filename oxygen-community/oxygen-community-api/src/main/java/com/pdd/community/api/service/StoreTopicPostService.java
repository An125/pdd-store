package com.pdd.community.api.service;

import com.pdd.common.core.params.page.Page;
import com.pdd.community.common.params.TopicPostParams;
import com.pdd.community.common.vo.TopicPostVo;

public interface StoreTopicPostService {
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月6日
	 * @描述：商户发帖
	 */
	public TopicPostVo postAdd(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月7日
	 * @描述：普通用户跟帖（评论）
	 */
	public TopicPostVo commentAdd(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月8日
	 * @描述：分页查询所有主帖并排序（排序类型，0时间，1热度---回帖数+点赞数）
	 */
	public Page<TopicPostVo> postPagingQuery(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月10日
	 * @描述：分页查询跟帖（评论）
	 */
	public Page<TopicPostVo> commentPagingQuery(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：审核帖子和评论---后台
	 */
	public int postVerify(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：删除帖子和评论---后台
	 */
	public int postRemove(TopicPostParams topicPostParams) throws Exception;
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：修改主帖---后台
	 */
	public int topicPostModify(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：修改评论---后台
	 */
	public int commentModify(TopicPostParams topicPostParams) throws Exception;
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月15日
	 * @描述：主帖置顶---后台
	 */
	public int setTop(TopicPostParams topicPostParams) throws Exception;

	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：取消置顶---后台
	 */
	public int removeTop(TopicPostParams topicPostParams) throws Exception;



}
