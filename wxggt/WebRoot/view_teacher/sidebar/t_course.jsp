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
<link rel="stylesheet" href="../../css/index_teacher/page/course.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="../index.html" class="logo">
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
					<a class="am-icon-home home-position" href="../index.html"></a>
				</li>
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
                    <li class="admin-parent"></li>
                    <li class="admin-parent">
                        <a class="am-cf page-on" style="color:#fff;" href="t_course.jsp">
                            <span class="am-icon-file"></span> 课程管理 <span class="am-fr am-margin-right"></span>
                        </a>
                    </li>
                    <li class="admin-parent">
                        <a class="am-cf" href="t_resource.jsp">
                            <span class="am-icon-files-o"></span> 资料管理 <span class="am-fr am-margin-right"></span>
                        </a>
                    <li class="admin-parent">
                        <a class="am-cf" href="t_exercises.jsp">
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
							<div class="div-plus">
								<div class="createCourse-position">
									<a href="t_createCourse.jsp" id="createCourse">创建新的课程</a>
								</div>
							</div>
						</div>
					</div>
					<!-- 这是第一个创建面板到这里结束 -->
					<!--  此处开始循环该教师所有的课程 -->
					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<!-- ondragstart="return false;"--禁止拖动图片 -->
								<img src="../../images/index_teacher/course/web.jpg" class="img-content x" ondragstart="return false;">
								<!-- 这里存放课程号 -->
								<input type="hidden" value="2" />
							</div>
							<div class="div-content">
								<h4 class="header-title m-t-0 title-name">&nbsp;</h4>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-book">&nbsp;web前端</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-user">&nbsp;52人学习</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-shopping-cart">&nbsp;18元</span>
									<button class="edit-course-button" onclick="window.location.href='t_editCourse.jsp'">编辑课时</button>
									<!-- 这里存放课程号 -->
									<input type="hidden" value="2" />
								</div>
							</div>
						</div>
					</div>
					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<!-- ondragstart="return false;"--禁止拖动图片 -->
								<img src="../../images/index_teacher/course/h.jpg" class="img-content x" ondragstart="return false;">
								<!-- 这里存放课程号 -->
								<input type="hidden" value="3" />
							</div>
							<div class="div-content">
								<h4 class="header-title m-t-0 title-name">&nbsp;</h4>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-book">&nbsp;家庭财务学</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-user">&nbsp;332人学习</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-shopping-cart">&nbsp;0元</span>
									<button class="edit-course-button" onclick="window.location.href='t_editCourse.jsp'">编辑课时</button>
									<!-- 这里存放课程号 -->
									<input type="hidden" value="3" />
								</div>
							</div>
						</div>
					</div>
					<div class="am-u-md-3">
						<div class="course-card-box">
							<div class="div-content">
								<!-- ondragstart="return false;"--禁止拖动图片 -->
								<img src="../../images/index_teacher/course/o.jpg" class="img-content x" ondragstart="return false;">
								<!-- 这里存放课程号 -->
								<input type="hidden" value="4" />
							</div>
							<div class="div-content">
								<h4 class="header-title m-t-0 title-name">&nbsp;</h4>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-book">&nbsp;OCP修炼之道</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-user">&nbsp;215人学习</span>
								</div>
								<div>
									&nbsp;&nbsp;
									<span class="am-icon-shopping-cart">&nbsp;88元</span>
									<button class="edit-course-button">编辑课时</button>
									<!-- 这里存放课程号 -->
									<input type="hidden" value="4" />
								</div>
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
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* 点击加号跳转到创建课程信息页面 */
		$('.img-plus').click(function() {
			$(location).attr('href', 't_createCourse.jsp');
		});
		/* 点击图片跳转到修改课程信息页面 */
		$('.x').click(function() {
			var cNo = $(this).next().val();
			alert("课程号：" + cNo);
			$(location).attr('href', 't_changeCourseInfo.jsp?cNo=' + cNo);
		});
		/* 点击按钮跳转到编辑课程课时页面 */
		$('.edit-course-button').click(function() {
			var cNo = $(this).next().val();
			alert("课程号：" + cNo);
			$(location).attr('href', 't_editCourse.jsp?cNo=' + cNo);
		});
	});
</script>
</html>
