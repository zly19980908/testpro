var cNo = $("#cNo").val().trim();
var cSort = $("#cSort").val().trim();
$(function() {
	initCourceInfo();
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

/*----------------------------------------1.重置序号----------------------------------------*/
/* 重置所有单元数 */
function resetUnitNum() {
	var num_unit = $('.num-unit');
	num_unit.each(function(index) {
		$(this).text(index + 1);
	});
}

/* 重置所有课时数 */
function resetPartNum() {
	var num_part = $('.part_num_xixi');
	num_part.each(function(index) {
		$(this).text(index + 1);
	});
}
/*----------------------------------------------------------------------------------------*/

/*-----------------------------------------2.画连接线---------------------------------------*/
/* 画普通连接线 */
function drawVerticalLine() {
	var $myCanvas = $(".c");
	$myCanvas.drawLine({
		strokeStyle : "#808080",
		strokeWidth : 2,
		x1 : 55,
		y1 : 0,
		x2 : 55,
		y2 : 47,
	});
}

/* 画编辑课时时的连接线 */
function drawVerticalLine_addPart() {
	var $myCanvas = $(".d");
	$myCanvas.drawLine({
		strokeStyle : "#808080",
		strokeWidth : 2,
		x1 : 55,
		y1 : 0,
		x2 : 55,
		y2 : 148.5,
	});
}
/*----------------------------------------------------------------------------------------*/

/*--------------------------------------3.单元ajax代码--------------------------------------*/
/* 改变单元标题 */
function changeUnitTitle(unit_title, new_unit_title) {
	var unit_title_ = "单元--" + unit_title;
	var new_unit_title_ = "单元--" + new_unit_title;
	var url_ = "../../php/t_changeUnitName.php?cNo=" + cNo + "&unit_title=" + unit_title_ + "&new_unit_title=" + new_unit_title_;
	$.ajax({
		url : url_,
		type : "GET",
		success : succseFunction
	});
	function succseFunction(tt) {
		if (eval(tt) == 0) {
			alert("保存失败,请稍后再试");
			toOrdinaryUnit(unit_title);
		} else {
			MP.successAlert("修改成功!");
			toOrdinaryUnit(new_unit_title);
			refreshTitleGather();
		}
	}
}

/* 新增单元标题 */
function insertUnitTitle(y, title) {
	var unit_title = "单元--" + title;
	var url_ = "../../php/t_insertUnitName.php?cNo=" + cNo + "&unit_title=" + unit_title + "&part_sort=" + cSort;
	$.ajax({
		url : url_,
		type : "GET",
		success : succseFunction
	});
	function succseFunction(tt) {
		if (eval(tt) == 0) {
			alert("保存失败,请稍后再试");
		} else {
			MP.successAlert("添加成功!");
			toNewUnit(y, title);
		}
	}
}

function delete_unit(this_row_unit, next_row_unit, del_title_group) {
	$.ajax({
		url : '../../php/t_deleteUnit.php',
		data : {
			cNo : cNo,
			del_title_group : del_title_group
		},
		type : "GET",
		cache : false,
		success : succseFunction()
	});
	function succseFunction(t) {
		if (eval(t) == 0) {
			alert("删除失败,请稍后再试");
		} else {
			MP.successAlert("已删除");
			next_row_unit.replaceWith();
			this_row_unit.replaceWith();
			resetUnitNum();
			resetPartNum();
			refreshTitleGather();
		}

	}

}

/*----------------------------------------------------------------------------------------*/

/*--------------------------------------4.课时ajax代码--------------------------------------*/
/* 点击编辑时获取课时信息的ajax代码 */
function getPartInfo(part_title, y) {
	/* 动态生成专业信息 */
	var url_ = "../../php/t_getCoursePartInfo.php?cNo=" + cNo + "&part_title=" + part_title;
	$.ajax({
		url : url_,
		type : "GET",
		dataType : "json",
		cache : false,
		error : errorFunction, // 错误执行方法
		success : succseFunction
	// 成功执行方法
	});
	function errorFunction() {
		alert("error");
	}
	function succseFunction(t1) {
		var partInfo = eval(t1); // 数组
		$.each(partInfo, function(index, item) {
			// 循环获取数据
			var real_path = partInfo[index].partName;
			var partName = real_path.match(/.*\/(.*)/)[1];
			var partDesc = partInfo[index].partDesc;
			var uploadDate = partInfo[index].uploadDate.substr(0, 10);
			y.find(".edit-part-title").val(part_title);
			y.find(".edit-part-desc").val(partDesc);
			y.find(".upload_real_path").val(real_path);
			y.find(".part_title_").html(partName);
			y.find(".part_upload_time").html(uploadDate);
		});
	}
}

/* 修改课时信息的ajax代码 */
function updatePartInfo(old_title, title, desc, real_path, x) {
	console.log("调用修改");
	var url_ = "../../php/t_changeCoursePartInfo.php?cNo=" + cNo + "&part_title=" + old_title + "&new_part_title=" + title + "&part_path=" + real_path + "&source_desc=" + desc;
	console.log(url_);
	$.ajax({
		url : url_,
		type : "GET",
		cache : false,
		success : succseFunction_2()
	});
	function succseFunction_2(t2) {
		if (eval(t2) == 0) {
			alert("修改失败,请稍后再试");
		} else {
			MP.successAlert("保存成功！");
			toOrdinaryPart(x, title);
			refreshTitleGather();
		}
	}
}

/* 新增课时信息的ajax代码 */
function insertPartInfo(title, desc, real_path, x) {
	console.log("调用新增");
	var url_ = "../../php/t_addCoursePartInfo.php?cNo=" + cNo + "&part_title=" + title + "&part_sort=中基&part_time=30&part_path=" + real_path + "&is_major=1&source_desc=" + desc;
	console.log(url_);
	$.ajax({
		url : url_,
		cache : false,
		type : "GET",
		success : succseFunction_3()
	});
	function succseFunction_3(t3) {
		if (eval(t3) == 0) {
			alert("保存失败,请稍后再试");
		} else {
			MP.successAlert("添加成功！");
			/* 生成一个新的课时行和一个添加课时行 */
			newPart(x, title);
			refreshTitleGather();
		}
	}
}

function deletePart(row_part, part_title) {
	var url_ = "../../php/t_deletePart.php?cNo=" + cNo + "&part_title=" + part_title;
	$.ajax({
		url : url_,
		type : "GET",
		cache : false,
		success : succseFunction()
	});
	function succseFunction(t) {
		if (eval(t) == 0) {
			alert("deletePart操作失败,请稍后再试");
		} else {
			row_part.prev().replaceWith();
			row_part.replaceWith();
			resetPartNum();
			refreshTitleGather();
		}
	}
}
/*-----------------------------------5.标题集合课时ajax代码-----------------------------------*/

function updateTitleGather(titleGather) {
	var url_ = "../../php/t_changeTitleGather.php?cNo=" + cNo + "&titleGather=" + titleGather;
	$.ajax({
		url : url_,
		type : "GET",
		cache : false,
		success : succseFunction()
	});
	function succseFunction(t) {
		if (eval(t) == 0) {
			alert("updateTitleGather操作失败,请稍后再试");
		}
	}
}

function initCourceInfo() {
	$.ajax({
		url : "../../php/t_getCourseSequence.php",
		type : "GET",
		data : {
			cNo : cNo
		},
		cache : false,
		success : getCourseSequence
	});
	function getCourseSequence(t) {
		if (eval(t) == "") {
		} else {
			var titleGather = eval(t);
			init_row(titleGather);
		}
	}
}

/*-----------------------------------5.刷新标题集合-----------------------------------*/

function refreshTitleGather() {
	var titleGather = "";
	var titleContent = $(".content-unit,.content-part");
	var length_ = titleContent.length;
	titleContent.each(function(index) {
		var title;
		if ($(this).attr("class") == "content-unit") {
			title = "单元--" + $(this).text();
		} else {
			title = $(this).text();
		}
		if (index == length_ - 1) {
			titleGather += title;
		} else {
			titleGather += title + ",";
		}
	});
	/* ajax代码 */
	updateTitleGather(titleGather);
}

/*-----------------------------------6.初始化课程信息-----------------------------------*/
function init_row(titleGather) {
	var title_group = [];
	var title;

	var row_add_part = '<div class="row-part"><div class="title-part">&nbsp;</div><div class="circle-part"></div><div class="new-part-content"><span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div></div></div>';
	var row_line = '<div class="row-line"> <canvas class="c"></canvas> </div>';
	title_group = titleGather.split(',');
	var row_add_unit = $('.row-unit');
	$.each(title_group, function(index, item) {
		if (item.substr(0, 4) == "单元--") {
			if (index != 0) {
				row_add_unit.before(row_line + row_add_part + row_line);
			}
			title = item.match(/单元--(.*)/)[1];
			var row_unit = '<div class="row-unit"><div class="title-unit">单元</div><div class="circle-unit"><span class="num-unit">1</span></div>	<div class="content-unit" style="">' + title + '</div></div>';
			row_add_unit.before(row_unit);
		} else {
			title = item;
			var row_part = '<div class="row-part"><div class="title-part">课时<i class="part_num_xixi">1</i></div><div class="circle-part"></div><div class="content-part" style="">' + title + '</div></div>';
			row_add_unit.before(row_line + row_part);
		}
	});
	row_add_unit.before(row_line + row_add_part + row_line);
	drawVerticalLine();
	resetUnitNum();
	resetPartNum();
	// refreshTitleGather();
}

/*----------------------------------------被调用的函数到这里结束----------------------------------------*/

