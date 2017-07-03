package com.delicacy.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;

import com.delicacy.dao.*;

public class index extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private static String id;		//用户输入的ID
	private static String pwd;		//用户输入的密码
	private String pwd_sql=null;	//从数据库读取出来的密码
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					index frame = new index();
					frame.setLocationRelativeTo(null);
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
	public index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7EFF\u8272\u519C\u4EA7\u54C1\u9500\u552E\u7CFB\u7EDF\uFF08\u7BA1\u7406\u7AEF\uFF09");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(150, 10, 224, 31);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u7528\u6237\u767B\u5F55\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(226, 51, 93, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8D26\u53F7\uFF1A");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(134, 111, 170, 15);
		contentPane.add(label_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(243, 109, 113, 21);
		contentPane.add(textField);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(134, 152, 170, 15);
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(243, 150, 113, 21);
		contentPane.add(passwordField);
		
		
		
		final JLabel label_4 = new JLabel("\u5BC6\u7801\u9519\u8BEF");
		label_4.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		label_4.setBounds(389, 153, 120, 15);
		contentPane.add(label_4);
		label_4.setVisible(false);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
				//System.out.print("pwd是："+pwd);
				if("".equals(pwd))
				{  
					label_4.setVisible(true);
					label_4.setText("密码不能为空");
				}
				else
				{
				
				if (pwd.equals(pwd_sql))
				{
				 JOptionPane.showMessageDialog(null, "登录成功");
				 switch (pd())
				 {
				 case 1:warehouse frame=new warehouse();dispose();frame.setLocationRelativeTo(null);frame.setVisible(true); break;
                 
				 case 2:commo frame2=new commo();dispose();frame2.setLocationRelativeTo(null);frame2.setVisible(true); break;
				 case 3:
				 }
				 System.out.print(pd());
				 
				
                	
                      
				}
				else
				  {
				    label_4.setVisible(true);
				    label_4.setText("密码错误");
				  }
				}
			}
		});
		btnNewButton.setBounds(198, 199, 93, 23);
		contentPane.add(btnNewButton);
		
	}
	protected int pd() {
		// TODO Auto-generated method stub
		String type=null;
		String sql="select employeePost from logininfo join employeeinfo on logininfo.id=employeeinfo.employeeID where logininfo.id=?;";
		MySQLConnect conn=new MySQLConnect(sql);
		try {
			conn.pstmt.setString(1,id);
			conn.resultSet=conn.pstmt.executeQuery();
			while(conn.resultSet.next()){
				type=conn.resultSet.getString("employeePost");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		if ("wh".equals(type))
		{
		    return 1;
		}
		else
			if("com".equals(type))
		      {
			     return 2;
		      }
			else
				if("cS".equals(type)) return 3;
	    return 0;
 
		
	}

	public void login(){
		id=textField.getText();
		char[] pwd_p=passwordField.getPassword();
		pwd=String.valueOf(pwd_p);
		//System.out.print(pwd);
		String sql="select password from logininfo where id=?;";
		MySQLConnect conn=new MySQLConnect(sql);
		try {
			conn.pstmt.setString(1, id);
			conn.resultSet=conn.pstmt.executeQuery();
			while(conn.resultSet.next()){
				pwd_sql=conn.resultSet.getString("password");
			}
		//System.out.print(pwd_sql);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		conn.close();
		
	}
}
