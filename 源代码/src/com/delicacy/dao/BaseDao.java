package com.delicacy.dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class BaseDao {
	//采用连接池的方式获取数据库连接
	DataSource dataSource;				//数据源
    PreparedStatement pstmt=null;		//语句对象
    Connection conn=null;				//连接对象
    ResultSet resultSet=null;			//返回查询结果
    int resultRow=0;					//返回更新行数
    public BaseDao(){
        try {
            Context context=new InitialContext();
            dataSource =(DataSource)context.lookup("java:comp/env/jdbc/delicacy");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public void getConnection(String sql) throws SQLException {
    	conn=dataSource.getConnection();		//获取一个数据库连接
    	pstmt=conn.prepareStatement(sql);		//根据sql语句生成一个语句对象
    	resultSet=null;
    	resultRow=0;
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
