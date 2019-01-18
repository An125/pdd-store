package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.TotalIdDao;

import net.sf.json.JSONObject;
@Controller
public class TotalId {
	@RequestMapping(value = "/totalid", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	// method = RequestMethod.POST,
	@ResponseBody
	//按用户查询产品
	public String thetotalproduct(HttpServletRequest request,
			HttpServletResponse response) {
		String mobile = String.valueOf(request.getParameter("mobile"));
		JSONObject json = new JSONObject();
		json = TotalIdDao.select_id();
		// request.setAttribute("select_quotation",photographDao.select_quotation());
		return json.toString();

	}
}

