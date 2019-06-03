package com.dl.model;

public class BookKind {
	private Integer kid;
	private String kname;
	public BookKind() {
		super();
	}
	public BookKind(Integer kid, String kname) {
		super();
		this.kid = kid;
		this.kname = kname;
	}
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
}
