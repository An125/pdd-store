package com.oxygen.shop.rpc.service.impl.user.loginRegister;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.User;

import net.sf.json.JSONObject;

public class InvitationDao {
	public static JSONObject invitationDao(String user_id, String mobile,
			String invitation) {
		JSONObject json = new JSONObject();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		String b = null;
		String str = "OK";
		int i =0;
		try {
			b = invitation.substring(0, 1);
			String Path = null;
			String statement = "com.oxygen.shop.rpc.service.impl.user.loginRegister.xml.user.superior_id";// 查询上级id
			String update_user = "com.oxygen.shop.rpc.service.impl.user.loginRegister.xml.user.update_user"; 
			if ("b".equals(b)) {// 为商家邀请码情况
				List<User> list = session.selectList(statement, invitation);
				for (User user : list) {
					Map map = new HashMap();
					map.put("location", user.getUsername());
					map.put("username", user.getUsername());// 商户店名
					map.put("user_id", user_id);
					map.put("Depth", 2);
					map.put("mobile", mobile);
					map.put("invitation", invitation);
					map.put("Path", String.valueOf(user.getId()));// 商户id
					i = session.update(update_user, map);
				}
			} else if ("c".equals(b)) {// 为用户邀请码情况
				List<User> list = session.selectList(statement, invitation);// 查询该邀请码上级
				for (User user : list) {
					// id,username,Depth,path,location
					Map map = new HashMap();
					map.put("username", user.getUsername());// 上级名
					map.put("user_id", user_id);
					map.put("location", user.getLocation());
					map.put("Depth", Integer.parseInt(user.getDepth()) + 1);
					map.put("mobile", mobile);
					map.put("invitation", invitation);
					map.put("Path", String.valueOf(user.getPath())+","+String.valueOf(user.getId()));// 上级id
					i = session.update(update_user, map);
				}
			}
			//删除购物车
			String dalete ="com.oxygen.shop.rpc.service.impl.user.loginRegister.xml.user.delete_shopping";
			int j = session.delete(dalete, user_id);
			if (0==i) {
				str="NO";
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			str = "NO";
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("root", str);
		return json;
	}
}
