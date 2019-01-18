package com.oxygen.shop.server.controller.user.loginRegister;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.common.po.User;
import com.oxygen.shop.rpc.service.impl.user.loginRegister.registerDao;

import net.sf.json.JSONObject;


@Controller
public class registerAccount {
	@RequestMapping(value="/register" ,produces = "text/plain;charset=UTF-8" ,method = {RequestMethod.POST, RequestMethod.GET})//method = {RequestMethod.POST, RequestMethod.GET}
	@ResponseBody
	public String register(HttpServletRequest request,
			HttpServletResponse response) {
		String mobile = String.valueOf(request.getParameter("mobile")); // 手机号
		String username = String.valueOf(request.getParameter("username")); // 姓名
		String password = String.valueOf(request.getParameter("password")); // 密码
		String invitation = String.valueOf(request.getParameter("invitation")); // 邀请码
		String privilege = "common";//权限
		Map<String, Object> resMap = new HashMap<String, Object>();
		JSONObject json = new JSONObject();
		try {
			User user = new User();
			user.setUsername(username);
			user.setMobile(mobile);
			user.setPassword(password);
			user.setInvitation(invitation);
			user.setPrivilege(privilege);
			json = registerDao.register(user);
			return json.toString();
		} catch (Exception e) {
			resMap.put("root", "程序异常");
			JSONObject jsonObject = JSONObject.fromObject(resMap);
			return jsonObject.toString();
		}
	
	}
	
}

