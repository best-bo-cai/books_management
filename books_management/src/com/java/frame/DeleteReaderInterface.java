package com.java.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.UserDao;
import com.java.util.Connect;
import com.java.util.StringNull;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class DeleteReaderInterface extends JFrame {

	private JPanel contentPane;
	private JTextField readerIdTxt;
	private UserDao readerDao = new UserDao();
	private Connect conutil = new Connect(); 

	/**
	 * Create the frame.
	 */
	public DeleteReaderInterface() {
		setTitle("\u5220\u9664\u7528\u6237");
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7528\u6237\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		readerIdTxt = new JTextField();
		readerIdTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		readerIdTxt.setColumns(10);
		
		JButton deleteButton = new JButton("\u5220\u9664\u6B64\u7528\u6237");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = JOptionPane.showConfirmDialog(null, "是否确认删除！", "选择一个选项", JOptionPane.YES_NO_OPTION);
				if(i == JOptionPane.YES_OPTION) {
					deleteReader();
				}else {
					JOptionPane.showMessageDialog(null, "请重新填写编号！");
				}
				
			}
		});
		deleteButton.setFont(new Font("宋体", Font.PLAIN, 20));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(76)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, 181, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(143)
							.addComponent(deleteButton)))
					.addContainerGap(59, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(69)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(readerIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(48)
					.addComponent(deleteButton)
					.addContainerGap(63, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/**
	 * 删除用户功能
	 */
	protected void deleteReader() {
		String readerId  = this.readerIdTxt.getText();
		
		if(StringNull.isEmpty(readerId)) {
			JOptionPane.showMessageDialog(null, "用户编号不能为空");
		}
		
		Connection con = null;
		try {
			con = conutil.loding();
			ResultSet rs = readerDao.query(con, Integer.parseInt(readerId));
			if(rs.next()) {
				readerDao.delete(con, Integer.parseInt(readerId));
				JOptionPane.showMessageDialog(null, "删除成功!");
				return;
			}
			else {
				JOptionPane.showMessageDialog(null, "删除失败！");
				return;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "删除失败！");
			return;
		}finally {
			try {
				conutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

}
