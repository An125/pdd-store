package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.SogoProductDeleteDao;

@Controller
public class SogoProductDelete {
	//商户下架产品
	@RequestMapping(value="/sogoproductdelete", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String ProductDelete(HttpServletRequest request,
			HttpServletResponse response){
		JSONObject json = new JSONObject();
		String user_id = String.valueOf(request.getParameter("user_id"));
		String cp_id = String.valueOf(request.getParameter("json"));
		String mobile = String.valueOf(request.getParameter("mobile"));
		json = SogoProductDeleteDao.ProductDelete(user_id,cp_id,mobile);
		return json.toString(); 
	}
}
