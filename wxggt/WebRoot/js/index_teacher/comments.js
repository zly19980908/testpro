$('b').click(function(){
//	$(this).parent().next().css({"background":"red"});
	var str='<div><input type="text" maxsize="50"/><button>确定</button></div>';
	$(this).parent().next().append(str);
});
