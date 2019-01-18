package com.oxygen.shop.rpc.service.impl.user.shopping;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UpdateParameterDao {
	/**
	 * 
	 * @param user_id			用户id
	 * @param prodct			产品
	 * @param quantity			数量
	 * @param id				购物车id
	 * @return
	 */
	public static JSONObject updatecartdao(String user_id, String product, String quantity,String id) {
		JSONObject json = new JSONObject();
		String str = "OK";
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.update_shopping"; 
			Map map = new HashMap();
			map.put("user_id", user_id);
			map.put("quantity", quantity);
			map.put("id", id);		
			int update = session.update(statement,map);
				
			// 提交
			session.commit();
			if (update==0) {
				str = "NO";
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