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
 * @日期：2018年8月7日
 * @描述：评论接口
 */
@RestController
@RequestMapping("/community")
public class CommentController {
	private static Logger LOG = Logger.getLogger(CommentController.class);
	
	@Autowired
	private StoreTopicPostService storeTopicPostService;
	
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月7日
	 * @描述：普通用户跟贴（评论）
	 */
	@PostMapping("/commentCreate")
	public MsgReturn<TopicPostVo> commentCreate(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			TopicPostVo vo = storeTopicPostService.commentAdd(topicPostParams);
			// 3.把对象设置进返回消息中
			if(vo==null) {
				msg.failed("评论失败");
			}else {
				msg.setReturnObj(vo);
				msg.success("评论成功");
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
	 * @日期：2018年8月10日
	 * @描述：分页查询跟帖（评论）
	 */
	@PostMapping("/commentPagingQuery")
	public MsgReturn<Page<TopicPostVo>> commentPagingQuery(TopicPostParams topicPostParams) {
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
			Page<TopicPostVo> page = storeTopicPostService.commentPagingQuery(topicPostParams);
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
	 * @日期：2018年8月16日
	 * @描述：修改评论（待发布）---后台
	 */
	@PostMapping("/commentUpdate")
	public MsgReturn<TopicPostVo> commentUpdate(TopicPostParams topicPostParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是帖子 Vo）
		MsgReturn<TopicPostVo> msg = new MsgReturn<TopicPostVo>();
		try {
			//2.处理业务逻辑
			 int reslut = storeTopicPostService.commentModify(topicPostParams);
			// 3.把对象设置进返回消息中
			if(reslut>0) {
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
}
