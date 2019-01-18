package com.oxygen.shop.rpc.service.impl.user.company.product.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;

import net.sf.json.JSONObject;

public class ProductUpdateDao {
	/**
	 * 
	 * @param user_id
	 *            商户id
	 * @param cp_id
	 *            产品id
	 * @param offer
	 *            价格
	 * @return
	 */
	public static JSONObject UpdateOffer(String user_id, String cp_id,
			String offer) {
		JSONObject json = new JSONObject();
		String str = "OK";
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		/*SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = df.format(new Date());*/
		String tableName = "" + user_id + "_quotation"; // 商户产品表为id_quotation
		try {
			String update_quotation = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.update_quotation";
			Map map = new HashMap();
			// select * from ${TableName} ORDER BY id desc LIMIT #{PageBegin},
			// #{PageEnd}
			map.put("tableName", tableName);
			map.put("cp_id", cp_id);
			map.put("offer", offer);
			int i=session.update(update_quotation, map);
			if (0==i) {
				str="NO";
			} 
			// 提交
			session.commit();// 如何前面操作都完成成功 进行提交

		} catch (Exception e) {
			session.rollback();// 事务回滚
			e.printStackTrace();
			str="NO";
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("root",str);
		return json;
	}

}
