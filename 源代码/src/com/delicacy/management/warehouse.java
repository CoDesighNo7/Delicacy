package com.delicacy.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JList;

public class warehouse extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					warehouse frame = new warehouse();
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
	public warehouse() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u6765\u5230\u4ED3\u5E93\u7BA1\u7406\u754C\u9762");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(134, 9, 170, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u8981\u505A\u7684\u4E8B\u60C5\uFF1A");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(24, 34, 295, 15);
		contentPane.add(label_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(287, 60, 88, 21);
		contentPane.add(comboBox);
		comboBox.setVisible(false);
		comboBox.addItem("请选择:");
		comboBox.addItem("入库");
		comboBox.addItem("出库");
		
		comboBox.addItemListener(new ItemListener()
		{
			public void itemStateChanged(ItemEvent e)
			{
				if(e.getStateChange()==ItemEvent.SELECTED)
				{   //System.out.print(comboBox.getSelectedIndex());
					String text=(String) comboBox.getSelectedItem();  
					System.out.print(text);
					if ("入库".equals(text))
						{
						  comIn ci = null;
						try {
							ci = new comIn();
							dispose();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						  ci.setLocationRelativeTo(null);
						  ci.setVisible(true);
						}
				}
			}
		});
		
		JButton btnNewButton = new JButton("\u5E93\u5B58\u7BA1\u7406");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox.setVisible(true);
			}
		});
		btnNewButton.setBounds(167, 59, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2\u5E93\u5B58");
		btnNewButton_1.setBounds(167, 105, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6838\u7B97\u5E93\u5B58");
		btnNewButton_2.setBounds(167, 154, 93, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u53D1\u8D27");
		btnNewButton_3.setBounds(167, 203, 93, 23);
		contentPane.add(btnNewButton_3);
		
	
	}
}
