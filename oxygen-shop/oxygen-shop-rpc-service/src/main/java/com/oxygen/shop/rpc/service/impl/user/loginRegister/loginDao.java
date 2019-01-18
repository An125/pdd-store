package com.oxygen.shop.rpc.service.impl.user.loginRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oxygen.common.model.BasePara;
import com.oxygen.shop.common.po.User;

public class loginDao {
	public static User logi(String username, String mobile, String password) {
		String sql = "SELECT * FROM USER WHERE mobile='" + mobile
				+ "' AND PASSWORD='" + password + "'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(BasePara.driverName).newInstance();
			conn = DriverManager.getConnection(BasePara.url, BasePara.username,
					BasePara.password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString("username"));
				user.setGenerated(rs.getString("Generated"));
				user.setId(rs.getInt("id"));
				user.setMobile(rs.getString("mobile"));
				user.setPassword(rs.getString("password"));
				user.setPrivilege(rs.getString("privilege"));
				user.setLocation(rs.getString("location"));
				user.setTxpath(rs.getString("txpath"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();// str="NO";
		} finally {
			BasePara.closeAll(conn, pstmt, rs);
		}
		return null;
	}
}
