package com.oxygen.shop.server.controller.user.company.product.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.company.product.app.FuzzySearchDao;

import net.sf.json.JSONObject;


@Controller
public class FuzzySearch {
	
	
    
	@RequestMapping(value = "/fuzzysearch",produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
  //模糊查询
    public String fuzzysearch(HttpServletRequest request,
			HttpServletResponse response){
		JSONObject json = new JSONObject();
		String mobile = String.valueOf(request.getParameter("mobile"));			//手机号(账户)
		String location = String.valueOf(request.getParameter("location"));		//所在店
		/*if (null==location) {
			location="胖嘟嘟总公司";
		}*/	
		String page = String.valueOf(request.getParameter("page"));				//当前页
		String user_id = String.valueOf(request.getParameter("user_id"));		//用户id
		String total = String.valueOf(request.getParameter("total"));			//总数	
		String product = String.valueOf(request.getParameter("product"));		//产品名
		json = FuzzySearchDao.fuzzysearchdao(mobile,location,page,user_id,total,product);
		return json.toString();		
    }
}
