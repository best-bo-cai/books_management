package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.java.model.Reader;

/**
 * 用户注册信息
 * @author admin
 *
 */
public class UserDao {
	/**
	 * 用户注册
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public int register(Connection con,Reader reader) throws Exception{
		String sql = "insert into reader values(?,?,?,?)";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, reader.getReader_id());
		pstmt.setString(2, reader.getReader_name());
		pstmt.setString(3, reader.getReader_phone());
		pstmt.setString(4, reader.getReader_password());
		return pstmt.executeUpdate();
	}
	/**
	 * 用户信息查找,查重用，用户id不能相同
	 * @param con
	 * @param reader
	 * @return
	 * @throws Exception
	 */
	public Reader login(Connection con,Reader reader) throws Exception{
		Reader resultUser = null;
		String sql ="select * from reader where reader_name=? and reader_password=?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setString(1, reader.getReader_name());
		pstmt.setString(2, reader.getReader_password());
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			resultUser = new Reader();
			resultUser.setReader_id(rs.getInt("reader_id"));
			resultUser.setReader_name(rs.getString("reader_name"));
			resultUser.setReader_phone(rs.getString("reader _phone"));//这多了一个空格，哈哈哈哈哈哈哈
			resultUser.setReader_password(rs.getString("reader_password"));
		}
		return resultUser;
	}
	/**
	 * 通过用户Id查询用户所有信息
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public ResultSet query(Connection con, int readerId)throws Exception{
		String sql = "select * from reader where reader_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, readerId);
		return pstmt.executeQuery();
	}
	/**
	 * 删除用户
	 * @param con
	 * @param readerId
	 * @return
	 * @throws Exception
	 */
	public int delete(Connection con, int readerId)throws Exception{
		String sql = "delete from reader where reader_id = ?";
		PreparedStatement pstmt = (PreparedStatement)con.prepareStatement(sql);
		pstmt.setInt(1, readerId);
		return pstmt.executeUpdate();
	}
}
