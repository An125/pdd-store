package com.oxygen.shop.rpc.service.impl.user.company.product.pc;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.ResolverUtil.Test;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.oxygen.shop.common.po.Quotation;

import net.sf.json.JSONObject;

public class photographDao {
	//添加
	public static JSONObject add_quotation(String product, String offer,String top_Price, String floor_Price, String stock, String path) {
		JSONObject json = new JSONObject();
		String str = "OK";
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		int insert = 0;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {					
			String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.pc.xml.Quotation.add_quotation";//保存
			/*insert = session.insert(statement, new Quotation("" + product
					+ "", "" + offer + "", "" + top_Price + "", ""
					+ floor_Price + "", "" + path+ "", "" + stock + "","" + nowDate + ""));*/
			// 提交
			session.commit();//如何前面操作都完成成功  进行提交
		} catch (Exception e) {
			str = "NO";
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		json.put("root", str);
		return json;
	}
	//查询
	public static List<Quotation> select_quotation() {
		String resource = "conf.xml";
		InputStream is = Test.class.getClassLoader().getResourceAsStream(
				resource);
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
		SqlSession session = factory.openSession();
		List<Quotation> list = null;
		try {
			String statement = "com.oxygen.shop.rpc.service.impl.user.company.product.pc.xml.Quotation.select_quotation";
			list = session.selectList(statement);
			// 提交
			session.commit();//如何前面操作都完成成功  进行提交
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != session) {
				session.close();
			}
		}
		return list;
		
	}
}
