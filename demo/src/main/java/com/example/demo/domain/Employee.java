package com.example.demo.domain;

public class Employee {
	
	private String fname;
	private String lname;
	private String ssn;
	private String dno;
	
	
	
	/**
	 * @param fname
	 * @param lname
	 * @param ssn
	 */
	public Employee(String fname, String lname, String ssn) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.ssn = ssn;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}
	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getDno() {
		return dno;
	}
	public void setDno(String dno) {
		this.dno = dno;
	}

	
	
}
