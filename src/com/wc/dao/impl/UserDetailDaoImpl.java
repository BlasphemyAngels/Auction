package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wc.Exception.UserDetailExitException;
import com.wc.Exception.UserDetailNotExitException;
import com.wc.domain.UserDetail;
import com.wc.utils.DBUtils;

public class UserDetailDaoImpl {
	
	public boolean add(UserDetail ud) throws UserDetailExitException{
		UserDetail ud1 = find(ud.getUserId());
		if(ud1 != null)
		{
			throw new UserDetailExitException();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into User_Detail() values(?, ?, ?, ?, ?, ?, ?)";
		try {
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setInt(1, ud.getUserId());
			ps.setString(2, ud.getName());
			ps.setString(3, ud.getEmail());
			ps.setString(4, ud.getID());
			ps.setString(5, ud.getTel());
			ps.setString(6, ud.getAddr());
			ps.setBoolean(7, ud.isCheck());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try
			{
				if(ps != null)
				{
					ps.close();
					ps = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public UserDetail find(int userId){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		UserDetail ud = null;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select * from user_detail where user_id = '"+userId+"'";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				ud = new UserDetail();
				ud.setUserId(rs.getInt("user_id"));
				ud.setName(rs.getString("name"));
				ud.setEmail(rs.getString("email"));
				ud.setID(rs.getString("ID"));
				ud.setTel(rs.getString("telephone"));
				ud.setAddr(rs.getString("addr"));
				ud.setCheck(rs.getBoolean("isCheck"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try
			{
				if(rs != null)
				{
					rs.close();
					rs = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				if(stmt != null)
				{
					stmt.close();
					stmt = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			try{
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return ud;
	}

	public boolean delete(int userId) throws UserDetailNotExitException{
		UserDetail ud = find(userId);
		if (ud == null)
		{
			throw new UserDetailNotExitException();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from user_detail where user_id = '" + userId + "'";
		try {
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try
			{
				if(ps != null)
				{
					ps.close();
					ps = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
			try
			{
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
			}catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean update(UserDetail ud)throws UserDetailNotExitException, UserDetailExitException{
		boolean ret = delete(ud.getUserId());
		ret = add(ud);
		return ret;
	}
	
	public boolean alterState(int userId){
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "update user_detail set isCheck = ? where user_id="+userId;
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			UserDetail ud = find(userId);
			ps.setBoolean(1, !ud.isCheck());
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