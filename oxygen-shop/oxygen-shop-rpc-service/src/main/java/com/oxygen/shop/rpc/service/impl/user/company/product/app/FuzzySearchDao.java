package com.oxygen.shop.rpc.service.impl.user.company.product.app;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.Quotation;


public class FuzzySearchDao {

	public static JSONObject fuzzysearchdao(String mobile, String location,
			String page, String user_id, String to,String produc) {
		String product = "%"+produc+"%";
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray ja = new JSONArray();
		int totalPages = 0;// 总页数
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		List<Quotation> list = null;
		String total; // 查询记录数sql
		int tota = 0; // 记录数
		if (!"null".equals(to)) {
			tota = Integer.parseInt(to); // 记录数
		}
		if ("null".equals(page)) {
			page = "1";
		}
		int PageBegin = 0; // 纪录起始号
		int PageEnd = 0; // 纪录结束号

		try {// 总公司模糊查询
			if (null == location || "null".equals(location)) {
				if ("null".equals(to)) {// 查询出该关键词的记录数
					String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.fuzzy_query_count";					
					tota = session.selectOne(statement,product);
					System.out.println(tota);
				}
				int i = Integer.parseInt(page);
				totalPages = tota / 10; // 总页数
				// totalPages=10/10;
				PageBegin = 10 * (i - 1); // 纪录起始号
				PageEnd = PageBegin + 10; // 纪录结束号
				if (PageEnd > tota) {
					PageEnd = tota;
				} // 纪录结束号
				String stat = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.fuzzy_query_quotation";
				Map map = new HashMap();
				map.put("PageBegin", PageBegin);
				map.put("PageEnd", PageEnd);
				map.put("product", product);
				list = session.selectList(stat, map);
				for (Quotation q : list) {
					json1.put("cp_id", q.getId());
					json1.put("product", q.getProduct());
					json1.put("offer", q.getOffer());
					json1.put("top_Price", q.getTopPrice());
					json1.put("floor_Price", q.getFloorPrice());
					json1.put("path", q.getPath());
					ja.add(json1);
				}

				// 提交
				session.commit();// 如何前面操作都完成成功 进行提交
			} else {// 代理商模糊查询
				String select_id = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select_id";// 查询店面id
				int userid = session.selectOne(select_id, "location");
				String tableName = "" + userid + "_quotation"; // 商户产品表为id_quotation
				if ("null".equals(to)) {
					String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.fuzzy_query_sogocount";// 查询出记录数
					Map map = new HashMap();
					map.put("_parameter", tableName);
					map.put("product", product);
					tota = session.selectOne(statement, map);
					System.out.println(tota);
				}
				int i = Integer.parseInt(page);
				totalPages = tota / 10; // 总页数
				// totalPages=10/10;
				PageBegin = 10 * (i - 1); // 纪录起始号
				PageEnd = PageBegin + 10; // 纪录结束号
				if (PageEnd > tota) {
					PageEnd = tota;
				} // 纪录结束号
				String stat = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.fuzzy_query_sogequotation";
				Map map = new HashMap();
				map.put("TableName", tableName);
				map.put("PageBegin", PageBegin);
				map.put("PageEnd", PageEnd);
				map.put("product", product);
				list = session.selectList(stat, map);
				for (Quotation q : list) {
					json1.put("cp_id", q.getId());
					json1.put("product", q.getProduct());
					json1.put("offer", q.getOffer());
					json1.put("top_Price", q.getTopPrice());
					json1.put("floor_Price", q.getFloorPrice());
					json1.put("path", q.getPath());
					ja.add(json1);
				}
				/*
				 * if ("null".equals(to)) { String statement =
				 * "com.pddzn.user.company.product.app.xml.Quotation.select_sogocount"
				 * ;//查询出记录数 tota =
				 * session.selectOne(statement,""+tableName+"");
				 * System.out.println(tota); }
				 */
			}
			session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();//事务回滚
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("total",tota);
		json.put("rows",ja);
		return json;
	}
}
