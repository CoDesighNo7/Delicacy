package com.delicacy.user;

public class UserBean {
	private String userID;			//�û�ID
	private String userName;		//�û���
	private int userAge;			//�û�����
	private String userPassword;	//�û�����
	private String userAddress;		//�û���ַ
	private String phoneNumber;		//�û��ֻ�����
	private String mail;			//�û������ַ
	private String invitation;		//�û���д��������	
	private String ownInvitation;	//�û�����������
	
	public UserBean(){}
	
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
	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
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
	public String getMail(){
		return mail;
	}
	public void setMail(String mail){
		this.mail=mail;
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
