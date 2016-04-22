package com.wc.domain;

public class UserDetail {
	private int userId;
	private String name;
	private String email;
	private String ID;
	private String tel;
	private String addr;
	private boolean isCheck;

	public UserDetail(int userId, String name, String email, String iD, String tel, String addr, boolean isCheck) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		ID = iD;
		this.tel = tel;
		this.addr = addr;
		this.isCheck = isCheck;
	}

	public UserDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getUserId() {
		return userId;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getID() {
		return ID;
	}

	public String getTel() {
		return tel;
	}

	public String getAddr() {
		return addr;
	}

	public boolean isCheck() {
		return isCheck;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setCheck(boolean isCheck) {
		this.isCheck = isCheck;
	}

}
