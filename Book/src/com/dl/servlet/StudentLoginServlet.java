package com.dl.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dl.dao.StudentDao;
import com.dl.daoImpl.StudentDaoImpl;
import com.dl.model.Student;
import com.dl.util.ShaEncrypt;


/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/StudentLogin")
public class StudentLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String sname=request.getParameter("sname");
			String spassword=request.getParameter("spassword");
			StudentDao dao=new StudentDaoImpl();
			Student stu =dao.login(sname,ShaEncrypt.shaEncode(spassword));
			
			String code=request.getParameter("code");
			HttpSession session=request.getSession();
			String sessCode=(String) session.getAttribute("sessCode");
			if(!code.equalsIgnoreCase(sessCode)) {
				request.setAttribute("mag", "验证码输入错误");
				request.getRequestDispatcher("student_login.jsp").forward(request, response);
			}else {
				if(stu==null) {
				request.setAttribute("msg", "用户或密码错误");
				request.getRequestDispatcher("student_login.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
			}
			String rem=request.getParameter("rem");
			if ("on".equals(rem)) {
				Cookie nc=new Cookie("name", sname);
				Cookie pc=new Cookie("pwd",spassword);
				nc.setMaxAge(60*60*24*10);
				pc.setMaxAge(60*60*24*10);
				response.addCookie(nc);
				response.addCookie(pc);
			}
	}

}
