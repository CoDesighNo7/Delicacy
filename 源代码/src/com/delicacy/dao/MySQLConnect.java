package com.delicacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnect {
	public static final String url = "jdbc:mysql://120.24.78.243/delicacy";	// 数据库地址
	public static final String name = "com.mysql.jdbc.Driver";						// 驱动名
	public static final String user = "delicacy";									// 数据库用户名
	public static final String password = "123456"; 								// 用户密码
	
	public Connection conn=null;
	public PreparedStatement pstmt=null;
	
	public MySQLConnect(String sql){
		try {
			Class.forName(name);										// 指定连接类型
			conn = DriverManager.getConnection(url, user, password);	// 获取数据库连接
			pstmt = conn.prepareStatement(sql);							// 准备执行语句
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close(){
		try {
			conn.close();
			pstmt.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
