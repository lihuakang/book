package com.dl.model;

public class Admin {
	private Integer aid;
	private String aname;
	private String apassword;
	public Admin() {
		super();
	}
	public Admin(Integer aid, String aname, String apassword) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.apassword = apassword;
	}
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
}
