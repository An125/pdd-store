package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.productSogoDao;

@Controller
public class productsogo {
	@RequestMapping(value = "/productsogo",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	//用户查看商户产品显示
	public String Sogo(HttpServletRequest request,
			HttpServletResponse response){
		String user_id = String.valueOf(request.getParameter("user_id"));
		String page = String.valueOf(request.getParameter("page"));
		String to = String.valueOf(request.getParameter("total"));
		String mobile = String.valueOf(request.getParameter("mobile"));
		
		JSONObject json = new JSONObject();
		json = productSogoDao.select_Sogo(user_id,page,to,mobile);
		// request.setAttribute("select_quotation",photographDao.select_quotation());
		return json.toString();
	}
}
