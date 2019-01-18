package com.oxygen.shop.server.controller.user.loginRegister;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.rpc.service.impl.user.loginRegister.InvitationDao;

import net.sf.json.JSONObject;


@Controller
public class Invitation {
	@RequestMapping(value = "/invitation", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String invitation(HttpServletRequest request,
			HttpServletResponse response) {
		JSONObject json = new JSONObject();
		String user_id = String.valueOf(request.getParameter("user_id"));// 手机号(账号)
		String mobile = String.valueOf(request.getParameter("mobile"));// 手机号(账号)
		String invitation = String.valueOf(request.getParameter("invitation")); // 邀请码
		json = InvitationDao.invitationDao(user_id, mobile, invitation);
		return json.toString();
	}

	

}
