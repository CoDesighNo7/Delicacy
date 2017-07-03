package com.delicacy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.delicacy.commodity.Commodity;

public class CommodityDao extends BaseDao {
	//查询商品，返回商品列表
	public ArrayList<Commodity> selectCommodityList(String kind,String name){
		ArrayList<Commodity> commodityList=new ArrayList<Commodity>();
		String sql="select commodityinfo.commodityID,commodityName,pictureURL,commodityKind,commodityPrice,commodityInfo,inventory,inTime,expirationDate "+
"from commodityinfo join warehouseInfo on commodityinfo.commodityID=warehouseInfo.commodityID";
		if(!kind.equals("")&&name.equals("")){
			sql+=" where commodityKind=?";
		}
		else if(kind.equals("")&&!name.equals("")){
			sql+=" where commodityInfo like ?";
		}
		try {
			this.getConnection(sql);
			if(!kind.equals("")&&name.equals("")){
				pstmt.setString(1, kind);
			}
			else if(kind.equals("")&&!name.equals("")){
				pstmt.setString(1, "%"+name+"%");
			}
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				Commodity c=new Commodity();
				c.setId(resultSet.getInt(1));
				c.setName(resultSet.getString(2));
				c.setPictureURL(resultSet.getString(3));
				c.setKind(resultSet.getString(4));
				c.setPrice(resultSet.getFloat(5));
				c.setInfo(resultSet.getString(6));
				c.setInventory(resultSet.getFloat(7));
				c.setInTime(resultSet.getDate(8));
				c.setExpirationDate(resultSet.getString(9));
				commodityList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return commodityList;
	}
	//根据商品ID
	public Commodity selectCommodityByID(int id){
		Commodity commodity=new Commodity();
		String sql="select commodityinfo.commodityID,commodityName,pictureURL,commodityKind,commodityPrice,commodityInfo,inventory,inTime,expirationDate,sourceID "+
"from commodityinfo join warehouseInfo on commodityinfo.commodityID=warehouseInfo.commodityID where commodityinfo.commodityID=?";
		try {
			this.getConnection(sql);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				commodity.setId(resultSet.getInt(1));
				commodity.setName(resultSet.getString(2));
				commodity.setPictureURL(resultSet.getString(3));
				commodity.setKind(resultSet.getString(4));
				commodity.setPrice(resultSet.getFloat(5));
				commodity.setInfo(resultSet.getString(6));
				commodity.setInventory(resultSet.getFloat(7));
				commodity.setInTime(resultSet.getDate(8));
				commodity.setExpirationDate(resultSet.getString(9));
				commodity.setNowPrice();
				commodity.setSourceName(this.selectSourceNameByID(resultSet.getInt(10)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return commodity;
	}
	//查询原产地名
	public String selectSourceNameByID(int id){
		String sourceName="";
		String sql="select sourceName from sourceinfo where sourceID=?";
		try {
			this.getConnection(sql);
			pstmt.setInt(1, id);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				sourceName=resultSet.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return sourceName;
	}
}
