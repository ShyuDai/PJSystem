	function getdata() {
		
		//首次加载城市
		$.ajax({
			type : "post",
			url : "AjaxGetChengShi?flag=2",
			dataType : "json",
			success : function(data) {
				$.each(data.json, function(i, power) {
					
				});
			}
		});		
	}