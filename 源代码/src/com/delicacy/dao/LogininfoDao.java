package com.delicacy.dao;

import java.sql.SQLException;

public class LogininfoDao extends BaseDao {
	public boolean isCorrect(String id,String password,int identity){
		String sql="select id,password from logininfo where id=? and identity=1";
		String truePassword="";
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
		if(truePassword.equals(password)){
			return true;
		}
		else return false;
	}
}
