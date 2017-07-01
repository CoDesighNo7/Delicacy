package com.delicacy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.delicacy.user.*;

public class UseracceptinfoDao extends BaseDao{
	//�����ջ���Ϣ,����ӳɹ��������ջ���Ϣʵ������ʧ�ܣ�����null
	public AcceptinfoBean insertAcceptinfo(String userID,String acceptName,String acceptPhone,String acceptAddress){
		AcceptinfoBean acceptinfo=new AcceptinfoBean();
		String sql="insert into useracceptinfo(userID,acceptName,acceptNumber,acceptAddress) values(?,?,?,?)";
		try {
			this.getConnection(sql);
			pstmt.setString(1, userID);
			pstmt.setString(2, acceptName);
			pstmt.setString(3, acceptPhone);
			pstmt.setString(4, acceptAddress);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		if(resultRow==1){
			acceptinfo.setAcceptAddress(acceptAddress);
			acceptinfo.setAcceptName(acceptName);
			acceptinfo.setAcceptPhone(acceptPhone);
		}
		else
			acceptinfo=null;
		return acceptinfo;
	}
	//�����û�ID��ѯ�û���ǰ������ջ���Ϣ������һ��ArrayList
	public ArrayList<AcceptinfoBean> selectAcceptinfoByUserID(String userID){
		ArrayList<AcceptinfoBean> acceptinfoList=new ArrayList<AcceptinfoBean>();
		String sql="select acceptName,acceptNumber,acceptAddress from useracceptinfo where userID=?";
		try {
			this.getConnection(sql);
			pstmt.setString(1, userID);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				AcceptinfoBean ai=new AcceptinfoBean(resultSet.getString(1),resultSet.getString(2),resultSet.getString(3));
				acceptinfoList.add(ai);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return acceptinfoList;
	}
}
