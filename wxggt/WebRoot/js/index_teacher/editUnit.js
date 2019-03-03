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
		executeChangeUnitTitle(unit_title);
	});
	/* 保存---按下回车 */
	$(".change-unit-input").keyup(function(e) {
		if (e.keyCode == 13) {
			/* 修改单元内容处理过程 */
			executeChangeUnitTitle(unit_title);
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
	var unit_title = $(this).parents(".content-unit").prop("firstChild").nodeValue;
	if (confirm("确定要删除单元 '" + unit_title + "' 吗？此举将删除此单元下所有课时!!!")) {
		var next_row_unit = $(this).parents(".row-unit").nextUntil(".row-unit");
		var row_part=next_row_unit.next(".row-part");
		var length_=row_part.length;
		var del_title_group=[];
		del_title_group.push("单元--"+unit_title);
		row_part.slice(0, length_-1).each(function(){
			del_title_group.push($(this).find('.content-part').text());
		});
		var this_row_unit = $(this).parents(".row-unit");
		delete_unit(this_row_unit,next_row_unit,del_title_group);
	}
});

/* 课时-----用户点击'添加' */
$(document).on("click", ".am-icon-plus.am-icon-md,.new-unit-text", function() {
	/* x代表单元内容面板 */
	x = $(this).parents(".new-unit-content");
	/* y代表添加新单元面板 */
	y = $(this).parents(".row-unit");
	/*
	 * y.css({ "background" : "red" });
	 */
	var edit_unit_html = "<div class='change-unit-content' tabindex='1'>" + "<input type='text' class='change-unit-input' maxlength='25' />" + "<div class='change-unit-button-group'>" + " <input type='button' class='change-unit-button' value='保存' />&nbsp;&nbsp;" + " <input type='button' class='change-unit-button' value='取消' id='exit_' />" + " </div>" + "</div>";
	x.replaceWith(edit_unit_html);
	y.find(".change-unit-input").focus();
	/* 防止在编辑单元格后点击保存或取消时触发blur事件 */
	avoidLost();
	/* 取消---用户点击取消 */
	y.find(".change-unit-button:eq(1)").click(function() {
		toAddUnit(y);
	});
	/* 取消---用户点击其他区域 */
	y.find(".change-unit-input").blur(function() {
		toAddUnit(y);
	});
	/* 保存---用户点击保存 */
	y.find(".change-unit-button:eq(0)").click(function() {
		var title = y.find(".change-unit-input").val();
		if (title != "") {
			insertUnitTitle(y, title);
		}

	});
	/* 保存---用户按下回车 */
	y.find(".change-unit-input").keyup(function(e) {
		if (e.keyCode == 13) {
			/* 修改单元内容处理过程 */
			var title = y.find(".change-unit-input").val();
			if (title != "") {
				insertUnitTitle(y, title);
			}
		}
	});
});
/*----------------------------------------下面是被调用的函数----------------------------------------*/
/* 切换到普通单元显示模式 */
function toOrdinaryUnit(unit_title) {
	$(".change-unit-content").replaceWith("<div class='content-unit'>" + unit_title + "</div>");
}

/* 修改单元内容处理过程 */
function executeChangeUnitTitle(unit_title) {
	var new_unit_title = $('.change-unit-input').val();
	/* 如果单元内容发生了变化 */
	if (new_unit_title != unit_title) {
		/* 这里写ajax代码 */
		changeUnitTitle(unit_title, new_unit_title);
	} else {
		toOrdinaryUnit(unit_title);
	}
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
/* 取消此次添加,返回到原始添加单元界面 */
function toAddUnit(y) {
	/* y.css({ "background" : "red" }); */
	var add_unit_html = '<div class="new-unit-content"><span class="am-icon-plus am-icon-md"></span><div class="new-unit-text">添加新单元 </div></div>';
	y.find(".change-unit-content").replaceWith(add_unit_html);
}

/* 点击保存,生成新的单元行 */
function toNewUnit(y, title) {
	var new_unit_html = '<div class="row-unit"><div class="title-unit">单元</div><div class="circle-unit"><span class="num-unit"></span></div>	<div class="content-unit" style="">' + title + '</div></div>';
	/* z代表新建单元的前一个row级元素 */
	var z = y.prev();
	y.replaceWith(new_unit_html);
	var row_line_ = '<div class="row-line"><canvas class="c"></canvas></div>';
	var add_part_ = '<div class="row-part"><div class="title-part">&nbsp;</div><div class="circle-part"></div><div class="new-part-content"><span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div></div></div>';
	var add_unit_ = '<div class="row-unit"><div class="title-unit">&nbsp;</div><div class="circle-unit"></div><div class="new-unit-content"><span class="am-icon-plus am-icon-md"></span><div class="new-unit-text">添加新单元</div></div></div>';
	z.next('.row-unit').after(row_line_ + add_part_ + row_line_ + add_unit_);
	drawVerticalLine();
	resetUnitNum();
	refreshTitleGather();
}