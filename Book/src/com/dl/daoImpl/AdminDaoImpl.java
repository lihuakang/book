package com.dl.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.dl.dao.AdminDao;
import com.dl.model.Admin;
import com.dl.model.Book;
import com.dl.model.BookKind;
import com.dl.util.DBUtil;

public class AdminDaoImpl  implements AdminDao{

	@Override
	public Admin login(String aname, String apassword) {
		String sql="select * from admin where aname ='"+aname+"' and apassword ='"+ apassword +"'";
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 ResultSet rs=DBUtil.search(stmt, sql);
		 Admin admin = null;
				try {
					if (rs.next()) {
						admin=new Admin();
						admin.setAid(rs.getInt(1));
						admin.setAname(rs.getString(2));
						admin.setApassword(rs.getString(3));
						}
					DBUtil.close(rs,stmt,conn);
					return admin;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
					return null;
	}

	@Override
	public BookKind findkid(String kname) {
		BookKind bk=null;
		String sql="select * from book_kind where kname='"+kname+"'";
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 ResultSet rs=DBUtil.search(stmt, sql);
		 try {
			if(rs.next()) {
				 bk=new BookKind();
				 bk.setKid(rs.getInt(1));
				 bk.setKname(rs.getString(2));
			 }
			DBUtil.close(rs,stmt,conn);
			return bk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return null;
	}

	@Override
	public void save(String bname, String author, String press, int kid, int bnum, String img) {
		
		String sql="insert into book values(null,'"+bname+"','"+author+"','"+press+"','"+kid+"','"+bnum+"','"+img+"')";
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 DBUtil.update(sql);
	}

	@Override
	public List<Book> findAll() {
		String sql="select b.bid,b.bname,b.author,b.press,b.kid,b.bnum,b.img,k.kname from book b join book_kind k on b.kid=k.kid";
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 ResultSet rs=DBUtil.search(stmt, sql);
		 Book book=null;
		 List<Book> list =new ArrayList<>();
		 try {
			while(rs.next()) {
				book=new Book();
				 book.setBid(rs.getInt(1));
				 book.setBname(rs.getString(2));
				 book.setAuthor(rs.getString(3));
				 book.setPress(rs.getString(4));
				 book.setKid(rs.getInt(5));
				 book.setBnum(rs.getInt(6));
				 book.setImg(rs.getString(7));
				 book.setKname(rs.getString(8));
				 list.add(book);
			 }
			DBUtil.close(rs,stmt,conn);
		return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void delect(String id) {
		// TODO Auto-generated method stub
		String sql="delete from book where bid="+id;
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 DBUtil.update(sql);
		 DBUtil.close(stmt,conn);
	}

	
	

}
