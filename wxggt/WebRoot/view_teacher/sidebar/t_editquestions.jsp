<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>题目管理</title>
<!-- 页面头上的图标 -->
<link rel="shortcut icon" href="../../images/top_logo.png" />
<!-- Bootstrap Styles-->
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/problems/editproblems.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="t_course.jsp" class="logo">
				<span class="logo-span">
					<img src="../../images/main_page/logo.png" class="img-logo"></img>
				</span>
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
					<a class="am-icon-home home-position" href="t_course.jsp"></a>
				</li>
				<li class="inform">
					<i class="am-icon-bell-o"></i> <i id="letterNum" class="info-num">2</i>
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
						<a href="#">张无忌</a>
					</h5>
				</div>
				<!-- End 用户 -->
				<!-- 导航栏开始 -->
				<ul class="am-list admin-sidebar-list">
					<li class="admin-parent"></li>
					<li class="admin-parent">
						<a class="am-cf" href="t_course.jsp">
							<span class="am-icon-file"></span>
							课程管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="t_resource.jsp">
							<span class="am-icon-files-o"></span>
							资料管理
							<span class="am-fr am-margin-right"></span>
						</a>
					<li class="admin-parent">
						<a class="am-cf page-on" style="color:#fff;" href="t_exercisesRepositories.jsp">
							<span class="am-icon-paperclip"></span>
							习题管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="t_comments.jsp">
							<span class="am-icon-envelope"></span>
							学生评价
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="m_income.jsp">
							<span class="am-icon-briefcase"></span>
							资金管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="../resetInfo.jsp">
							<span class="am-icon-user"></span>
							个人中心
							<span class="am-fr am-margin-right"></span>
						</a>
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
				<!-- Row start -->
				<div id="wrapper">
					<div id="page-inner">
						<!-- row start -->
						<div class="am-g">
							<!-- col start -->
							<div class="am-u-md-11">
								<div class="card-box card-position">
									<h4 class="header-title m-t-0 m-b-30">试题编辑</h4>
									<form class="am-form am-form-horizontal">
										<hr style="border:2px inset #ccffb8;width:100%;">
										<div class="am-form-group">
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0" style="left:-40px;">题目内容</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control textarea-style" maxlength="80" rows="4" id="question_comtent" style="left:-40px;"></textarea>
												<div class="question-word-num">
													还可输入
													<span>76</span>
													个字
												</div>
											</div>
										</div>

										<div class="am-form-group">
											<div class="radio-group">
												<input type="radio" name="selection" id="A" class="am-radio" />
											</div>
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0 labels">选项A</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control select-style" maxlength="38" rows="2" id="question_select_A"></textarea>
												<div class="select-word-num">
													还可输入
													<span>38</span>
													个字
												</div>
											</div>
										</div>

										<div class="am-form-group">
											<div class="radio-group">
												<input type="radio" name="selection" id="B" class="am-radio" />
											</div>
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0 labels">选项B</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control select-style" maxlength="38" rows="2" id="question_select_B"></textarea>
												<div class="select-word-num">
													还可输入
													<span>38</span>
													个字
												</div>
											</div>
										</div>

										<div class="am-form-group">
											<div class="radio-group">
												<input type="radio" name="selection" id="C" class="am-radio" />
											</div>
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0 labels">选项C</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control select-style" maxlength="38" rows="2" id="question_select_C"></textarea>
												<div class="select-word-num">
													还可输入
													<span>38</span>
													个字
												</div>
											</div>
										</div>

										<div class="am-form-group">
											<div class="radio-group">
												<input type="radio" name="selection" id="D" class="am-radio" />
											</div>
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0 labels">选项D</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control select-style" maxlength="38" rows="2" id="question_select_D"></textarea>
												<div class="select-word-num">
													还可输入
													<span>38</span>
													个字
												</div>
											</div>
										</div>
										<br>
										<div class="am-form-group">
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0" style="left:-40px;">题目解析</label>
											<div class="am-u-sm-9">
												<textarea class="am-u-md-5 form-control textarea-style" maxlength="80" rows="4" id="question_comtent" style="left:-40px;"></textarea>
												<div class="question-word-num">
													还可输入
													<span>76</span>
													个字
												</div>
											</div>
										</div>
										<br>
										<div class="am-form-group">
											<label for="doc-ipt-3" class="am-u-sm-2 am-form-label am-text-right am-padding-right-0" style="left:-40px;">题目解析</label>
											<div class="am-u-sm-9">
												<button onclick="document.getElementById('image_file').click();" class="am-btn am-btn-primary">请选择图片</button>
												<input type="file" id="image_file" style="display:none;">
											</div>
										</div>
										<br>
										<hr style="border:2px inset #ccffb8;width:100%;">
										<div class="am-form-group">
											<div class="am-u-sm-10 am-u-sm-offset-3">
												<button type="submit" class="am-btn am-btn-warning">保存</button>
												<button type="reset" class="am-btn am-btn-danger" style="position:relative;left:250px">重置</button>
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
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../js/problems/editproblems.js"></script>
</html>
