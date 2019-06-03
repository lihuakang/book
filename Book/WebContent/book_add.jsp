<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增页面</title>
</head>
<body>
	<h3>新增图书</h3>
	<form action="bookadd?flag=save" method="post">
		<table>
			<tr>
				<td>图书名称</td>
				<td><input type="text" name="bname"></td>
			</tr>
			<tr>
				<td>作者</td>
				<td><input type="text" name="author"></td>
			</tr>
			<tr>
				<td>出版社</td>
				<td><input type="text" name="press"></td>
			</tr>
			<tr>
				<td>图书种类</td>
				<td>
				<select name="kname">
					<option value="">--请选择--</option>
					<option value="现实小说">现实小说</option>
					<option value="历史书籍">历史书籍</option>
					<option value="数理科学和化学">数理科学和化学</option>
					<option value="期刊">期刊</option>
					<option value="其他">其他</option>
				</select></td>
			</tr>
			<tr>
				<td>图书数量</td>
				<td><input type="text" name="bnum"></td>
			</tr>
			<!-- <tr>
				<td>图书图片</td>
				<td><input type="file" name="img"></td>
			</tr> -->
			<tr>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
</body>
</html>