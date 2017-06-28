package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.user.UserBean;

public class UserinfoDao extends BaseDao{
	//根据用户id查找用户信息，返回一个UserBean的对象。
	public UserBean selectUserByID(String id){
		UserBean user=new UserBean();
		String sql="select * from userinfo where userID=?";
		try {
			getConnection(sql);
			pstmt.setString(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				user.setUserID(resultSet.getString("userID"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserAge(resultSet.getInt("userAge"));
				user.setPhoneNumber(resultSet.getString("userPhone"));
				user.setMail(resultSet.getString("userMail"));
				user.setInvitation(resultSet.getString("invitation"));
				user.setOwnInvitation(resultSet.getString("ownInvitation"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return user;
	}
	//用户通过邮箱注册，将用户信息插入userinfo表中，若插入成功，则返回1
	public int insertUserByMail(){
		return resultRow;
	}
	//用户通过手机号码注册，同上
	public int insertUserByPhone(){
		return resultRow;
	}
	//删除用户信息，以用户ID为查找依据，若删除成功，则返回1
	public int deleteUserByID(){
		return resultRow;
	}
	/**
	 * @param args
	 */
	

}
