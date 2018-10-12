$(function(){
	$(".form-btn-1").on('click', function() {
		$(".form-btn-1").addClass('active');
		$(".form-btn-1").removeClass('form-btn-1');
		$(".active2").addClass('form-btn-2');
		$(".active2").removeClass('active2');
	});
	$(".form-btn-2").on('click', function() {
		$(".active").addClass('form-btn-1');
		$(".form-btn-1").removeClass('active');
		$(".form-btn-2").addClass('active2');
		$(".form-btn-2").removeClass('form-btn-2');
	});
})