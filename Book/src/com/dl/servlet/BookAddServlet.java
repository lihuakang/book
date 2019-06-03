package com.dl.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dl.dao.AdminDao;
import com.dl.daoImpl.AdminDaoImpl;
import com.dl.model.Book;
import com.dl.model.BookKind;

/**
 * Servlet implementation class BookAddServlet
 */
@WebServlet("/bookadd")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag");
		if("save".equals(flag)) {
			String bname=request.getParameter("bname");
			String author=request.getParameter("author");
			String press=request.getParameter("press");
			String kname=request.getParameter("kname");
			String bnum=request.getParameter("bnum");//转换成Integer
//			String img =request.getParameter("img");
			String img=null;
//			System.out.println(img);
			AdminDao dao=new AdminDaoImpl();
			BookKind bk=dao.findkid(kname);
			int kid=bk.getKid();
			dao.save(bname,author,press,kid,Integer.parseInt(bnum),img);
			flag=null;
		}
		if("del".equals(flag)) {
			String id=request.getParameter("id");
			AdminDao dao=new AdminDaoImpl();
			dao.delect(id);
			flag=null;
		}
		if(flag==null) {
			AdminDao dao=new AdminDaoImpl();
			List<Book>  list=dao.findAll();
			request.setAttribute("list", list);
			request.getRequestDispatcher("book_list.jsp").forward(request, response);
		}
		
	}

}
