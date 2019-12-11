package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.java.model.BookInformation;

public class BookInformationDao {
	/**
	 * book_borrow表添加操作
	 * @param con
	 * @param booki
	 * @return
	 * @throws Exception
	 */
	public int add(Connection con, BookInformation booki) throws Exception{
		String sql = "insert into book_information values(?,?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		
		pstmt.setInt(1, booki.getBook_id());
		pstmt.setString(2, booki.getReader_name());
		pstmt.setTime(3, (Time) booki.getBorrow_data());
		pstmt.setTime(4, (Time) booki.getReturn_data());
		pstmt.setString(5, booki.getBook_status());
		
		return pstmt.executeUpdate();
	}
	/**
	 * book_borrow表归还操作
	 * @param con
	 * @param booki
	 * @return
	 * @throws SQLException
	 */
	public ResultSet returnn(Connection con, BookInformation booki) throws SQLException { 
		ResultSet rs = null;
		String sql = "select * from book_information where book_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, booki.getBook_id());
		rs = pstmt.executeQuery();
		return rs;
	}
	/**
	 * book_borrow表删除操作
	 * @param con
	 * @param bookId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con,int bookId) throws Exception{
		String sql = "delete from book_information where book_id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, bookId);
		return pstmt.executeUpdate();
	}
}
