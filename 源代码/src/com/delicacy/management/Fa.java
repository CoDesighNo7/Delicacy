package com.delicacy.management;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;


import com.delicacy.dao.MySQLConnect;
import com.delicacy.management.Ftable;
import com.delicacy.user.AcceptinfoBean;

import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Fa extends JFrame implements ActionListener  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
    JTable jt=null;
    JScrollPane jsp=null;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Fa frame = new Fa();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Fa() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("请输入要搜索的订单号：");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=textField.getText();
				
				String sql="select u_orderID,userOrder.userID,userinfo.userName,orderCommodity.commodityID,commodityinfo.commodityName,commodityCount,commodityAmont from userOrder join orderCommodity on userOrder.u_orderID=orderCommodity.orderID,userinfo,commodityinfo where orderCommodity.commodityID=commodityinfo.commodityID and userOrder.userID=userinfo.userID and u_orderID='"+name+"'";

				Ftable x=new Ftable(sql);
				jt.setModel(x);
			}
		});
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton_3 = new JButton("发货");
		btnNewButton_3.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				String id=textField_1.getText();
				AcceptinfoBean acceptinfo=new AcceptinfoBean();
				String flag="";
				String flag1="select u_orderState from userOrder where u_orderID='"+id+"'";
				MySQLConnect a=new MySQLConnect(flag1);
				try{
					ResultSet re=a.pstmt.executeQuery();
					if(re.next())
						flag=re.getString(1);
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 
				 if(flag.equals("")){
						JOptionPane.showMessageDialog(null, "不存在此订单");  
						return;
					}
				 int c = Integer.parseInt(flag);
				 if(c==2){
					JOptionPane.showMessageDialog(null, "此订单以发货");  
					return;
				}
				if(c==0){
					JOptionPane.showMessageDialog(null, "此订单未付款");  
					return;
				}	
				String sql="update userOrder set u_orderState=2 where u_orderID='"+id+"'";
				MySQLConnect con=new MySQLConnect(sql);
				try {
					con.pstmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				String sql1="select acceptinfoID,userOrder.userID,acceptName,acceptNumber,acceptAddress from userOrder join useracceptinfo on userOrder.acceptinfoID=useracceptinfo.user_acceptID where userOrder.u_orderID='"+id+"'";
				MySQLConnect con1=new MySQLConnect(sql1);
				try {
					ResultSet resultSet=con1.pstmt.executeQuery();
					if(resultSet.next())
					{
					acceptinfo.setAcceptinfoID(resultSet.getInt(1));
					acceptinfo.setUserID(resultSet.getString(2));
					acceptinfo.setAcceptName(resultSet.getString(3));
					acceptinfo.setAcceptPhone(resultSet.getString(4));
					acceptinfo.setAcceptAddress(resultSet.getString(5));
					}con1.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String sql2="insert into deliveryForm(deliveryID,sendoutTime,deliverMan,phoneNumber,acceptinfoID,cost) values(?,now(),?,?,?,5)";
				String deliveryID=acceptinfo.getUserID()+id;
				int row=0;
				MySQLConnect con2=new MySQLConnect(sql2);
				try {
					con2.pstmt.setString(1, deliveryID);
					con2.pstmt.setString(2, acceptinfo.getAcceptName());
					con2.pstmt.setString(3, acceptinfo.getAcceptPhone());
					con2.pstmt.setInt(4,acceptinfo.getAcceptinfoID());
					row=con2.pstmt.executeUpdate();
					con2.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
					JOptionPane.showMessageDialog(null, "发货成功");
					Fa newframe = new Fa();
					newframe.setVisible(true);
					dispose();
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("订单号：");
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		btnNewButton_3.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		panel_1.add(btnNewButton_3);

		
		
		setTitle("发货管理");

        Ftable x=new Ftable();
        jt=new JTable(x);
		jsp=new JScrollPane(jt);
		getContentPane().add(jsp);
		this.setBounds(12, 76, 380, 560);
		this.setVisible(true);

		}
	
	public void actionPerformed(ActionEvent arg0) {
		// TODO 自动生成的方法存根
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

