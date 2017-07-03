package com.delicacy.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TextField;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;

import com.delicacy.commodity.SourceBean;
import com.delicacy.dao.MySQLConnect;

import java.awt.Font;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JComboBox;

public class comIn extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	final ArrayList<SourceBean> sourcelist=new ArrayList<SourceBean>();
	//private JTextField[]  jtf[];
	private int num=1;
	private int i=0;
    private int x=530;
    private int y=153;
    private int ly=120;
    private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					comIn frame = new comIn();
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
	 * @throws SQLException 
	 */
	public comIn() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u586B\u5199\u5165\u5E93\u5355\u4FE1\u606F\uFF1A");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(37, 15, 387, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u5165\u5E93\u65F6\u95F4\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(30, 57, 364, 15);
		contentPane.add(label);
		
		Date now=new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/HH/mm/ss");//可以方便地修改日期格式
		String hehe = dateFormat.format( now ); 
		//System.out.println(hehe);   
		
		Calendar c = Calendar.getInstance();//可以对每个时间域单独修改

		 


	    String[] spl=hehe.split("/");
		
		final String time=spl[0]+spl[1]+spl[2]+spl[3]+spl[4]+spl[5]; 
		final String time2=spl[0]+spl[1]+spl[2];
		//System.out.println(time);
		textField = new JTextField(hehe);
		textField.setBounds(110, 55, 130, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5546\u54C1\u540D\u79F0");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(30, 90, 366, 20);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u5165\u5E93\u6570\u91CF");
		label_2.setFont(new Font("宋体", Font.PLAIN, 16));
		label_2.setBounds(330, 90, 234, 20);
		contentPane.add(label_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u5B58\u653E\u4F4D\u7F6E");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(430, 90, 95, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("\u6267\u884C\u5E93\u7BA1\u5458\uFF1A");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(288, 57, 180, 15);
		contentPane.add(label_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(388, 55, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		final JTextField[] list = new JTextField[100];
		
		list[0] = new JTextField();
		list[0].setBounds(30, 120, 66, 21);
		contentPane.add(list[0]);
		//list[0].setColumns(10);
		
		final JComboBox[] com=new JComboBox[100];
		source();
		com[0] = new JComboBox();
		com[0].setBounds(120, 120, 90, 21);
		contentPane.add(com[0]);
		com[0].addItem("请选择原产地:");
		for(int i=0;i<sourcelist.size();i++){
			com[0].addItem(sourcelist.get(i).getName());
		}
		
		list[2] = new JTextField();
		list[2].setBounds(230, 120, 66, 21);
		contentPane.add(list[2]);
		list[2].setColumns(10);
		
		list[3] = new JTextField();
		list[3].setBounds(330, 120, 66, 21);
		contentPane.add(list[3]);
		list[3].setColumns(10);
		list[4] = new JTextField();
		list[4].setBounds(430, 120, 66, 21);
		contentPane.add(list[4]);
		list[4].setColumns(10);
		
		list[5] = new JTextField();
		list[5].setBounds(530, 120, 66, 21);
		contentPane.add(list[5]);
		list[5].setColumns(10);
		
		
		
		final JButton btnNewButton = new JButton("\u6DFB\u52A0");
		
		btnNewButton.setBounds(530, 153, 60, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				warehouse frame=new warehouse();dispose();frame.setLocationRelativeTo(null);frame.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(311, 10, 120, 23);
		contentPane.add(btnNewButton_1);
		
		final JButton btnNewButton_2 = new JButton("\u63D0\u4EA4\u5165\u5E93\u5355");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options ={ "提交！", "取消" };  
				int m = JOptionPane.showOptionDialog(null, "确定提交入库单吗？", "标题",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				
				if (m==0)
				{System.out.print("高兴"); 
				 JOptionPane.showMessageDialog(null, "入库单提交成功");
				 warehouse frame=new warehouse();dispose();frame.setLocationRelativeTo(null);frame.setVisible(true);
				 }
				else {System.out.print("不高兴");return;}
				
				String sql="insert into wareHouseInForm values(?,?,?);";
				MySQLConnect conn=new MySQLConnect(sql);
				try {
					conn.pstmt.setString(1,time);
					conn.pstmt.setString(2,textField.getText());
					conn.pstmt.setString(3,textField_1.getText());
					conn.pstmt.executeUpdate();
					
					//System.out.print(textField.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 JLabel[] la = new JLabel[100];
				for(i=0;i<num;i++)
				{
					//System.out.print(com[i].getSelectedItem());
				  if ("".equals(list[i*6].getText())||"".equals(com[i].getSelectedItem())||"".equals(list[i*6+2].getText())||"".equals(list[i*6+3].getText())||"".equals(list[i*6+4].getText()))
				  {
					  //System.out.println("缺少数据，跳过该行");
					  int yy=120+30*i;
					  la[i]=new JLabel("缺少数据\n 跳过该行");
						la[i].setFont(new Font("宋体", Font.PLAIN, 16));
						la[i].setBounds(600, yy, 366, 20);
						
						contentPane.add(la[i]);
					  continue;
				  }
				  com[i].addItemListener(new ItemListener()
					{
						public void itemStateChanged(ItemEvent e)
						{
							if(e.getStateChange()==ItemEvent.SELECTED)
							{   //System.out.print(comboBox.getSelectedIndex());
								String text=(String) com[i].getSelectedItem();  
								//System.out.print(text);
								System.out.print(sourcelist.get((com[i].getSelectedIndex()-1)).getId());
							}
						}
					});
				  
				  sql="insert into commodityinfo(commodityName,sourceID,commodityKind) values (?,?,?)";
				  conn=new MySQLConnect(sql);
				  String id=null;
				  try {
					conn.pstmt.setString(1,list[i*6].getText());
					conn.pstmt.setInt(2,sourcelist.get(com[i].getSelectedIndex()-1).getId());
					conn.pstmt.setString(3,list[i*6+2].getText());
					conn.pstmt.executeUpdate();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  sql="select commodityID from commodityinfo where (commodityName=? and sourceID=?);";
				  conn=new MySQLConnect(sql);
				  try {
					conn.pstmt.setString(1,list[i*6].getText());
					conn.pstmt.setInt(2,sourcelist.get(com[i].getSelectedIndex()-1).getId());
					conn.resultSet=conn.pstmt.executeQuery();
					while(conn.resultSet.next()){
						id=conn.resultSet.getString("commodityID");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  sql="insert into wareHouseIn(informID,commodityID,commodityKind,commodityCount,siteID) values(?,?,?,?,?);";
				  conn=new MySQLConnect(sql);
                  try {
					//conn.pstmt.setString(1,Integer.toString(i+1));
					conn.pstmt.setString(1,time);
					conn.pstmt.setString(2,id);
					conn.pstmt.setString(3,list[i*6+2].getText());
					conn.pstmt.setInt(4,Integer.parseInt(list[i*6+3].getText()));
					conn.pstmt.setString(5,list[i*6+4].getText());
					conn.pstmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                  sql="insert into warehouseInfo(commodityID,inventory,inTime,expirationDate) values(?,?,?,?)";
                  conn=new MySQLConnect(sql);
                  try {
					conn.pstmt.setString(1,id);
					conn.pstmt.setInt(2,Integer.parseInt(list[i*6+3].getText()));
					conn.pstmt.setString(3, time2);
					conn.pstmt.setString(4, list[i*6+5].getText());
					conn.pstmt.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                  
				}
				
				conn.close();
				contentPane.updateUI();
			}
			
		});
		btnNewButton_2.setBounds(260, 300, 120, 25);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("\u539F\u4EA7\u5730");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(130, 90, 214, 20);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5546\u54C1\u79CD\u7C7B");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(230, 90, 78, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u4FDD\u8D28\u671F");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(530, 90, 54, 20);
		contentPane.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(140, 120, 32, 21);
		contentPane.add(comboBox);
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				x=x;y=y+30;
				btnNewButton.setBounds(x,y, 60,30);
				btnNewButton_2.setBounds(260, 300-153+y, 120, 23);
				ly=ly+30;
				list[num*6]=new JTextField();
				list[num*6].setBounds(30, ly, 66, 21);
				contentPane.add(list[num*6]);
				
				
				com[num] = new JComboBox();
				com[num].setBounds(120, ly, 90, 21);
				contentPane.add(com[num]);
				com[num].addItem("请选择原产地:");
				for(int i=0;i<sourcelist.size();i++){
					com[num].addItem(sourcelist.get(i).getName());
				}
				
				list[num*6+2]=new JTextField();
				list[num*6+2].setBounds(230, ly, 66, 21);
				contentPane.add(list[num*6+2]);
				list[num*6+3]=new JTextField();
				list[num*6+3].setBounds(330, ly, 66, 21);
				contentPane.add(list[num*6+3]);
				list[num*6+4]=new JTextField();
				list[num*6+4].setBounds(430, ly, 66, 21);
				contentPane.add(list[num*6+4]);
				list[num*6+5]=new JTextField();
				list[num*6+5].setBounds(530, ly, 66, 21);
				contentPane.add(list[num*6+5]);
				
				
				num++;
				contentPane.updateUI();
			}
		});
		
		
	}

	private void source() throws SQLException {
		// TODO Auto-generated method stub
        String sql="select sourceID,sourceName from sourceinfo;";
		
		MySQLConnect conn=new MySQLConnect(sql);
		//conn.pstmt.setString(1, "原产地2");
		conn.resultSet=conn.pstmt.executeQuery();
		
		while(conn.resultSet.next()){
			SourceBean s=new SourceBean(); 
			s.setId(conn.resultSet.getInt("sourceID"));
			//aa=conn.resultSet.getString("sourceID")
				//	bb=conn.resultSet.getString("sourceName"));
			s.setName(conn.resultSet.getString("sourceName"));
			sourcelist.add(s);
			//id=conn.resultSet.getString("commodityID");
		}
	}
}
