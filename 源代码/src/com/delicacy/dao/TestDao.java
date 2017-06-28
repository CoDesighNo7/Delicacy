package com.delicacy.dao;

import com.delicacy.user.UserBean;

public class TestDao {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserinfoDao userinfoDao=new UserinfoDao();
		UserBean userbean=userinfoDao.selectUserPasswordByID("1001");
		System.out.println("password:"+userbean.getUserPassword());
	}
}
