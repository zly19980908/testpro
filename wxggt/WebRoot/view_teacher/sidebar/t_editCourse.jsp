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
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/index.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/typography.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/form.css" />
<link rel="stylesheet" href="../../css/MyPopup.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/course.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="index.html" class="logo">
				<span class="logo-span">
					<img src="../../images/main_page/logo.png" class="img-logo"></img>
				</span>
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
							<img src="../../upload/headFace/201601090127/headFace.png" ondragstart="return false;" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive" style="width:89px;height:89px;">
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
				<!-- 创建一门新的课程开始 -->
				<div class="am-g">
					<!-- Row start -->
					<div class="am-u-sm-12">
						<div class="card-box">
							<h3 class="header-title">编辑课程</h3>
							<!-- 这里填入课程号 -->
							<input id="cNo" type="hidden" value="126263347" />
							<input id="cSort" type="hidden" value="中基" />
							<!-- 添加新单元 -->
							<div class="row-unit">
								<div class="title-unit">&nbsp;</div>
								<div class="circle-unit"></div>
								<div class="new-unit-content">
									<span class="am-icon-plus am-icon-md"></span>
									<div class="new-unit-text">添加新单元</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Row end -->
					<!-- 创建一门新的课程结束 -->
				</div>
			</div>
		</div>
	</div>
</body>
<!-- 上传视频 -->
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript" src="../../lib/crypto1/crypto/crypto.js"></script>
<script type="text/javascript" src="../../lib/crypto1/hmac/hmac.js"></script>
<script type="text/javascript" src="../../lib/crypto1/sha1/sha1.js"></script>
<script type="text/javascript" src="../../lib/base64.js"></script>
<script type="text/javascript" src="../../lib/plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/uploadCourseVideo.js"></script>
<!-- 上传视频这里结束 -->
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../js/jcanvas.min.js"></script>
<script type="text/javascript" src="../../js/MyPopup.js"></script>
<!-- 课时编辑页面的动态效果,及工具函数 -->
<script type="text/javascript" src="../../js/index_teacher/editCourse.js"></script>
<!-- 编辑单元 -->
<script type="text/javascript" src="../../js/index_teacher/editUnit.js"></script>
<!-- 编辑课时 -->
<script type="text/javascript" src="../../js/index_teacher/editPart.js"></script>

</html>
