package com.pdd.community.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.page.Page;
import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.community.api.service.StoreTopicPostService;
import com.pdd.community.common.params.TopicPostParams;
import com.pdd.community.common.vo.TopicPostVo;

/**
 * 
 * @作者： ppx
 * @日期：2018年8月13日
 * @描述：帖子接口
 */
@RestController
@RequestMapping("/community")
public class TopicPostController {
	private static Logger LOG = Logger.getLogger(TopicPostController.class);
	
	@Autowired
	private StoreTopicPostService storeTopicPostService;
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月6日
	 * @描述：商户发帖
	 */
	@PostMapping("/postCreate")
	public MsgReturn<TopicPostVo> postCreate(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			TopicPostVo vo = storeTopicPostService.postAdd(topicPostParams);
			// 3.把对象设置进返回消息中
			if(vo==null) {
				msg.failed("发帖失败");
			}else {
				msg.setReturnObj(vo);
				msg.success("发帖成功");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月8日
	 * @描述：分页查询所有主帖并排序（排序类型，0时间，1热度---回帖数+点赞数）
	 */
	@PostMapping("/postPagingQuery")
	public MsgReturn<Page<TopicPostVo>> postPagingQuery(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<Page<TopicPostVo>> msg = new MsgReturn<Page<TopicPostVo>>();
		try {
			
			/*//2.参数校验  ---如果PageParam已有默认值则无需校验
			if(topicPostParams.getPageNo()==0) {
				topicPostParams.setPageNo(1);
			}else if(topicPostParams.getPageSize()==0) {
				topicPostParams.setPageSize(10);
			}*/
			
			//3.处理业务逻辑
			Page<TopicPostVo> page = storeTopicPostService.postPagingQuery(topicPostParams);
			// 4.把对象设置进返回消息中
			if(page==null) {
				msg.failed("没有您要的数据");
			}else {
				msg.setReturnObj(page);
				msg.success("请求成功");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 5.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：审核帖子和评论---后台
	 */
	@PostMapping("/postCheck")
	public MsgReturn<TopicPostVo> postCheck(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int result = storeTopicPostService.postVerify(topicPostParams);
			// 3.把对象设置进返回消息中
			if(result>0) {
				msg.success("审核通过");
			}else {
				msg.failed("审核不通过");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：修改主帖---后台
	 */
	@PostMapping("/topicPostUpdate")
	public MsgReturn<TopicPostVo> topicPostUpdate(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int result = storeTopicPostService.topicPostModify(topicPostParams);
			// 3.把对象设置进返回消息中
			if(result>0) {
				msg.success("修改成功");
			}else {
				msg.failed("修改失败");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月14日
	 * @描述：删除帖子和评论---后台
	 */
	@PostMapping("/postDelete")
	public MsgReturn<TopicPostVo> postDelete(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int result = storeTopicPostService.postRemove(topicPostParams);
			// 3.把对象设置进返回消息中
			if(result>0) {
				msg.success("删除成功");
			}else {
				msg.failed("删除失败");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月15日
	 * @描述：主帖置顶
	 */
	@PostMapping("/setTop")
	public MsgReturn<TopicPostVo> setTop(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int result = storeTopicPostService.setTop(topicPostParams);
			// 3.把对象设置进返回消息中
			if(result>0) {
				msg.success("置顶成功");
			}else {
				msg.failed("置顶失败");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月16日
	 * @描述：取消置顶---后台
	 */
	@PostMapping("/cancelTop")
	public MsgReturn<TopicPostVo> cancelTop(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int result = storeTopicPostService.removeTop(topicPostParams);
			// 3.把对象设置进返回消息中
			if(result>0) {
				msg.success("取消成功");
			}else {
				msg.failed("取消失败");
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
}
