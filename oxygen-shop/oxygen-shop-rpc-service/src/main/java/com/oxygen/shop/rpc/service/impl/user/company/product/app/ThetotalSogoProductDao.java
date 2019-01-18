package com.oxygen.shop.rpc.service.impl.user.company.product.app;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oxygen.shop.common.po.Quotation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class ThetotalSogoProductDao {
/**
 * 
 * @param page	当前页
 * @param to	总产品数
 * @param id	该用户id
 * @param location	该用户所在商家
 * @return		分页查询数据
 */
	public static JSONObject select_quotation(String page, String to,
			String id, String location) {
		int totalPages = 0 ;//总页数
		JSONArray ja = new JSONArray();
		String sql;
		
		String total;		//查询记录数sql
		int tota = 0;		//记录数
		if (!"null".equals(to)) {
			tota = Integer.parseInt(to);		//记录数	
		}
		if ("null".equals(page)) {
			page = "1";		
		}
		int PageBegin = 0 ; //纪录起始号
		int PageEnd = 0 ;	//纪录结束号
		JSONObject json1 = new JSONObject();
		JSONObject json = new JSONObject();
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);

		SqlSession session = factory.openSession();
		List<Quotation> list = null;
		try {
			String select_id = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select_id";//查询店面id
			int userid = session.selectOne(select_id, "location");
			String tableName = "" + userid + "_quotation"; // 商户产品表为id_quotation
			if ("null".equals(to)) {
				String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select_sogocount";//查询出记录数
				tota = session.selectOne(statement,""+tableName+"");
				System.out.println(tota);
			}
				int i = Integer.parseInt(page);
				totalPages=tota/10;					//总页数
				//totalPages=10/10;
				PageBegin = 10*(i-1);				//纪录起始号
				PageEnd = PageBegin+10;				//纪录结束号
				if(PageEnd>tota){PageEnd = tota;}	//纪录结束号
				String stat = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select_sogequotation";	
				Map map = new HashMap();
				map.put("TableName", tableName);
				map.put("PageBegin", PageBegin);
				map.put("PageEnd",PageEnd);
				list = session.selectList(stat, map);
				for (Quotation q:list) {
					json1.put("cp_id",q.getId());
					json1.put("product",q.getProduct());
					json1.put("offer",q.getOffer());
					json1.put("top_Price",q.getTopPrice());
					json1.put("floor_Price",q.getFloorPrice());
					json1.put("path",q.getPath()); 				
					ja.add(json1);
				}
			
		// 提交
			session.commit();//如何前面操作都完成成功  进行提交
			
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
