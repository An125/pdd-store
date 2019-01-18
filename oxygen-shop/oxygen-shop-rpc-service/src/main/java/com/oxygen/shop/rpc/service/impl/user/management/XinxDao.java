package com.oxygen.shop.rpc.service.impl.user.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.OrderForm;
import com.oxygen.shop.common.po.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class XinxDao {

	public static JSONObject selectUser(String page, String rows) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray ja = new JSONArray();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		List<User> list = null;
		int tota = 0; // 记录数
		//String page=pa.trim();
		/*if ("null".equals(page)||"".equals(page)||page=="null"||""==page) {
			page = "1";
		}
		page="1";
		rows="25";*/
		
		int PageBegin = 0; // 纪录起始号
		int PageEnd = 0; // 纪录结束号
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_userjl"; // 查询记录数
			tota = session.selectOne(statement);
			System.out.println(tota);
			int i = Integer.parseInt(page);
			int j = Integer.parseInt(rows);
			
			// totalPages=10/10;
			PageBegin = j * (i - 1); // 纪录起始号
			PageEnd = PageBegin + j; // 纪录结束号
			String stat = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_user";
			Map map = new HashMap();
			map.put("PageBegin", PageBegin);
			map.put("PageEnd", PageEnd);
			list = session.selectList(stat, map);
			for (User q : list) {
				json1.put("username", q.getUsername());
				json1.put("mobile", q.getMobile());
				json1.put("location", q.getLocation());
				json1.put("superior", q.getSuperior());
				json1.put("consume", q.getConsume());
				ja.add(json1);
			}
			session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();// 事务回滚
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("total", tota);
		json.put("rows", ja);
		return json;
	}

	public static JSONObject selectAdmin(String page, String rows) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray ja = new JSONArray();
		int totalPages = 0;// 总页数
		List<User> list = null;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		String total; // 查询记录数sql
		int tota = 0; // 记录数

		if ("null".equals(page)) {
			page = "1";
		}
		int PageBegin = 0; // 纪录起始号
		int PageEnd = 0; // 纪录结束号
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_adminjl"; // 查询记录数
			tota = session.selectOne(statement);
			System.out.println(tota);
			int i = Integer.parseInt(page);
			int j = Integer.parseInt(rows);
			totalPages = tota / 10; // 总页数
			// totalPages=10/10;
			PageBegin = j * (i - 1); // 纪录起始号
			PageEnd = PageBegin + j; // 纪录结束号
			String stat = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_admin";
			Map map = new HashMap();
			map.put("PageBegin", PageBegin);
			map.put("PageEnd", PageEnd);

			list = session.selectList(stat, map);
			for (User q : list) {
				json1.put("username", q.getUsername());
				json1.put("mobile", q.getMobile());
				json1.put("location", q.getLocation());
				json1.put("superior", q.getSuperior());
				ja.add(json1);
			}
			session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();// 事务回滚
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("total", tota);
		json.put("rows", ja);
		return json;
	}

	public static JSONObject selectUserxf(String username,String page, String rows) {
		JSONObject json = new JSONObject();
		JSONObject json1 = new JSONObject();
		JSONArray ja = new JSONArray();
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();// 需要手动提交
		List<OrderForm> list = null;
		int tota = 0; // 记录数
		int PageBegin = 0; // 纪录起始号
		int PageEnd = 0; // 纪录结束号
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.management.xxgl.xml.select_userxfjl"; // 查询记录数
			tota = session.selectOne(statement,username);
			System.out.println(tota);
			int i = Integer.parseInt(page);
			int j = Integer.parseInt(rows);
			
			// totalPages=10/10;
			PageBegin = j * (i - 1); // 纪录起始号
			PageEnd = PageBegin + j; // 纪录结束号
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
				json1.put("Method", q.getMethod());
				ja.add(json1);
			}
			session.commit();// 如何前面操作都完成成功 进行提交
		} catch (Exception e) {
			session.rollback();// 事务回滚
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("total", tota);
		json.put("rows", ja);
		return json;
	}

}