package com.oxygen.shop.rpc.service.impl.user.personal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.oxygen.shop.common.po.UserAddress;
import com.oxygen.shop.common.vo.UserAddressVo;
import com.oxygen.shop.dao.mapper.UserAddressCustomMapper;
import com.oxygen.shop.rpc.api.UserAddressService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Service("userAddressServiceImpl")
@Transactional
public class UserAddressServiceImpl implements UserAddressService{

	/**
	 * @param id
	 *            用户id
	 * @param mobile
	 *            用户手机号
	 * @param theConsignee
	 *            收货人姓名
	 * @param telephone
	 *            收货人手机号
	 * @param inTheArea
	 *            所在地区
	 * @param detailedAddress
	 *            详细地址
	 * @param choice
	 *            是否默认
	 * @return 添加地址是否成功
	 */
	
	@Resource(name = "userAddressCustomMapper")
	private UserAddressCustomMapper userAddressCustomMapper;
	
	//添加
	@Override
	public JSONObject addAddress(UserAddressVo userAddressVo) throws Exception {
		JSONObject json = new JSONObject();
		String str = "OK";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
			List<UserAddress> list = userAddressCustomMapper.selectDefault(userAddressVo);//查询原数据是否有默认
			if("0".equals(userAddressVo.getChoice())) {
				if(!(list.size()==0)) {//有默认的情况下,把原来默认修改成非默认
					userAddressCustomMapper.changeDefaultToOne(userAddressVo);//把原先默认改成1 
				}
			}else {//没有默认的情况下
				if (list.size()==0) {
					userAddressVo.setChoice("0");
				}
			}
			userAddressCustomMapper.addAddress(userAddressVo);
			Map map = new HashMap();

		} catch (Exception e) {
			str = "NO";
			e.printStackTrace();
		}
		
		json.put("root", str);
		return json;

	}
	
	//删除
	@Override
	public JSONObject deleteAddress(UserAddressVo userAddressVo) throws Exception {
		JSONObject json = new JSONObject();
		String str = "OK";
		 try {
			int count = userAddressCustomMapper.deleteAddress(userAddressVo);
			 if(count ==0) {
				 str="NO";
			 }
		} catch (Exception e) {
			str="NO";
			e.printStackTrace();
		}
		 json.put("root", str);
		return json;
	
	}
	
	// 修改收货地址
	@Override
	public JSONObject updateAddress(UserAddressVo userAddressVo) throws Exception {
		JSONObject json = new JSONObject();
		String str = "OK";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
			int count = userAddressCustomMapper.updateAddress( userAddressVo);
			if(count==0) {
				str = "NO";
			}
		} catch (Exception e) {
			str = "NO";
			e.printStackTrace();
		}
		json.put("root", str);
		return json;

	}
	
	//查询该用户收货地址
	@Override
	public JSONObject selectAddress(UserAddressVo userAddressVo) throws Exception {
		JSONObject json1 = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		String str;
		try {
			List<UserAddress> list = userAddressCustomMapper.selectAddress( userAddressVo);
			for (UserAddress address : list) {
				json1 = new JSONObject();
				json1.put("address_id", address.getId());
				json1.put("the_consignee", address.getTheConsignee());
				json1.put("telephone", address.getTelephone());
				json1.put("in_the_area", address.getInTheArea());
				json1.put("detailed_address", address.getDetailedAddress());
				json1.put("choice", address.getChoice());
				ja.add(json1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			str = "NO";
			json.put("root", str);
		}
		json.put("root", ja);
		return json;

	}
	
	//修改默认地址
	@Override
	public JSONObject updateDefault(UserAddressVo userAddressVo) throws Exception {
		JSONObject json = new JSONObject();
		String str = "OK";
		try {
			int count = userAddressCustomMapper.changeDefaultToOne(userAddressVo);
			int count1 = userAddressCustomMapper.updateDefault( userAddressVo);
			if(count==0||count1==0) {
				str="NO";
			}
		} catch (Exception e) {
			str = "NO";
			e.printStackTrace();
		}
		json.put("root", str);
		return json;
		
	}
	
	//查询默认收货地址
	@Override
	public JSONObject selectDefault(UserAddressVo userAddressVo) throws Exception {
		JSONObject json1 = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		String str;
		try {
			List<UserAddress> list = userAddressCustomMapper.selectDefault(userAddressVo);
			for(UserAddress useraddress:list) {
				json1 = new JSONObject();	
				json1.put("addressId", useraddress.getId());
				json1.put("theConsignee", useraddress.getTheConsignee());
				json1.put("telephone", useraddress.getTelephone());
				json1.put("inTheArea", useraddress.getInTheArea());
				json1.put("detailedAddress", useraddress.getDetailedAddress());
				json1.put("choice", useraddress.getChoice());
				ja.add(json1);
			}
		} catch (Exception e) {
			str = "NO";
			json.put("root", str);
			e.printStackTrace();
		}
		json.put("root", ja);
		return json;
		
	}

	@Override
	public JSONObject changeDefaultToOne(UserAddressVo userAddressVo) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


}
