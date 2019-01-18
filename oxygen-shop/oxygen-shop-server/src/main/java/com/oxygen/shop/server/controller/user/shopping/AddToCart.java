package com.oxygen.shop.server.controller.user.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.shopping.AddtocartDao;

import net.sf.json.JSONObject;

@Controller
public class AddToCart {
	
	@RequestMapping(value = "/addtocart",  produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//添加产品到购物车
	public String addtocart(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String user_id = String.valueOf(request.getParameter("user_id"));
		String Original_price = String.valueOf(request.getParameter("original_price"));
		String Rates = String.valueOf(request.getParameter("rates"));
		String quantity = String.valueOf(request.getParameter("quantity"));
		String product = String.valueOf(request.getParameter("product"));
		String path = String.valueOf(request.getParameter("path"));
		String location = String.valueOf(request.getParameter("location"));
		String quotation_id = String.valueOf(request.getParameter("cp_id"));
		if (null==Rates) {
			Rates=Original_price;
		}
		
		json = AddtocartDao.addtocartdao(user_id,Original_price,Rates,quantity,product,path,location,quotation_id);
		return json.toString();
		
	}
}
