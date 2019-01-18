package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.TotalProductSelectionDao;

import net.sf.json.JSONObject;

@Controller
public class TotalProductSelection {
	//商户选择产品的产品页面(过滤掉已经选择了的产品,已经选择的不显示)
	@RequestMapping(value="/totalproductselection",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String selection(HttpServletRequest request,HttpServletResponse response){
		JSONObject json = new JSONObject();
		String page = String.valueOf(request.getParameter("page"));
		String total = String.valueOf(request.getParameter("total"));
		String user_id = String.valueOf(request.getParameter("user_id"));
		String mobile = String.valueOf(request.getParameter("mobile"));
		json = TotalProductSelectionDao.selection(page,total,user_id,mobile);
		return json.toString();
		}
}
