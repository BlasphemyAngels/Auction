package com.wc.web.form;

import java.util.HashMap;
import java.util.Map;

public class UpdatePswForm {
	private String oldpassword;
	private String newPassword;
	private String repeatPassword;
	private String ranomdWord;
	private Map<String, String> errors = new HashMap<String, String>();

	public UpdatePswForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdatePswForm(String oldpassword, String newPassword, String repeatPassword) {
		super();
		this.oldpassword = oldpassword;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
	}

	public UpdatePswForm(String oldpassword, String newPassword, String repeatPassword, String ranomdWord) {
		super();
		this.oldpassword = oldpassword;
		this.newPassword = newPassword;
		this.repeatPassword = repeatPassword;
		this.ranomdWord = ranomdWord;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
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
		if (oldpassword == null || oldpassword.trim().equals("")) {
			ok = false;
			errors.put("oldpassword", "密码不能为空！！");
		} else {
			if (!oldpassword.matches("[\\w]{6,10}")) {
				ok = false;
				errors.put("oldpassword", "密码只能由6-10位数字、字母、下划线组成！！");
			}
		}
		if (newPassword == null || newPassword.trim().equals("")) {
			ok = false;
			errors.put("newPassword", "密码不能为空！！");
		} else {
			if (!newPassword.matches("[\\w]{6,10}")) {
				ok = false;
				errors.put("newPassword", "密码只能由6-10位数字、字母、下划线组成！！");
			}
		}
		if (repeatPassword == null || repeatPassword.equals("")) {
			ok = false;
			errors.put("repeatPassword", "确认密码不能为空！");
		} else {
			if (!repeatPassword.equals(newPassword)) {
				ok = false;
				errors.put("repeatPassword", "两次输入的密码不同！");
			}
		}
		if (ranomdWord == null || ranomdWord.trim().equals("")) {
			ok = false;
			errors.put("ranomdWord", "验证码不能为空！");
		}
		return ok;
	}

}
