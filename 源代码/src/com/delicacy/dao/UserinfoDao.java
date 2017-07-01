package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.user.UserBean;

public class UserinfoDao extends BaseDao {
	// 根据用户id查找用户信息，返回一个UserBean的对象。
	public UserBean selectUserByID(String id) {
		UserBean user = new UserBean();
		String sql = "select * from userinfo where userID=?";
		try {
			getConnection(sql);
			pstmt.setString(1, id);
			resultSet = pstmt.executeQuery();
			while (resultSet.next()) {
				user.setUserID(resultSet.getString("userID"));
				user.setUserName(resultSet.getString("userName"));
				user.setUserBirth(resultSet.getDate("userBirth").toString());
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
	//注册时判断用户是否已存在,若已存在，返回true，否则返回false
	public boolean isUserExist(String phone,String mail){
		boolean result=false;
		String sql="";
		//根据传入的手机号和邮箱信息生成sql语句
		if(phone!=null&&mail==null){
			sql="select userPhone from userinfo where userPhone=?";
		}
		if(phone==null&&mail!=null){
			sql="select userMail from userinfo where userMail=?";
		}
		try {
			this.getConnection(sql);
			if(phone!=null&&mail==null){
				pstmt.setString(1, phone);
			}
			if(phone==null&&mail!=null){
				pstmt.setString(1, mail);
			}
			resultSet=pstmt.executeQuery();
			//若有查询结果，则表示手机号或邮箱已被注册过，返回true
			if(resultSet.next()){
				result=true;
			}
			//若无查询结果，返回false
			else
				result=false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return result;
	}
	public String selectNextUserID() {
		int id = (int) (Math.random() * 10000000); // 产生一个8位的随机数
		int idExist = 0; // 已经存在的ID
		do {
			id++; // id自加
			String sql = "select userID from userinfo where userID=?";
			try {
				this.getConnection(sql);
				pstmt.setString(1, String.valueOf(id)); // 查询已生成的随机数是否已经存在为一个ID
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					idExist = Integer.parseInt(resultSet.getString("userID"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		} while (id == idExist); // 当查找出来ID存在时，ID+1，再一次查找
		return String.valueOf(id); // 返回ID

	}

	// 用户通过邮箱或手机号注册，将用户信息插入userinfo表中，若插入成功，则返回userBean,若插入失败，则返回null
	public UserBean insertUser(String mail, String phone, String invitation) {
		UserBean user = new UserBean();
		String sql = "insert userinfo(userID,userMail,userPhone,ownInvitation) values (?,?,?,?)";
		String id = this.selectNextUserID();
		try {
			this.getConnection(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, mail);
			pstmt.setString(3, phone);
			pstmt.setString(4, invitation);
			resultRow = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		if (resultRow == 1) {
			user.setUserID(id);
			user.setMail(mail);
			user.setPhoneNumber(phone);
			user.setInvitation(invitation);
			return user;
		} else
			return null;
	}
	//修改用户信息
	public int updateUserinfo(String userID,String userName,String userSex,String userBirth){
		String sql="update userinfo set userName=?,userSex=?,userBirth=? where userID=?";
		try {
			this.getConnection(sql);
			pstmt.setString(1, userName);
			pstmt.setString(2, userSex);
			pstmt.setString(3, userBirth);
			pstmt.setString(4, userID);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return resultRow;
	}

	// 删除用户信息，以用户ID为查找依据，若删除成功，则返回1
	public int deleteUserByID() {
		return resultRow;
	}
	/**
	 * @param args
	 */

}
