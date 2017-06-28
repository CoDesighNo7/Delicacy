package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.user.UserBean;

public class UserinfoDao extends BaseDao{
	//�����û�id�����û���Ϣ������һ��UserBean�Ķ���
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
	//�û�ͨ������ע�ᣬ���û���Ϣ����userinfo���У�������ɹ����򷵻�1
	public int insertUserByMail(){
		return resultRow;
	}
	//�û�ͨ���ֻ�����ע�ᣬͬ��
	public int insertUserByPhone(){
		return resultRow;
	}
	//ɾ���û���Ϣ�����û�IDΪ�������ݣ���ɾ���ɹ����򷵻�1
	public int deleteUserByID(){
		return resultRow;
	}
	/**
	 * @param args
	 */
	

}
