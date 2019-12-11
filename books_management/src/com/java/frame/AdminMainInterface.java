package com.java.frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AdminMainInterface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JFrame frame = new JFrame();

	/**
	 * Create the frame.
	 */
	public AdminMainInterface() {
		setTitle("\u7BA1\u7406\u5458\u64CD\u4F5C");
		setBounds(100, 100, 395, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton queryBook = new JButton("\u67E5\u8BE2\u56FE\u4E66");
		queryBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBookInterface qbi = new QueryBookInterface();
				qbi.setVisible(true);
			}
		});
		
		JButton borrowBook = new JButton("\u501F\u9605\u56FE\u4E66");
		borrowBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBookInterface qbi = new QueryBookInterface();
				qbi.setVisible(true);
			}
		});
		
		JButton addBook = new JButton("\u589E\u52A0\u56FE\u4E66");
		addBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddBookInterface ai = new AddBookInterface();
				ai.setVisible(true);
			}
		});
		
		JButton delBook = new JButton("\u5220\u9664\u56FE\u4E66");
		delBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteBook();
			}
		});
		
		JButton returnBook = new JButton("\u5F52\u8FD8\u56FE\u4E66");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				QueryBookInterface qbi = new QueryBookInterface();
				qbi.setVisible(true);
			}
		});
		
		JButton delReader = new JButton("\u5220\u9664\u7528\u6237");
		delReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deleteReader();
			}
		});
		
		JButton queryReader = new JButton("\u67E5\u8BE2\u7528\u6237");
		queryReader.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				queryReader();
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(queryReader, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(queryBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addComponent(returnBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addComponent(delBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
							.addComponent(addBook, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
							.addComponent(delReader, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
							.addComponent(borrowBook, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(251))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(1)
					.addComponent(queryBook, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(borrowBook, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(returnBook, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delBook, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(addBook, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(delReader, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(queryReader, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void deleteReader() {
		DeleteReaderInterface dif = new DeleteReaderInterface();
		dif.setVisible(true);
	}

	protected void queryReader() {
		QueryReaderInterface qri = new QueryReaderInterface();
		qri.setVisible(true);
	}

	private void deleteBook() {
		DeleteBookInterface dbi = new DeleteBookInterface();
		dbi.setVisible(true);
	}
}
