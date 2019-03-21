<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<title>修改教师信息</title>
<!-- 页面头上的图标 -->
<link rel="shortcut icon" href="../images/top_logo.png" />
<link href="../css/register/normalize.css" rel="stylesheet" />
<link href="../css/register/jquery-ui.css" rel="stylesheet" />
<link href="../css/resetInfo/baseInfo.css" rel="stylesheet" />
<link href="../css/register/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />
</head>
<body>
	<div class="row" >
		<div class="eightcol last">
		
			<!-- Begin Form -->
			<form id="my-form" action="modifyInfo.action" method="post" >

				<section id="第一步">
					<div>
						<label>教师编号:</label><input id="tno" name="tno" type="text"
							readonly="readonly" value='<s:property value="list.tno"/>' />
					</div>
					<div>
						<label>教师姓名:</label><input id="username" name="username" type="text"
							value="哈哈" data-ideal="username" />
					</div>
					<div>
						<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label><input
							id="phone" type="tel" name="phone" data-ideal="phone" />
					</div>
					<div>
						<label>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label><input
							id="email" name="email" data-ideal="email" type="email" />
					</div>
				</section>

				<section id="第二步">
					<div>
						<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <label><input
							type="radio" name="sex" checked />男</label> <label><input
							type="radio" name="sex" />女</label>
					</div>
					<div>
						<label>简介:</label>
						<textarea id="comments" name="intro" value=""></textarea>
					</div>
				</section>
				<div>
					<hr />
				</div>

				<div>
					<button type="submit">提交</button>
					<button id="reset" type="button">重置</button>
				</div>

			</form>
		</div>

	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/register/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/register/jquery.idealforms.js"></script>
<script type="text/javascript">
	$(function() {
		$comments = $('#comments')
		$comments.val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
		$comments.click(function() {
			$comments.val('');
		});
		$comments.blur(function() {
			if ($comments.val() == "") {
				$comments.val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
			}
		});
		$("#password").blur(function() {
			$("#repassword").focus();
		});
		var options = {
			onFail : function() {
				alert($myform.getInvalid().length + '个错误.');
			},

			inputs : {
				'tno' : {
					filters : '',
				},
				'username' : {
					filters : 'username',
				},
				'email' : {
					filters : 'email',
				},
				'phone' : {
					filters : 'phone',
				},
				'comments' : {
					filters : 'max',
					data : {
						min : 10,
						max : 200
					}
				},
			}
		};

		var $myform = $('#my-form').idealforms(options).data('idealforms');

		$('#reset').click(function() {
			/*不让tno被重置*/
			var x = $('#tno');
			var tno_val = x.val();
			$myform.reset().fresh().focusFirst();
			x.val(tno_val);
			/*不让comments被清空*/
			$('#comments').val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
		});
	});
</script>
</html>
