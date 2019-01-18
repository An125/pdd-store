package com.oxygen.shop.server.controller.user.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.shopping.DeleteCartDao;

import net.sf.json.JSONObject;

@Controller
public class DeleteCart  {


	@RequestMapping(value = "/delete_cart", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//删除购物车产品
	public String delete_cart(HttpServletRequest request, HttpServletResponse response) {
		String shopping_id = String.valueOf(request.getParameter("shopping_id"));
		String user_id = String.valueOf(request.getParameter("user_id")); // 外键对应用户id
		String product = String.valueOf(request.getParameter("product")); // 产品

		// String choice = "1";
		JSONObject json = new JSONObject();

		
//		  addressDao addressDao = new addressDao(); 
		  json = DeleteCartDao.deletecart(shopping_id,user_id,product); 
		  //add_address add_address =new add_address();
		 
		return json.toString();
	}
}