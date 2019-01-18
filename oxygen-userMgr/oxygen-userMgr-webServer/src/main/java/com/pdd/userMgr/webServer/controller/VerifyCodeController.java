package com.pdd.userMgr.webServer.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oxygen.common.util.MobClient;
import com.pdd.common.core.params.returns.MsgReturn;

import net.sf.json.JSONObject;

/**
 * 
 * @作者： zhaoxin
 * @日期：2018年7月23日
 * @描述：验证码校验接口
 */
@RestController
@RequestMapping("/userMgr")
public class VerifyCodeController {

	@RequestMapping("/checkCode")
	public  MsgReturn<Object> checkCode(HttpServletRequest request,String params) throws Exception {
		MsgReturn<Object> msg = new MsgReturn<Object>();
		String address = "https://webapi.sms.mob.com/sms/verify";
		String result  = MobClient.requestData(address, params);
		System.out.println("--->"+result);
		
		//获取Json字符串中某个key对应的value，这里key是"status"，表示返回的编码
		JSONObject jsonObject = JSONObject.fromObject(result);
		Object value = jsonObject.get("status");
		System.out.println("===>"+value);
		
		//判断返回的编码是否为200，是则验证成功---编码参考mob官网
		if(value.equals(200)) {
			msg.success("校验成功！");
		}else {
			msg.failed("校验失败，请确认验证码是否正确！");
		}
		return msg;
		
	}
}
