package com.delicacy.warehouse;

public class DeliveryForm {
	private String deliveryID;
	private String deliveryAddress;
	private String commodities;
	private float commodityWeight;
	public String getDeliveryID() {
		return deliveryID;
	}
	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}
	public String getCommodities() {
		return commodities;
	}
	public void setCommodities(String commodities) {
		this.commodities = commodities;
	}
	public float getCommodityWeight() {
		return commodityWeight;
	}
	public void setCommodityWeight(float commodityWeight) {
		this.commodityWeight = commodityWeight;
	}
	public String getDeliverName() {
		return deliverName;
	}
	public void setDeliverName(String deliverName) {
		this.deliverName = deliverName;
	}
	public String getDeliverPhone() {
		return deliverPhone;
	}
	public void setDeliverPhone(String deliverPhone) {
		this.deliverPhone = deliverPhone;
	}
	public String getAcceptName() {
		return acceptName;
	}
	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}
	public String getAcceptPhone() {
		return acceptPhone;
	}
	public void setAcceptPhone(String acceptPhone) {
		this.acceptPhone = acceptPhone;
	}
	public float getDeliverCost() {
		return deliverCost;
	}
	public void setDeliverCost(float deliverCost) {
		this.deliverCost = deliverCost;
	}
	private String deliverName;
	private String deliverPhone;
	private String acceptName;
	private String acceptPhone;
	private float deliverCost;
	
}
