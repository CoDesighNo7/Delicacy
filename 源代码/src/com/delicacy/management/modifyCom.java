package com.delicacy.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import com.delicacy.commodity.CommoBean;
import com.delicacy.dao.MySQLConnect;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
public class modifyCom extends JFrame {

	private JPanel contentPane;
	private JTable table;
	final ArrayList<CommoBean> sourcelist=new ArrayList<CommoBean>();
    String sql="select commodityID,commodityName,sourceName,commodityKind,commodityPrice,commodityInfo from commodityinfo join sourceinfo on commodityinfo.sourceID=sourceinfo.sourceID;";
    private int change=0;
    private int[] changeid=new int[100];
    private int[] changecol=new int[100];
    private String[] changecon=new String[100];
    private JTextField textField;
    private JTable t=new JTable(); 
    Vector RowData=new Vector(); 
	Vector ColumnNames=new Vector();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifyCom frame = new modifyCom();
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
	
	public modifyCom() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		final JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 63, 708, 383);
		contentPane.add(scrollPane);
		list(sql);
		t= new JTable(RowData,ColumnNames);
		scrollPane.setViewportView(t);
		
		
		
				
				JButton btnNewButton = new JButton("\u4FDD\u5B58\u4FEE\u6539");
				btnNewButton.setFont(new Font("宋体", Font.PLAIN, 16));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						for(int i=0;i<change;i++)
						modi((changeid[i]),changecol[i],changecon[i]);
					}

					private void modi(int id,int pos,String con) {
				// TODO Auto-generated method stub
				String p=null;
				
				MySQLConnect  conn=null;
				System.out.print("succeed1");
				switch(pos)
				{
				case 1:	sql="update commodityinfo set commodityName=? where commodityID=?;";
					try {
						conn=new MySQLConnect(sql);
						conn.pstmt.setString(1, con);
						 conn.pstmt.setInt(2, id);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				       
				break;

				case 4:sql="update commodityinfo set commodityPrice=? where commodityID=?;";
				try {
					conn=new MySQLConnect(sql);
					conn.pstmt.setFloat(1, Float.parseFloat(con));
					 conn.pstmt.setInt(2, id);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}break;
				case 5:sql="update commodityinfo set commodityInfo=? where commodityID=?;";
				try {
					conn=new MySQLConnect(sql);
					conn.pstmt.setString(1, con);
					 conn.pstmt.setInt(2, id);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}       
				break;
				}
				try {
					conn.pstmt.executeUpdate();
					System.out.print("succeed");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
				});
				btnNewButton.setBounds(235, 455, 102, 23);
				contentPane.add(btnNewButton);
				
				JButton btnNewButton_1 = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
				btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 16));
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						commo c=new commo();
						dispose();
						c.setLocationRelativeTo(null);
						c.setVisible(true);
					}
				});
				btnNewButton_1.setBounds(386, 455, 121, 23);
				contentPane.add(btnNewButton_1);
				
				JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u5546\u54C1\u4FE1\u606F\u754C\u9762\uFF1A");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
				lblNewLabel.setBounds(300, 0, 160, 18);
				contentPane.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setFont(new Font("宋体", Font.PLAIN, 16));
				textField.setBounds(320, 30, 66, 23);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_1 = new JLabel("\u641C\u7D22\u5546\u54C1\uFF1A");
				lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
				lblNewLabel_1.setBounds(183, 33, 80, 20);
				contentPane.add(lblNewLabel_1);
				
				JButton btnNewButton_2 = new JButton("\u641C\u7D22");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					    String con=textField.getText();
						String sql="select commodityID,commodityName,sourceName,commodityKind,commodityPrice,commodityInfo from commodityinfo join sourceinfo on commodityinfo.sourceID=sourceinfo.sourceID where commodityName like '%"+con+"%';";
                        System.out.print(sql);
						try {
							list(sql);
							t= new JTable(RowData,ColumnNames);
							scrollPane.setViewportView(t);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 16));
				btnNewButton_2.setBounds(462, 28, 93, 25);
				contentPane.add(btnNewButton_2);
		
		t.getModel().addTableModelListener(new TableModelListener()
		{
			public void tableChanged(TableModelEvent e){
				if (e.getType()==TableModelEvent.UPDATE){
					  String newvalue = t.getValueAt(e.getLastRow(),e.getColumn()).toString();
                      String id=t.getValueAt(e.getLastRow(), 0).toString();
                      System.out.print(Integer.parseInt(id));
                      int idd=Integer.parseInt(id);
				      changeid[change]=idd;
				      changecol[change]=e.getColumn();
				      changecon[change]=newvalue;
				      change++;
                      //if(!newvalue.equals(oldvalue)){
				        	//System.out.print(id);
				        	//modi(Integer.parseInt(id),e.getColumn(),newvalue);
				        	
				        }
				}

			
					
			}
		
		);
     	
	}

	private void list(String sql2) throws SQLException {
		// TODO Auto-generated method stub
		Vector data = new Vector();
		
		final MySQLConnect  conn=new MySQLConnect(sql2);
		
	   conn.resultSet=conn.pstmt.executeQuery();
		sourcelist.clear();
		System.out.print(sourcelist.size());

		while(conn.resultSet.next()){
			CommoBean s=new CommoBean(); 
			s.setcID(conn.resultSet.getInt("commodityID"));
			s.setcName(conn.resultSet.getString("commodityName"));
			s.setcInfo(conn.resultSet.getString("commodityInfo"));
			s.setcK(conn.resultSet.getString("commodityKind"));
			s.setcP(conn.resultSet.getFloat("commodityPrice"));
			s.setsName(conn.resultSet.getString("sourceName"));
			sourcelist.add(s);
			//id=conn.resultSet.getString("commodityID");
		}
		RowData.clear();
		System.out.print(sourcelist.size());
		for(int i=0;i<sourcelist.size();i++){
			Vector hang=new Vector();
			
			hang.add(sourcelist.get(i).getcID());
			hang.add(sourcelist.get(i).getcName());
			hang.add(sourcelist.get(i).getsName());
			hang.add(sourcelist.get(i).getcK());
			hang.add(sourcelist.get(i).getcP());
			hang.add(sourcelist.get(i).getcInfo());
			//hang.get(1);
			//System.out.print(hang.get(1));
			RowData.add(hang);
		}
      
      	
      	ColumnNames= new Vector();
		ColumnNames.add("商品ID");
		ColumnNames.add("商品名称");
		ColumnNames.add("原产地名称");
		ColumnNames.add("商品种类");
		ColumnNames.add("商品价格");
		ColumnNames.addElement("商品简介");
		contentPane.setLayout(null);
	}
	
	
}
