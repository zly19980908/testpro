/*----------------------------------------功能区----------------------------------------*/
/* 单元-----用户点击编辑 */
$(document).on("click", "a:contains('编辑')[href='javascript:void(0);']", function() {
	var unit_title = $(this).parent().parent().prop("firstChild").nodeValue;
	/* 生成编辑单元面板 */
	$(this).parent().parent().replaceWith("<div class='change-unit-content' tabindex='1'><input type='text' class='change-unit-input' maxlength='25' /><div class='change-unit-button-group'><input type='button' class='change-unit-button' value='保存' />&nbsp;&nbsp;<input type='button' class='change-unit-button' value='取消' id='exit_' /></div></div>");
	/* 防止在编辑单元格后点击保存或取消时触发blur事件 */
	avoidLost();
	/* 自动聚焦到文本框 */
	$(".change-unit-input").focus().val(unit_title);
	/* 保存---点击保存 */
	$(".change-unit-button:eq(0)").click(function() {
		/* 修改单元内容处理过程 */
		executeChangeUnitTitle(cNo, unit_title);
	});
	/* 保存---按下回车 */
	$(".change-unit-input").keyup(function(e) {
		if (e.keyCode == 13) {
			/* 修改单元内容处理过程 */
			executeChangeUnitTitle(cNo, unit_title);
		}
	});
	/* 取消---用户点击取消 */
	$(".change-unit-button:eq(1)").click(function() {
		toOrdinaryUnit(unit_title);
	});
	/* 取消---用户点击其他区域 */
	$(".change-unit-input").blur(function() {
		toOrdinaryUnit(unit_title);
	});
});

/* 单元-----用户点击删除 */
$(document).on("click", "a:contains('删除')[href='javascript:void(0);']", function() {
	var unit_num = parseInt($(this).parent().parent().prev().text());
	if (confirm("确定要删除吗？")) {
		console.log("删除单元:" + unit_num);
	}
});
/*----------------------------------------下面是被调用的函数----------------------------------------*/
/* 切换到普通单元显示模式 */
function toOrdinaryUnit(unit_title) {
	$(".change-unit-content").replaceWith("<div class='content-unit'>" + unit_title + "</div>");
}

/* 修改单元内容处理过程 */
function executeChangeUnitTitle(cNo, unit_title) {
	var new_unit_title = $('.change-unit-input').val();
	/* 如果单元内容发生了变化 */
	if (new_unit_title != unit_title) {
		/* 这里写ajax代码 */
		changeUnitTitle(cNo, unit_title, new_unit_title);
	} else {
		toOrdinaryUnit(unit_title);
	}
}

function changeUnitTitle(cNo, unit_title, new_unit_title) {
	var unit_title_ = "单元--" + unit_title;
	var new_unit_title_ = "单元--" + new_unit_title;
	var url_ = "../../php/t_changeUnitName.php?cNo=" + cNo + "&unit_title=" + unit_title_ + "&new_unit_title=" + new_unit_title_;
	$.ajax({
		url : url_,
		type : "post",
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
/* 防止在编辑单元格后点击保存或取消时触发blur事件 */
function avoidLost() {
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
}