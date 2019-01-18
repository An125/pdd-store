package com.oxygen.shop.rpc.service.impl.user.loginRegister;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.oxygen.common.model.BasePara;
import com.oxygen.shop.common.po.User;

import net.sf.json.JSONObject;

public class registerDao {
	public static JSONObject register(User user) {
		String Privilege="common";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String str = "OK";
		String invitation = user.getInvitation();
		String b = null;
		if (invitation==null) {//邀请码为空默认为公司下 
			b="a";
		} else {
			b=invitation.substring(0,1); 
		}
		String location ="胖嘟嘟总公司";
		String Path=null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate=df.format(new Date());
		//System.out.println(nowDate);
		try { 
			Class.forName(BasePara.driverName).newInstance();
			conn = (Connection) DriverManager.getConnection(BasePara.url,
					BasePara.username, BasePara.password);
			//开启事务
			//conn.setAutoCommit(false);
			if ("b".equals(b)) {//为商家邀请码情况
				String select="select id,username from user where Generated='"+invitation+"'";
				pstmt = conn.prepareStatement(select);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					location=rs.getString("username");
					Path=rs.getString("id");
				}
				sql = "insert into user (username,mobile,PASSWORD,invitation,Privilege,location,Depth,Path,date)values('"+ user.getUsername()+ "','"+ user.getMobile()+ "','"+ user.getPassword() + "','" + user.getInvitation() + "','"+Privilege+"','"+location+"','2','"+Path+"','"+nowDate+"')";
			}else if("c".equals(b)){//为用户邀请码情况
				String Depth=null;
				String superior=null;
				String select= "select id,username,Depth,Path,location from user where Generated='"+invitation+"'";//查询该邀请码上级
				pstmt = conn.prepareStatement(select);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					location=rs.getString("location");
					Path=rs.getString("Path")+","+rs.getString("id");
					Depth=rs.getString("Depth");
					superior = rs.getString("username");
				}
				int a=Integer.parseInt(Depth)+1;
				Depth = String.valueOf(a);
				sql = "insert into user (username,mobile,PASSWORD,invitation,Privilege,location,Path,Depth,superior,date)values('"+ user.getUsername()+ "','"+ user.getMobile()+ "','"+ user.getPassword() + "','" + user.getInvitation() + "','"+Privilege+"','"+location+"','"+Path+"','"+Depth+"','"+superior+"','"+nowDate+"')";
			}else{
				sql = "insert into user (username,mobile,PASSWORD,invitation,Privilege,date)values('"+ user.getUsername()+ "','"+ user.getMobile()+ "','"+ user.getPassword() + "','" + user.getInvitation() + "','"+Privilege+"','"+nowDate+"')";
			}
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(sql);
			InviteGodeGenerated.toSerialCode(""+ user.getMobile()+"");//生成邀请码
			//提交事务
			//conn.commit();
			//conn.close();
		} catch (Exception e) {
			//回滚事务
			//try {
				//conn.rollback();
				//conn.close();
			//} catch (SQLException e1) {
			//	str = "发现错误";
			//}
			str = "用户或者手机号已经存在";
			e.printStackTrace();
		} finally {
			BasePara.closeAll(conn, pstmt, rs);
		}
		JSONObject json = new JSONObject();
		json.put("root", str);
		return json;
	}
}
