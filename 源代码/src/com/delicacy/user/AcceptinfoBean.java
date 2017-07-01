package com.delicacy.user;

public class AcceptinfoBean {
	private String acceptName;			//�ջ�������
	private String acceptPhone;			//�ջ����ֻ���
	private String acceptAddress;		//�ջ��˵�ַ��ʡ���У��У�������ϸ��ַ֮���ÿո����
	private String province;			//ʡ���У�
	private String city;				//�У�����
	private String street;				//�ֵ�����ϸ��ַ��
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
