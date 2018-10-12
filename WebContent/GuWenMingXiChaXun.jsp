<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>顾问明细查询</title>
<script type="text/javascript" src="jquery-3.2.1.min.js"></script>
<script type="text/javascript">

		//加载页面时加载城市列表
		$.ajax({
			url:"AjaxGetChengShi?method=00",
			type:"post",
			dataType:"json",
			success:function(data) {
				$("#chengshi").empty(); //清空下拉列表
				$.each(data.rows, function(i, danyuan) {
					$("#chengshi").append("<option value='"+danyuan.code+"'>" + danyuan.name + "</option>");
				});
			}
		});
		
		//城市的值发生改变，获取相应的品牌列表
		 $(function(){
            $("#chengshi").bind("change", $("#chengshi").click(function() {
						//加载品牌
						$.ajax({
							url:"AjaxGetPinPai?method="+$("#chengshi").val(),
							type:"post",
							dataType:"json",
							success:function(data) {
								$("#pinpai").empty(); //清空下拉列表
								if(data.rows.length>0){//该地区有品牌
									$.each(data.rows, function(i, danyuan) {
										if(i==0){
											//$("#pinpai").val(danyuan.code);
											//$("#pinpai").prepend("<option>"+danyuan.name+"</option>");
											//alert(i);
											//加载专柜开始
											$.ajax({
												url:"AjaxGetZhuanGui?method="+danyuan.code,
												type:"post",
												dataType:"json",
												success:function(data) {
													$("#zhuangui").empty(); //清空下拉列表
													$.each(data.rows, function(i, danyuan) {
														$("#zhuangui").append("<option value="+danyuan.code+">" + danyuan.name + "</option>");
													});
												}
											});
											//加载专柜结束
										}
										$("#pinpai").append("<option value="+danyuan.code+">" + danyuan.name + "</option>");
									});
								}else{//该地区无品牌
									$("#pinpai").empty(); //清空下拉列表
									$("#zhuangui").empty(); //清空下拉列表
								}
								
							}
						});
					}));
            
          //根据品牌加载专柜
            $("#pinpai").bind("change", $("#pinpai").click(function() {
            	//加载专柜
				$.ajax({
					url:"AjaxGetZhuanGui?method="+$("#pinpai").val(),
					type:"post",
					dataType:"json",
					success:function(data) {
						$("#zhuangui").empty(); //清空下拉列表
						$.each(data.rows, function(i, danyuan) {
							$("#zhuangui").append("<option value="+danyuan.code+">" + danyuan.name + "</option>");
						});
					}
				});
			}));
        });
 
	
</script>
</head>
<body>


	<br>
	<br> 城市：
	<select id="chengshi" name="chengshi"
		style="WIDTH: 90px; height: 30px;">
		<option>请选择城市</option>
	</select>
	<br>
	<br> 品牌：
	<select id="pinpai" name="pinpai" style="WIDTH: 90px; height: 30px;">
		<option>请选择品牌</option>
	</select>
	<br>
	<br> 专柜：
	<select id="zhuangui" name="zhuangui"
		style="WIDTH: 90px; height: 30px;">
		<option>请选择专柜</option>
	</select>
	<br>
	<br>



	<h1>评价查询</h1>
	<table id="pjTab" border="1" align="center" width="70%">
		<tr align="center">
			<td>序号</td>
			<td>城市</td>
			<td>品牌</td>
			<td>专柜</td>
			<td>OpenId</td>
			<td>人员</td>
			<td>产生时间</td>
			<td>是否满意</td>
			<td>位置</td>
		</tr>
		<c:forEach items="${pageHelper.rows}" var="ph">
			<tr align="center">
				<td>${ph.pingjiajiluid}</td>
				<td>${ph.chengshi}</td>
				<td>${ph.pinpai}</td>
				<td>${ph.zhuangui}</td>
				<td>${ph.openid}</td>
				<td>${ph.renyuanmc}</td>
				<td>${ph.createtime}</td>
				<td><c:if test="${ph.leixing==1}">
						满意
					</c:if> <c:if test="${ph.leixing==0}">
						不满意
					</c:if></td>
				<td><a
					href="WeiZhiServlet?jingDu=${ph.jingdu}&weiDu=${ph.weidu}">位置</a></td>
			</tr>
		</c:forEach>


	</table>
	<br>
	<br>
	<div id="pagehelper" align="center">
		<c:if test="${requestScope.pageHelper.currentPage==1}">
			首页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;上一页
		</c:if>
		<c:if test="${requestScope.pageHelper.currentPage>1}">
			<a href="PageHelperServlet?currentPage=1">首页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a
				href="PageHelperServlet?currentPage=${requestScope.pageHelper.currentPage-1}">上一页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 第${requestScope.pageHelper.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if
			test="${requestScope.pageHelper.currentPage<requestScope.pageHelper.totalPage}">
			<a
				href="PageHelperServlet?currentPage=${requestScope.pageHelper.currentPage+1}">下一页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a
				href="PageHelperServlet?currentPage=${requestScope.pageHelper.totalPage}">尾页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if
			test="${requestScope.pageHelper.currentPage==requestScope.pageHelper.totalPage}">
			下一页&nbsp;&nbsp;&nbsp;&nbsp;尾页
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.totalPage}页
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.total}条数据

	</div>

</body>
</html>