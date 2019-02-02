<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<title>教师注册</title>

<link href="../css/register/normalize.css" rel="stylesheet" />
<link href="../css/register/jquery-ui.css" rel="stylesheet" />
<link href="../css/register/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />

<style type="text/css">
body {
	font: normal 15px/1.5 Arial, Helvetica, Free Sans, sans-serif;
	color: #222;
	background: url(pattern.png);
	overflow-y: scroll;
	padding: 60px 0 0 0;
}

#my-form {
	width: 755px;
	margin: 0 auto;
	border: 1px solid #ccc;
	padding: 3em;
	border-radius: 3px;
	box-shadow: 0 0 2px rgba(0, 0, 0, .2);
}

#comments {
	width: 350px;
	height: 100px;
}
</style>

</head>
<body>
	<div class="row">
		<div class="eightcol last">
			<!-- Begin Form -->
			<form id="my-form">

				<section id="基础信息">
					<div>
						<label>教师编号:</label> <input id="tno" name="" type="text"
							value='1327126546' readonly="readonly" />
					</div>
					<div>
						<label>教师姓名:</label><input id="username" name="username"
							type="text" />
					</div>
					<div>
						<label>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label><input
							id="pass" name="password" type="password" />
					</div>
					<div>
						<label>确认密码:</label><input id="email" name="email"
							data-ideal="required email" type="email" />
					</div>

				</section>

				<section id="详细信息">
					<div>
						<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label><input
							type="tel" name="phone" data-ideal="phone" />
					</div>

					<div>
						<label>教资证书:</label><input id="file" name="file" multiple
							type="file" />
					</div>
					<div>
						<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <label><input
							type="radio" name="radio" checked />男</label> <label><input
							type="radio" name="radio" />女</label>
					</div>
				</section>

				<section id="个人简介">
					<div>
						<label>简介:</label>
						<textarea id="comments" name="comments"></textarea>
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
	/* alert('111');
	$('section:eq(1)').click(); */
		var options = {
			onFail : function() {
				alert($myform.getInvalid().length + '个错误.');
				$('section:eq(0)').click();
			},

			inputs : {
				'password' : {
					filters : 'required pass',
				},
				'username' : {
					filters : 'required username',
					data : {
						//ajax: { url:'validate.php' }
					}
				},
				'file' : {
					filters : 'extension',
					data : {
						extension : [ 'jpg','png' ]
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
			/*不让tno被重置*/
			var x=$('#tno');
			var tno_val = x.val();
			$myform.reset().fresh().focusFirst();
			x.val(tno_val);
		});
	});
</script>

</html>
