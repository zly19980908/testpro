/*----------------------------------------功能区----------------------------------------*/
$(function() {
	/* 课时-----用户点击'删除' */
	$(document).on("click", "a:contains('删除')[href='#']", function() {
		var part_num = parseInt($(this).parent().parent().prev().prev().children().text());
		alert("课时" + part_num);
	});

	/* 课时-----用户点击'编辑' */
	$(document).on(
			"click",
			"a:contains('编辑')[href='#']",
			function() {
				var part_title = $(this).parent().parent().prop("firstChild").nodeValue;
				/* x代表前一个,用于保存选择 */
				var x = $(this).parents(".row-part").prev();
				var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>课时标题:</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>课时描述:</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>视频上传:</label>" + "<input type='button' class='upload_video' value='点击上传'/>" + "<div class='video_box'>视频名:<span class='part_title_'></span>&nbsp;&nbsp;&nbsp;&nbsp;上传时间:<span class='part_upload_time'></span></div>" + "<input type='file' class='upload_file_x' accept='video/*' style='display:none;' />" + "<input type='text' class='upload_real_path' value='../apple.mp4' style='display:none;' /> </div>" + "<div class='button_box'>" + "<input type='button' class='edit-part-button' value='保存' />"
						+ "&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div> </div>";
				/* 生成编辑面板 */
				createPart_Panel($(this), edit_panel);
				/* y代表编辑面板 */
				y = x.nextAll(".row-line_editPart:eq(0)");
				/* 这里写ajax代码--查询本课时的简介,资源路径 */
				getPartInfo(cNo, part_title, y);
				/* 用户点击---取消 */
				y.find('.button_box [value="取消"]').click(function() {
					toOrdinaryPart($(this), part_title);
				});
				/* 用户点击---上传 */
				y.find('.upload_video').click(function() {
					$(this).nextAll(".upload_file_x:eq(0)").click();
				});
				/* 用户选择了视频 */
				y.find(".upload_file_x:eq(0)").change(function() {
					var x = $(this).val().match(/.*\\(.*)/)[1];
					var sourceName = x == "" ? "apple.mp4" : x;
					var date = formatDate();
					/* --------------------这里写视频上传代码-------------------- */
					/* 生成视频信息面板 */
					createVideoInfo($(this), sourceName, date, 2);
				});
				/* 用户点击---保存 */
				y.find('.button_box [value="保存"]').click(function() {
					dealSave(y, 0, part_title, $(this));
				});
			});

	/* 课时-----用户点击'添加' */
	$(document).on("click", ".am-icon-plus.am-icon-sm,.new-part-text", function() {
		/* i代表点击'点击上传'按钮的次数 */
		var i = 0;
		var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>课时标题:</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>课时描述:</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>视频上传:</label>" + "<input type='button' class='upload_video' value='点击上传'/>" + "<input type='file' class='upload_file_x' accept='video/*' style='display:none;' />" + "<input type='text' class='upload_real_path' value='../apple.mp4' style='display:none;' />" + "</div>" + "<div class='button_box'>" + "<input type='button' class='edit-part-button' value='保存' />" + "&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div>" + "</div>";
		/* x代表圆圈circle-part */
		var x = $(this).parents('.new-part-content').prev();
		createPart_Panel($(this), edit_panel);
		/* y代表课时编辑面板edit_part */
		var y = x.parent().next().find(".edit_part");
		$(this).parent().empty();
		$(".edit-part-title").focus();
		/* 用户点击---取消 */
		y.find('.button_box [value="取消"]').click(function() {
			toAddPart($(this));
		});
		/* 用户点击---保存 */
		y.find('.button_box [value="保存"]').click(function() {
			dealSave(y, 1, "", $(this));
		});
		/* 用户点击---上传 */
		y.find('.upload_video').click(function() {
			$(this).parent().find(".upload_file_x:eq(0)").click();
			i++;
		});

		/* 用户选择了视频 */
		y.find(".upload_file_x:eq(0)").change(function() {
			var x = $(this).val().match(/.*\\(.*)/)[1];
			var sourceName = x == "" ? "../apple.mp4" : "../" + x;
			var date = formatDate();
			/* --------------------这里写视频上传代码-------------------- */
			/* 生成视频信息面板 */
			createVideoInfo($(this), sourceName, date, i);
		});
	});
});
/*----------------------------------------下面是被调用的函数----------------------------------------*/
/* 处理保存逻辑 x代表保存按钮,y代表课时编辑面板 */
function dealSave(y, num_, part_title, x) {
	var title = y.find('.edit-part-title').val();
	var desc = y.find('.edit-part-desc').val();
	var real_path = y.find('.upload_real_path').val();
	if (title == "") {
		alert("请填写课时标题");
		return;
	}
	if (desc == "") {
		desc = "暂时还没有简介";
	}
	/* num_的取值:0代表修改,1代表新增 */
	if (num_ == 0) {
		updatePartInfo(cNo, part_title, title, desc, real_path, x);
	} else {
		insertPartInfo(cNo, title, desc, real_path, x);
	}
}
/* 点击编辑时获取课时信息的ajax代码 */
function getPartInfo(cNo, part_title, y) {
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
function updatePartInfo(cNo, old_title, title, desc, real_path, x) {
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
			alert("修改成功");
			toOrdinaryPart(x, title);
		}
	}
}

