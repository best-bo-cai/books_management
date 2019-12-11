package com.java.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReaderMainInterface extends JFrame {

	private JPanel contentPane;

	JFrame frame = new JFrame();
	/**
	 * Create the frame.
	 */
	public ReaderMainInterface() {
		setTitle("\u7528\u6237\u64CD\u4F5C");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//查询图书
		JButton queryBook = new JButton("\u67E5\u8BE2\u56FE\u4E66");
		queryBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookfunction();
			}
		});
		//借阅图书（修改信息status为1，即为借出，同时判断status是否为1,添加到bookinformation）
		JButton borrowBook = new JButton("\u501F\u9605\u56FE\u4E66");
		borrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookfunction();
			}
		});
		
		JButton returnBook = new JButton("\u5F52\u8FD8\u56FE\u4E66");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookfunction();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(queryBook)
							.addContainerGap(315, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(returnBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(315))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(borrowBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(315))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(queryBook)
					.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
					.addComponent(borrowBook)
					.addGap(73)
					.addComponent(returnBook)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void queryBookfunction() {
		QueryBookInterface qbi = new QueryBookInterface();
		qbi.setVisible(true);
	}
}
