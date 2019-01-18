package com.oxygen.shop.rpc.service.impl.user.company.product.app;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.Quotation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TotalIdDao {

	public static JSONObject select_id() {
		JSONObject json1 = new JSONObject();
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();
		List<Quotation> list = null;
		try {
				String stat = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.s_id";
				list = session.selectList(stat);
				for (Quotation q:list) {
					json1.put("cp_id",q.getId());				
					ja.add(json1);
				}
			
		// 提交
			session.commit();//如何前面操作都完成成功  进行提交
			
		} catch (Exception e) {
			session.rollback();//事务回滚.
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("rows",ja);
		return json;
	}
}
