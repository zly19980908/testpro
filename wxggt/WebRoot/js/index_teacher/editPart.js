/*----------------------------------------功能区----------------------------------------*/

/* 课时-----用户点击'删除' */
$(document).on("click", "a:contains('删除')[href='#']", function() {
	var part_title = $(this).parents(".content-part").prop("firstChild").nodeValue;
	var row_part = $(this).parents('.row-part');
	if (confirm("确定要删除课时 '" + part_title + "' 吗？")) {
		deletePart(row_part, part_title);
	}
});

/* 课时-----用户点击'编辑' */
$(document).on(
		"click",
		"a:contains('编辑')[href='#']",
		function() {
			var edittingPart = $(".row-line_editPart");
			if (edittingPart.length > 0) {
				alert("请先编辑完当前课时");
			} else {
				var part_title = $(this).parent().parent().prop("firstChild").nodeValue;
				$.trim(part_title);
				/* x代表前一个,用于保存选择 */
				var x = $(this).parents(".row-part").prev();
				var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>&nbsp;&nbsp;&nbsp;课时标题:&nbsp;</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>&nbsp;&nbsp;&nbsp;课时描述:&nbsp;</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>&nbsp;&nbsp;&nbsp;视频上传:&nbsp;</label>" + 
				"<div id='container'><a id='selectfiles' href='javascript:void(0);' class='btn'>选择文件</a></div>" + "<div class='video_box'>视频名:<span class='part_title_'></span>&nbsp;&nbsp;上传时间:<span class='part_upload_time'></span></div>" + 
				"<div id='ossfile' class='ossfile-box'></div>" + "<input type='text' class='upload_real_path' value='../apple.mp4' style='display:none;' /> </div>" + "<div class='button_box'>"
						+ "<input type='button' class='edit-part-button' value='保存' />" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div> </div>";
				/* 生成编辑面板 */
				createPart_Panel($(this), edit_panel);
				/* y代表编辑面板 */
				y = x.nextAll(".row-line_editPart:eq(0)");
				/* 这里写ajax代码--查询本课时的简介,资源路径 */
				getPartInfo(part_title, y);
				/* 用户点击---取消 */
				y.find('.button_box [value="取消"]').click(function() {
					toOrdinaryPart($(this), part_title);
				});
				/* --------------------这里写视频上传代码-------------------- */
				var uploader = getUploader(y);
				/* 文件上传 */
				uploader.init();
				/* 用户点击---保存 */
				y.find('.button_box [value="保存"]').click(function() {
					dealSave(y, 0, part_title, $(this));
				});
			}
		});

/* 课时-----用户点击'添加' */
$(document).on("click", ".am-icon-plus.am-icon-sm,.new-part-text", function() {
	var edittingPart = $(".row-line_editPart");
	if (edittingPart.length > 0) {
		alert("请先编辑完当前课时");
	} else {
		var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>课时标题:</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>课时描述:</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>视频上传:</label>" + 
		"<div id='container'><a id='selectfiles' href='javascript:void(0);' class='btn'>选择文件</a></div>" + "<div class='video_box'></div>" + 
		"<div id='ossfile' class='ossfile-box'></div>" + "<input type='text' class='upload_real_path' value='../apple.mp4' style='display:none;' /> </div>"+
		"<div class='button_box'>" + "<input type='button' class='edit-part-button' value='保存' />" + "&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div>" + "</div>";
		/* x代表圆圈circle-part */
		var x = $(this).parents('.new-part-content').prev();
		createPart_Panel($(this), edit_panel);
		/* y代表课时编辑面板edit_part */
		var y = x.parent().next().find(".edit_part");
		$(this).parent().empty();
		$(".edit-part-title").focus();
		var uploader = getUploader(y);
		/* 文件上传 */
		uploader.init();
		
		/* 用户点击---取消 */
		y.find('.button_box [value="取消"]').click(function() {
			toAddPart($(this));
		});
		/* 用户点击---保存 */
		y.find('.button_box [value="保存"]').click(function() {
			dealSave(y, 1, "", $(this));
		});
	}
});
/*----------------------------------------下面是被调用的函数----------------------------------------*/
/* 处理保存逻辑 x代表保存按钮,y代表课时编辑面板 */
function dealSave(y, num_, part_title, x) {
	var title = y.find('.edit-part-title').val().trim();
	var desc = y.find('.edit-part-desc').val().trim();
	var real_path = y.find('.upload_real_path').val().trim();
	if (title == "") {
		alert("请填写课时标题");
		return;
	}
	if (desc == "") {
		desc = "暂时还没有简介";
	}
	/* num_的取值:0代表修改,1代表新增 */
	if (num_ == 0) {
		updatePartInfo(part_title, title, desc, real_path, x);
	} else {
		insertPartInfo(title, desc, real_path, x);
	}
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
	var part = x.parents('.row-line_editPart');
	var row_part = "<div class='row-part'><div class='title-part'>课时<i class='part_num_xixi'></i></div><div class='circle-part'></div><div class='content-part'>" + title + "</div></div>";
	var row_line = '<div class="row-line"> <canvas class="c"></canvas> </div>';
	var add_part = '<div class="row-part"><div class="title-part">&nbsp;</div><div class="circle-part"></div><div class="new-part-content"><span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div></div></div>';
	$(".content-part").css({
		"background" : ""
	});
	/* y代表添加课时面板 */
	y = part.prev();
	part.replaceWith(row_line);
	z = y.prev();
	y.replaceWith(add_part);
	z.replaceWith(row_line + row_part + row_line);
	drawVerticalLine();
	resetPartNum();
}
