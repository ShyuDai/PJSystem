<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>	
</script>
</head>
<body>
	<form action="QuanXianServlet?gangweiid=1&flag=1" method="post">
	<table>
	<c:forEach var="p" items="${list}">	
	<tr>
	<td>
	<c:if test="${p.setpower==1}">
		<input type="checkbox" id="gangweiset" name="${p.power}" value="${p.power}" checked="checked" />${p.power}
	</c:if>
	<c:if test="${p.setpower==0}">
		<input type="checkbox" id="gangweiset" name="${p.power}" value="${p.power}" />${p.power}
	</c:if>
	</td>
	</tr>
	</c:forEach>
	</table>
	<input type="submit" id="save" value="保存" />
	</form>

</body>
</html>