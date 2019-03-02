var cNo = $("#cNo").val();
$(function() {
	/* 画所有初始竖直连接线 */
	drawVerticalLine();
});
/*----------------------------------------功能区----------------------------------------*/
/* 单元鼠标覆盖效果 */
$(document).on("mouseenter", ".content-unit", function() {
	$(this).append("<div class='action-unit'><a class='bj' href='javascript:void(0);'>编辑</a>&nbsp;<a href='javascript:void(0);'>删除</a></div>");
	$(this).css({
		"background" : "#e6fbe6"
	});
});

/* 课时鼠标覆盖效果 */
$(document).on("mouseenter", ".content-part", function() {
	$(this).append("<div class='action-part'><a href='#'>编辑</a>&nbsp;<a href='#'>删除</a></div>");
	$(this).css({
		"background" : "#e6fbe6"
	});
});

/* 单元鼠标离开事件 */
$(document).on("mouseleave", ".content-unit", function() {
	$(this).children(".action-unit").remove();
	$(this).css({
		"background" : ""
	});
});

/* 课时鼠标离开事件 */
$(document).on("mouseleave", ".content-part", function() {
	$(this).children(".action-part").remove();
	$(this).css({
		"background" : ""
	});
});
/*----------------------------------------下面是被调用的函数----------------------------------------*/
/* 画普通连接线 */
function drawVerticalLine() {
	var $myCanvas = $(".c");
	$myCanvas.drawLine({
		strokeStyle : "#808080",
		strokeWidth : 2,
		x1 : 55,
		y1 : 0,
		x2 : 55,
		y2 : 47.5,
	});
}