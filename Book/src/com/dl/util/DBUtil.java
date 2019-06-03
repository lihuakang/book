package com.dl.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtil {
	public static Connection getConn() {
		try {
			Context ctx=new InitialContext();
			DataSource ds=(DataSource) ctx.lookup("java:comp/env/jdbc/CarDB");
			return ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Statement openStmt(Connection conn) {
		try {
			return conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static ResultSet search(Statement stmt,String sql) {
		try {
			return stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static int update(Statement stmt,String sql) {
		try {
			return stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	public static void close(Connection conn) {
		if (conn!=null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt) {
		if (stmt!=null)
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(ResultSet rs) {
		if (rs!=null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void close(Statement stmt,Connection conn) {
		close(stmt);
		close(conn);
	}
	public static void close(ResultSet rs,Statement stmt,Connection conn) {
		close(rs);
		close(stmt);
		close(conn);
	}
	
	public static int update(String sql) {
		Connection conn=getConn();
		Statement stmt=openStmt(conn);
		int i=update(stmt,sql);
		close(stmt,conn);
		return i;
	}
}