/* 新增课时信息的ajax代码 */
function insertPartInfo(cNo, title, desc, real_path, x) {
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
			alert("保存成功");
			/* 生成一个新的课时行和一个添加课时行 */
			newPart(x, title);
		}
	}
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

/* 增加课时----点击取消变回添加课时样式 */
function toAddPart(this_) {
	var add_html = '<span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div>';
	var line_panel = '<div class="row-line"> <canvas class="c"></canvas> </div>';
	var row_line_editPart = this_.parents(".row-line_editPart");
	row_line_editPart.prev().children(".new-part-content").html(add_html);
	row_line_editPart.replaceWith(line_panel);
	drawVerticalLine();
}

/* 修改课时----点击取消变回普通课时样式 */
function toOrdinaryPart(this_, part_title) {
	var line_panel = '<div class="row-line"> <canvas class="c"></canvas> </div>';
	var row_line_editPart = this_.parents(".row-line_editPart");
	row_line_editPart.prev().children(".content-part_null").attr("class", "content-part").text(part_title);
	$(".content-part").css({
		"background" : ""
	});
	row_line_editPart.replaceWith(line_panel);
	drawVerticalLine();
}

/* 点击添加或编辑课时---生成part_panel */
function createPart_Panel(this_, edit_panel) {
	var next_row_line = this_.parents(".row-part").next();
	this_.parents(".content-part").empty().attr("class", "content-part_null");
	next_row_line.attr("class", "row-line_editPart");
	next_row_line.children().attr("class", 'd');
	drawVerticalLine_addPart();
	next_row_line.append(edit_panel);
}

/* 生成视频信息面板,x代表file */
function createVideoInfo(x, sourceName, time_, i) {
	if (i <= 1) {
		var video_box_html = "<div class='video_box'>视频名:<span class='part_title_'></span>&nbsp;&nbsp;&nbsp;&nbsp;上传时间:<span class='part_upload_time'></span></div>";
		x.prev().after(video_box_html);
	}
	x.prev().find(".part_title_").text(sourceName);
	x.prev().find(".part_upload_time").text(time_);
}
/* 格式化日期 */
function formatDate() {
	var datetime = new Date();
	var year = datetime.getFullYear();
	var month = datetime.getMonth() + 1 < 10 ? "0" + (datetime.getMonth() + 1) : datetime.getMonth() + 1;
	var date = datetime.getDate() < 10 ? "0" + datetime.getDate() : datetime.getDate();
	return year + "-" + month + "-" + date;
}
/* 生成一个新的课时行和一个添加课时行 */
function newPart(x, title) {
	/* x代表保存按钮 */
	x.css({
		"background" : "red"
	});
	var part = x.parents('.row-line_editPart');
	part.css({
		"background" : "red"
	});
	var row_part = "<div class='row-part'><div class='title-part'>课时<i class='part_num_xixi'></i></div><div class='circle-part'></div><div class='content-part'>"+title+"</div></div>";
	var row_line = '<div class="row-line"> <canvas class="c"></canvas> </div>';
	var add_part = '<div class="row-part"><div class="title-part">&nbsp;</div><div class="circle-part"></div><div class="new-part-content"><span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div></div></div>';
	$(".content-part").css({
		"background" : ""
	});
	/*y代表添加课时面板*/
	y=part.prev();
	part.replaceWith(row_line);
	z=y.prev();
	y.replaceWith(add_part);
	z.replaceWith(row_line+row_part+row_line);
	drawVerticalLine();
	resetPartNum();
}

/*重置所有课时数*/
function resetPartNum(){
	var num_part=$('.part_num_xixi');
	num_part.each(function(index){
		$(this).text(index+1);
	});
}
