package com.oxygen.shop.server.controller.user.shopping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.shopping.UpdateParameterDao;

import net.sf.json.JSONObject;

@Controller
public class UpdateParameter  {


	@RequestMapping(value = "/updatecart", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//修改购物车产品参数 
	public String updatecart(HttpServletRequest request, HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String user_id = String.valueOf(request.getParameter("user_id"));
		String quantity = String.valueOf(request.getParameter("quantity"));
		String product = String.valueOf(request.getParameter("product"));
		String shopping_id = String.valueOf(request.getParameter("shopping_id"));
		json = UpdateParameterDao.updatecartdao(user_id, product, quantity, shopping_id);
		return json.toString();

	}
}