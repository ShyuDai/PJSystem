<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style type="text/css">
form
{
	width:180px;
	height:300px;
	margin:0 auto;
	margin-top:300px;
}
#save
{
	margin-left:60px;
	margin-top:15px;
}
</style>
<body>
	<form action="GangweiUpdateServlet?gangweiid=${requestScope.gangWei.gangweiid }&flag=1" method="post">
		岗位名称：<input type="text" name="gangwei">
		所属部门：<input type="text" name="bumen">
		<input id="save" type="submit" value="提交">
	
	</form>
</body>
</html>