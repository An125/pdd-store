package com.oxygen.shop.rpc.service.impl.user.shopping;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oxygen.shop.common.po.Shopping;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SelectCartDao {

	public static JSONObject selectcartdao(String user_id) {

 		JSONObject json1 = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		String str;
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.select_shopping";
			Map map = new HashMap();
			map.put("user_id", user_id);
			List<Shopping> list = session.selectList(statement, map);
			System.out.println(list);
			for(Shopping shopping:list){
				json1 = new JSONObject();		
				/*private String id;
				private String user_id;
				private String product;
				private String Original_price;
				private String Rates;
				private String quantity;
				private String path;
				private String data;*/
				json1.put("shopping_id",shopping.getId());
				json1.put("user_id",shopping.getUserId());
				json1.put("product",shopping.getProduct());
				json1.put("Original_price",shopping.getOriginalPrice());
				json1.put("Rates",shopping.getRates());
				json1.put("quantity",shopping.getQuantity()); 				
				json1.put("path",shopping.getPath()); 				
				json1.put("cp_id",shopping.getQuotationId()); 				
				ja.add(json1);
			}
			// 提交
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			str = "NO";
			json.put("root", str);
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("root", ja);
		return json;
	}
}