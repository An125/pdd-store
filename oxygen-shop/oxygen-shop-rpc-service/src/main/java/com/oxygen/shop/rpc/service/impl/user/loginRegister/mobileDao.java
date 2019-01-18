package com.oxygen.shop.rpc.service.impl.user.loginRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.oxygen.common.model.BasePara;

import net.sf.json.JSONObject;

public class mobileDao {
	public static JSONObject register(String mobile) {
		String sql = "SELECT * FROM USER WHERE mobile='" + mobile + "'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		JSONObject json = new JSONObject();
		String str = "OK";
		try {
			Class.forName(BasePara.driverName).newInstance();
			conn = DriverManager.getConnection(BasePara.url, BasePara.username,
					BasePara.password);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				str = "手机号存在";
			}
			rs = pstmt.executeQuery();
			if (rs.last()) {
				// System.out.println(tota);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			BasePara.closeAll(conn, pstmt, rs);
		}
		json.put("root", str);
		// System.out.println(json);
		return json;
	}
}
