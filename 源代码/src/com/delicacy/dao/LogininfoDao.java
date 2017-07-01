package com.delicacy.dao;

import java.sql.SQLException;

public class LogininfoDao extends BaseDao {
	//根据id，password，identity判断用户登录信息是否正确
	public boolean isCorrect(String id,String password,int identity){
		String sql="select id,password from logininfo where id=? and identity=1";
		String truePassword="0";
		try {
			this.getConnection(sql);
			this.pstmt.setString(1, id);
			this.resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				truePassword=resultSet.getString("password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		if(truePassword.equals(password)){
			return true;
		}
		else 
			return false;
	}
	//向logininfo表中插入用户登陆信息，返回值为表中修改行数
	public int insertLogininfo(String id,String password,int identity){
		String sql="insert into logininfo values(?,?,?)";
		try {
			this.getConnection(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setInt(3, identity);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return resultRow;
	}
	//从用户表中删除用户登陆信息，返回值为表中修改的行数
	public int deleteLogininfo(String id,int identity){
		String sql="delete from logininfo where id=?";
		try {
			this.getConnection(sql);
			pstmt.setString(1, id);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return resultRow;
	}
	//修改密码
	public boolean updatePassword(String id,String password){
		String sql="update logininfo set password=? where id=?";
		try {
			this.getConnection(sql);
			pstmt.setString(1, password);
			pstmt.setString(2, id);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		if(resultRow==1)
			return true;
		else
			return false;
	}
}
