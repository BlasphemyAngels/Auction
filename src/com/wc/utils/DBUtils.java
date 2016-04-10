package com.wc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBUtils {
	public static String url = "jdbc:mysql://localhost:3306/Auction?user=root&password=root";
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(url);
		return conn;
	}
	public static Statement createStmt(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement();
		return stmt;
	}
	public static ResultSet executeQuary(String sql, Statement stmt) throws SQLException{
		ResultSet rs = stmt.executeQuery(sql);
		return rs;
	}
	public static PreparedStatement prepareStmt(Connection conn, String sql) throws SQLException{
		PreparedStatement ps = conn.prepareStatement(sql);
		return ps;
	}
}
