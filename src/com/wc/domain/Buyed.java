package com.wc.domain;

import java.sql.Timestamp;

public class Buyed {

	private int commId;
	private int userId;
	private int price;
	private Timestamp buyTime;
	private String note;

	public Buyed(int commId, int userId, int price, Timestamp buyTime, String note) {
		super();
		this.commId = commId;
		this.userId = userId;
		this.price = price;
		this.buyTime = buyTime;
		this.note = note;
	}

	public Buyed() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCommId() {
		return commId;
	}

	public int getUserId() {
		return userId;
	}

	public int getPrice() {
		return price;
	}

	public Timestamp getBuyTime() {
		return buyTime;
	}

	public String getNote() {
		return note;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setBuyTime(Timestamp buyTime) {
		this.buyTime = buyTime;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
