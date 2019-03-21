<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>平台收益</title>
<!-- 页面头上的图标 -->
<link rel="shortcut icon" href="../images/top_logo.png" />
<link rel="stylesheet" href="../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../css/index_teacher/core.css" />
<link rel="stylesheet" href="../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../css/index_teacher/index.css" />
<link rel="stylesheet" href="../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../css/index_teacher/page/typography.css" />
<link rel="stylesheet" href="../css/index_teacher/page/form.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="#" class="logo"> <span class="logo-span"> <img
					src="../images/main_page/logo.png" class="img-logo"></img>
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
				<li class="inform"><a class="am-icon-home home-position"
					href="../index.html"></a></li>
				<li class="inform"><i class="am-icon-bell-o"></i> <i
					id="letterNum" class="info-num">2</i></li>
				<li class="hidden-xs am-hide-sm-only">
					<form class="app-search">
						<input type="text" placeholder="Search..." class="form-control">
						<a href="javascript:;"> <img
							src="../images/index_teacher/search.png">
						</a>
					</form>
				</li>
			</ul>
		</div>
	</header>
	<!-- end page -->
	<div class="admin">
		<!-- ========== 侧边栏开始 ========== -->
		<div class="admin-sidebar am-offcanvas  am-padding-0"
			id="admin-offcanvas">
			<div class="am-offcanvas-bar admin-offcanvas-bar">
				<!-- start User -->
				<div class="user-box am-hide-sm-only">
					<div class="user-img">
						<a href="../photoCut.html"> <img
							src="../upload/headFace/201601090127/headFace.png"
							ondragstart="return false;" alt="user-img" title="Mat Helme"
							class="img-circle img-thumbnail img-responsive"
							style="width:89px;height:89px;">
						</a>
						<div class="user-status offline">
							<i class="am-icon-dot-circle-o"></i>
						</div>
					</div>
					<h5>
						<a href="#">管理员</a>
					</h5>
				</div>
				<!-- End 用户 -->
				<!-- 导航栏开始 -->
				<ul class="am-list admin-sidebar-list">
					<li class="admin-parent"></li>
					<li class="admin-parent"><a class="am-cf page-on"
						style="color:#fff;" href="platform_info.jsp"> <span
							class="am-icon-file"></span> 平台信息 <span
							class="am-fr am-margin-right"></span>
					</a></li>
					<li class="admin-parent"><a class="am-cf" href="t_manage.jsp">
							<span class="am-icon-file"></span> 教师管理 <span
							class="am-fr am-margin-right"></span>
					</a></li>
					<li class="admin-parent"><a class="am-cf" href="s_manage.jsp">
							<span class="am-icon-file"></span> 学生管理 <span
							class="am-fr am-margin-right"></span>
					</a></li>
					<li class="admin-parent"><a class="am-cf" href="c_manage.jsp">
							<span class="am-icon-file"></span> 课程管理 <span
							class="am-fr am-margin-right"></span>
					</a></li>
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
					<div class="am-u-md-12">
						<!-- 动态数据+时间坐标轴 -->
						<div class="card-box">
							<div id="trends"
								style="width: 100%; height: 300px; -webkit-tap-highlight-color: transparent; user-select: none; position: relative; background: transparent;"
								_echarts_instance_="ec_1552821425882">
								<div
									style="position: relative; overflow: hidden; width: 973px; height: 300px; cursor: default;">
									<canvas data-zr-dom-id="zr_0"
										style="position: absolute; left: 0px; top: 0px; width: 973px; height: 700px; user-select: none; -webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></canvas>
								</div>
								<div
									style="position: absolute; display: none; border-style: solid; white-space: nowrap; z-index: 9999999; transition: left 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s, top 0.4s cubic-bezier(0.23, 1, 0.32, 1) 0s; background-color: rgba(50, 50, 50, 0.7); border-width: 0px; border-color: rgb(51, 51, 51); border-radius: 4px; color: rgb(255, 255, 255); font: 14px/21px &quot;Microsoft YaHei&quot;; padding: 5px; left: 353px; top: 85px;">1/9/1998
									: 434</div>
							</div>
						</div>
					</div>
				</div>
				<div class="am-g">
					<!-- 访问量分析 -->
					<div class="am-u-md-6">
						<div class="card-box">
							<div id="page_view"
								style="width:100%;height:300px;position:right"></div>
						</div>
					</div>
					<!-- 程序收益 -->
					<div class="am-u-md-6">
						<div class="card-box">
							<div id="earning" style="width:100%;height:300px;"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../js/index_teacher/blockUI.js"></script>
<script type="text/javascript"
	src="../js/index_teacher/charts/echarts.min.js"></script>
<script type="text/javascript"
	src="../js/admin/platform_info.js"></script>
</html>
