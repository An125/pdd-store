package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.ThetotalSogoProductDao;

import net.sf.json.JSONObject;


@Controller
public class ThetotalSogoProduct {
	@RequestMapping(value = "/thetotalsogoproduct", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	// method = RequestMethod.POST,
	//分页查询商户
	@ResponseBody
	public String thetotalproduct(HttpServletRequest request,
			HttpServletResponse response) {
		String page = String.valueOf(request.getParameter("page"));
		String to = String.valueOf(request.getParameter("total"));
		String id = String.valueOf(request.getParameter("user_id"));
		String location = String.valueOf(request.getParameter("location"));
		
		JSONObject json = new JSONObject();
		json = ThetotalSogoProductDao.select_quotation(page, to,id,location);
		// request.setAttribute("select_quotation",photographDao.select_quotation());
		return json.toString();
	}
}