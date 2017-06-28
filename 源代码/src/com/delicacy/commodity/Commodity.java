package com.delicacy.commodity;

import java.util.Date;

public class Commodity {
	private String id;
	private String name;
	private String sourceID;
	private String pictureURL;
	private Date wareHouseInTime;
	private String kind;
	private float price;
	private Date expirationDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourceID() {
		return sourceID;
	}
	public void setSourceID(String sourceID) {
		this.sourceID = sourceID;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public Date getWareHouseInTime() {
		return wareHouseInTime;
	}
	public void setWareHouseInTime(Date wareHouseInTime) {
		this.wareHouseInTime = wareHouseInTime;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	

}
