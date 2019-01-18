package com.oxygen.shop.rpc.service.impl.user.shopping;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import net.sf.json.JSONObject;

public class DeleteCartDao {

	public static JSONObject deletecart(String shopping_id, String user_id,
			String product) {
		JSONObject json = new JSONObject();
		String str = "OK";
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.delete_product";
			Map map = new HashMap();
			map.put("user_id", user_id);
			map.put("id", shopping_id);		
			int delete = session.delete(statement,map);
			// 提交
			session.commit();
			if (delete==0) {
				str="NO";
			}
		} catch (Exception e) {
			str = "NO";
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("root", str);
		return json;
	}

}
