<%@page import="com.pj.util.PageResult"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

 <title>rizhilist</title>
   
   <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
   <script type="text/javascript">
     function deleteRizhiByRizhiId(rizhiId,obj) {
		if(confirm("确定删除？")){
    	 $.post("rizhiServlet?flag=1",{"rizhiId":rizhiId},function(data){
			alert("删除成功");
			if(data=="1"){
			   $(obj).parent().parent().remove();
			   alert("删除成功");
			}else {
				alert("删除失败");
			}
		});
	}
  }
   </script>
<link rel="stylesheet" type="text/css" href="css/index-main.css">
</head>
<body>
  <header>
  <div class="head-left">
    <img src="images/ava.jpg">
    <span>系统管理员</span>
    <div class="test_triangle_border">
    <div class="popup">
        <span><em></em></span>
        <p>修改密码</p>
        <p>退出登录</p>
    </div>
</div>
  </div>
</header>
<!-- <iframe src="index.html" frameborder="0"> -->
<div class="main">
  <div class="rizhi">
    <div class="rizhi-search">
      <input type="text" name="rizhi" id="rizhi" placeholder="操作人名称">
      <button class="rizhi-b1">搜索</button>
      <!-- <button class="rizhi-b2">添加</button> -->
      <div class="rizhi-title">
        系统设置
      </div>
    </div>
  </div>
</div>
<!-- </iframe> -->



  <div align="center">
  		<h1 style="color: red;">系统日志</h1>

  		<hr>
  		<table border="1px">
	  		<tr>
	  			<th>行号</th>
	  			<th>操作时间</th>
	  			<th>路径</th>
	  			<th>名称</th>
	  			<th>描述</th>
	  			<th>操作人员</th>
	  		</tr>
	  		<c:forEach var="rizhi" items="${pageResult.results}"
	  			varStatus="index">
	  			<tr>
	  				<td>${(pageResult.pageNO-1)*pageResult.pageSize+index.count }</td>
	  				<td>${rizhi.createtime }</td>
	  				<td>${rizhi.link }</td>
	  				<td>${rizhi.name }</td>
	  				<td>${rizhi.description }</td>
	  				<td>${rizhi.caozuorymc }</td>
	  				<td><a href="javascript:void(0)" onclick="deleteRizhiByRizhiId(${rizhi.rizhiid})">删除</a></td>
	  			</tr>
	  		 
	  		</c:forEach>
	  	</table>
	  	 <!-- 分页 -->
	  	 <%
	    	PageResult pageResult=(PageResult)request.getAttribute("pageResult");
	  	    int pageCount=pageResult.getPageCount();
	  	    int pageNO = pageResult.getPageNO();
	  	    
	  	    int start = pageNO-5 <= 0 ? 1:pageNO-5;
	  	    int end = start+10<pageCount ? start+10 :pageCount;
	  	    
	  	    if(pageNO>1){
	  	    	%>
	  	    <a href="RizhiServlet?pageNO=1&pageSize=10">首页</a>
	  	    <a href="RizhiServlet?pageNO=<%=pageNO-1 %>&pageSize=10">上一页</a>
	  	    	<% 
	  	    }
	  	    
	  	    for(int i=start;i<=end;i++){
	  	    	%>
	  	   	<a style="color:<%=(i==pageNO?"red":"" )%>" href="RizhiServlet?pageNO=<%=i %>&pageSize=10"><%=i %></a>
	  	 <% 
	  	    }
	  	    if(pageNO < pageCount){
	  	    	%>	  	    	
	  	    	<a href="RizhiServlet?pageNO=<%=pageNO+1 %>&pageSize=10">下一页</a>
	  	    	<a href="RizhiServlet?pageNO=<%=pageCount %>&pageSize=10">尾页</a>
	  	    	
	  	  <% 
	  	    }
	  	 %>
	  	 <form action="RizhiServlet">
	  	   跳转到<input type="text" name="pageNO" value="${pageResult.pageNO }">页
	  	   <input value="确定" type="submit">
	  	 </form>
	  	 查询出${pageResult.count }条记录
  	</div>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="js/index-main.js"></script>
</body>
</html>