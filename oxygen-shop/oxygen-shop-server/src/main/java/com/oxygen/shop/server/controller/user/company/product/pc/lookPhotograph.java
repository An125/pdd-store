package com.oxygen.shop.server.controller.user.company.product.pc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.oxygen.shop.rpc.service.impl.user.company.product.pc.photographDao;
@Controller
public class lookPhotograph {
	@RequestMapping(value = "/lookPhotograph", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})// method = RequestMethod.POST,
	//查询产品
	public String select_quotation(HttpServletRequest request,
			HttpServletResponse response){
		request.setAttribute("select_quotation",photographDao.select_quotation());		
				return "/jsp/photograph1/list.jsp";
		
	}
}
