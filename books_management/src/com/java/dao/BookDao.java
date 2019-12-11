package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.model.Book;
import com.java.util.StringNull;

/**
 * 
 * @author admin
 *
 */
public class BookDao {
	/**
	 * 查询图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con,Book book)throws Exception{
		ResultSet resultUser = null;
		StringBuffer sql = new StringBuffer("select * from book");
		
		//数据库模糊查询
		if(StringNull.isNotEmpty(book.getBook_name())) {
			sql.append(" and book_name like '%"+book.getBook_name()+"%'");
		}
		 
		if(StringNull.isNotEmpty(book.getBook_writer())) {
			sql.append(" and book_writer like '%"+book.getBook_writer()+"%'");
		}
		
		if(StringNull.isNotEmpty(book.getBook_publish())) {
			sql.append(" and book_publish like '%"+book.getBook_publish()+"%'");
		}
		
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery(); 
	}
	/**
	 * 查询图书
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public ResultSet query2(Connection con,Book book)throws Exception{
		ResultSet resultUser = null;
		String sql = "select * from book where book_id=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		
		pstmt.setInt(1, book.getBook_id());
		
		return pstmt.executeQuery();
	}
	/**
	 * 图书信息修改
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int update(Connection con,Book book)throws Exception {
		String sql = "update book set book_status=? where book_id=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
	
		pstmt.setString(1, book.getBook_status());
		pstmt.setInt(2, book.getBook_id());
		
		return pstmt.executeUpdate();
	}
	/**
	 * 添加图书信息
	 * @param con
	 * @param book
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con,Book book)throws Exception{
		String sql  = "insert into book values(?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		
		pstmt.setInt(1, book.getBook_id());
		pstmt.setString(2, book.getBook_name());
		pstmt.setString(3, book.getBook_writer());
		pstmt.setString(4, book.getBook_publish());
		pstmt.setString(5, book.getBook_status());
		
		return pstmt.executeUpdate();
	}
	public int delete(Connection con,int bookId) throws Exception{
		String sql = "delete from book where book_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		return pstmt.executeUpdate();
	}
}

