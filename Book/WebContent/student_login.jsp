<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生登录页面</title>
</head>
<body>
	<h4><a href="admin_login.jsp">我是管理员</a></h4>
	<form action="StudentLogin" method="post">
		<table>
			<tr>
				<td>学生姓名</td>
				<td><input type="text" name="sname" value="${cookie.name.value} "></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="password" name="spassword" value="${cookie.pwd.value}"></td>
			</tr>
			<tr>
				<td><input type="radio" name="rem" <c:if test="${!empty cookie.name }">checked</c:if>>记住账号和密码</td>
			</tr>
			<tr>
				<td>
					验证码
				</td>
				<td>
					<input type="text" name="code" />
					<a href="#" onclick="show(); return false;"><img id="imgId" src="${ pageContext.request.contextPath }/CheckcodeServlet"></a>
				</td>
				
			</tr>
			<tr>
				<td>${mag }</td>
			</tr>
			<tr>
				<td><input type="submit" value="登录"></td>
				<td>${msg}</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		function show(){
			var image = document.getElementById("imgId");
			image.src = "${pageContext.request.contextPath}/CheckcodeServlet?"+new Date().getTime();
		}
		
	</script>
</body>
</html>