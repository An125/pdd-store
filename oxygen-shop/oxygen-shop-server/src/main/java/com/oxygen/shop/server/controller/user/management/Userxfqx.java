package com.oxygen.shop.server.controller.user.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.management.XinxDao;

import net.sf.json.JSONObject;

@Controller
public class Userxfqx {
	
	/**
	 * 
	 * @param page当前页
	 * @param rows每页纪录数
	 */
	@RequestMapping(value = "/Userxfqx",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String userxx(String username, String page, String rows) {

		JSONObject json = new JSONObject();
		json = XinxDao.selectUserxf(username, page, rows);   
		return json.toString();
	}
}
