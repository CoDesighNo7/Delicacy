package com.delicacy.cart;

import java.util.ArrayList;

import com.delicacy.commodity.Commodity_Cart;

public class Cart {
	private ArrayList<Commodity_Cart> commodityList;
	private float cartAmont;
	private String userID;
	public ArrayList<Commodity_Cart> getCommodityList() {
		return commodityList;
	}
	public void setCommodityList(ArrayList<Commodity_Cart> commodityList) {
		this.commodityList = commodityList;
	}
	public float getCartAmont() {
		return cartAmont;
	}
	public void setCartAmont(float cartAmont) {
		this.cartAmont = cartAmont;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
	

}
