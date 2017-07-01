package com.delicacy.user;

public class AcceptinfoBean {
	private String acceptName;			//收货人姓名
	private String acceptPhone;			//收货人手机号
	private String acceptAddress;		//收货人地址，省（市）市（区）详细地址之间用空格隔开
	private String province;			//省（市）
	private String city;				//市（区）
	private String street;				//街道（详细地址）
	public AcceptinfoBean(){}
	public AcceptinfoBean(String acceptName,String acceptPhone,String acceptAddress){
		this.acceptName=acceptName;
		this.acceptPhone=acceptPhone;
		this.acceptAddress=acceptAddress;
		String [] address=acceptAddress.split(" ");
		this.province=address[0];
		this.city=address[1];
		this.street=address[2];
	}
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
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
	public String getAcceptAddress() {
		return acceptAddress;
	}
	public void setAcceptAddress(String acceptAddress) {
		this.acceptAddress = acceptAddress;
	}
	
}
