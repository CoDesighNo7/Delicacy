package com.delicacy.order;

import java.util.Date;

public class Order {
	private String orderID;
	private String userID;
	private int acceptinfoID;
	private Date createTime;
	private float paymentAmont;
	private String deliveryID;
	private int orderState;
	private float paiedAmont;
	private Date paiedTime;
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getAcceptinfoID() {
		return acceptinfoID;
	}
	public void setAcceptinfoID(int acceptinfoID) {
		this.acceptinfoID = acceptinfoID;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public float getPaymentAmont() {
		return paymentAmont;
	}
	public void setPaymentAmont(float paymentAmont) {
		this.paymentAmont = paymentAmont;
	}
	public String getDeliveryID() {
		return deliveryID;
	}
	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public float getPaiedAmont() {
		return paiedAmont;
	}
	public void setPaiedAmont(float paiedAmont) {
		this.paiedAmont = paiedAmont;
	}
	public Date getPaiedTime() {
		return paiedTime;
	}
	public void setPaiedTime(Date paiedTime) {
		this.paiedTime = paiedTime;
	}
	
}
