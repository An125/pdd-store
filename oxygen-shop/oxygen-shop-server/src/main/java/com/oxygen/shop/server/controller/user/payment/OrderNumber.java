package com.oxygen.shop.server.controller.user.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.payment.OrderNumberDao;

import net.sf.json.JSONObject;
/**
 * 生成订单号
 * @author Administrator
 *
 */
@Controller
public class OrderNumber {
	
	@RequestMapping(value = "/ordernumber", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String ordernumber(HttpServletRequest request,
			HttpServletResponse response) {
		String js= String.valueOf(request.getParameter("json"));
		String user_id = String.valueOf(request.getParameter("user_id"));// 用户id
		String username = String.valueOf(request.getParameter("username"));// 用户名	
		String merchants = String.valueOf(request.getParameter("location")); // 商家
		String address = String.valueOf(request.getParameter("adderss"));//收货地址
		String address_id = String.valueOf(request.getParameter("address_id"));//收货地址id
		JSONObject json = new JSONObject();
		json=OrderNumberDao.ordernumber(js, user_id, username, merchants, address, address_id);
		return json.toString();
	}
}
