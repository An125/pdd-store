package com.oxygen.shop.rpc.service.impl.user.company.product.app;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.Quotation;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class TotalProductSelectionDao {

	public static JSONObject selection(String page, String to,
			String user_id, String mobile) {
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
		
		JSONObject json = new JSONObject();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		List<Quotation> list = null;
		JSONObject json1 = new JSONObject();
		//String src = "OK";
		String tableName = user_id+"_quotation";
		try {
			if ("null".equals(to)) {
				String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.selectFilter";//查询过滤后记录数
				tota = session.selectOne(statement,""+tableName+"");
				System.out.println(tota);
			}
			int i = Integer.parseInt(page);
			totalPages=tota/10;					//总页数
			//totalPages=10/10;
			PageBegin = 10*(i-1);				//纪录起始号
			PageEnd = PageBegin+10;				//纪录结束号
			if(PageEnd>tota){PageEnd = tota;}	//纪录结束号
			String select = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select";//查询过滤分页结果集
			Map map = new HashMap();
			map.put("tableName", tableName);
			map.put("PageBegin", PageBegin);
			map.put("PageEnd",PageEnd);
			list = session.selectList(select, map);
			for(Quotation q:list){
				json1.put("cp_id",q.getId());
				json1.put("product",q.getProduct());
				json1.put("offer",q.getOffer());
				json1.put("top_Price",q.getTopPrice());
				json1.put("floor_Price",q.getFloorPrice());
				json1.put("path",q.getPath()); 				
				ja.add(json1);
			}
			session.commit();// 如何前面操作都完成成功 进行提交 
		} catch (Exception e) {
			session.rollback();// 事务回滚
			//src = "NO";
			e.printStackTrace();
		} finally {
			session.close();
		}
		json.put("total",tota);
		json.put("rows",ja);
		return json;
		
	}

}
