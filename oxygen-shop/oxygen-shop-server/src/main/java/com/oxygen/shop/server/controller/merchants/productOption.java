package com.oxygen.shop.server.controller.merchants;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.merchants.productOptionDao;

import net.sf.json.JSONObject;
/**
 * 选择产品并建立销售表
 * @author Administrator
 *
 */
@Controller
public class productOption {
	

	
	@RequestMapping(value = "/productoption", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String  selectProduct(HttpServletRequest request,HttpServletResponse response){
		String mobile = String.valueOf(request.getParameter("mobile"));
		String js= String.valueOf(request.getParameter("json"));
		JSONObject json = new JSONObject();
		json = productOptionDao.selectProduct(mobile,js);
		return json.toString();
		
	}
}
