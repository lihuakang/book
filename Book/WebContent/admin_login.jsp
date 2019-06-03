<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="AdminLogin" method="post">
		<table>
			<tr>
				<td>管理员姓名</td>
				<td><input type="text" name="aname" value="${cookie.name.value} "></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="apassword" value="${cookie.pwd.value}"></td>
			</tr>
			<tr>
				<td><input type="radio" name="rem" <c:if test="${!empty cookie.name }">checked</c:if>>记住账号和密码</td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td>${msg}</td>
			</tr>
		</table>
	</form>
</body>
</html>