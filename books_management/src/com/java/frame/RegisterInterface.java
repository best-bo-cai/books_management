 package com.java.frame;
 /**
  * 注册
  */
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

import com.java.dao.UserDao;
import com.java.model.Reader;
import com.java.util.Connect;
import com.java.util.StringNull;
import java.awt.Dialog.ModalExclusionType;

public class RegisterInterface extends JFrame {

	private JPanel contentPane;
	private JTextField reader_id;
	private JTextField reader_name;
	private JTextField reader_phone;
	private JTextField reader_password;
	private Connect conutil= new Connect();

	JFrame frame = new JFrame();
	/**
	 * Create the frame.
	 */
	public RegisterInterface() {
		setTitle("\u6CE8\u518C");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 530);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel("\u7F16\u53F7\uFF1A");
		
		reader_id = new JTextField();
		reader_id.setColumns(10);
		
		JLabel label_1 = new JLabel("\u59D3\u540D\uFF1A");
		
		reader_name = new JTextField();
		reader_name.setColumns(10);
		
		JLabel label_2 = new JLabel("\u624B\u673A\u53F7\u7801\uFF1A");
		
		reader_phone = new JTextField();
		reader_phone.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		
		reader_password = new JTextField();
		reader_password.setColumns(10);
		
		JButton button = new JButton("\u6CE8\u518C");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usearRegister(e);
			}
		});
		
		JButton buttonNot = new JButton("\u6E05\u7A7A");
		buttonNot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delActiontxt();
			}
		});
			
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(136)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addComponent(label_1)
						.addComponent(label_2)
						.addComponent(label_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(buttonNot))
						.addComponent(reader_password)
						.addComponent(reader_phone)
						.addComponent(reader_name)
						.addComponent(reader_id, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE))
					.addContainerGap(194, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(83)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(label)
						.addComponent(reader_id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(56)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(reader_name, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(reader_phone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(50)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(reader_password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(buttonNot))
					.addContainerGap(67, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
/**
 * 读者注册
 * @param e
 */
	private void usearRegister(ActionEvent e) {
		
		 String readerIdStr = this.reader_id.getText().toString();
		 int readerId = 0;
		 if(!StringNull.isEmpty(readerIdStr)) {
			 readerId = Integer.parseInt(readerIdStr);
		 }
		 
		 String readerName = this.reader_name.getText();
		 String readerPhone = this.reader_phone.getText();
		 String readerPassword = this.reader_password.getText();
		 
		 if(StringNull.isEmpty(readerIdStr)) {
			 JOptionPane.showMessageDialog(null,"用户编号不能为空!");
			 return;
		 }
		 if(StringNull.isEmpty(readerName)) {
			 JOptionPane.showMessageDialog(null, "用户姓名不能为空！");
			 return;
		 }
		 if(StringNull.isEmpty(readerPhone)) {
			 JOptionPane.showMessageDialog(null, "用户手机号不能为空！");
			 return;
		 }
		 if(StringNull.isEmpty(readerPassword)) {
			 JOptionPane.showMessageDialog(null, "用户密码不能为空！");
			 return;
		 }
		 
		 Connection con = null;
		 UserDao ud = new UserDao();
		 try { 
			Reader reader = new Reader(readerId,readerName,readerPhone,readerPassword);
			con = conutil.loding();
			Reader rs = ud.login(con, reader);

			if(String.valueOf(rs.getReader_id()).equals(readerIdStr)) {
				JOptionPane.showMessageDialog(null, "账号已存在，注册失败!");
				return;
			}
			else {
				ud.register(con, reader);
				JOptionPane.showMessageDialog(null, "注册成功!");
				return;
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "账号已存在，注册失败!");
			e1.printStackTrace();
			return;
		} finally {
			  try {
				conutil.closeCon(con);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	//清空输入框
	private void delActiontxt() {
			this.reader_id.setText("");
			this.reader_name.setText("");
			this.reader_password.setText("");
			this.reader_phone.setText("");
	}
}