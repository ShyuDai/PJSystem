<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<link rel="stylesheet" type="text/css" href="css/index-main.css">
</head>
<body>
<nav class="menu" id="menu">
  <div class="menu-logo">
    <div class="logo">
        <!-- 魔方 -->
        <div class="scene">
          <div class="cube rotating">
            <div class="cube-face front">后台</div>
            <div class="cube-face inner-faces inner-face"></div>
            <div class="cube-face inner-faces inner-face2"></div>
            <div class="cube-face inner-faces inner-face3"></div>
            <div class="cube-face back">管理</div>
            <div class="cube-face left">用户</div>
            <div class="cube-face right">添加</div>
            <div class="cube-face top">权限</div>
            <div class="cube-face bottom">修改</div>
          </div>
        </div>
    </div>
  </div>
    <nav class="drop-down-menu">
      <input type="checkbox" class="activate" id="accordion-1" name="accordion-1">
      <label for="accordion-1" class="menu-title menu-active"><img src="images/icon1.png">系统管理</label>
      <div class="drop-down down-active">
        <a href="GangweiServlet" class="down1" target="main">岗位设置</a>
        <a href="renyuan.html" class="down2" target="main">人员设置</a>
        <a class="last down3" href="Rizhi.jsp" target="main">系统日志</a>
      </div>
    </nav>
    <nav class="drop-down-menu">
      <input type="checkbox" class="activate" id="accordion-2" name="accordion-2">
      <label for="accordion-2" class="menu-title"><img src="images/icon2.png">评价管理</label>
      
      <div class="drop-down">
        <a href="ToGuWenMingXiChaXunServlet" class="down4" target="main">顾问明细查询</a>
        <a href="ToGuWenChaXunServlet" class="down5" target="main">顾问查询</a>
        <a href="ToGuKeChaXunServlet" class="last down6" target="main">顾客查询</a>
      </div>
    </nav>
    <nav class="drop-down-menu">
      <input type="checkbox" class="activate" id="accordion-3" name="accordion-3">
      <label for="accordion-3" class="menu-title"><img src="images/icon3.png">关于我们</label>
      
      <div class="drop-down">
        <a href="#">分工明细</a>
        <a href="#">凑位置</a>
        <a class="last" href="#">假装看不见</a>
      </div>
    </nav>
</nav>


<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="js/index-main.js"></script>
</body>
</html>