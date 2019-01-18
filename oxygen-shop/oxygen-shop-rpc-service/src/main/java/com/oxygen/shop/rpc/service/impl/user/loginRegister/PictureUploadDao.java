package com.oxygen.shop.rpc.service.impl.user.loginRegister;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;

import net.sf.json.JSONObject;

public class PictureUploadDao {

	public static JSONObject insertDiz(String diz, String user_id) {
		JSONObject json = new JSONObject();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		String src = "OK";
		try {
			String update = "com.oxygen.shop.rpc.service.impl.user.loginRegister.xml.user.update_add";
			Map map = new HashMap();
			map.put("user_id", user_id);
			map.put("txpath", diz);
			int updat = session.update(update, map);
			if (0==updat) {
				src="NO";
			}
			
			session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();// 事务回滚
			src="NO";
			
			e.printStackTrace();
		} finally {
			session.close();
		}
		json.put("root", src);
		return json;
		
	}

}
