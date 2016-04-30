package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wc.domain.Buyed;
import com.wc.utils.DBUtils;

public class BuyedDaoImpl {
	
	public void add(Buyed b){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into buyed(comm_id, user_id, price, buy_time, note) values(?, ?, ?, ?, ?)";
		try {
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setInt(1, b.getCommId());
			ps.setInt(2, b.getUserId());
			ps.setInt(3, b.getPrice());
			ps.setTimestamp(4, b.getBuyTime());
			ps.setString(5, b.getNote());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
	}
	
	public Buyed findBuy(int commId){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Buyed buy = null;
		String sql = "select * from buyed where comm_id = " + commId;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if(rs.next())
			{
				buy = new Buyed();
				buy.setUserId(rs.getInt("user_id"));
				buy.setCommId(rs.getInt("comm_id"));
				buy.setPrice(rs.getInt("price"));
				buy.setBuyTime(rs.getTimestamp("buy_time"));
				buy.setNote(rs.getString("note"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buy;
	}
	
	public List<Buyed> find(int userId){
		List<Buyed> list = new ArrayList<Buyed>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from buyed where user_id = '"+userId+"'";
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			while(rs.next())
			{
				Buyed b = new Buyed();
				b.setCommId(rs.getInt("comm_id"));
				b.setUserId(rs.getInt("user_id"));
				b.setPrice(rs.getInt("price"));
				b.setBuyTime(rs.getTimestamp("buy_time"));
				b.setNote(rs.getString("note"));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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
		return list;
	}
}
