package com.pdd.community.webServer.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pdd.common.core.params.returns.MsgReturn;
import com.pdd.community.api.service.StoreTopicUserLikeService;
import com.pdd.community.common.params.UserLikeParams;
import com.pdd.community.common.vo.UserLikeVo;

/**
 * 
 * @作者： ppx
 * @日期：2018年8月10日
 * @描述：点赞接口
 */
@RestController
@RequestMapping("/community")
public class UserLikeController {
	private static Logger LOG = Logger.getLogger(UserLikeController.class);
	@Autowired
	private StoreTopicUserLikeService storeTopicUserLikeService;
	
	
	/**
	 * 
	 * @作者： ppx
	 * @日期：2018年8月10日
	 * @描述：用户点赞和取消点赞共用
	 */
	@PostMapping("/userLike")
	public MsgReturn<UserLikeVo> userLike(UserLikeParams userLikeParams) {
		// 1、创建新的返回对象（这里泛型指返回消息中带的对象是点赞 Vo）
		MsgReturn<UserLikeVo> msg = new MsgReturn<UserLikeVo>();
		try {
			
			//2.处理业务逻辑
			UserLikeVo vo = storeTopicUserLikeService.userLike(userLikeParams);
			// 3.把对象设置进返回消息中
			if(vo == null) {
				msg.failed("failure");
			}else {
				msg.success("success");
				msg.setReturnObj(vo);
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			msg.exception();
		}
		// 4.将返回的对象返回， 框架自动转成 JSON 对象
		return msg;
		
	}
	
}
