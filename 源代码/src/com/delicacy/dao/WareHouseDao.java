package com.delicacy.dao;

import java.sql.SQLException;

public class WareHouseDao extends BaseDao {
	//�����Ϣ���޸���Ʒ����,symbolΪ�������1Ϊ������ӣ�-1Ϊ������
	public boolean redeceInventory(int id,float count,int symbol){
		String sql1="select inventory from warehouseInfo where warehouseID=?";
		String sql2="update warehouseInfo set inventory=? where warehouseID=?";
		float inventory=0;
		try {
			this.getConnection(sql1);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				inventory=resultSet.getFloat(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		try {
			this.getConnection(sql2);
			pstmt.setFloat(1, inventory+count*symbol);
			pstmt.setInt(2, id);
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
