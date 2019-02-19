<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>课程管理</title>
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/index.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/typography.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/form.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/course.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="index.html" class="logo">
				<span> 教师管理系统 </span>
				<i class="zmdi zmdi-layers"></i>
			</a>
		</div>

		<div class="contain">
			<ul class="am-nav am-navbar-nav am-navbar-left">

				<li>
					<h4 class="page-title">课程管理</h4>
				</li>
			</ul>

			<ul class="am-nav am-navbar-nav am-navbar-right">
				<li class="inform">
					<span class="am-icon-bell-o"></span>
					<i id="letterNum" class="info-num">2</i>
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
							<img src="../../upload/headFace/201601090127/headFace.png" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive" style="width:89px;height:89px;" ondragstart="return false;">
						</a>
						<div class="user-status offline">
							<i class="am-icon-dot-circle-o"></i>
						</div>
					</div>
					<h5>
						<a href="#">周 娜</a>
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
								<a href="t_course.jsp" class="am-cf">课程管理</a>
							</li>
							<li>
								<a href="t_resource.jsp">资料管理</a>
							</li>
							<li>
								<a href="t_practice.jsp">练习管理</a>
							</li>
							<li>
								<a href="t_exam.jsp">考试管理</a>
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
		<!-- 右边的内容 -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<!-- 我的课程开始 -->
				<div class="am-g">
					<h3 class="page-title">我的课程</h3>

					<!-- Row start -->
					<!-- 这是第一个创建面板，不参与循环 -->
					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<div class="on-center">
									<img src="../../images/index_teacher/plus.png" class="img-plus" ondragstart="return false;">
								</div>
							</div>
							<div class="div-title">
								<a href="t_createCourse.jsp" id="createCourse">创建新的课程</a>
								<!-- <h4 class="header-title m-t-0">创建课程</h4> -->
							</div>
						</div>
					</div>

					<!--  此处开始循环该教师所有的课程 -->

					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<!-- ondragstart="return false;"--禁止拖动图片 -->
								<img src="../../images/index_teacher/course/x.jpg" class="img-content" ondragstart="return false;">
							</div>
							<div class="div-title">
								<h4 class="header-title m-t-0">孩子叛逆早知道</h4>
							</div>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<img src="../../images/index_teacher/course/web.jpg" class="img-content" ondragstart="return false;">
							</div>
							<div class="div-title">
								<h4 class="header-title m-t-0">web前端</h4>
							</div>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<img src="../../images/index_teacher/course/h.jpg" class="img-content" ondragstart="return false;">
							</div>
							<div class="div-title">
								<h4 class="header-title m-t-0">家庭财务学</h4>
							</div>
						</div>
					</div>

					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<img src="../../images/index_teacher/course/o.jpg" class="img-content" ondragstart="return false;">
							</div>
							<div class="div-title">
								<h4 class="header-title m-t-0">OCP修炼之道</h4>
							</div>
						</div>
					</div>

					<!--  此处结束循环该教师所有的课程 -->
					<!-- Row end -->

				</div>
				<!-- 第一部分结束 -->
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/app.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('.img-plus').click(function() {
			$(location).attr('href', 't_createCourse.jsp');
		});
	});
</script>
</html>
