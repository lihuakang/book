package com.dl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dl.dao.AdminDao;
import com.dl.daoImpl.AdminDaoImpl;
import com.dl.model.Admin;
import com.dl.util.ShaEncrypt;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLogin")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String aname=request.getParameter("aname");
		String apassword=request.getParameter("apassword");
		AdminDao dao=new AdminDaoImpl();
		Admin admin =dao.login(aname,ShaEncrypt.shaEncode(apassword));
		if(admin==null) {
			request.setAttribute("msg", "用户或密码错误");
			request.getRequestDispatcher("admin_login.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("admin.jsp").forward(request, response);
		}
		String rem=request.getParameter("rem");
		if ("on".equals(rem)) {
			Cookie nc=new Cookie("name", aname);
			Cookie pc=new Cookie("pwd",apassword);
			nc.setMaxAge(60*60*24*10);
			pc.setMaxAge(60*60*24*10);
			response.addCookie(nc);
			response.addCookie(pc);
	}

}
}
