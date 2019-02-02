<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<link href="css/login/login.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body onload="_init()">
	<div id="tab">
		<ul class="tab_menu">
			<li class="selected">教师登录</li>
			<li>管理员登录</li>
		</ul>
		<div class="tab_box">
			<!-- 教师登录开始 -->
			<div>
				<form action="" method="post" class="stu_login_error" onsubmit="return verify_1(this);">
					<div id="username">
						<label>账&nbsp;&nbsp;&nbsp;号：</label> <input type="text"
							id="t_id" name="" value="输入教师账号" class="input_init" />
					</div>
					<div id="password">
						<label>密&nbsp;&nbsp;&nbsp;码：</label>
						<input type="password" id="t_pwd" class="input_init" name=""/>
					</div>
					<div id="code">
						<label>验证码：</label> 
						<input type="text" id="code_input_1" class="input_init" name="code" value="输入验证码" autocomplete="off" />
					    <div class="code_BG"></div>
						<canvas id="verifyCanvas_1"></canvas>
					</div>
					<div id="login">
						<button type="submit">登录</button>
					</div>
				</form>
			</div>
			<!-- 教师登录结束-->
			<!-- 管理员登录开始-->
			<div class="hide">
				<form action="" method="post" class="tea_login_error" onsubmit="return verify_2(this);">
					<div id="username">
						<label>账&nbsp;&nbsp;&nbsp;号：</label>
						<input type="text" id="a_id" class="input_init" name="" value="输入管理员账号" />
					</div>
					<div id="password">
						<label>密&nbsp;&nbsp;&nbsp;码：</label>
						<input type="password" class="input_init" id="a_pwd" name=""/>
					</div>
					<div id="code">
						<label>验证码：</label> 
						<input type="text" class="input_init" id="code_input_2" name="code" value="输入验证码" autocomplete="off" />
					    <div class="code_BG"></div>
						<canvas id="verifyCanvas_2"></canvas>
					</div>
					<div id="login">
						<button type="submit">登录</button>
					</div>
				</form>
			</div>
			
			<!-- 管理员登录结束-->
		</div>
	</div>
	<div class="screenbg">
		<ul>
			<li><a href="javascript:;"><img src="images/login/2.jpg"></a></li>
		</ul>
	</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="js/login/login.js">	</script>
<script type="text/javascript" src="js/login/verification_code.js">	</script>
</html>
 
