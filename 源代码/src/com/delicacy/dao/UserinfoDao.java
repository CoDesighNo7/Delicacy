package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.user.UserBean;

public class UserinfoDao extends BaseDao{
	//public UserinfoDao(){}
	public UserBean selectUserPasswordByID(String id){
		UserBean user=new UserBean();
		String sql="select id,password from logininfo where userID=?";
		try {
			getConnection(sql);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				user.setUserID(resultSet.getString("id"));
				user.setUserPassword(resultSet.getString("password"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	/**
	 * @param args
	 */
	

}
