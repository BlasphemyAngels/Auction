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
 * �������ݿ���User������ز�����ʵ�ְ�
 * 
 * @author ccl
 *
 */
public class UserDaoImpl {
	/**
	 * ͨ���û������û�
	 * 
	 * @param username
	 *            Ҫ���û����û���
	 * @return �ҵ����û�
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
	 * ͨ���û������������û�
	 * 
	 * @param username
	 *            �û���
	 * @param password
	 *            ����
	 * @return �ҵ����û�
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
	 * ���һ���û�
	 * 
	 * @param user
	 *            Ҫ��ӵ��û�
	 * @return �Ƿ���ӳɹ�
	 * @throws UserExistException
	 *             ���û����Ѿ���Ҫ��ӵ��û����׳�����쳣
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
