package com.java.model;
/**
 * 图书信息
 * @author admin
 *
 */
public class Book {
	private int book_id;//图书编号
	private String book_name;//图书姓名
	private String book_writer;//作者
	private String book_publish;//出版社
	private String book_status;//状态
	
	public Book() {
		super();
	}
	
	
	public Book(int book_id) {
		super();
		this.book_id = book_id;
	}


	public Book(int book_id, String book_name, String book_writer, String book_publish, String book_status) {
		super();
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_writer = book_writer;
		this.book_publish = book_publish;
		this.book_status = book_status;
	}

	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getBook_name() {
		return book_name;
	}
	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	public String getBook_writer() {
		return book_writer;
	}
	public void setBook_writer(String book_writer) {
		this.book_writer = book_writer;
	}
	public String getBook_publish() {
		return book_publish;
	}
	public void setBook_publish(String book_publish) {
		this.book_publish = book_publish;
	}
	public String getBook_status() {
		return book_status;
	}
	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	
	
	
}
