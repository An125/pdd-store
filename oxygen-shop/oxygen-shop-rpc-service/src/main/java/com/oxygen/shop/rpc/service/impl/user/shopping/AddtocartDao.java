package com.oxygen.shop.rpc.service.impl.user.shopping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.Shopping;

import net.sf.json.JSONObject;

public class AddtocartDao {
/**
 * 
 * @param user_id 			用户id
 * @param original_price	原价格	
 * @param rates				优惠价格
 * @param quantity			数量
 * @param product			产品
 * @param path				图片路径
 * @param location 
 * @param quotation_id 
 * @return
 */
	public static JSONObject addtocartdao(String user_id,
			String original_price, String rates, String quantity,
			String product, String path, String location, String quotation_id) {
		/*if ("null".equals(location)||null==location) {
			location="胖嘟嘟总公司";
		}*/
		JSONObject json = new JSONObject();
		String str = "OK";
		int insert = 0;
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();//需要手动提交    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
			String select= "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.select_product";//查询
			Map ma = new HashMap();
			ma.put("user_id", user_id);
			ma.put("product", product);
			List<Shopping> list = session.selectList(select, ma);
			if (!(list.size()==0)) {//该产品存在的情况下
				String update= "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.update_product";//修改
				Map m = new HashMap();
				for(Shopping shopping:list){
					int i = Integer.parseInt(shopping.getQuantity()); 
					quantity = String.valueOf(i+1);
				}
				m.put("user_id", user_id);
				m.put("product", product);
				m.put("quantity", quantity);
				int updat = session.update(update, m);	
			}else {
				String statement = "com.oxygen.shop.rpc.service.impl.user.shopping.xml.user_shopping.add_product";//保存
				Map map = new HashMap();
				map.put("user_id", user_id);
				map.put("original_price", original_price);
				map.put("rates",rates);
				map.put("quantity",quantity);
				map.put("product",product);
				map.put("path",path);
				map.put("date",nowDate);
				map.put("location", location);
				map.put("quotation_id", quotation_id);
				insert = session.insert(statement, map);				
			}			
			// 提交
			session.commit();//如何前面操作都完成成功  进行提交
		} catch (Exception e) {
			session.rollback();//事务回滚
			str = "NO";
			e.printStackTrace();
		} finally {
			session.close();
			// System.out.println(insert);
		}
		json.put("root", str);
		return json;
		}

}
