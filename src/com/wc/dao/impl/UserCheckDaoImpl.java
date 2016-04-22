package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wc.domain.UserCheck;
import com.wc.utils.DBUtils;

public class UserCheckDaoImpl {
	public boolean add(UserCheck uc){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into user_check values(?,?)";
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setInt(1, uc.getUserId());
			ps.setBoolean(2, uc.isCheckState());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean delete(int userId){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "delete from user_check where user_id = ?";
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setInt(1, userId);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public UserCheck find(int userId){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		UserCheck uc = null;
		try {
			String sql = "select * from user_check where user_id = '"+userId+"'";
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next())
			{
				uc = new UserCheck();
				uc.setUserId(rs.getInt("user_id"));
				uc.setCheckState(rs.getBoolean("checkstate"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				if(stmt != null)
				{
					stmt.close();
					stmt = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try
			{
				if (conn != null) {
					conn.close();
					conn = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return uc;
	}
	
	public boolean alterState(int userId){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "update user_check set checkstate = ?";
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			UserCheck uc = find(userId);
			ps.setBoolean(1, !uc.isCheckState());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
					ps = null;
				}
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
}
