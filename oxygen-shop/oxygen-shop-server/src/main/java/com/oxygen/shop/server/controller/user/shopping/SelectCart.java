package com.oxygen.shop.server.controller.user.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.shopping.SelectCartDao;

import net.sf.json.JSONObject;

@Controller
public class SelectCart  {


	@RequestMapping(value = "/selectcart",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//查询购物车
	public String selectcart(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String user_id = String.valueOf(request.getParameter("user_id"));
		json = SelectCartDao.selectcartdao(user_id);
		return json.toString();

	}
}