<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://api.tianditu.com/api?v=4.0"></script>
</head>
<body>

	<div>
		<input type="hidden" id="lon" value="${requestScope.jingdu}" />
		<input type="hidden" id="lat" value="${requestScope.weidu}" /> 
	</div>
	
	<div id="mapDiv" style="position: absolute; width: 100%; height: 100%"></div>
		
	<script>
		var map; //地图对象123
		var zoom = 12; //层级，值越大，地图范围越小
		var lon = document.getElementById('lon').value;
		var	lat = document.getElementById('lat').value;
		if (lon == '' || lon == null)
			lon = 116.40769;
		if (lat == '' || lat == null)
			lat = 39.89945;
		var t = new T.LngLat(lon, lat);
		map = new T.Map("mapDiv");
		map.centerAndZoom(t, zoom);
	    //允许鼠标滚轮缩放地图
	   	map.enableHandleMouseScroll();
	    //向地图上添加自定义标注
	    var marker = new TMarker(new TLngLat(lon,lat));
	    //向地图上添加标注
	    map.addOverLay(marker);
		
	</script>
</body>
</html>