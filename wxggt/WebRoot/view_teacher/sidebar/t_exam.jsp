<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台模板</title>
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/index.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/typography.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/form.css" />
<style type="text/css">
.info-num {
	position: absolute;
	top: 28px;
	right: -10px;
	width: 16px;
	height: 16px;
	line-height: 16px;
	text-align: center;
	background: url('../../images/index_teacher/msg.png');
	color: #fff;
	font-style: normal;
	font-size: 1px;
}

.info-num_ {
	display: none;
	list-style-type: none;
}
</style>
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="index.html" class="logo">
				<span class="logo-span"><img src="../../images/main_page/logo.png" class="img-logo"></img></span>
				<i class="zmdi zmdi-layers"></i>
			</a>
		</div>

		<div class="contain">
			<ul class="am-nav am-navbar-nav am-navbar-left">

				<li>
					<h4 class="page-title">首页</h4>
				</li>
			</ul>

			<ul class="am-nav am-navbar-nav am-navbar-right">
				<li class="inform">
					<i class="am-icon-bell-o"></i> <i id="letterNum" class="info-num">2</i>
				</li>
				<li class="hidden-xs am-hide-sm-only">
					<form class="app-search">
						<input type="text" placeholder="Search..." class="form-control">
						<a href="javascript:;">
							<img src="../../images/index_teacher/search.png" ondragstart="return false;">
						</a>
					</form>
				</li>
			</ul>
		</div>
	</header>
	<!-- end page -->


	<div class="admin">
		<!-- ========== 侧边栏开始 ========== -->
		<div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<!-- start User -->
				<div class="user-box am-hide-sm-only">
					<div class="user-img">
						<a href="../photoCut.html">
							<img src="../../upload/headFace/201601090127/headFace.png" ondragstart="return false;" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive" style="width:89px;height:89px;">
						</a>
						<div class="user-status offline">
							<i class="am-icon-dot-circle-o"></i>
						</div>
					</div>
					<h5>
						<a href="#">张 三</a>
					</h5>
				</div>
				<!-- End 用户 -->

				<!-- 导航栏开始 -->
				<ul class="am-list admin-sidebar-list">
					<!-- 首页 -->
					<li>
						<a href="../index.html">
							<span class="am-icon-home"></span>
							首页
						</a>
					</li>
					<!-- 副标题---教学管理-->
					<li class="admin-parent">
						<a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}">
							<span class="am-icon-book"></span>
							教学管理
							<span class="am-icon-angle-right am-fr am-margin-right"></span>
						</a>
						<ul class="am-list admin-sidebar-sub am-collapse am-in" id="collapse-nav1" style="">
							<li>
								<a href="t_course.jsp">课程管理</a>
							</li>
							<li>
								<a href="t_resource.jsp">资料管理</a>
							</li>
							<li>
								<a href="t_practice.jsp">练习管理</a>
							</li>
							<li>
								<a href="t_exam.jsp"  class="am-cf">考试管理</a>
							</li>
							<li>
								<a href="t_audio.jsp">音频管理</a>
							</li>
						</ul>
					</li>
					<!-- 副标题---资金管理-->
					<li class="admin-parent">
						<a class="am-cf am-collapsed" data-am-collapse="{target: '#collapse-nav2'}">
							<span class="am-icon-briefcase"></span>
							资金管理
							<span class="am-icon-angle-right am-fr am-margin-right"></span>
						</a>
						<ul class="am-list admin-sidebar-sub am-collapse" id="collapse-nav2" style="height: 0px;">
							<li>
								<a href="m_income.jsp" class="am-cf">收益管理</a>
							</li>
						</ul>
					</li>
					<!-- 副标题---个人中心 -->
					<li class="admin-parent">
						<a class="am-cf am-collapsed" data-am-collapse="{target: '#collapse-nav5'}">
							<span class="am-icon-user"></span>
							个人中心
							<span class="am-icon-angle-right am-fr am-margin-right"></span>
						</a>
						<ul class="am-list admin-sidebar-sub am-collapse" id="collapse-nav5" style="height: 0px;">
							<li>
								<a href="../resetInfo.jsp" class="am-cf">信息管理</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="javascript:;">&nbsp;</a>
					</li>
				</ul>
				<!-- 导航栏结束 -->
			</div>
		</div>
		<!-- ========== 侧边栏结束 ========== -->




		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-sm-12">
						<div class="card-box">
							<ul class="am-nav am-fr">
								<li class="am-dropdown" data-am-dropdown>
									<a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
										<span class="am-icon-caret-down"></span>
									</a>
									<ul class="am-dropdown-content">
										<li>1231234</li>
										<li>1231234</li>
										<li>1231234</li>
										<li>1231234</li>
									</ul>
								</li>
							</ul>

							<h4 class="header-title m-t-0 m-b-30">输入框类型</h4>

							<div class="am-g">
								<div class="am-u-md-6">
									<form class="am-form am-text-sm">
										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ipt-text-1">标题</label>
												<input class="am-u-md-10 form-control" id="doc-ipt-text-1" placeholder="输入标题信息">
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ipt-email-1">电子邮箱</label>
												<input class="am-u-md-10 form-control" id="doc-ipt-email-1" placeholder="输入电子邮件">
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ipt-pwd-1">密码</label>
												<input type="password" class="am-u-md-10" id="doc-ipt-pwd-1" placeholder="设置个密码吧">
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ipt-phd-1">提示</label>
												<input class="am-u-md-10 form-control" id="doc-ipt-phd-1" placeholder="提示信息">
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ta-1">文本域</label>
												<textarea class="am-u-md-10 form-control" rows="5" id="doc-ta-1"></textarea>
											</div>
										</div>
									</form>
								</div>

								<div class="am-u-md-6">
									<form class="am-form am-text-sm">
										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right" for="doc-ds-ipt-1">禁用</label>
												<input class="am-form-field am-u-md-10" type="text" id="doc-ds-ipt-1" placeholder="禁止输入" disabled>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right am-padding-left-0" for="doc-ipt-text-2">说明信息</label>
												<div class="am-u-md-10 am-padding-0">
													<input class="am-u-md-12 form-control am-padding-0" id="doc-ipt-text-2">
													<span class="help-block m-b-none">帮助文本，可能会超过一行，以块级元素显示</span>
												</div>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right" for="doc-select-1">下拉选框</label>
												<select id="doc-select-1">
													<option value="option1">选项一...</option>
													<option value="option2">选项二.....</option>
													<option value="option3">选项三........</option>
												</select>
												<span class="am-form-caret"></span>
											</div>
										</div>

										<div class="am-form-group">
											<div class="am-g">
												<label class="am-u-md-2 am-md-text-right" for="doc-select-2">多选框</label>
												<div class="am-u-md-10 am-padding-0">
													<select multiple class="" id="doc-select-2">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
					<!-- Row end -->
				</div>


				<!-- row start -->
				<div class="am-g">
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">验证状态</h4>
							<form action="" class="am-form">
								<div class="am-form-group am-form-success am-form-icon am-form-feedback">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-success">验证成功</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" id="doc-ipt-success" class="am-form-field am-radius">
											<span class="am-icon-check" id="rightPa"></span>
										</div>
									</div>
								</div>

								<div class="am-form-group am-form-warning">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-warning">验证警告</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" id="doc-ipt-warning" class="am-form-field am-radius">
										</div>
									</div>
								</div>

								<div class="am-form-group am-form-error">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-error">验证失败</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" id="doc-ipt-error" class="am-form-field am-radius">
										</div>
									</div>
								</div>

								<div class="am-form-group am-form-success am-form-icon am-form-feedback">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-success2">验证成功</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" class="am-form-field am-radius" id="doc-ipt-success2" placeholder="验证成功">
											<span class="am-icon-check" id="rightPa"></span>
										</div>
									</div>
								</div>

								<div class="am-form-group am-form-warning am-form-icon am-form-feedback">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-warm2">验证警告</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" class="am-form-field am-u-md-3 am-md-text-right am-padding-right-0 am-radius" id="doc-ipt-warm2" placeholder="验证警告">
											<span class="am-icon-warning" id="rightPa"></span>
										</div>
									</div>
								</div>

								<div class="am-form-group am-form-error am-form-icon am-form-feedback">
									<div class="am-g">
										<label class="am-form-label am-u-md-3 am-md-text-right am-padding-right-0" for="doc-ipt-error2">验证失败</label>
										<div class="am-u-md-6 am-u-end">
											<input type="text" class="am-form-field am-u-md-3 am-md-text-right am-padding-right-0 am-radius" id="doc-ipt-error2" placeholder="验证警告">
											<span class="am-icon-times" id="rightPa"></span>
										</div>
									</div>
								</div>



							</form>
						</div>
					</div>
					<!-- col end -->

					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">表单域大小</h4>
							<form class="am-form">
								<input class="am-form-field am-input-lg am-radius" type="text" placeholder="添加了 .am-input-lg">
								<br />
								<input class="am-form-field am-radius" type="text" placeholder="默认的 input">
								<br />
								<input class="am-form-field am-input-sm am-radius" type="text" placeholder="添加了 .am-input-sm">
								<br />

								<div class="am-form-group am-form-select">
									<select class=" am-input-lg am-radius">
										<option value="">添加了 .am-input-lg</option>
									</select>
								</div>

								<div class="am-form-group am-form-select">
									<select class="am-radius">
										<option value="">select 默认大小</option>
									</select>
								</div>

								<div class="am-form-group am-form-select">
									<select class=" am-input-sm am-radius">
										<option value="">添加了 .am-input-sm</option>
									</select>
								</div>
							</form>
						</div>
					</div>
					<!-- col end -->
				</div>
				<!-- row end -->


				<!-- row start -->
				<div class="am-g">
					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">基本示例</h4>
							<form class="am-form">
								<div class="am-form-group">
									<label for="doc-ipt-email-2">邮件</label>
									<input type="email" class="am-radius" id="doc-ipt-email-2" placeholder="输入电子邮件">
								</div>

								<div class="am-form-group">
									<label for="doc-ipt-pwd-2">密码</label>
									<input type="password" class="am-radius" id="doc-ipt-pwd-2" placeholder="设置个密码吧">
								</div>

								<div class="am-checkbox">
									<label>
										<input type="checkbox">
										记住我
									</label>
								</div>

								<button type="submit" class="am-btn am-btn-primary">Submit</button>
							</form>
						</div>
					</div>
					<!-- col end -->

					<!-- col start -->
					<div class="am-u-md-6">
						<div class="card-box">
							<h4 class="header-title m-t-0 m-b-30">水平排列</h4>
							<form class="am-form am-form-horizontal">
								<div class="am-form-group">
									<label for="doc-ipt-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">电子邮件</label>
									<div class="am-u-sm-9">
										<input type="email" id="doc-ipt-3" placeholder="输入你的电子邮件">
									</div>
								</div>

								<div class="am-form-group">
									<label for="doc-ipt-pwd-2" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">密码</label>
									<div class="am-u-sm-9">
										<input type="password" id="doc-ipt-pwd-2" placeholder="设置一个密码吧">
									</div>
								</div>

								<div class="am-form-group">
									<label for="doc-ipt-pwd-3" class="am-u-sm-3 am-form-label am-text-right am-padding-right-0">确认密码</label>
									<div class="am-u-sm-9">
										<input type="password" id="doc-ipt-pwd-3" placeholder="输入确认密码">
									</div>
								</div>

								<div class="am-form-group">
									<div class="am-u-sm-offset-3 am-u-sm-10">
										<div class="checkbox">
											<label>
												<input type="checkbox">
												记住我
											</label>
										</div>
									</div>
								</div>

								<div class="am-form-group">
									<div class="am-u-sm-10 am-u-sm-offset-3">
										<button type="submit" class="am-btn am-btn-default">提交登入</button>
									</div>
								</div>
							</form>
						</div>
					</div>
					<!-- col end -->
				</div>
				<!-- row end -->

			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
</html>
