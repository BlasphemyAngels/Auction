package com.wc.domain;

/**
 * Userʵ����
 * @author ccl
 *
 */
public class User {
	private String username;
	private String password;
	private int userType;

	public User(String username, String password, int userType) {
		super();
		this.username = username;
		this.password = password;
		this.userType = userType;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

}
