package com.wc.web.form;

import java.util.HashMap;
import java.util.Map;

/**
 * 注册提交过来的表�?
 * @author Administrator
 *
 */
public class RegisterForm {

	private String username;
	private String password;
	private String password2;
	private String ranomdWord;
	private Map<String, String> errors = new HashMap<String, String>();

	public RegisterForm() {
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

	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public String getRanomdWord() {
		return ranomdWord;
	}

	public void setRanomdWord(String ranomdWord) {
		this.ranomdWord = ranomdWord;
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
			errors.put("username", "用户名不能为空！！！");
		} else {
			if (!username.matches("[\\w]{3,6}")) {
				ok = false;
				errors.put("username", "用户名只能由数字、字母�?�下划线组成！！�?");
			}
		}
		if (password == null || password.trim().equals("")) {
			ok = false;
			errors.put("password", "密码不能为空！！�?");
		} else {
			if (!password.matches("[\\w]{6,10}")) {
				ok = false;
				errors.put("password", "密码只能由数字�?�字母�?�下划线组成！！�?");
			}
		}
		if (password2 == null || password2.equals("")) {
			ok = false;
			errors.put("password2", "确认密码不能为空");
		} else {
			if (!password2.equals(password)) {
				ok = false;
				errors.put("password2", "两次输入的密码不同！�?");
			}
		}
		if(ranomdWord == null || ranomdWord.trim().equals(""))
		{
			ok = false;
			errors.put("ranomdWord", "验证码不能为�?");
		}
		return ok;
	}

}
