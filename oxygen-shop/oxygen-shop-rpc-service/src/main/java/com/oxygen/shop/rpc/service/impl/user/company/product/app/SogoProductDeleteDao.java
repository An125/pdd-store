package com.oxygen.shop.rpc.service.impl.user.company.product.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class SogoProductDeleteDao {
	/**
	 * 
	 * @param user_id		商户id
	 * @param cp_id			产品id
	 * @param mobile		手机号
	 * @return				OK或者NO
	 */
	public static JSONObject ProductDelete(String user_id, String js,
			String mobile) {
		JSONArray ja = JSONArray.fromObject(js);
		JSONObject json1 = new JSONObject();
		String src = "OK";
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		String tableName = user_id+"_quotation";//商户产品表
		try {
			for (int i = 0; i < ja.size(); i++) {
				JSONObject json = ja.getJSONObject(i);
				String cp_id = String.valueOf(json.get("cp_id"));
			String delete = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.ProductDelete";
			//com.pddzn.user.company.product.app.xml.Quotation
			Map map = new HashMap();
			map.put("tableName", tableName );
			map.put("id", cp_id);
			int j= session.delete(delete,map);		
			if (0==j) {
				src="NO";
			}
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			e.printStackTrace();
			src="NO";
		}finally{
			if (null != session) {
				session.close();
			}
		}
		json1.put("root", src);
		return json1;
	}

}
