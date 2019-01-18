package com.oxygen.shop.rpc.service.impl.merchants;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.oxygen.common.mybatis.MybatisUtils;
import com.oxygen.shop.common.po.User;
import com.oxygen.shop.rpc.service.impl.user.loginRegister.InviteGodeGenerated;


public class registerPCdao {

	public static void registerPcDao(String mobile, String username,
			String password, String privilege) {
		SqlSessionFactory factory = MybatisUtils.getFactory();
		SqlSession session = factory.openSession();//需要手动提交   
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		try {
		String statement = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.add_user";//保存
																								
//		int insert = session.insert(statement, new User("" + username+ "", "" + mobile + "", "" + password + "", "" + privilege + "", "胖嘟嘟总公司", "2", "1", "" + nowDate + ""));
		String select = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.select_user";
		String id = session.selectOne(select, ""+mobile+"");
		String tableName = ""+id+"_quotation";
		String chuangjian = "com.oxygen.shop.rpc.service.impl.merchants.xml.user.createQuotation";//建该商户产品表
		session.update(chuangjian,""+tableName+"");
		/*String xiaos = "com.pddzn.merchants.xml.user.createmarket";//建该商户销售表
		session.update(xiaos,""+tableName+"");*/
		session.commit();//如何前面操作都完成成功  进行提交
		InviteGodeGenerated.toSerialCode(""+mobile+"");//生成邀请码
		} catch (Exception e) {
			session.rollback();//事务回滚
			e.printStackTrace();
		} finally {
			session.close();
			// System.out.println(insert);
		}
	}

}
