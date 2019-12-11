package com.java.model;

import javax.xml.crypto.Data;

/*
 * 图书状态
 */
public class BookInformation {
	private int book_id;//图书ID
	private String reader_name;//借书读者name
	private Data borrow_data;//借书时间
    private Data return_data;//还书时间
    private String book_status;//图书状态
    
	public BookInformation(int book_id) {
		super();
		this.book_id = book_id;
	}

	public BookInformation(int book_id, String reader_name) {
		super();
		this.book_id = book_id;
		this.reader_name = reader_name;
	}

	public BookInformation(int book_id, String reader_name, Data borrow_data, Data return_data, String book_status) {
		super();
		this.book_id = book_id;
		this.reader_name = reader_name;
		this.borrow_data = borrow_data;
		this.return_data = return_data;
		this.book_status = book_status;
	}
	
	public BookInformation() {
		super();
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getReader_name() {
		return reader_name;
	}

	public void setReader_name(String reader_name) {
		this.reader_name = reader_name;
	}

	public Data getBorrow_data() {
		return borrow_data;
	}

	public void setBorrow_data(Data borrow_data) {
		this.borrow_data = borrow_data;
	}

	public Data getReturn_data() {
		return return_data;
	}

	public void setReturn_data(Data return_data) {
		this.return_data = return_data;
	}

	public String getBook_status() {
		return book_status;
	}

	public void setBook_status(String book_status) {
		this.book_status = book_status;
	}
	
     
}
