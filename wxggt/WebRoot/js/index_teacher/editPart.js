$(function() {
	var cNo = $("#cNo").val();
	/* 课时点击编辑-动态元素的绑定 */
	$(document).on("click", "a:contains('编辑')[href='#']", function() {
		var part_num = $(this).parent().parent().prev().prev().children().text();
		var part_title = $(this).parent().parent().prop("firstChild").nodeValue;
		console.log("触发了编辑课时事件," + cNo);
		var next_row_line = $(this).parents(".row-part").next();
		$(this).parents(".content-part").empty();
		next_row_line.attr("class", "row-line_editPart");
		next_row_line.children().attr("class", 'd');
		drawVerticalLine_addPart();
		var upload_buttojs_code = '"' + "document.getElementById('upload_file_x').click();" + '"';
		var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>课时标题:</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>课时描述:</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>视频上传:</label>" + "<input type='button' class='upload_video' value='点击上传' onclick=" + upload_buttojs_code + "/>" + "<input type='file' id='upload_file_x' style='display:none;' />" + "</div>" + "<div class='button_box'>" + "<input type='button' class='edit-part-button' value='保存' />" + "&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div>" + "</div>";
		next_row_line.append(edit_panel);
		$('.edit_part').focus();
		/* 点击取消 */
		$('.button_box [value="取消"]').click(function() {
			toAddPart($(this));
		});
	});
	
	/* 课时点击删除-动态元素的绑定 */
	$(document).on("click", "a:contains('删除')[href='#']", function() {
		var part_num = parseInt($(this).parent().parent().prev().prev().children().text());
		alert("课时" + part_num);
	});
	
	/* 点击取消变回添加课时样式 */
	function toAddPart(this_) {
		var add_html='<span class="am-icon-plus am-icon-sm"></span><div class="new-part-text">添加新课时</div>';
		var line_panel='<div class="row-line"> <canvas class="c"></canvas> </div>';
		var row_line_editPart=this_.parents(".row-line_editPart");
		row_line_editPart.prev().children(".new-part-content").html(add_html);
		row_line_editPart.replaceWith(line_panel);
		drawVerticalLine();
	}
	/* 课时点击添加事件 */
	$(document).on("click",".am-icon-plus.am-icon-sm,.new-part-text",function(){
		console.log("触发了增加课时事件," + cNo);
		var next_row_line = $(this).parent().parent().next();
		$(this).parent().empty();
		next_row_line.attr("class", "row-line_editPart");
		next_row_line.children().attr("class", 'd');
		drawVerticalLine_addPart();
		var upload_buttojs_code = '"' + "document.getElementById('upload_file_x').click();" + '"';
		var edit_panel = "<div class='edit_part' tabindex='1'>" + "<label>课时标题:</label>" + "<input type='text' maxlength='25'  class='edit-part-title'/>" + "<label>课时描述:</label>" + "<textarea maxlength='99' class='edit-part-desc'></textarea>" + "<div class='upload_box'>" + "<label>视频上传:</label>" + "<input type='button' class='upload_video' value='点击上传' onclick=" + upload_buttojs_code + "/>" + "<input type='file' id='upload_file_x' style='display:none;' />" + "</div>" + "<div class='button_box'>" + "<input type='button' class='edit-part-button' value='保存' />" + "&nbsp;&nbsp;" + "<input type='button' class='edit-part-button' value='取消' />" + "</div>" + "</div>";
		next_row_line.append(edit_panel);
		$('.edit_part').focus();
		/* 点击取消 */
		$('.button_box [value="取消"]').click(function() {
			toAddPart($(this));
		});
	});

	/* 单元点击添加事件 */
	$(".am-icon-plus.am-icon-md,.new-unit-text").click(function() {
		console.log("触发了增加单元事件," + cNo);
	});

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
});