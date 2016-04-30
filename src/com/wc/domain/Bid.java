package com.wc.domain;

import java.sql.Timestamp;

public class Bid {
	private int commId;
	private int buyer;
	private int price;
	private Timestamp cDate;
	private String note;

	public Bid() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bid(int commId, int buyer, int price, Timestamp cDate, String note) {
		super();
		this.commId = commId;
		this.buyer = buyer;
		this.price = price;
		this.cDate = cDate;
		this.note = note;
	}

	public int getCommId() {
		return commId;
	}

	public int getBuyer() {
		return buyer;
	}

	public int getPrice() {
		return price;
	}

	public Timestamp getcDate() {
		return cDate;
	}

	public String getNote() {
		return note;
	}

	public void setCommId(int commId) {
		this.commId = commId;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setcDate(Timestamp cDate) {
		this.cDate = cDate;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
