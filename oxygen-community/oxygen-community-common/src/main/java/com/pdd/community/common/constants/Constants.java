package com.pdd.community.common.constants;

/**
 * 
 * @作者： ppx
 * @日期：2018年8月6日
 * @描述：用到的常量
 */
public class Constants {
	
	/**
	 * 数据库字段type---用户身份：普通用户
	 */
	public static final int DB_STOREUSER_TYPE_ORDINARY=0;
	
	
	/**
	 * 数据库字段type---帖子类型：主帖
	 */
	public static final int DB_STORETOPICPOST_TYPE_TOPIC=0;
	/**
	 * 数据库字段type---帖子类型：跟帖（评论）
	 */
	public static final int DB_STORETOPICPOST_TYPE_COMMENT=1;
	
	
	/**
	 * 数据库字段topic_id---主帖id:如果type=0，则为-1；如果type=1，则为id，表示该主帖下的跟帖
	 */
	public static final int DB_STORETOPICPOST_TOPICID_TOPIC=-1;
	
	
	/**
	 * 数据库字段top---是否置顶：否
	 */
	public static final int DB_STORETOPICPOST_TOP_NOTOP=0;
	/**
	 * 数据库字段top---是否置顶：是
	 */
	public static final int DB_STORETOPICPOST_TOP_SETTOP=1;
	
	
	
	/**
	 * 数据库字段status---帖子状态:待发布
	 */
	public static final int DB_STORETOPICPOST_STATUS_UNPUBLISHED=0;
	/**
	 * 数据库字段status---帖子状态:已发布
	 */
	public static final int DB_STORETOPICPOST_STATUS_BEENPUBLISHED=1;
	/**
	 * 数据库字段status---帖子状态:已删除
	 */
	public static final int DB_STORETOPICPOST_STATUS_BEENDELETED=2;
	
	
	/**
	 * 请求参数（sortType）---排序类型:按时间排序
	 */
	public static final int SORTTYPE_BYTIME=0;
	/**
	 * 请求参数 （sortType）---排序类型：按热度排序
	 */
	public static final int SORTTYPE_BYHOT=1;
	
	
	/**
	 * 排序参数（orderString）---排序类型:按时间
	 */
	public static final String ORDERSTRING_BYTIME="create_time";
	/**
	 * 排序参数（orderString）---排序类型:按热度（回帖数+点赞数）
	 */
	public static final String ORDERSTRING_BYHOT="reply_count+like_count";
	/**
	 * 排序参数（orderDirection）---排序方式：升序
	 */
	public static final String ORDERDIRECTION_ASC="asc";
	/**
	 * 排序参数（orderDirection）---排序方式：降序
	 */
	public static final String ORDERDIRECTION_DESC="desc";
	
	
	/**
	 * 数据库字段status---点赞状态：已取消
	 */
	public static final int DB_STORE_TOPIC_USER_LIKE_STATUS_NOLIKE=0;
	/**
	 * 数据库字段status---点赞状态：已点赞
	 */
	public static final int DB_STORE_TOPIC_USER_LIKE_STATUS_LIKE=1;
	
	
	/**
	 * 请求参数（type）---类型：取消点赞
	 */
	public static final int USERLIKE_TYPE_NOLIKE=0;
	/**
	 * 请求参数（type）---类型：点赞
	 */
	public static final int USERLIKE_TYPE_LIKE=1;
}
