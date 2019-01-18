package com.oxygen.common.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BasePara {
	public static String url = "jdbc:mysql://192.168.1.88:3306/store?characterEncoding=UTF8";
	public static String driverName = "com.mysql.jdbc.Driver";
	public static String username = "root";
	public static String password = "88828887";

	public static void closeAll(Connection conn,PreparedStatement ps,ResultSet rs){
		try{
			if(null != rs){
				rs.close();
			}
			if(null != ps){
				ps.close();
			}
			if(null != conn){
				conn.close();
			}
		}catch(Exception e){}
	}
}
