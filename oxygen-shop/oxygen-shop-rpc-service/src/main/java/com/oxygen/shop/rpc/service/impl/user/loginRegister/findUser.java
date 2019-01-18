package com.oxygen.shop.rpc.service.impl.user.loginRegister;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oxygen.common.model.BasePara;
import com.oxygen.shop.common.po.User;

public class findUser {

	public User findUser1(String mobile) {
		//以手机号查询用户
		String sql = "SELECT * FROM USER where mobile='"+mobile+"'";
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			Class.forName(BasePara.driverName).newInstance();
			conn = DriverManager.getConnection(BasePara.url,BasePara.username,BasePara.password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setMobile(rs.getString("mobile"));
					//admin.setPassword(rs.getString("password"));
					//admin.setPermission(rs.getString("permission"));
					//System.out.println(admin);
					//list.add(admin);
					return user;
					
				}
  				
  				
			//System.out.println(ja);
		}catch(Exception e){e.printStackTrace();}finally{
			
			BasePara.closeAll(conn, pstmt, rs);
		}
		
		return null;
	}
	}