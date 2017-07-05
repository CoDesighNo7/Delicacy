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

import com.delicacy.commodity.SourceInfoBean;
import com.delicacy.dao.MySQLConnect;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
public class modifySource extends JFrame {

	private JPanel contentPane;
	private JTable table;
	final ArrayList<SourceInfoBean> sourcelist=new ArrayList<SourceInfoBean>();
    String sql="select sourceID,sourceName,sourceAddress from sourceinfo;";
    private int change=0;
    private int[] changeid=new int[100];
    private int[] changecol=new int[100];
    private String[] changecon=new String[100];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					modifySource frame = new modifySource();
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
	
	public modifySource() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Vector data = new Vector();
		Vector RowData=new Vector(); 
		Vector ColumnNames=new Vector();
		
		final MySQLConnect  conn=new MySQLConnect(sql);
		
	   conn.resultSet=conn.pstmt.executeQuery();
		
		while(conn.resultSet.next()){
			SourceInfoBean s=new SourceInfoBean(); 
			s.setID(conn.resultSet.getInt("sourceID"));
			s.setName(conn.resultSet.getString("sourceName"));
			s.setAdd(conn.resultSet.getString("sourceAddress"));
			sourcelist.add(s);
			//id=conn.resultSet.getString("commodityID");
		}
		System.out.print(sourcelist.size());
		for(int i=0;i<sourcelist.size();i++){
			Vector hang=new Vector();
			
			hang.add(sourcelist.get(i).getId());
			hang.add(sourcelist.get(i).getName());
			hang.add(sourcelist.get(i).getAdd());
			
			RowData.add(hang);
		}
      
      	
      	ColumnNames= new Vector();
		ColumnNames.add("原产地ID");
		ColumnNames.add("原产地名称");
		ColumnNames.add("原产地地址");
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 23, 708, 383);
		contentPane.add(scrollPane);
		
				final JTable t= new JTable(RowData,ColumnNames);
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
				case 1:	sql="update sourceinfo set sourceName=? where sourceID=?;";
					try {
						conn=new MySQLConnect(sql);
						conn.pstmt.setString(1, con);
						 conn.pstmt.setInt(2, id);

					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				       
				break;

				case 2:sql="update sourceinfo set sourceAddress=? where sourceID=?;";
				try {
					conn=new MySQLConnect(sql);
					conn.pstmt.setString(1, (con));
					 conn.pstmt.setInt(2, id);

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}break;
				case 3:sql="update commodityinfo set commodityInfo=? where commodityID=?;";
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
				btnNewButton.setBounds(235, 416, 102, 23);
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
				btnNewButton_1.setBounds(386, 416, 121, 23);
				contentPane.add(btnNewButton_1);
				
				JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u539F\u4EA7\u5730\u4FE1\u606F\u754C\u9762\uFF1A");
				lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
				lblNewLabel.setBounds(300, 0, 160, 18);
				contentPane.add(lblNewLabel);
		        conn.close();
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
}
