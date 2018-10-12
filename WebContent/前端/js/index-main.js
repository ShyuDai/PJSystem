$(function(){


	// 遮罩层
	$(".gangwei-b2").on('click', function() {
		$(".zhezhao").show();
		$(".gangwei-add").show();
	});
	$(".close").on('click', function() {
		$(".zhezhao").hide();
		$(".zhezhao2").hide();
		$(".gangwei-add").hide();
		$(".renyuan-add").hide();
	});

	$(".renyuan-b2").on('click', function() {
		$(".zhezhao2").show();
		$(".renyuan-add").show();
	});

	$(".head-left").on('mouseover', function() {
		$(".test_triangle_border").show();
	});
	$(".test_triangle_border").on('mouseover', function() {
		$(".test_triangle_border").show();
	});
	$(".test_triangle_border").on('mouseout', function() {
		$(".test_triangle_border").hide();
	});

// var w=window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;
var h=window.innerHeight || document.documentElement.clientHeight || document.body.clientHeight;
// document.getElementById("这里放id").style.width = w+"px";
document.getElementById("menu").style.height = h+"px";


})

// window.onresize = function(){

// }