package com.delicacy.dao;

import java.sql.SQLException;

public class WareHouseDao extends BaseDao {
	//库存信息中修改商品数量,symbol为运算符，1为库存增加，-1为库存减少
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
