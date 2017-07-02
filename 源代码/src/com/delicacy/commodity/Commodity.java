package com.delicacy.commodity;

import java.util.Date;

public class Commodity {
	private int id;						//��ƷID
	private String name;				//��Ʒ��
	private String sourceID;			//ԭ����ID
	private String sourceName;			//ԭ������
	private String sourceAddress;		//ԭ���ص�ַ
	private String pictureURL;			//��ƷͼƬURL
	private Date InTime;				//���ʱ��
	private float inventory;			//�������
	private String kind;				//��Ʒ���
	private String info;				//��Ʒ����
	private float price;				//����
	private Date expirationDate;		//������	
	public float getInventory() {
		return inventory;
	}
	public void setInventory(float inventory) {
		this.inventory = inventory;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceAddress() {
		return sourceAddress;
	}
	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Date getInTime() {
		return InTime;
	}
	public void setInTime(Date wareHouseInTime) {
		this.InTime = wareHouseInTime;
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
