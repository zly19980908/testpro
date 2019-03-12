<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>题目管理</title>
<!-- Bootstrap Styles-->
<link rel="stylesheet" href='../../css/index_teacher/amazeui.css' />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/problems/problems.css" />
<link rel="stylesheet" href="../../css/problems/problemsRepositories.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="../index.html" class="logo">
				<span class="logo-span"> <img src="../../images/main_page/logo.png" class="img-logo"></img>
				</span> <i class="zmdi zmdi-layers"></i>
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
					<a class="am-icon-home home-position" href="../index.html"></a>
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
						<a href="#">张 三</a>
					</h5>
				</div>
				<!-- End 用户 -->
				<!-- 导航栏开始 -->
				<ul class="am-list admin-sidebar-list">
					<li class="admin-parent"></li>
					<li class="admin-parent">
						<a class="am-cf" href="t_course.jsp">
							<span class="am-icon-file"></span> 课程管理 <span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="t_resource.jsp">
							<span class="am-icon-files-o"></span> 资料管理 <span class="am-fr am-margin-right"></span>
						</a>
					<li class="admin-parent">
						<a class="am-cf page-on" style="color:#fff;" href="t_exercises.jsp">
							<span class="am-icon-paperclip"></span> 习题管理 <span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="t_audio.jsp">
							<span class="am-icon-microphone"></span> 音频管理 <span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="m_income.jsp">
							<span class="am-icon-briefcase"></span> 资金管理 <span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="../resetInfo.jsp">
							<span class="am-icon-user"></span> 个人中心 <span class="am-fr am-margin-right"></span>
						</a>
					</li>
				</ul>
				<!-- 导航栏结束 -->
			</div>
		</div>
		<!-- ========== 侧边栏结束 ========== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<!-- Row start -->
				<div class="am-g row-group">
					<div class="am-u-sm-5">
						<div class="test">
							<h1>
								<b>爬虫</b>
							</h1>
							<div class="test_container">
								<p>
									<span class="am-icon-question-circle"></span><span style="color:red;">10道题</span> <span class="am-icon-paper-planet"></span>
									<a href="t_exercises.jsp">进入题库</a>
								</p>
							</div>
						</div>
					</div>
					<!-- Row end -->

				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<!-- Bootstrap Js -->
<script src="../../js/bootstrap.min.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="../../js/problems/jquery.dataTables.js"></script>
<script src="../../js/problems/dataTables.bootstrap.js"></script>
<script src="../../js/problems/problems.js"></script>
</html>
