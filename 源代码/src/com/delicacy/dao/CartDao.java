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
	//向购物车中添加新商品
	public boolean insertCart(String userID,Commodity commodity,float count){
		boolean result=false;
		String sql1="select commodityCount from cartinfo where userID=? and commodityID=?";
		String sql2="insert into cartinfo(userID,commodityID,commodityCount,commodityPrice) values(?,?,?,?)";
		String sql3="update cartinfo set commodityCount=? where userID=? and commodityID=?";
		float inventory=0;
		try {
			this.getConnection(sql1);
			pstmt.setString(1,userID);
			pstmt.setInt(2,commodity.getId());
			resultSet=pstmt.executeQuery();
			if(resultSet.next()){
				inventory=resultSet.getFloat(1);
			}
			close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(inventory!=0){
			try {
				this.getConnection(sql3);
				pstmt.setFloat(1, inventory+count);
				pstmt.setString(2, userID);
				pstmt.setInt(3, commodity.getId());
				resultRow=pstmt.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			close();
			if(resultRow==0){
				return false;
			}
			else return true;
		}
		else {
			try {
				this.getConnection(sql2);
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
	//删除购物车中的商品
	public boolean deleteCart(Commodity commodity,String userID){
		String sql="delete from cartinfo where commodityID=? and userID=?";
		boolean result=false;
		try {
			this.getConnection(sql);
			pstmt.setInt(1, commodity.getId());
			pstmt.setString(2, userID);
			resultRow=pstmt.executeUpdate();
			close();
			if(resultRow==1){
				result=new WareHouseDao().redeceInventory(commodity.getWarehouseID(), commodity.getCount(), 1);
			}
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
