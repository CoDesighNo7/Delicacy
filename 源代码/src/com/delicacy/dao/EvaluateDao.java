package com.delicacy.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.delicacy.evaluate.CommodityEvaluate;

public class EvaluateDao extends BaseDao {
	//根据商品ID查询商品评价，返回一个评价列表
	public ArrayList<CommodityEvaluate> selectCommodityEvaluate(int commodityID){
		ArrayList<CommodityEvaluate> evaluateList=new ArrayList<CommodityEvaluate>();
		String sql="select commodityEvaluate.commodityID,commodityName,userID,describeMark,qualityMark,delivarMark,evaluate,addevaluate,evaluateTime,sourceID"+
" from commodityEvaluate join commodityinfo on commodityEvaluate.commodityID=commodityinfo.commodityID"+
" where commodityEvaluate.commodityID=?";
		try {
			this.getConnection(sql);
			pstmt.setInt(1, commodityID);
			resultSet=pstmt.executeQuery();
			while(resultSet.next()){
				CommodityEvaluate ce=new CommodityEvaluate();
				ce.setCommodityID(resultSet.getInt(1));
				ce.setCommodityName(resultSet.getString(2));
				ce.setUserID(resultSet.getString(3));
				ce.setDescribeMark(resultSet.getFloat(4));
				ce.setQualityMark(resultSet.getFloat(5));
				ce.setDeliverMark(resultSet.getFloat(6));
				ce.setEvaluate(resultSet.getString(7));
				ce.setAddevaluate(resultSet.getString(8));
				ce.setTime(resultSet.getDate(9));
				ce.setSourceID(resultSet.getInt(10));
				evaluateList.add(ce);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close();
		return evaluateList;
	}
}
