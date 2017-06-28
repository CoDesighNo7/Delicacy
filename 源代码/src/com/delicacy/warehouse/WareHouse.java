package com.delicacy.warehouse;

import java.util.Date;

public class WareHouse {
	private String commodityID;
	private Date wareHouseInTime;
	public String getCommodityID() {
		return commodityID;
	}
	public void setCommodityID(String commodityID) {
		this.commodityID = commodityID;
	}
	public Date getWareHouseInTime() {
		return wareHouseInTime;
	}
	public void setWareHouseInTime(Date wareHouseInTime) {
		this.wareHouseInTime = wareHouseInTime;
	}
	
	private float inventory;
	private Date expirationDate;
	private Date dropTime;
	public float getInventory() {
		return inventory;
	}
	public void setInventory(float inventory) {
		this.inventory = inventory;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Date getDropTime() {
		return dropTime;
	}
	public void setDropTime(Date dropTime) {
		this.dropTime = dropTime;
	}
	
}
