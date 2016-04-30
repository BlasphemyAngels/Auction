package com.wc.web.form;

public class CompleteInfoForm {
	private String personname;
	private String email;
	private String ID;
	private String tel;
	private String addr;

	public String getPersonname() {
		return personname;
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

	public void setPersonname(String personname) {
		this.personname = personname;
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

	public CompleteInfoForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompleteInfoForm(String personname, String email, String iD, String tel, String addr) {
		super();
		this.personname = personname;
		this.email = email;
		ID = iD;
		this.tel = tel;
		this.addr = addr;
	}

}
