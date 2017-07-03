package com.delicacy.management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class commo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					commo frame = new commo();
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
	public commo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u6765\u5230\u4EA7\u54C1\u7BA1\u7406\u754C\u9762");
		lblNewLabel.setBounds(183, 30, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u8981\u505A\u7684\u4E8B\u60C5\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(44, 55, 295, 15);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("修改商品信息");
		btnNewButton.setBounds(160, 80, 93, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("修改原产地信息");
		btnNewButton_1.setBounds(160, 127, 93, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("录入采购单");
		btnNewButton_2.setBounds(160, 181, 93, 23);
		contentPane.add(btnNewButton_2);
	}
}
