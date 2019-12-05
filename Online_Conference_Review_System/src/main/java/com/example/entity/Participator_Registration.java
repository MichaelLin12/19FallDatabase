package com.example.entity;

public class Participator_Registration {
	
	private String fname;
	private String email;
	private String lname;
	private String minit;
	private String phone;
	private String affiliation;
	private String password;
	private String repassword;
	private String conType;
	
	public Participator_Registration(String fname, String email, String lname, String minit, String phone,
			String affiliation, String password, String repassword,String conType) {
		super();
		this.fname = fname;
		this.email = email;
		this.lname = lname;
		this.minit = minit;
		this.phone = phone;
		this.affiliation = affiliation;
		this.password = password;
		this.repassword = repassword;
		this.conType=conType;
	}
	
	public Participator_Registration()
	{
		super();
		this.fname = "";
		this.email = "";
		this.lname = "";
		this.minit = "";
		this.phone = "";
		this.affiliation = "";
		this.password = "";
		this.repassword = "";
		this.conType="";
	}
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMinit() {
		return minit;
	}
	public void setMinit(String minit) {
		this.minit = minit;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAffiliation() {
		return affiliation;
	}
	public void setAffiliation(String affiliation) {
		this.affiliation = affiliation;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepassword() {
		return repassword;
	}
	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}
	
	public String getConType() {
		return conType;
	}
	
	public void setConType(String conType) {
		this.conType=conType;
	}
}
