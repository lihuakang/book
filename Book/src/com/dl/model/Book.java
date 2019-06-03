package com.dl.model;

public class Book {
	private Integer bid;
	private String bname;
	private String author;
	private String press;
	private Integer kid;
	private Integer bnum;
	private String img;
	private String kname;
	public Book(Integer bid, String bname, String author, String press, Integer bnum, String img, String kname) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.press = press;
		this.bnum = bnum;
		this.img = img;
		this.kname = kname;
	}
	public String getKname() {
		return kname;
	}
	public void setKname(String kname) {
		this.kname = kname;
	}
	public Book() {
		super();
	}
	public Book(Integer bid, String bname, String author, String press, Integer kid, Integer bnum, String img) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.press = press;
		this.kid = kid;
		this.bnum = bnum;
		this.img = img;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public Integer getKid() {
		return kid;
	}
	public void setKid(Integer kid) {
		this.kid = kid;
	}
	public Integer getBnum() {
		return bnum;
	}
	public void setBnum(Integer bnum) {
		this.bnum = bnum;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
}
