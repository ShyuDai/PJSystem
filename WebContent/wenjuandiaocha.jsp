<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>问卷调查</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta name="viewport" content="width=device-width,user-scalable=no,initial-scale=1,maximum-scale=1,minimum-scale=1">
	
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.css">
	<link rel="stylesheet" href="css/wenjuan.css">
	
	<script type="text/javascript">
		function changeCity(code){
			$.post("danYuanServlet?flag=1",{parentCode:code},function(data){
				$("#pinPai option:not(:first)").remove();
				$("#zhuangGui option:not(:first)").remove();
				$("#guWen option:not(:first)").remove();
				$.each(data,function(i,danYuan){
					$("#pinPai").append("<option value='"+ danYuan.code + "'>"+ danYuan.name + "</option>");
				});
			},"json");
		}
		
		
		function changePinPai(code){
			$.post("danYuanServlet?flag=1",{parentCode:code},function(data){
				$("#zhuangGui option:not(:first)").remove();
				$("#guWen option:not(:first)").remove();
				$.each(data,function(i,danYuan){
					$("#zhuangGui").append("<option value='"+ danYuan.code + "'>"+ danYuan.name + "</option>");
				});
			},"json");
		}
		
		function changeZhuanGui(code){
			$.post("renYuanServlet?flag=1",{danYuanCode:code},function(data){
				$("#guWen option:not(:first)").remove();
				$.each(data,function(i,renYuan){
					$("#guWen").append("<option value='"+ renYuan.renyuanid + "'>"+ renYuan.name + "</option>");
				});
			},"json");
		}
		
		//满意按钮
		function manyi(){
			$("#manyianniu").val(1);
			//alert($("#manyianniu").val());
		}
		//不满意按钮
		function bumanyi(){
			$("#manyianniu").val(0);
			//alert($("#manyianniu").val());
		}
	</script>
</head>
<body>
<div class="logo">
        <!-- 魔方 -->
        <div class="scene">
          <div class="cube rotating">
            <div class="cube-face front">问卷</div>
            <div class="cube-face inner-faces inner-face"></div>
            <div class="cube-face inner-faces inner-face2"></div>
            <div class="cube-face inner-faces inner-face3"></div>
            <div class="cube-face back">调查</div>
            <div class="cube-face left">问卷</div>
            <div class="cube-face right">调查</div>
            <div class="cube-face top">问卷</div>
            <div class="cube-face bottom">调查</div>
          </div>
        </div>
</div>

<form action="GetPingJiaServlet" method="post">
	<select id="city" class="form-control" id="form-control1" onchange="changeCity(this.value)" name="chengshi">
	  <option>选择您所在的城市</option>
	  <c:forEach var="danYuan" items="${danYuanList}">
	  	<option value="${danYuan.code }">${danYuan.name }</option>
	  </c:forEach>
	</select>
	<select id="pinPai" class="form-control" id="form-control2" onchange="changePinPai(this.value)" name="pinpai">
	  <option>选择您的购买品牌</option>
	</select>
	<select id="zhuangGui" class="form-control" id="form-control3" onchange="changeZhuanGui(this.value)" name="zhuangui">
	  <option>选择柜台</option>
	</select>
	<select id="guWen" class="form-control" id="form-control4" name="guwen">
	  <option>选择专柜顾问</option>
	</select>
	<div class="form-news">请对您提供服务的顾问进行评价</div>
	<div class="form-btn">
		<span class="form-btn-1" onclick="manyi()">满意</span>
		<span class="form-btn-2" onclick="bumanyi()">不满意</span>
		<input id="manyianniu" type="hidden" name="manyishu" value="">
	</div>
	<div class="form-sub">
		<button>提交</button>
	</div>
</form>

<!-- <script type="text/javascript" src="bootstrap-3.3.7-dist/js/bootstrap.js"></script> -->
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="js/wenjuan.js"></script>
</body>
</html>