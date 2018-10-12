<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index-main.css">
</head>
<style>
table
{
	position: absolute;
    width: 600px;
    height: 250px;
    color: #111;
    margin-left:500px;
    margin-top: 280px;
    font-size: 16px;
}

table td
{
	text-align: center;
}
table tr:nth-child(2n-1)
		{
			background:#eee;
		}
#gangwei-t a:hover
{
	color:blue;
	font-weight:normal;
	
}
#gangwei-t a
{
	color:#111;
	font-weight:normal;
	font-size:16px;
}
.gangwei-baocun
{
	display: block;
  width: 80px;
  height:40px;
  margin:0 auto;
  border-radius:5px;
  border:none;
  background: #3399CC;
  outline: none;
  cursor: pointer;
  color:#fff;
  font-size: 16px;
  margin-top:20px;
}
</style>
<script>
$("#p-out").on('click',function(){
	window.location.href = "http://www.baidu.com";
});
</script>
<body>
<div class="zhezhao">
    <div class="gangwei-add">
      <div class="gangwei-add-tittle">
        <span class="close"></span>
        岗位位置新增
      </div>
      <form action="GangweiAddServlet" method="post">
      <div class="gangwei-add-i1"><span>岗位名称：</span><input type="text" name="gangwei">&nbsp;&nbsp;*</div>
      <div class="gangwei-add-i2"><span>所属部门：</span><input type="text" name="bumen">&nbsp;&nbsp;*</div>
      <input class="gangwei-baocun" type="submit" value="保存">
      </form>
    </div>
</div>
<header>
  <div class="head-left">
    <img src="images/ava.jpg">
    <span>系统管理员</span>
    <div class="test_triangle_border">
    <div class="popup">
        <span><em></em></span>
        <p>修改密码</p>
        <p id="p-out">退出登录</p>
    </div>
</div>
  </div>
</header>
<!-- <iframe src="index.html" frameborder="0"> -->
<div class="main">
  <div class="gangwei">
    <div class="gangwei-search">
      <input type="text" name="gangwei" id="gangwei" placeholder="岗位名称">
      <button class="gangwei-b1">搜索</button>
      <button class="gangwei-b2">添加</button>
      <div class="gangwei-title">
        岗位设置
      </div>
    </div>
  </div>
</div>
<!-- </iframe> -->
	<table id="gangwei-t">
		<tr><td>岗位名称</td><td>所属部门</td><td>操作</td></tr>
		<c:forEach items="${sessionScope.gangWeis}" var="gw">
			<tr style="text-algin:center;">
				<td>${gw.gangwei}</td>
				<td>${gw.bumen}</td>
				<td><a href="QuanXianServlet?gangweiid=${gw.gangweiid}&flag=0">设置权限</a>
				<a href="GangweiUpdateServlet?gangweiid=${gw.gangweiid }&flag=0">修改</a></td>
			</tr>
		</c:forEach>
	</table>

<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="js/index-main.js"></script>

</body>
</html>