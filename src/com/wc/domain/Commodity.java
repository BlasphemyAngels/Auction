package com.wc.domain;

import java.sql.Timestamp;

public class Commodity {
	private int comm_id;
	private String title;
	private int owner;
	private Timestamp pub_date;
	private Timestamp end_date;
	private boolean closed;
	private int buyer;
	private int price;
	private String image;

	public Commodity(int comm_id, String title, int owner, Timestamp pub_date, Timestamp end_date, boolean closed, int buyer,
			int price, String image) {
		super();
		this.comm_id = comm_id;
		this.title = title;
		this.owner = owner;
		this.pub_date = pub_date;
		this.end_date = end_date;
		this.closed = closed;
		this.buyer = buyer;
		this.price = price;
		this.image = image;
	}

	public Commodity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getComm_id() {
		return comm_id;
	}

	public String getTitle() {
		return title;
	}

	public int getOwner() {
		return owner;
	}

	public Timestamp getPub_date() {
		return pub_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public boolean isClosed() {
		return closed;
	}

	public int getBuyer() {
		return buyer;
	}

	public int getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setComm_id(int comm_id) {
		this.comm_id = comm_id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOwner(int owner) {
		this.owner = owner;
	}

	public void setPub_date(Timestamp pub_date) {
		this.pub_date = pub_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public void setBuyer(int buyer) {
		this.buyer = buyer;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public boolean isEnd(){
		if (end_date.before(new Timestamp(System.currentTimeMillis())))
		{
			closed = true;
			return true;
		}
		return false;
	}
	

}
