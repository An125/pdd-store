package com.oxygen.shop.server.controller.user.management;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.management.AppDao;

import net.sf.json.JSONObject;
/**
 * 查询用户消费(分页)
 * @author Administrator
 *
 */
@Controller
public class AppUserXf {
	
	@RequestMapping(value = "/appuserxf",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String appuserxf(HttpServletRequest request,HttpServletResponse response){
		String user_id = String.valueOf(request.getParameter("user_id"));
		String page= String.valueOf(request.getParameter("page"));
		String total= String.valueOf(request.getParameter("total"));
		String mobile= String.valueOf(request.getParameter("mobile"));
		String username= String.valueOf(request.getParameter("username"));
		JSONObject json = new JSONObject();
		json = AppDao.user(user_id,page,total,mobile,username);    
		return json.toString();
	}
}
