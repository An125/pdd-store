package com.oxygen.shop.rpc.service.impl.user.management;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.OrderForm;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class AppDao {
/**
 * 
 * @param user_id	用户id
 * @param page		当前页
 * @param to		记录数
 * @param mobile	手机号
 * @param username	用户名
 * @return
 */
	public static JSONObject user(String user_id, String page, String to,
			String mobile, String username) {
		JSONObject json = new JSONObject();
		JSONArray ja = new JSONArray();
		JSONObject json1 = new JSONObject();

		//String str = "OK";
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		//String tableName = "" + user_id + "_quotation"; // 商户产品表为id_quotation
		
		List<OrderForm> list = null;
		int tota = 0;		//记录数
		if (!"null".equals(to)) {
			tota = Integer.parseInt(to);		//记录数	
		}
		/*if(to.length()<=0||""==to||null==to){
			System.out.println("111");
		}*/
		if ("null".equals(page)) {
			page = "1";		
		}
		
		int PageBegin = 0 ; //纪录起始号
		int PageEnd = 0 ;	//纪录结束号
		int totalPages = 0 ;//总页数
		try {
			if ("null".equals(to)) {
				String statement = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_userxfjl"; // 查询记录数
				tota = session.selectOne(statement,username);
				System.out.println(tota);
			}
				int i = Integer.parseInt(page);
				totalPages=tota/10;					//总页数
				//totalPages=10/10;
				PageBegin = 10*(i-1);				//纪录起始号
				PageEnd = PageBegin+10;				//纪录结束号
				if(PageEnd>tota){PageEnd = tota;}	//纪录结束号
				String stat = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_userxf";
				Map map = new HashMap();
				map.put("PageBegin", PageBegin);
				map.put("PageEnd", PageEnd);
				map.put("username", username);
				list = session.selectList(stat, map);
				for (OrderForm q : list) {
					json1.put("product", q.getProduct());
					json1.put("merchants", q.getMerchants());
					json1.put("price", q.getPrice());
					json1.put("quantity", q.getQuantity());
					json1.put("state", q.getState());	//状态1为代付2为待货3为待收4为待评
					json1.put("Method", q.getMethod());
					json1.put("address", q.getAddress());		//收货地址
					json1.put("path", q.getPath());		//图片路径
					json1.put("date", q.getDate());		//时间
					json1.put("order_form", q.getOrderForm());		//订单号
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


	/**
	 * 
	 * @param user_id	商户id
	 * @param page		当前页
	 * @param to		记录数
	 * @param mobile	手机号
	 * @param username	商户名
	 * @return
	 */
public static JSONObject admin(String user_id, String page, String to,
		String mobile, String username) {
	JSONObject json = new JSONObject();
	JSONArray ja = new JSONArray();
	JSONObject json1 = new JSONObject();

	//String str = "OK";
	SqlSessionFactory factory = MybatisUtils.getFactory();
	SqlSession session = factory.openSession();// 需要手动提交
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String nowDate=df.format(new Date());
	//String tableName = "" + user_id + "_quotation"; // 商户产品表为id_quotation
	
	List<OrderForm> list = null;
	int tota = 0;		//记录数
	//String t = to.trim();
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
			String statement = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_admincsjl"; // 查询记录数
			tota = session.selectOne(statement,username);
			System.out.println(tota);
		}
			int i = Integer.parseInt(page);
			totalPages=tota/10;					//总页数
			//totalPages=10/10;
			PageBegin = 10*(i-1);				//纪录起始号
			PageEnd = PageBegin+10;				//纪录结束号
			if(PageEnd>tota){PageEnd = tota;}	//纪录结束号
			String stat = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_admincs";
			Map map = new HashMap();
			map.put("PageBegin", PageBegin);
			map.put("PageEnd", PageEnd);
			map.put("username", username);
			list = session.selectList(stat, map);
			for (OrderForm q : list) {
				json1.put("username", q.getUsername());//购买用户
				json1.put("product", q.getProduct());	//产品
				json1.put("price", q.getPrice());		//价格
				json1.put("quantity", q.getQuantity());	//数量
				json1.put("state", q.getState());	//状态1为代付2为待货3为待收4为待评
				json1.put("Method", q.getMethod());		//支付情况
				json1.put("address", q.getAddress());		//收货地址
				json1.put("path", q.getPath());		//图片路径
				json1.put("date", q.getDate());		//时间
				json1.put("order_form", q.getOrderForm());		//订单号
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
