package com.wc.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.wc.domain.Bid;
import com.wc.domain.Buyed;
import com.wc.domain.Commodity;
import com.wc.domain.User;
import com.wc.utils.DBUtils;

public class CommodityDaoImpl {
	public Commodity find(int commId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		Commodity comm = null;
		checkState(commId);
		try {
			String sql = "select * from commodity where comm_id = '" + commId + "'";
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				comm = new Commodity();
				comm.setComm_id(commId);
				comm.setTitle(rs.getString("title"));
				comm.setOwner(rs.getInt("owner"));
				comm.setPub_date(rs.getTimestamp("pub_date"));
				comm.setEnd_date(rs.getTimestamp("end_date"));
				comm.setClosed(rs.getBoolean("closed"));
				comm.setBuyer(rs.getInt("buyer"));
				comm.setImage(rs.getString("image"));
				comm.setPrice(rs.getInt("price"));
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comm;
	}

	public boolean add(Commodity comm) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String sql = "insert into commodity values(0, ?, ?, ?, ?, ?, ?, ?, ?)";
			conn = DBUtils.getConnection();
			ps = DBUtils.prepareStmt(conn, sql);
			ps.setString(1, comm.getTitle());
			ps.setInt(2, comm.getOwner());
			ps.setTimestamp(3, new Timestamp(comm.getPub_date().getTime()));
			ps.setTimestamp(4, new Timestamp(comm.getEnd_date().getTime()));
			ps.setBoolean(5, false);
			ps.setInt(6, 1);
			ps.setString(7, comm.getImage());
			ps.setInt(8, comm.getPrice());
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

	@SuppressWarnings("resource")
	public Commodity find() {
		Commodity comm = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select * from commodity where pub_date = (select max(pub_date) from commodity)";
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				int id = rs.getInt("comm_id");
				checkState(id);
			}
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				comm = new Commodity();
				comm.setComm_id(rs.getInt("comm_id"));
				comm.setTitle(rs.getString("title"));
				comm.setOwner(rs.getInt("owner"));
				comm.setPub_date(rs.getTimestamp("pub_date"));
				comm.setEnd_date(rs.getTimestamp("end_date"));
				comm.setClosed(rs.getBoolean("closed"));
				comm.setBuyer(rs.getInt("buyer"));
				comm.setImage(rs.getString("image"));
				comm.setPrice(rs.getInt("price"));
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comm;
	}

	public int count() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int ret = 0;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select count(*) from commodity";
			rs = DBUtils.executeQuary(sql, stmt);
			if (rs.next()) {
				ret = rs.getInt(1);
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ret;
	}

	public List<Commodity> findAll(int start, int pageSize) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<Commodity> commodities = new ArrayList<Commodity>();
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select * from commodity order by pub_date desc limit " + start + "," + pageSize;
			rs = DBUtils.executeQuary(sql, stmt);
			while (rs.next()) {
				Commodity comm = new Commodity();
				comm.setComm_id(rs.getInt("comm_id"));
				comm.setTitle(rs.getString("title"));
				comm.setOwner(rs.getInt("owner"));
				comm.setPub_date(rs.getTimestamp("pub_date"));
				comm.setEnd_date(rs.getTimestamp("end_date"));
				comm.setClosed(rs.getBoolean("closed"));
				comm.setBuyer(rs.getInt("buyer"));
				comm.setImage(rs.getString("image"));
				comm.setPrice(rs.getInt("price"));
				commodities.add(comm);
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return commodities;
	}

	public List<Commodity> find(int start, int pageSize) {
		List<Commodity> commodities = findAll(start, pageSize);
		for (Commodity comm : commodities) {
			checkState(comm.getComm_id());
		}
		commodities = findAll(start, pageSize);
		return commodities;
	}

	public void checkState(int commId) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			String sql = "select end_date from commodity where comm_id = '" + commId + "'";
			rs = DBUtils.executeQuary(sql, stmt);
			if (!rs.next())
				return;
			
			BuyedDaoImpl buyDao = new BuyedDaoImpl();
			Buyed bb = buyDao.findBuy(commId);
			if (bb != null)
				return;
			Timestamp e = rs.getTimestamp("end_date");
			Timestamp n = new Timestamp(System.currentTimeMillis());
			if (e.before(n)) {
				sql = "update Commodity set closed = true where comm_id = '" + commId + "'";
				stmt.executeUpdate(sql);
				BidDaoImpl bd = new BidDaoImpl();
				Bid bid = bd.find(commId);
				if (bid != null && bid.getcDate().before(e)) {
					sql = "update Commodity set buyer = " + bid.getBuyer() + " where comm_id = '" + commId + "'";
					stmt.executeUpdate(sql);
					Buyed buy = new Buyed();
					buy.setCommId(commId);
					buy.setUserId(bid.getBuyer());
					buy.setPrice(bid.getPrice());
					buy.setBuyTime(bid.getcDate());
					buy.setNote(bid.getNote());
					buyDao.add(buy);
				}
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<Commodity> find(String uPart) {
		List<Commodity> comms = new ArrayList<>();
		if (uPart == null || uPart.trim().equals("")) {
			return comms;
		}
		UserDaoImpl userDao = new UserDaoImpl();
		List<User> users = userDao.listAllUsers("all", uPart);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from commodity where owner = ";
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			for (User user : users) {
				rs = DBUtils.executeQuary(sql + user.getUserId(), stmt);
				while (rs.next()) {
					Commodity comm = new Commodity();
					comm.setBuyer(rs.getInt("buyer"));
					comm.setClosed(rs.getBoolean("closed"));
					comm.setComm_id(rs.getInt("comm_id"));
					comm.setEnd_date(rs.getTimestamp("end_date"));
					comm.setImage(rs.getString("image"));
					comm.setOwner(rs.getInt("owner"));
					comm.setPrice(rs.getInt("price"));
					comm.setPub_date(rs.getTimestamp("pub_date"));
					comm.setTitle(rs.getString("title"));
					comms.add(comm);
				}
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comms;
	}

	public List<Commodity> find(String tPart, String uPart, int price) {
		List<Commodity> comms = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from commodity where 1=1";
		if (tPart != null && !tPart.trim().equals("")) {
			sql += " and title like '%" + tPart + "%'";
		}
		if (uPart != null && !uPart.trim().equals("")) {
			return find(uPart);
		}
		if (price > 0) {
			sql += " and price >= " + price;
		}
		sql += " order by pub_date desc";
		try {
			conn = DBUtils.getConnection();
			stmt = DBUtils.createStmt(conn);
			rs = DBUtils.executeQuary(sql, stmt);
			while (rs.next()) {
				Commodity comm = new Commodity();
				comm.setBuyer(rs.getInt("buyer"));
				comm.setClosed(rs.getBoolean("closed"));
				comm.setComm_id(rs.getInt("comm_id"));
				comm.setEnd_date(rs.getTimestamp("end_date"));
				comm.setImage(rs.getString("image"));
				comm.setOwner(rs.getInt("owner"));
				comm.setPrice(rs.getInt("price"));
				comm.setPub_date(rs.getTimestamp("pub_date"));
				comm.setTitle(rs.getString("title"));
				comms.add(comm);
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
			try {
				if (stmt != null) {
					stmt.close();
					stmt = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return comms;
	}
}
