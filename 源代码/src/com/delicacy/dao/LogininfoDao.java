package com.delicacy.dao;

import java.sql.SQLException;

public class LogininfoDao extends BaseDao {
	//����id��password��identity�ж��û���¼��Ϣ�Ƿ���ȷ
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
	//��logininfo���в����û���½��Ϣ������ֵΪ�����޸�����
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
	//���û�����ɾ���û���½��Ϣ������ֵΪ�����޸ĵ�����
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
	//�޸�����
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
