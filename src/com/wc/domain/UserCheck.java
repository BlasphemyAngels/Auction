package com.wc.domain;

public class UserCheck {
	private int userId;
	private boolean checkState;

	public UserCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCheck(int userId, boolean checkState) {
		super();
		this.userId = userId;
		this.checkState = checkState;
	}

	public int getUserId() {
		return userId;
	}

	public boolean isCheckState() {
		return checkState;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setCheckState(boolean checkState) {
		this.checkState = checkState;
	}

}
