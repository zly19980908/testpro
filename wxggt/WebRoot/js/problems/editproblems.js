/*---------------------------------------字数限制处理---------------------------------------*/

/*问题内容*/
$(".textarea-style").focus(function(){
	$(this).next(".question-word-num").css({
		"display":"block"
	});
	
});

$(".textarea-style").blur(function(){
	$(this).next(".question-word-num").css({
		"display":"none"
	});
});

$(".textarea-style").keyup(function(){
	var word_num = $(this).val().length;
	$(this).next(".question-word-num").find("span").text(76-word_num);
});

/*选项*/
$(".select-style").focus(function(){
	$(this).next(".select-word-num").css({
		"display":"block"
	});
});

$(".select-style").blur(function(){
	$(this).next(".select-word-num").css({
		"display":"none"
	});
});

$(".select-style").keyup(function(){
	var word_num = $(this).val().length;
	$(this).next(".select-word-num").find("span").text(38-word_num);
});

/*---------------------------------------字数限制处理到此结束---------------------------------------*/

