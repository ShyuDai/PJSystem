<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Document</title>
	<script type="text/javascript">
    function base64 (content) {
       return window.btoa(unescape(encodeURIComponent(content)));         
    }
    function exportOffice(dom,tableID,fName){
            var type = 'excel';
            var table = document.getElementById(tableID);
            var excelContent = table.innerHTML;
            var excelFile = "<html xmlns:o='urn:schemas-microsoft-com:office:office' xmlns:x='urn:schemas-microsoft-com:office:"+type+"' xmlns='http://www.w3.org/TR/REC-html40'>";
            excelFile += "<head>";
            excelFile += "<meta http-equiv=Content-Type; content=text/html;charset=UTF-8>";
            excelFile += "<!--[if gte mso 9]>";
            excelFile += "<xml>";
            excelFile += "<x:ExcelWorkbook>";
            excelFile += "<x:ExcelWorksheets>";
            excelFile += "<x:ExcelWorksheet>";
            excelFile += "<x:Name>";
            excelFile += "{worksheet}";
            excelFile += "</x:Name>";
            excelFile += "<x:WorksheetOptions>";
            excelFile += "<x:DisplayGridlines/>";
            excelFile += "</x:WorksheetOptions>";
            excelFile += "</x:ExcelWorksheet>";
            excelFile += "</x:ExcelWorksheets>";
            excelFile += "</x:ExcelWorkbook>";
            excelFile += "</xml>";
            excelFile += "<![endif]-->";
            excelFile += "</head>";
            excelFile += "<body><table>";
            excelFile += excelContent;
            excelFile += "</table></body>";
            excelFile += "</html>";
            var base64data = "base64," + base64(excelFile);
            switch(type){
                case 'excel':
                    dom.href ='data:application/vnd.ms-'+type+';'+base64data;;//必须是a标签，否则无法下载改名
                    dom.download = fName;
                break;
            }
    }
</script>
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
	<link rel="stylesheet" type="text/css" href="css/index-main.css">
	<style type="text/css">
		.main .guke .mingxi-b1
		{
		    display: block;
		  text-align: center;
		  line-height:30px;
		  font-weight: normal;
		  font-size: 14px;
		  position: absolute;
		  top:36px;
		  left: 623px;
		  bottom:54px;
		  width: 70px;
		  height:30px;
		  border:none;
		  background: #3399CC;
		  color:#fff;
		  outline: none;
		  border-radius:5px;
		  cursor: pointer;
		}
		#Button1
		{
		  display: block;
		  text-align: center;
		  line-height:30px;
		  font-weight: normal;
		  font-size: 14px;
		  position: absolute;
		  top:158px;
		  left: 1110px;
		  bottom:54px;
		  width: 70px;
		  height:30px;
		  border:none;
		  background: #3399CC;
		  color:#fff;
		  outline: none;
		  border-radius:5px;
		  cursor: pointer;
		}
		table
		{
			margin-top:100px;
			border-radius:50px;
			color:#111;
			font-size:16px;
		}
		table tr:nth-child(2n-1)
		{
			background:#eee;
		}
		table a
		{
			color:blue;
			text-decoration: none;
			font-weight: normal;
		}
		table a:hover
		{
			color:blue;
		}
		table td
		{
			line-height:40px;
		}
		#pagehelper
		{
			color:#111;
		}
		#pagehelper a
		{
			color:#111;
			text-decoration: none;
			font-weight: normal;
		}
		#pagehelper a:hover
		{
			color:blue;
		}
	</style>
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
  <div class="guke">
    <form action="ToGuKeChaXunServlet" method="post">
      <div class="mingxi-city">
          <span>城&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;市：</span>
          <select id="chengshi" name="chengshi">
          <c:if test="${not empty sessionScope.chengshi}">
            <option>${sessionScope.chengshi}</option>
          </c:if>
          </select>
        </div>
        <!-- <br> -->
        <div class="mingxi-pinpai">
          <span>品&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;牌：</span>
          <select id="pinpai" name="pinpai">
            <c:if test="${not empty sessionScope.pinpai}">
            <option>${sessionScope.pinpai}</option>
          	</c:if>
            <c:if test="${empty sessionScope.pinpai}">
            <option>请选择品牌</option>
          	</c:if>
          </select>
        </div>
        <div class="mingxi-zhuangui">
          <span>专&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;柜：</span>
          <select id="zhuangui" name="zhuangui">
            <c:if test="${not empty sessionScope.zhuangui}">
            <option>${sessionScope.zhuangui}</option>
          	</c:if>
            <c:if test="${empty sessionScope.zhuangui}">
            <option>请选择专柜</option>
          	</c:if>
          </select>
        </div>
        <div class="mingxi-begintime">
          <span>开始时间：</span>
            	<input id="" name="begintime" type="date"/>
        </div>
        <div class="mingxi-overtime">
          <span>结束时间：</span>
            	<input id="" name="overtime" type="date"/> 
        </div>
        <input class="mingxi-b1" type="submit" value="查询">
      </form>
      <a onClick="exportOffice(this,'pjTab','excel下载')" href="javascript:void(-1)">
			<input id="Button1" type="button" value="导出" />
		</a>
  </div>
	<br><br>
	<br>
	<c:if test="${not empty pageHelper.rows}">
	<table id="pjTab" border="0" align="center" width="70%">
		<tr align="center">
			<td>序号</td>
			<td>品牌</td>
			<td>地区</td>
			<td>柜台名称</td>
			<td>OpenId</td>
			<td>满意次数</td>
			<td>不满意次数</td>
		</tr>
		<c:forEach items="${pageHelper.rows}" var="ph" varStatus="idx">
			<tr align="center">
				<td>${(pageHelper.currentPage-1)*pageHelper.pageSize+idx.count}</td>
				<td>${ph.pinpai}</td>
				<td>${ph.chengshi}</td>
				<td>${ph.zhuangui}</td>
				<td>${ph.openid}</td>
				<td>${ph.manyi}</td>
				<td>${ph.bumanyi}</td>
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
			<a href="PageHelperServlet?Source=3&currentPage=1">首页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="PageHelperServlet?Source=3&currentPage=${requestScope.pageHelper.currentPage-1}">上一页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 第${requestScope.pageHelper.currentPage}页
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if
			test="${requestScope.pageHelper.currentPage<requestScope.pageHelper.totalPage}">
			<a href="PageHelperServlet?Source=3&currentPage=${requestScope.pageHelper.currentPage+1}">下一页</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="PageHelperServlet?Source=3&currentPage=${requestScope.pageHelper.totalPage}">尾页</a>
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp;
		<c:if test="${requestScope.pageHelper.currentPage==requestScope.pageHelper.totalPage}">
			下一页&nbsp;&nbsp;&nbsp;&nbsp;尾页
		</c:if>
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.totalPage}页
		&nbsp;&nbsp;&nbsp;&nbsp; 共${requestScope.pageHelper.total}条数据

	</div>
	</c:if>
</div>
<!-- </iframe> -->


<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="js/index-main.js"></script>
</body>
</html>