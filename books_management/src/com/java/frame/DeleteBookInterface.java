package com.java.frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.java.dao.BookDao;
import com.java.model.Book;
import com.java.util.Connect;
import com.java.util.StringNull;
import java.awt.SystemColor;

public class DeleteBookInterface extends JFrame {

	private JPanel contentPane;
	private JTextField bookIdTxt;
	private Connect conutil= new Connect();
	private BookDao bookDao= new BookDao();
	/**
	 * Create the frame.
	 */
	public DeleteBookInterface() {
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DeleteBookInterface.class.getResource("/image/1.jpg")));
		setTitle("\u5220\u9664\u754C\u9762");
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u56FE\u4E66\u7F16\u53F7\uFF1A");
		label.setFont(new Font("宋体", Font.PLAIN, 20));
		
		bookIdTxt = new JTextField();
		bookIdTxt.setFont(new Font("宋体", Font.PLAIN, 20));
		bookIdTxt.setColumns(10);
		
		JButton deleteButton = new JButton("\u5220\u9664");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int jp = JOptionPane.showConfirmDialog(null, "是否确认删除！", "选择一个选项", JOptionPane.YES_NO_OPTION);
				
				if(jp ==JOptionPane.YES_OPTION ) {
					deleteBook();
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
							.addGap(66)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(160)
							.addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(105)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(bookIdTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53)
					.addComponent(deleteButton)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	protected void deleteBook() {
		String bookId = this.bookIdTxt.getText();
		
		if(StringNull.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "请输入图书的编号！");
		}
		
		Connection con = null;
		try {
			Book book = new Book(Integer.parseInt(bookId));
			con = conutil.loding();
			ResultSet rs = bookDao.query2(con, book);
			if(rs.next()) {
				bookDao.delete(con, Integer.parseInt(bookId));
				JOptionPane.showMessageDialog(null, "删除成功！");
				return ;
			}else {
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
