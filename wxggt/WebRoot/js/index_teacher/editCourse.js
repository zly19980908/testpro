$(function() {
	var cNo = $("#cNo").val();
	/* 画所有连接线 */
	drawVerticalLine();

	/* 单元鼠标覆盖效果 */
	$(document).on("mouseenter", ".content-unit", function() {
		$(this).append("<div class='action-unit'><a class='bj' href='javascript:void(0);'>编辑</a>&nbsp;<a href='javascript:void(0);'>删除</a></div>");
		$(this).css({
			"background" : "#c5eef3b1"
		});
	});

	/* 课时鼠标覆盖效果 */
	$(document).on("mouseenter", ".content-part", function() {
		$(this).append("<div class='action-part'><a href='#'>编辑</a>&nbsp;<a href='#'>删除</a></div>");
		$(this).css({
			"background" : "#c5eef3b1"
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

	/* 切换到普通单元显示模式 */
	function toOrdinaryUnit(unit_title) {
		$(".change-unit-content").replaceWith("<div class='content-unit'>" + unit_title + "</div>");
	}

	/* 单元点击编辑-动态元素的绑定 */
	$(document).on("click", "a:contains('编辑')[href='javascript:void(0);']", function() {
		var unit_num = parseInt($(this).parent().parent().prev().text());
		var unit_title = $(this).parent().parent().prop("firstChild").nodeValue;
		$(this).parent().parent().replaceWith("<div class='change-unit-content' tabindex='1'><input type='text' class='change-unit-input' maxlength='25' /><div class='change-unit-button-group'><input type='button' class='change-unit-button' value='保存' />&nbsp;&nbsp;<input type='button' class='change-unit-button' value='取消' id='exit_' /></div></div>");
		/* 自动聚焦到文本框 */
		$(".change-unit-input").focus().val(unit_title);
		/* 1.点击保存 */
		$(".change-unit-button:eq(0)").click(function() {
				executeChangeUnitTitle();
		});
		/* 2.按下了回车 */
		$(".change-unit-input").keyup(function(e) {
			if (e.keyCode == 13) {
				executeChangeUnitTitle();
			}
		});
		/*修改单元内容处理过程*/
		function executeChangeUnitTitle(){
			var new_unit_title = $('.change-unit-input').val();
			/*如果单元内容发生了变化*/
			if (new_unit_title != unit_title) {
				/* 这里写ajax代码 */
				changeUnitTitle(cNo,unit_num, unit_title,new_unit_title);
			}else{
				toOrdinaryUnit(unit_title);
			}
		}
		
		/* 3.点击取消 */
		$(".change-unit-button:eq(1)").click(function() {
			console.log("点击了取消");
			toOrdinaryUnit(unit_title);
		});
		/* 防止在编辑单元格后点击保存或取消时触发blur事件 */
		$(".change-unit-button-group").on("mousedown", function(e) {
			if (e && e.preventDefault) {
				// 现代浏览器阻止默认事件
				e.preventDefault();
			} else {
				// IE阻止默认事件
				window.event.returnValue = false;
			}
			return false;
		});
		/* 失去焦点时还原 */
		$(".change-unit-input").blur(function() {
			console.log("触发了失去焦点事件");
			toOrdinaryUnit(unit_title);
		});
	});

	/* 课时点击编辑-动态元素的绑定 */
	$(document).on("click", "a:contains('编辑')[href='#']", function() {
		var part_num = $(this).parent().parent().prev().prev().children().text();
		var part_title = $(this).parent().parent().prop("firstChild").nodeValue;
		alert("课时" + part_num + "原标题是:" + part_title);
	});

	/* 单元点击删除-动态元素的绑定 */
	$(document).on("click", "a:contains('删除')[href='javascript:void(0);']", function() {
		var unit_num = parseInt($(this).parent().parent().prev().text());
		if (confirm("确定要删除吗？")) {
			console.log("删除单元:" + unit_num);
		}
	});

	/* 课时点击删除-动态元素的绑定 */
	$(document).on("click", "a:contains('删除')[href='#']", function() {
		var part_num = parseInt($(this).parent().parent().prev().prev().children().text());
		alert("课时" + part_num);
	});

	function changeUnitTitle(cNo,unit_num, unit_title, new_unit_title) {
		unit_title_="单元"+unit_num+"--"+unit_title;
		new_unit_title_="单元"+unit_num+"--"+new_unit_title;
		$.ajax({
			url : "../../php/changeUnitName.php?cNo=" + cNo + "&unit_title=" + unit_title_ + "&new_unit_title=" + new_unit_title_,
			type : "GET",
			success : succseFunction
		});
		function succseFunction(tt) {
			if (eval(tt) == 0) {
				alert("保存失败,请稍后再试");
				toOrdinaryUnit(unit_title);
			} else {
				toOrdinaryUnit(new_unit_title);
			}
		}
		alert(flag);
		return flag;
	}

	/* 画连接线 */
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
	;

});
