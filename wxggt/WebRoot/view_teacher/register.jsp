<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<title>教师注册</title>
<!-- 页面头上的图标 -->
<link rel="shortcut icon" href="../images/top_logo.png" />
<link href="../css/register/normalize.css" rel="stylesheet" />
<link href="../css/register/jquery-ui.css" rel="stylesheet" />
<link href="../css/register/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />
	<link href="../css/resetInfo/baseInfo.css" rel="stylesheet" />

</head>
<body>
	<div class="row">
		<div class="eightcol last">
			<!-- Begin Form -->
			<form id="my-form" action="teacherRegist.action" method="post">

				<section id="基础信息">
					<div>
						<label>教师姓名:</label><input id="username" name="username" type="text" />
					</div>
					<div>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label><input
							id="password" name="password" data-ideal="required pass" type="password" />
					</div>
					<div>
						<label>确认密码:</label><input id="repassword" name="repassword"
							data-ideal="required repass" type="password" />
					</div>
					<div>
						<label>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label><input
							id="email" name="email" data-ideal="required email" type="email" />
					</div>
				</section>

				<section id="详细信息">
					<div>
						<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label><input
							id="phone" type="tel" name="phone" data-ideal="required phone" />
					</div>

					<div>
						<label>教资证书:</label><input id="file" name="filename" multiple
							type="file" />
					</div>
					<div>
						<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <label><input
							type="radio" name="sex" checked />男</label> <label><input
							type="radio" name="sex" />女</label>
					</div>
				</section>

				<section id="个人简介">
					<div>
						<label>简介:</label>
						<textarea id="comments" name="intro"></textarea>
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
		$comments = $('#comments');
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
				'username' : {
					filters : 'required username',
				},
				'password' : {
					filters : 'required pass',
				},
				'repassword' : {
					filters : 'required repass',
				},
				'email' : {
					filters : 'required email',
				},
				'phone' : {
					filters : 'required phone',
				},
				'file' : {
					filters : 'required extension',
					data : {
						extension : [ 'jpg', 'png' ]
					}
				},
				'comments' : {
					filters : 'min max',
					data : {
						min : 10,
						max : 200
					}
				},
			}
		};

		var $myform = $('#my-form').idealforms(options).data('idealforms');

		$('#reset').click(function() {
			$myform.reset().fresh().focusFirst();
			/*不让comments被清空*/
			$('#comments').val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
		});
	});
</script>

</html>
