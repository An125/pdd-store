package com.oxygen.shop.server.controller.user.management;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.management.XinxDao;

import net.sf.json.JSONObject;

/**
 * 查询出有哪些代理商
 * @author Administrator
 *
 */
@Controller
public class Adminxx {
	/**
	 * 
	 * @param page当前页
	 * @param roes每页纪录数
	 */
	 @RequestMapping(value = "/Adminxx",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	 @ResponseBody
	public String admin(String page,String rows){
		JSONObject json = new JSONObject();
		json = XinxDao.selectAdmin(page,rows);
		return json.toString();
	}
}
