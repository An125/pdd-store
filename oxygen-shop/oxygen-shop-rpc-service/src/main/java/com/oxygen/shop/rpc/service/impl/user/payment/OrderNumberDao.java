package com.oxygen.shop.rpc.service.impl.user.payment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class OrderNumberDao {
	/**
	 * 
	 * @param merchants_id 
	 * @param merchants 
	 * @param username 
	 * @param js
	 * @param user_id		用户id
	 * @param price 
	 * @param address 		收货地址
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject ordernumber(String js, String user_id, String username, String merchants, String address, String address_id) {
		if ("null".equals(merchants)||null==merchants) {
			merchants="胖嘟嘟总公司";
		}
		JSONArray ja = JSONArray.fromObject(js);
		JSONObject json1 = new JSONObject();
		String str = "NO"; 
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();//需要手动提交    
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
			DateFormat df1=new SimpleDateFormat("yyyyMMddHHmmss");
			String nowDat=df1.format(new Date());
			Random rad=new Random();
			String a=rad.nextInt(1000)+"";			
			String order_form = nowDat+""+a;	//17位数订单号0
			for (int i = 0; i < ja.size(); i++) {
				
				JSONObject json = ja.getJSONObject(i);
				String product = String.valueOf(json.get("product"));
				String product_id = String.valueOf(json.get("product_id"));
				String quantity = String.valueOf(json.get("quantity"));
				String path = String.valueOf(json.get("path"));
				String price = String.valueOf(json.get("price"));
				//把数据保存到订单表
				String add = "com.oxygen.shop.rpc.service.impl.user.payment.xml.order_form.add_order";
				@SuppressWarnings("rawtypes")
				Map map = new HashMap();
				//insert into order_form
				/*(username,user_id,product,product_id,merchants,merchants_id,price,quantity,date,order_form,state,Method)values(#{username},
				#{user_id}, #{product}, #{product_id}, #{merchants},
				#{merchants_id},#{price},#{quantity},#{date},#{order_form},#{state},#{Method})*/
				map.put("user_id", user_id);//用户id
				map.put("username", username);//用户
				map.put("product", product);//产品
				map.put("product_id", product_id);//报价表id
				map.put("merchants", merchants);//商家
				//map.put("merchants_id", merchants_id); 
				map.put("address_id", address_id);//收货地址id
				map.put("address", address);//收货地址
				map.put("price", price);//价格
				map.put("path", path);//图片路径
				map.put("quantity", quantity); //数量
				map.put("date", nowDate);	//时间
				map.put("order_form", order_form);//订单号
				map.put("state", 1);
				map.put("Method", "还未支付");
				session.insert(add, map);
				str = order_form;		
			
			}
			session.commit();//如何前面操作都完成成功  进行提交
		} catch (Exception e) {
			session.rollback();//事务回滚
			str = "NO";
			e.printStackTrace();
		}finally {
			session.close();
		}
		json1.put("root", str);
		return json1;
	}

}
