package com.delicacy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnect {
	public static final String url = "jdbc:mysql://120.24.78.243/delicacy";	// ���ݿ��ַ
	public static final String name = "com.mysql.jdbc.Driver";						// ������
	public static final String user = "delicacy";									// ���ݿ��û���
	public static final String password = "123456"; 								// �û�����
	
	public Connection conn=null;
	public PreparedStatement pstmt=null;
	
	public MySQLConnect(String sql){
		try {
			Class.forName(name);										// ָ����������
			conn = DriverManager.getConnection(url, user, password);	// ��ȡ���ݿ�����
			pstmt = conn.prepareStatement(sql);							// ׼��ִ�����
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
