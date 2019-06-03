package com.dl.model;

public class Student {
	private Integer sid;
	private String sname;
	private String spassword;
	public Student() {
		super();
	}
	public Student(Integer sid, String sname, String spassword) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.spassword = spassword;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSpassword() {
		return spassword;
	}
	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}
}
