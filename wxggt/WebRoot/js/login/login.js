/*角色切换效果*/
$(document).ready(function() {
	var $tab_li = $('#tab ul li');
	$tab_li.hover(function() {
		$(this).addClass('selected').siblings().removeClass('selected');
		var index = $tab_li.index(this);
		$('div.tab_box > div').eq(index).show().siblings().hide();
	});
});

/*背景效果*/
$(function() {
	$(".screenbg ul li").each(function() {
		$(this).css("opacity", "0");
	});
	$(".screenbg ul li:first").css("opacity", "1");
	var index = 0;
	var t;
	var li = $(".screenbg ul li");
	var number = li.size();
	function change(index) {
		li.css("visibility", "visible");
		li.eq(index).siblings().animate({
			opacity : 0
		}, 3000);
		li.eq(index).animate({
			opacity : 1
		}, 3000);
	}
	function show() {
		index = index + 1;
		if (index <= number - 1) {
			change(index);
		} else {
			index = 0;
			change(index);
		}
	}
	t = setInterval(show, 8000);
	//根据窗口宽度生成图片宽度
	var width = $(window).width();
	$(".screenbg ul img").css("width", width + "px");
});

/*输入校验*/
$(function() {
	/*账号id输入校验*/
	valid_id = function(id_) {
		var id = $(id_);
		/*当获得焦点时*/
		id.focus(function() {
			$(this).removeClass('right error').addClass('input_init')
			$(this).css("color", "black");
			$(this).css("background-color", "#FFFFCC");
			$(this).val('');
		});
		/*失去焦点*/
		id.blur(function() {
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			/*如果输入为空*/
			if ($(this).val() == '') {
				$(this).css("color", "red");
				$(this).toggleClass('right')
				$(this).val('请输入正确的账号!');
			}
			/*如果输入有误*/
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[0-9]{8,16}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
		/*输入时动态判断*/
		id.keyup(function() {
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[0-9]{8,16}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
	}

	/*密码pwd输入校验*/
	valid_pwd = function(pwd_) {
		var pwd = $(pwd_);
		/*获得焦点*/
		pwd.focus(function() {
			$(this).removeClass('right error').addClass('input_init')
			$(this).css("color", "black");
			$(this).css("background-color", "#FFFFCC");
			$(this).val('');
		});
		/*失去焦点*/
		pwd.blur(function() {
			$(this).removeClass('input_init');
			$(this).css("background-color", "#FFFFFF");
			/*如果输入为空*/
			if ($(this).val() == '') {
				$(this).addClass('error')
			}
			/*如果输入有误*/
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[a-zA-Z0-9\._]{3,16}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
		/*输入时动态判断*/
		pwd.keyup(function() {
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[a-zA-Z0-9\._]{3,16}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
	}

	/*验证码code输入校验*/
	valid_code = function(code_) {
		var code = $(code_);
		/*获得焦点*/
		code.focus(function() {
			$(this).removeClass('right error').addClass('input_init')
			$(this).css("color", "black");
			$(this).css("background-color", "#FFFFCC");
			$(this).val('');
		});
		/*失去焦点*/
		code.blur(function() {
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			/*如果输入为空*/
			if ($(this).val() == '') {
				$(this).css("color", "red");
				$(this).toggleClass('right')
				$(this).val('请输入验证码');
			}
			/*如果输入有误*/
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[a-zA-Z0-9]{4}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
		/*输入时动态判断*/
		code.keyup(function() {
			str = $(this).val();
			$(this).removeClass('input_init').addClass('right error');
			$(this).css("background-color", "#FFFFFF");
			var ret = /^[a-zA-Z0-9]{4}$/;
			if (!ret.test(str)) {
				$(this).css("color", "red");
				$(this).toggleClass('right')
			} else {
				$(this).css("color", "green");
				$(this).toggleClass('error')
			}
		});
	}

	valid_id('#t_id');
	valid_id('#a_id');
	valid_pwd('#t_pwd');
	valid_pwd('#a_pwd');
	valid_code('#code_input_1');
	valid_code('#code_input_2');
});