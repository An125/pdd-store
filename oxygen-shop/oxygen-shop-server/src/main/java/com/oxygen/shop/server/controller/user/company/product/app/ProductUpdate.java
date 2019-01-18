package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.ProductUpdateDao;

import net.sf.json.JSONObject;

@Controller
public class ProductUpdate {
	@RequestMapping(value = "/productupdate", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//商户修改产品价格
	public String Update(HttpServletRequest request,
			HttpServletResponse response) {
		String user_id = String.valueOf(request.getParameter("user_id"));
		String cp_id = String.valueOf(request.getParameter("cp_id"));
		String offer = String.valueOf(request.getParameter("offer"));
		JSONObject json = new JSONObject();
		json = ProductUpdateDao.UpdateOffer(user_id,cp_id,offer);
		return json.toString(); 

	}
}
