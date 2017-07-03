package com.delicacy.evaluate;

import java.util.Date;

public class CommodityEvaluate {
	private String commodityName;		//评价商品名
	private int commodityID;			//评价商品ID
	private int sourceID;
	private String userID;
	private Float describeMark;
	private Float qualityMark;
	private Float deliverMark;
	private String evaluate;
	private String addevaluate;
	private Date time;
	public String getCommodityName() {
		return commodityName;
	}
	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}
	public int getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(int commodityID) {
		this.commodityID = commodityID;
	}
	public int getSourceID() {
		return sourceID;
	}
	public void setSourceID(int sourceID) {
		this.sourceID = sourceID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public Float getDescribeMark() {
		return describeMark;
	}
	public void setDescribeMark(Float describeMark) {
		this.describeMark = describeMark;
	}
	public Float getQualityMark() {
		return qualityMark;
	}
	public void setQualityMark(Float qualityMark) {
		this.qualityMark = qualityMark;
	}
	public Float getDeliverMark() {
		return deliverMark;
	}
	public void setDeliverMark(Float deliverMark) {
		this.deliverMark = deliverMark;
	}
	public String getEvaluate() {
		return evaluate;
	}
	public void setEvaluate(String evaluate) {
		this.evaluate = evaluate;
	}
	public String getAddevaluate() {
		return addevaluate;
	}
	public void setAddevaluate(String addevaluate) {
		this.addevaluate = addevaluate;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	

}
