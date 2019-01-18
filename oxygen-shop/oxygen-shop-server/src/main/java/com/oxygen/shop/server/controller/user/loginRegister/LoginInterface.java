package com.oxygen.shop.server.controller.user.loginRegister;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.common.po.User;
import com.oxygen.shop.rpc.service.impl.user.loginRegister.loginDao;

import net.sf.json.JSONObject;


@Controller
public class LoginInterface {

	/**
	 * 1. 使用 @RequestMapping 注解来映射请求的 URL 2. 返回值会通过视图解析器解析为实际的物理视图, 对于
	 * InternalResourceViewResolver 视图解析器, 会做如下的解析: 通过 prefix + returnVal + 后缀
	 * 这样的方式得到实际的物理视图, 然会做转发操作 /WEB-INF/views/success.jsp
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	// method = RequestMethod.POST,
	@ResponseBody
	// @RequestMapping("/helloworld")
	public String login1(HttpServletRequest request,
			HttpServletResponse response) {
		Map<String, Object> resMap = new HashMap<String, Object>();
		//JSONObject json = new JSONObject();
		try {
			// Integer id=Integer.valueOf(request.getParameter("userID"));
			String username = String.valueOf(request.getParameter("username")); // 账号
			String mobile = String.valueOf(request.getParameter("mobile")); // 手机号
			String password = String.valueOf(request.getParameter("password")); // 密码
			User user = loginDao. logi(username,mobile,password);
			if (user == null) {
				resMap.put("root", "NO");
				JSONObject jsonObject = JSONObject.fromObject(resMap);
				return jsonObject.toString();
			}
			Integer id = user.getId();
			String Generated = user.getGenerated();
			String name = user.getUsername();
			String Privilege = user.getPrivilege();
			String location = user.getLocation();
			String txpath = user.getTxpath();
			//JSONObject json1 = new JSONObject();
			resMap.put("Generated", ""+Generated+"");
			resMap.put("id", ""+id+"");
			resMap.put("username", ""+name+"");
			resMap.put("privilege", ""+Privilege+"");
			resMap.put("location", ""+location+"");
			resMap.put("txpath", ""+txpath+"");
			resMap.put("root", "OK");
			JSONObject jsonObject = JSONObject.fromObject(resMap);
			return jsonObject.toString();
		} catch (Exception e) {
			resMap.put("root", "NO");
			JSONObject jsonObject = JSONObject.fromObject(resMap);
			return jsonObject.toString();

		}
	}

	

}
