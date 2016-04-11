package com.wc.web.form;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Administrator
 *
 */
public class LoginForm {

	private String username;
	private String password;
	private String randomWord;
	private Map<String, String> errors = new HashMap<String, String>();

	public LoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginForm(String username, String password, String randomWord) {
		super();
		this.username = username;
		this.password = password;
		this.randomWord = randomWord;
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

	public String getRandomWord() {
		return randomWord;
	}

	public void setRandomWord(String randomWord) {
		this.randomWord = randomWord;
	}

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public boolean invalidate() {
		boolean ok = true;
		if (username == null || username.trim().equals("")) {
			ok = false;
			errors.put("username", "�û�������Ϊ��^_^��");
		}
		if (password == null || password.trim().equals("")) {
			ok = false;
			errors.put("password", "���벻��Ϊ��^_^��");
		}
		if(randomWord == null || randomWord.trim().equals(""))
		{
			ok = false;
			errors.put("randomWord", "��֤�벻��Ϊ��^_^��");
		}
		return ok;
	}
}
