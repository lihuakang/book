package com.dl.dao;

import java.util.List;

import com.dl.model.Admin;
import com.dl.model.Book;
import com.dl.model.BookKind;

public interface AdminDao {
	public Admin login(String sname,String spassword);
	public BookKind findkid(String kname);
	public void save(String bname, String author, String press, int kid, int bnum, String img);
	public List<Book> findAll();
	public void delect(String id);
}
