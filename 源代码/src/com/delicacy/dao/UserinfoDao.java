package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.user.UserBean;

public class UserinfoDao extends BaseDao {
	// �����û�id�����û���Ϣ������һ��UserBean�Ķ���
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
	//ע��ʱ�ж��û��Ƿ��Ѵ���,���Ѵ��ڣ�����true�����򷵻�false
	public boolean isUserExist(String phone,String mail){
		boolean result=false;
		String sql="";
		//���ݴ�����ֻ��ź�������Ϣ����sql���
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
			//���в�ѯ��������ʾ�ֻ��Ż������ѱ�ע���������true
			if(resultSet.next()){
				result=true;
			}
			//���޲�ѯ���������false
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
		int id = (int) (Math.random() * 10000000); // ����һ��8λ�������
		int idExist = 0; // �Ѿ����ڵ�ID
		do {
			id++; // id�Լ�
			String sql = "select userID from userinfo where userID=?";
			try {
				this.getConnection(sql);
				pstmt.setString(1, String.valueOf(id)); // ��ѯ�����ɵ�������Ƿ��Ѿ�����Ϊһ��ID
				resultSet = pstmt.executeQuery();
				while (resultSet.next()) {
					idExist = Integer.parseInt(resultSet.getString("userID"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
		} while (id == idExist); // �����ҳ���ID����ʱ��ID+1����һ�β���
		return String.valueOf(id); // ����ID

	}

	// �û�ͨ��������ֻ���ע�ᣬ���û���Ϣ����userinfo���У�������ɹ����򷵻�userBean,������ʧ�ܣ��򷵻�null
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
	//�޸��û���Ϣ
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

	// ɾ���û���Ϣ�����û�IDΪ�������ݣ���ɾ���ɹ����򷵻�1
	public int deleteUserByID() {
		return resultRow;
	}
	/**
	 * @param args
	 */

}
