package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wc.Exception.UserExistException;
import com.wc.domain.User;
import com.wc.utils.DBUtils;

/**
 * 处理数据库中User包的相关操作的实现包
 * 
 * @author ccl
 *
 */
public class UserDaoImpl {
	/**
	 * 通过用户名找用户
	 * 
	 * @param username
	 *            要找用户的用户名
	 * @return 找到的用户
	 */
	public User find(String username) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from User where username = '" + username + "'";
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getInt("user_type"));
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
				if (stmt != null) {
					stmt.close();
					stmt = null;
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
		return user;
	}

	public User find(int userId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from User where user_id = '" + userId + "'";
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				user = new User();
				user.setUserId(userId);
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getInt("user_type"));
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
				if (stmt != null) {
					stmt.close();
					stmt = null;
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
		return user;
	}

	/**
	 * 通过用户名和密码找用户
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return 找到的用户
	 */
	public User find(String username, String password) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from User where username = '" + username + "' and password = '" + password + "'";
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUsername(username);
				user.setPassword(rs.getString("password"));
				user.setUserType(rs.getInt("user_type"));
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
				if (stmt != null) {
					stmt.close();
					stmt = null;
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
		return user;
	}

	/**
	 * 添加一个用户
	 * 
	 * @param user
	 *            要添加的用户
	 * @return 是否添加成功
	 * @throws UserExistException
	 *             若用户中已经有要添加的用户，抛出这个异常
	 */
	public boolean addUser(User user) throws UserExistException {
		User user2 = find(user.getUsername());
		if (user2 != null) {
			throw new UserExistException();
		}
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into User values(0,?,?,?)";
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getUserType());
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
