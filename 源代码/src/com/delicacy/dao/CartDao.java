package com.delicacy.dao;

import java.sql.SQLException;

import com.delicacy.cart.Cart;
import com.delicacy.commodity.Commodity;
import com.delicacy.commodity.Commodity_Cart;

public class CartDao extends BaseDao {
	//查询购物车中的商品信息，返回一个Cart实例
	public Cart selectCartByUserID(String userID){
		Cart cart=new Cart();
		cart.setUserID(userID);
		String sql="select userID,cartinfo.commodityID,commodityCount"+
" from cartinfo join commodityinfo on cartinfo.commodityID=commodityinfo.commodityID where userID=?";
		try {
			this.getConnection(sql);
			pstmt.setString(1, userID);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				Commodity c=new CommodityDao().selectCommodityByID(resultSet.getInt(2));
				c.setCount(resultSet.getFloat(3));
				c.setAmont();
				cart.getCommodityList().add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		cart.setCartAmont();
		return cart;
	}
	public boolean insertCart(String userID,Commodity commodity,float count){
		String sql="insert into cartinfo(userID,commodityID,commodityCount,commodityPrice) values(?,?,?,?)";
		try {
			this.getConnection(sql);
			pstmt.setString(1, userID);
			pstmt.setInt(2, commodity.getId());
			pstmt.setFloat(3, count);
			pstmt.setFloat(4, commodity.getNowPrice()*count);
			resultRow=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		if(resultRow==1){
			return true;
		}
		else		
			return false;
	}
	//确认添加到购物车的商品数量足够
	public boolean confirmCount(int commodityID,float count){
		String sql="select inventory from warehouseInfo join commodityinfo on warehouseInfo.commodityID=commodityinfo.commodityID where warehouseInfo.commodityID=?";
		int inventory=0;
		try {
			this.getConnection(sql);
			pstmt.setInt(1, commodityID);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				inventory=resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(inventory>=count)
			return true;
		else return false;
	}
}
