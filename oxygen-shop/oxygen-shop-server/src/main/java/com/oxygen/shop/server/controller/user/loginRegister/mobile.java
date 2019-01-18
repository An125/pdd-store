package com.oxygen.shop.server.controller.user.loginRegister;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.loginRegister.mobileDao;

import net.sf.json.JSONObject;
@Controller
public class mobile {
	@RequestMapping(value = "/mobile", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//判断手机是否存在
	public String mobile1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		try {
			String mobile = String.valueOf(request.getParameter("mobile")); // 手机号
			json = mobileDao.register(mobile); 
			//resMap.put("root", "NO");
			//JSONObject jsonObject = JSONObject.fromObject(resMap);
			return json.toString();
		} catch (Exception e) {
			resMap.put("root", "程序异常");
			JSONObject jsonObject = JSONObject.fromObject(resMap);
			return jsonObject.toString();
		}
	}

	

}