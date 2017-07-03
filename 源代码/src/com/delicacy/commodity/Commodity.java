package com.delicacy.commodity;

import java.text.SimpleDateFormat;
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
	private float nowPrice;				//�ּ�
	private String expirationDate;		//������
	private float count;				//���빺�ﳵ������
	private float amont;				//���빺�ﳵ����Ʒ���

	public float getAmont() {
		return amont;
	}

	public void setAmont() {
		this.amont = this.nowPrice*this.count;
	}

	public void setNowPrice(float nowPrice) {
		this.nowPrice = nowPrice;
	}

	public float getCount() {
		return count;
	}

	public void setCount(float count) {
		this.count = count;
	}
	public float getNowPrice() {
		return nowPrice;
	}
	public void setNowPrice() {
		Date now=new Date();
		SimpleDateFormat dateformat=new SimpleDateFormat("yyyy/mm/dd");
		long diff=now.getTime()-this.InTime.getTime();
		long days=diff/(1000*60*60*24);
		this.nowPrice=(float) (this.price*(1.0-Float.parseFloat(String.valueOf(days))/Integer.parseInt(expirationDate)));
	}
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
	public String getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
	

}
