package com.oxygen.shop.server.controller.merchants;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.merchants.registerPCdao;

@Controller
public class registerPC {
	
	@RequestMapping(value = "/merchantsregister", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String register(HttpServletRequest request, HttpServletResponse response) {
		String mobile = String.valueOf(request.getParameter("mobile")); // 手机号
		String username = request.getParameter("username"); // 姓名
		String password = String.valueOf(request.getParameter("password")); // 密码
		String privilege = "merchants";// 权限
		registerPCdao.registerPcDao(mobile, username, password, privilege);
		return null;

	}
}
