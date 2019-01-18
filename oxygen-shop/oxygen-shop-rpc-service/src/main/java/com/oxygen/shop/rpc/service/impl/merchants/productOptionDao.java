package com.oxygen.shop.rpc.service.impl.merchants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.Quotation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class productOptionDao {
	
	public static JSONObject selectProduct(String mobile, String js) {
		JSONArray ja = JSONArray.fromObject(js);
		
		SqlSessionFactory factory =MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		List<Quotation> list = null;
		JSONObject json1 = new JSONObject();
		String src = "OK";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = df.format(new Date());
		try {
			String select = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.select_user";
			String id = session.selectOne(select, "" + mobile + "");// 查询该商户id
			String tableName = "" + id + "_quotation"; // 商户产品表为id_quotation
														// 在此进行拼接出表名

			for (int i = 0; i < ja.size(); i++) {
				JSONObject json = ja.getJSONObject(i);
				String cp_id = String.valueOf(json.get("cp_id"));
				String stat = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.select_quotation";// 查询商户选择的产品信息
				Map map = new HashMap();
				map.put("id", cp_id);
				list = session.selectList(stat, map);
				for (Quotation q : list) {
					Map ma = new HashMap();
					ma.put("tableName", tableName);
					ma.put("quotation_id", cp_id);
					ma.put("product", q.getProduct());
					// System.out.println(q.getProduct());
					ma.put("offer", q.getOffer());
					ma.put("top_Price", q.getTopPrice());
					ma.put("floor_Price", q.getFloorPrice());
					ma.put("path", q.getPath());
					ma.put("date", nowDate);
					String statement = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.add_quotation";// 保存商户选择的产品信息到商户产品表
					int insert = session.insert(statement, ma);
					//session.commit();// 如何前面操作都完成成功 进行提交
					String sql = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.select_sql";//查询商户选择后在表的id
					Map m = new HashMap();
					m.put("tableName", tableName);
					m.put("quotation_id", cp_id);					
					String sh_id = session.selectOne(sql, m);//查询商户产品表id
					//String tabie ="market_"+id+"_"+sh_id+"";
					
					String xiaos = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.createmarketTable";//建立销售表
					Map mmm = new HashMap();
					String market ="market_"+id; // 商户销售表为market_商户用户表中id_商户产品表中id
					mmm.put("_parameter", market);
					mmm.put("sh_id", sh_id);
					/*mmm.put("_parameter", tabie);
					mmm.put("tableName", tableName);*/
					session.update(xiaos, mmm);
				}
			}
			
			 session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();// 事务回滚
			src = "NO";
			e.printStackTrace();
		} finally {
			session.close();
		}
		json1.put("root", src);
		return json1;
	}

}
