package com.delicacy.management;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import com.delicacy.commodity.SourceBean;
import com.delicacy.dao.MySQLConnect;


public class login_success extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_success frame = new login_success();
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
	public login_success() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(157, 39, 54, 15);
		contentPane.add(lblNewLabel);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(180, 92, 161, 21);
		contentPane.add(comboBox);
		String sql="select sourceID,sourceName from sourceinfo;";
		
		MySQLConnect conn=new MySQLConnect(sql);
		//conn.pstmt.setString(1, "原产地2");
		conn.resultSet=conn.pstmt.executeQuery();
		final ArrayList<SourceBean> sourcelist=new ArrayList<SourceBean>();
		String[] aa,bb;
		while(conn.resultSet.next()){
			SourceBean s=new SourceBean(); 
			s.setId(conn.resultSet.getInt("sourceID"));
			//aa=conn.resultSet.getString("sourceID")
				//	bb=conn.resultSet.getString("sourceName"));
			s.setName(conn.resultSet.getString("sourceName"));
			sourcelist.add(s);
			//id=conn.resultSet.getString("commodityID");
		}
		comboBox.addItem("请选择原产地:");
		for(int i=0;i<sourcelist.size();i++){
			comboBox.addItem(sourcelist.get(i).getName());
		}
		//System.out.print(sourcelist.get(comboBox.getSelectedIndex()).getId());
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange()==ItemEvent.SELECTED)
				{   //System.out.print(comboBox.getSelectedIndex());
					String text=(String) comboBox.getSelectedItem();  
					//System.out.print(text);
					System.out.print(sourcelist.get((comboBox.getSelectedIndex()-1)).getId());
				}
			}
		});
		Object[] options ={ "好啊！", "去一边！" };  
		int m = JOptionPane.showOptionDialog(null, "我可以约你吗？", "标题",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		
	}
}
