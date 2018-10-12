<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>

	<table>
		<tr>
			<td>岗位名称</td>
			<td>所属部门</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${sessionScope.gangWeis}" var="gw">
			<tr>
				<td>${gw.gangwei}</td>
				<td>${gw.bumen}</td>
				<td><a href="QuanXianServlet?gangweiid=1&flag=0">设置权限</a>
					<a href="GangweiUpdateServlet?gangweiid=${gw.gangweiid }&flag=0">修改</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>