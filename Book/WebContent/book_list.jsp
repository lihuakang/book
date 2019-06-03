<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty list }">
		无用户信息
	</c:if>
	<c:if test="${not empty list }">
		<form action="">
			<table boder="1">
				<tr>
					<td><input type="checkbox"></td>
					<td>id</td>
					<td>书名</td>
					<td>作者</td>
					<td>出版社</td>
					<td>书类型</td>
					<td>数量</td>
					<td>图片</td>
					<td>操作</td>
				</tr>
				<c:forEach items="${list }" var="c">
					<tr>
						<td><input type="checkbox"></td>
						<td>${c.bid }</td>
						<td>${c.bname }</td>
						<td>${c.author }</td>
						<td>${c.press }</td>
						<td>${c.kname }</td>
						<td>${c.bnum }</td>
						<td>${c.img }</td>
						<td>
							<a href="javascript:;">修改</a>
							<a href="javascript:;" onclick="del('${c.bid}')">删除</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</form>
	
	
	
	</c:if>
	
<script type="text/javascript">
	function del(id) {
		var flag = window.confirm("确认删除吗");

		if (flag) {
			//确认删除
			location.href = "${pageContext.request.contextPath}/bookadd?flag=del&id="
					+ id;
		}
	}
</script>
</body>
</html>