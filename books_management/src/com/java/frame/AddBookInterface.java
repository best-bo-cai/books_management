package com.java.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.java.dao.BookDao;
import com.java.model.Book;
import com.java.util.Connect;
import com.java.util.StringNull;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AddBookInterface extends JFrame {

	private JPanel contentPane;
	private JTextField bookIdTxt;
	private JTextField bookNameTxt;
	private JTextField bookWriterTxt;
	private JTextField bookPublishTxt;
	private JTextField bookStatusTxt;
	private Connect contil = new Connect();
	private BookDao bookDao= new BookDao();
	JFrame frame = new JFrame();

	/**
	 * Create the frame.
	 */
	public AddBookInterface() {
		setTitle("\u6DFB\u52A0\u56FE\u4E66");
		setBounds(100, 100, 663, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton addButton = new JButton("\u6DFB\u52A0");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook();
			}
		});
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7:");
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u5B57:");
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel label_3 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		JLabel label_4 = new JLabel("\u72B6\u6001\uFF1A");
		
		bookIdTxt = new JTextField();
		bookIdTxt.setColumns(10);
		
		bookNameTxt = new JTextField();
		bookNameTxt.setColumns(10);
		
		bookWriterTxt = new JTextField();
		bookWriterTxt.setColumns(10);
		
		bookPublishTxt = new JTextField();
		bookPublishTxt.setColumns(10);
		
		bookStatusTxt = new JTextField();
		bookStatusTxt.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(label_1)
										.addComponent(label_2)
										.addComponent(label_3)
										.addComponent(label_4))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(bookStatusTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookPublishTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookWriterTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
										.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(279)
							.addComponent(addButton)))
					.addContainerGap(198, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(68)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(bookNameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(41)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(bookWriterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(bookPublishTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(bookStatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(addButton)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void addBook() {
		String bookId = this.bookIdTxt.getText();
		String bookName = this.bookNameTxt.getText();
		String bookPublish = this.bookPublishTxt.getText();
		String bookWriter = this.bookWriterTxt.getText();
		String bookStatus = this.bookStatusTxt.getText();
		
		if(StringNull.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "图书编号不能为空！");
			return;
		}
		if(StringNull.isEmpty(bookName)) { 
			JOptionPane.showMessageDialog(null, "图书姓名不能为空！");
			return;
		}
		if(StringNull.isEmpty(bookPublish)) {
			JOptionPane.showMessageDialog(null, "图书出版社不能为空！");
			return ;
		}
		if(StringNull.isEmpty(bookWriter)) {
			JOptionPane.showMessageDialog(null, "图书作者不能为空！");
			return;
		}
		if(StringNull.isEmpty(bookStatus)) {
			JOptionPane.showMessageDialog(null, "图书状态不能为空！");
			return;
		}
		
		Connection con = null;
		try {
			Book book = new Book(Integer.parseInt(bookId), bookName, bookWriter, bookPublish, bookStatus);
			con = contil.loding();
			ResultSet rs = bookDao.query2(con, book);
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "添加失败！");
				return; 
			}else {
				bookDao.add(con, book);
				JOptionPane.showMessageDialog(null, "添加成功！");
				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				contil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
