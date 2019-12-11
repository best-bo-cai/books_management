package com.java.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.java.dao.BookDao;
import com.java.dao.BookInformationDao;
import com.java.model.Book;
import com.java.model.BookInformation;
import com.java.util.Connect;
import com.java.util.StringNull;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QueryBookInterface extends JFrame {

	private JPanel contentPane;
	private JTextField book_nameTxt;
	private JTextField book_writerTxt;
	private JTextField book_publishTxt;
	private Connect conutil= new Connect();
	private BookDao bookDao= new BookDao();
	private BookInformationDao bookInformationDao = new BookInformationDao();
	public static String readerName;
	public static String adminName;

	/**
	 * Launch the application.
	 */
	JFrame frame = new JFrame();
	private JTable bookTable;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JButton borrowButton;
	private JLabel label;
	private JLabel label_4;
	private JLabel label_5;
	private JTextField book_RBnameTxt;
	private JTextField book_RBwriterTxt;
	private JTextField book_RBpublishTxt;
	private JTextField book_RBstatusTxt;
	private JButton returnButton;
	private JTextField book_RBidTxt;
	/**
	 * Create the frame.
	 */
	public QueryBookInterface() {
		setTitle("\u56FE\u4E66\u7684\u67E5\u8BE2\uFF0C\u501F\u9605\uFF0C\u5F52\u8FD8");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 920, 686);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton queryButton = new JButton("\u67E5\u8BE2");
		queryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryBookTable(e);
			}
		});
		
		JLabel label_1 = new JLabel("\u56FE\u4E66\u540D\u5B57:");
		
		JLabel label_2 = new JLabel("\u56FE\u4E66\u4F5C\u8005\uFF1A");
		
		JLabel label_3 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		book_nameTxt = new JTextField();
		book_nameTxt.setColumns(10);
		
		book_writerTxt = new JTextField();
		book_writerTxt.setColumns(10);
		 
		book_publishTxt = new JTextField();
		book_publishTxt.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		
		panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_2)
								.addComponent(label_1)
								.addComponent(label_3))
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
									.addComponent(book_nameTxt)
									.addComponent(book_writerTxt)
									.addComponent(book_publishTxt, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 435, GroupLayout.PREFERRED_SIZE)))
					.addGap(34)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(21, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(42)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(84)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(label_1)
								.addComponent(book_nameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_2)
								.addComponent(book_writerTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(51)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_3)
								.addComponent(book_publishTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(queryButton, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 277, GroupLayout.PREFERRED_SIZE)
							.addGap(11)))
					.addGap(21))
		);
		
		lblNewLabel = new JLabel("\u56FE\u4E66\u540D\u5B57\uFF1A");
		
		borrowButton = new JButton("\u501F\u9605");
		borrowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				borrowBook();
			}
		});
		
		label = new JLabel("\u4F5C\u8005\uFF1A");
		
		label_4 = new JLabel("\u51FA\u7248\u793E\uFF1A");
		
		label_5 = new JLabel("\u72B6\u6001\uFF1A");
		
		book_RBnameTxt = new JTextField();
		book_RBnameTxt.setColumns(10);
		
		book_RBwriterTxt = new JTextField();
		book_RBwriterTxt.setColumns(10);
		
		book_RBpublishTxt = new JTextField();
		book_RBpublishTxt.setColumns(10);
		
		book_RBstatusTxt = new JTextField();
		book_RBstatusTxt.setColumns(10);
		
		returnButton = new JButton("\u5F52\u8FD8");
		returnButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnBook();
			}
		});
		
		JLabel label_6 = new JLabel("\u7F16\u53F7\uFF1A");
		
		book_RBidTxt = new JTextField();
		book_RBidTxt.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(label)
						.addComponent(label_4)
						.addComponent(label_5)
						.addComponent(label_6))
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(book_RBidTxt, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(borrowButton)
							.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
							.addComponent(returnButton))
						.addComponent(book_RBwriterTxt, Alignment.LEADING, 286, 286, Short.MAX_VALUE)
						.addComponent(book_RBnameTxt, GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
						.addComponent(book_RBpublishTxt, Alignment.LEADING, 286, 286, Short.MAX_VALUE)
						.addComponent(book_RBstatusTxt, Alignment.LEADING, 286, 286, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(book_RBnameTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(book_RBwriterTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(book_RBpublishTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_5)
						.addComponent(book_RBstatusTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(book_RBidTxt, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_6))
					.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(returnButton)
						.addComponent(borrowButton))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		bookTable = new JTable();
		bookTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				bookTableMousePressed(e);
			}
		});
		bookTable.setFillsViewportHeight(true);
		bookTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7F16\u53F7", "\u56FE\u4E66\u540D\u5B57", "\u4F5C\u8005", "\u51FA\u7248\u793E", "\u72B6\u6001"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(bookTable);
		contentPane.setLayout(gl_contentPane);

		this.fillTable(new Book());//初始化图书信息
	}
	/**
	 * 归还图书函数
	 */
	protected void returnBook() {
		String bookId = this.book_RBidTxt.getText();
		String bookName = this.book_RBnameTxt.getText();
		String bookPublish =this.book_RBpublishTxt.getText();
		String bookWriter = this.book_RBwriterTxt.getText();
		String bookStatus = this.book_RBstatusTxt.getText();
		
		if(StringNull.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "图书信息不能为空！");
			return ;
		}
		
		Connection con = null;
		try {
			BookInformation bi = new BookInformation(Integer.parseInt(bookId));
			Book book = new Book(Integer.parseInt(bookId));
			book.setBook_status("0");//把图书状态改变为0
			
			con = conutil.loding();
			ResultSet rs = bookInformationDao.returnn(con,bi);//得到符合bookId的那一行。
			
			//读者对比，只有借此书的读者才能还此书
			if((rs.next() && rs.getString(2).equals(readerName))||((StringNull.isNotEmpty(adminName))&&rs.getString(5).equals("1"))) {
				bookInformationDao.delete(con, Integer.parseInt(bookId));//删除借书表里的哪一行数据
				bookDao.update(con, book);//更新图书表中的图书状态
				JOptionPane.showMessageDialog(null, "归还成功！");
				return ;
			}else{
				JOptionPane.showMessageDialog(null, "归还失败！");
				return ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	/**
	 * 接受用户ID，从其它类接受
	 * @param id
	 */
	public static void setReaderId(String name) {
		readerName = name;
	}
	public static void setAdminId(String name) {
		adminName = name;
	}
	/**
	 *  借书
	 */
	private void borrowBook() {
		String bookId = this.book_RBidTxt.getText();
		String bookName = this.book_RBnameTxt.getText();
		String bookPublish = this.book_RBpublishTxt.getText();
		String bookWriter = this.book_RBwriterTxt.getText();
		String bookStatus = this.book_RBstatusTxt.getText();
		
		if(StringNull.isEmpty(bookId)) {
			JOptionPane.showMessageDialog(null, "图书信息不能为空！");
			return;
		}
		
		if(bookStatus.equals("1")) {
			JOptionPane.showMessageDialog(null, "该图书已被借走了！");
			return;
		}
		
		Connection con = null;
		try {
			con = conutil.loding();
			
			BookInformation bi;
			if(StringNull.isNotEmpty(readerName)) {
				bi = new BookInformation(Integer.parseInt(bookId), readerName, null, null, "1");//读者
			}else {
				bi = new BookInformation(Integer.parseInt(bookId), adminName, null, null, "1");//管理员
			}
			
			Book book =new Book(Integer.parseInt(bookId), bookName, bookWriter, bookPublish, "1");
			
			int find = bookInformationDao.add(con, bi);
			int flag = bookDao.update(con, book);
			if(1 != find ||1 != flag) {
				JOptionPane.showMessageDialog(null, "借阅失败！");
				return;
			}else {
				JOptionPane.showMessageDialog(null, "借阅成功！");
				return;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "借阅失败！");
			return ;
		}finally {
			try {
				conutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	/**
	 * 添加到面板中
	 * @param e
	 */
	private void bookTableMousePressed(MouseEvent e) {
		int row = bookTable.getSelectedRow();
		book_RBnameTxt.setText((String)bookTable.getValueAt(row, 1));
		book_RBwriterTxt.setText((String)bookTable.getValueAt(row, 2));
		book_RBpublishTxt.setText((String)bookTable.getValueAt(row, 3));
		book_RBstatusTxt.setText((String)bookTable.getValueAt(row, 4));
		book_RBidTxt.setText((String)bookTable.getValueAt(row, 0));
	}
	/**
	 * 图书信息查询
	 */
	private void queryBookTable(ActionEvent e) {
		//书名查询，作者，出版社
		String book_name = this.book_nameTxt.getText();
		String book_writer = this.book_writerTxt.getText();
		String book_publish = this.book_publishTxt.getText();
		
		Book book =new Book();
		book.setBook_name(book_name);
		book.setBook_writer(book_writer);
		book.setBook_publish(book_publish);
		
		this.fillTable(book);
	}
	/**
	 * 初始化图书信息
	 * @param book
	 */
	private void fillTable(Book book) {
		DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
		dtm.setRowCount(0);
		Connection con = null;
		try {
			con = conutil.loding();
			ResultSet rs = bookDao.query(con, book);
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("book_id"));
				v.add(rs.getString("book_name"));
				v.add(rs.getString("book_writer"));
				v.add(rs.getString("book_publish"));
				if(rs.getString("book_status").equals("1")) {
					v.add("已借出");
				}else {
					v.add("未借出");
				}
				dtm.addRow(v);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				conutil.closeCon(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
