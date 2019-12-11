package com.java.frame;
/**
 * 登录
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import com.java.dao.AdminDao;
import com.java.dao.UserDao;
import com.java.model.Admin;
import com.java.model.Reader;
import com.java.util.Connect;
import com.java.util.StringNull;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.ImageIcon;

public class EnterInterface extends JFrame {

	private JPanel contentPane;
	private JTextField user_name;
	private JLabel label;
	private JLabel label_1;
	private JRadioButton userBut;
	private JRadioButton adminBut;
	private final JPanel panel = new JPanel();
	private JLabel label_2;
	private JPasswordField user_password;
	private Connect conutil= new Connect();
	private AdminDao adminDao = new AdminDao();
	private UserDao readerDao = new UserDao();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int action = 0;
	
	JFrame frame = new JFrame(); 
	
	/**
	 * Create the frame.
	 */
	public EnterInterface() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF\\\u6570\u636E\u5E93\\window.jpg"));
		setTitle("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 530);
		contentPane = new JPanel();
		contentPane.setForeground(Color.RED);

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		user_name = new JTextField();
		user_name.setColumns(10);
		
		label = new JLabel("\u7528\u6237\u540D\uFF1A");
		
		label_1 = new JLabel("\u5BC6\u7801\uFF1A");
		label_1.setIcon(null);
		
		JButton button = new JButton("\u767B\u5F55");
		button.setIcon(null);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(0 == action)
				JOptionPane.showMessageDialog(null, "请选择登录方式！");
			}
		});
		button.setForeground(Color.BLUE);
		
		JButton button_1 = new JButton("\u6CE8\u518C");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userRegister(e);
			}
		});
		
		button_1.setForeground(Color.BLUE);
		
		userBut = new JRadioButton("\u7528\u6237");
		buttonGroup.add(userBut);
		userBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action =1;
			}
		});
		
		adminBut = new JRadioButton("\u7BA1\u7406\u5458");
		buttonGroup.add(adminBut);
		adminBut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = 2;
			}
		});
		
		button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e2) {
				if(1 == action) {
					int toRmif = userLogin(e2);
					if(1 == toRmif) {
						ReaderMainInterface Rmif = new ReaderMainInterface();
						Rmif.setVisible(true);
					}
				}	
				if(2 == action) {
					int toAmif = adminLogin(e2);
					if(1 == toAmif) {
						AdminMainInterface Amif = new AdminMainInterface();
						Amif.setVisible(true);
					}
				}
			}
		});
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		
		label_2 = new JLabel("\u56FE\u4E66\u7BA1\u7406\u7CFB\u7EDF");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("宋体", Font.BOLD, 40));
		
		user_password = new JPasswordField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 749, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(129)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(260)
							.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(46)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
													.addGap(32))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(label, GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(user_name, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
														.addComponent(user_password, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
											.addComponent(userBut)
											.addGap(31)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(37)
													.addComponent(adminBut))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(layeredPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
													.addGap(77))
												.addComponent(button_1))))
									.addGap(138))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 263, GroupLayout.PREFERRED_SIZE)
									.addGap(119)))))
					.addGap(190))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(layeredPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(adminBut)
								.addComponent(userBut))
							.addGap(24)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(user_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label))
							.addGap(42)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(user_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_1)))
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addGap(137)
							.addComponent(layeredPane_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(button_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}
	/*
	 * 登录事件处理
	 */
	private int adminLogin(ActionEvent e)  {
		String userName = this.user_name.getText();
		String password = new String(this.user_password.getPassword());//获取密码
		//从一个类的函数中得到一个成员变量，传输到另一个类中进行使用
		QueryBookInterface.setAdminId(userName);
		//提示框
		if(StringNull.isEmpty(userName)) {
			JOptionPane.showMessageDialog(null, "管理员名不能为空！");
			return 0;
		}
		if(StringNull.isEmpty(password)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return 0;
		}
		Admin admin = new Admin(userName,password);
		Connection con =null;
		try {
		con = conutil.loding();//连接数据库
		Admin curreatAdmin= adminDao.login(con, admin);
		
		if(curreatAdmin!=null) {
			//提示框
			JOptionPane.showMessageDialog(null, "管理员登陆成功！");
			return 1;
		}else {
			JOptionPane.showMessageDialog(null, "管理员名或者密码错误！");
			return 0;
		}
		}catch(Exception e1){
			e1.printStackTrace();
			return 0;
		}finally {
			  try {
				conutil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/*
	 * 
	 */
	private int userLogin(ActionEvent e)  {
		String userName1 = this.user_name.getText();
		String password1 = new String(this.user_password.getPassword());//获取密码
		//从一个类的函数中得到一个成员变量，传输到另一个类中进行使用
		 QueryBookInterface.setReaderId(userName1);
		//提示框
		if(StringNull.isEmpty(userName1)) {
			JOptionPane.showMessageDialog(null, "用户名不能为空！");
			return 0;
		}
		if(StringNull.isEmpty(password1)) {
			JOptionPane.showMessageDialog(null, "密码不能为空！");
			return 0;
		}
		Reader reader =new Reader(userName1,password1);
		Connection con =null;
		try {
		con = conutil.loding();//连接数据库
		Reader curreatReader= readerDao.login(con, reader);
		
		if(curreatReader!=null) {
			//提示框
			JOptionPane.showMessageDialog(null, "登陆成功！");
			return 1;
		}else {
			
			JOptionPane.showMessageDialog(null, "用户名或者密码错误！");
			return 0;
		}
		}catch(Exception e1){
			e1.printStackTrace();
			return 0;
		}finally {
			  try {
				conutil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	/*
	 * 注册事件处理
	 */
	private void userRegister(ActionEvent e) {
		RegisterInterface ri = new RegisterInterface();
		ri.setVisible(true);
	}
}
