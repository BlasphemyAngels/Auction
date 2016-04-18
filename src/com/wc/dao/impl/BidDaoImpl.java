package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.wc.domain.Bid;
import com.wc.utils.DBUtils;

public class BidDaoImpl {
	
	public boolean add(Bid bid){
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into Bid values(?, ?, ?, ?, ?)";
		try {
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setInt(1, bid.getCommId());
			ps.setInt(2, bid.getBuyer());
			ps.setInt(3, bid.getPrice());
			ps.setDate(4, bid.getcDate());
			ps.setString(5, bid.getNote());
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try{
				if(ps != null)
				{
					ps.close();
					ps = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			try{
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public int findBuyer(int commId){
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select buyer from Bid where comm_id = '"+commId+"' order by price";
			rs = DBUtils.executeQuary(sql, stmt);
			if(rs.next())
			{
				return rs.getInt("buyer");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				if(rs != null)
				{
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(stmt != null)
				{
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if(conn != null)
				{
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;

	}
	
}
