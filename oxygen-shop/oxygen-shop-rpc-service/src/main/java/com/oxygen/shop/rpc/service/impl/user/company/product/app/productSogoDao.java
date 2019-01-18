package com.oxygen.shop.rpc.service.impl.user.company.product.app;

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

public class productSogoDao {
/**
 * 
 * @param user_id	用户id
 * @param page		当前页
 * @param to		记录数
 * @param mobile	手机号
 * @return
 */
	public static JSONObject select_Sogo(String user_id, String page,
			String to, String mobile) {
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONObject json1 = new JSONObject();

		//String str = "OK";
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		String tableName = "" + user_id + "_quotation"; // 商户产品表为id_quotation
		List<Quotation> list = null;
		int tota = 0;		//记录数
		if (!"null".equals(to)) {
			tota = Integer.parseInt(to);		//记录数	
		}
		if ("null".equals(page)) {
			page = "1";		
		}
		
		int PageBegin = 0 ; //纪录起始号
		int PageEnd = 0 ;	//纪录结束号
		int totalPages = 0 ;//总页数
		try {
			if ("null".equals(to)) {
				String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.app.xml.Quotation.select_sogocount";
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
			//	select * from ${TableName}  ORDER BY id desc LIMIT #{PageBegin}, #{PageEnd}
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
