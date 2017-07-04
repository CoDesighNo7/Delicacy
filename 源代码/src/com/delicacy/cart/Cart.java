package com.delicacy.cart;

import java.util.ArrayList;

import com.delicacy.commodity.Commodity;
import com.delicacy.commodity.Commodity_Cart;

public class Cart {
	private ArrayList<Commodity> commodityList;
	private float cartAmont;
	private String userID;
	
	
	public Cart(){
		this.commodityList=new ArrayList<Commodity>();
	}
	
	public ArrayList<Commodity> getCommodityList() {
		return commodityList;
	}
	public void setCommodityList(ArrayList<Commodity> commodityList) {
		this.commodityList = commodityList;
	}
	public float getCartAmont() {
		return cartAmont;
	}
	public void setCartAmont() {
		cartAmont=0;
		for(int i=0;i<this.commodityList.size();i++){
			this.cartAmont+=commodityList.get(i).getNowPrice()*commodityList.get(i).getCount();
		}
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
	
	
	

}
