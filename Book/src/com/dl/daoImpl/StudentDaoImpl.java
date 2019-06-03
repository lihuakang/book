package com.dl.daoImpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dl.dao.StudentDao;
import com.dl.model.Student;
import com.dl.util.DBUtil;

public class StudentDaoImpl implements StudentDao{

	@Override
	public Student login(String sname, String spassword) {
		String sql="select * from student where sname ='"+sname+"' and spassword ='"+ spassword +"'";
		Connection conn=DBUtil.getConn();
		 Statement stmt=DBUtil.openStmt(conn);
		 ResultSet rs=DBUtil.search(stmt, sql);
		 Student stu = null;
				try {
					if (rs.next()) {
						stu=new Student();
						stu.setSid(rs.getInt(1));
						stu.setSname(rs.getString(2));
						stu.setSpassword(rs.getString(3));
						}
					DBUtil.close(rs,stmt,conn);
					return stu;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
					return null;
	}
}
