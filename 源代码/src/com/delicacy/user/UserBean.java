package com.delicacy.user;

public class UserBean {
	private String userID; // 用户ID
	private String userName; // 用户名
	private String userSex;		//用户性别
	private String userBirth; // 用户出生日
	private String userPassword; // 用户密码
	private String userAddress; // 用户地址
	private String phoneNumber; // 用户手机号码
	private String mail; // 用户邮箱地址
	private String invitation; // 用户填写的邀请码
	private String ownInvitation; // 用户个人邀请码

	public UserBean() {
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex(){
		return userSex;
	}
	
	public void setUserSex(String userSex){
		this.userSex=userSex;
	}
	public String getUserBirth() {
		return userBirth;
	}

	public void setUserBirth(String userBirth) {
		this.userBirth = userBirth;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getInvitation() {
		return invitation;
	}

	public void setInvitation(String invitation) {
		this.invitation = invitation;
	}

	public String getOwnInvitation() {
		return ownInvitation;
	}

	public void setOwnInvitation(String ownInvitation) {
		this.ownInvitation = ownInvitation;
	}

}
