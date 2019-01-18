package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.TheTotalProductDao;

import net.sf.json.JSONObject;

@Controller
public class TheTotalProduct {
	//分页查询总公司
	@RequestMapping(value = "/thetotalproduct", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	// method = RequestMethod.POST,
	@ResponseBody
	public String thetotalproduct(HttpServletRequest request,
			HttpServletResponse response) {
		String page = String.valueOf(request.getParameter("page"));
		String to = String.valueOf(request.getParameter("total"));
		JSONObject json = new JSONObject();
		json = TheTotalProductDao.select_quotation(page, to);
		// request.setAttribute("select_quotation",photographDao.select_quotation());
		return json.toString();

	}
}
