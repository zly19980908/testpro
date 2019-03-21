$('b').click(function() {
	var str = '<div><input type="text" class="yyy" maxsize="50"/><button class="xxx">确定</button></div>';
	$(this).parent().next().append(str);
	$(".yyy").focus();
	$(".xxx").click(function() {
		var txt = $(this).prev().val();
		var comments = $(this).parents("pre");
		var pre_html = '<pre class="t_reply">回复:' + txt + '</pre>';
		$(this).parent().remove();
		comments.after(pre_html);
	});
	$(".change-unit-input").keyup(function(e) {
		if (e.keyCode == 13) {
			var txt = $(this).prev().val();
			var comments = $(this).parents("pre");
			var pre_html = '<pre class="t_reply">回复:' + txt + '</pre>';
			$(this).parent().remove();
			comments.after(pre_html);
		}
	});
});