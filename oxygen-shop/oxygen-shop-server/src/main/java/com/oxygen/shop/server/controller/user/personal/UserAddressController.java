package com.oxygen.shop.server.controller.user.personal;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oxygen.shop.common.vo.UserAddressVo;
import com.oxygen.shop.rpc.api.UserAddressService;

import net.sf.json.JSONObject;


@Controller
@RequestMapping("/UserAddress")
public class UserAddressController {
	
	@Resource(name="userAddressServiceImpl")
	private UserAddressService userAddressService;
	
	
	//添加收货地址
	@RequestMapping(value = "/addAddress", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String addAddress(UserAddressVo userAddressVo) throws Exception{

//		String choice = "1";
//		choice = String.valueOf(request.getParameter("choice")); // 是否默认  0为默认
		JSONObject json = new JSONObject();
		json = userAddressService.addAddress(userAddressVo);
		return json.toString();
	}
	
	//删除收货地址
	@RequestMapping(value = "/deleteAddress", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String deleteAddress(UserAddressVo userAddressVo) throws Exception{
		JSONObject json = new JSONObject();
		json = userAddressService.deleteAddress(userAddressVo);
		return json.toString();
	}
	
	//修改收货地址
	@RequestMapping(value = "/updateAddress", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String updateAddress(UserAddressVo userAddressVo) throws Exception{
		JSONObject json = new JSONObject();
		json = userAddressService.updateAddress(userAddressVo);
		return json.toString();
	}
		
	//查询收货地址
	@RequestMapping(value = "/selectAddress", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String selectAddress(UserAddressVo userAddressVo) throws Exception{
		JSONObject json = new JSONObject();
		json = userAddressService.selectAddress(userAddressVo);
		return json.toString();
	}
	
	//修改默认
	@RequestMapping(value = "/updateDefault", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String updateDefault(UserAddressVo userAddressVo) throws Exception{
		JSONObject json = new JSONObject();
		json = userAddressService.updateDefault(userAddressVo);
		return json.toString();
	}
	
	//查询默认收货地址
	@RequestMapping(value = "/selectDefault", produces = "text/plain;charset=UTF-8",method = {RequestMethod.POST, RequestMethod.GET})
	@ResponseBody
	public String selectDefault (UserAddressVo userAddressVo) throws Exception {
		JSONObject json = new JSONObject();
		json = userAddressService.selectDefault(userAddressVo);
		return json.toString();
	}
}
