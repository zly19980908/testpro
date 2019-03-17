<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>教师管理</title>
<link rel="stylesheet" href="../css/problems/bootstrap.css" />
<link rel="stylesheet"
	href="../css/problems/dataTables.bootstrap.css" />
	<link rel="stylesheet" href="../css/problems/problems.css" />
<link rel="stylesheet" href="../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../css/index_teacher/core.css" />
<link rel="stylesheet" href="../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../css/index_teacher/index.css" />
<link rel="stylesheet" href="../css/index_teacher/admin.css" />
<!-- TABLE STYLES-->
<link rel="stylesheet"
	href="../css/problems/dataTables.bootstrap.css" />
<link rel="stylesheet" href="../css/problems/problems.css" />

</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="#" class="logo">
				<span class="logo-span">
					<img src="../images/main_page/logo.png" class="img-logo"></img>
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
					<a class="am-icon-home home-position" href="../index.html"></a>
				</li>
				<li class="inform">
					<i class="am-icon-bell-o"></i> <i id="letterNum" class="info-num">2</i>
				</li>
				<li class="hidden-xs am-hide-sm-only">
					<form class="app-search">
						<input type="text" placeholder="Search..." class="form-control">
						<a href="javascript:;">
							<img src="../images/index_teacher/search.png">
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
							<img src="../upload/headFace/201601090127/headFace.png" ondragstart="return false;" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive" style="width:89px;height:89px;">
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
					<li class="admin-parent">
						<a class="am-cf" href="platform_info.jsp">
							<span class="am-icon-file"></span>
							平台信息
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf page-on" style="color:#fff;" href="t_manage.jsp">
							<span class="am-icon-file"></span>
							教师管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="s_manage.jsp">
							<span class="am-icon-file"></span>
							学生管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf" href="c_manage.jsp">
							<span class="am-icon-file"></span>
							课程管理
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
				<div class="am-g">
					<!-- Row start -->
					<div id="wrapper">
						<div id="page-inner">
							<div class="row">
								<div class="col-md-12">
									<!-- Advanced Tables -->
									<div class="panel panel-default">
										<div class="panel-heading">教师列表</div>
										<div class="panel-body">
											<div class="table-responsive">
												<input type="button" class="select-all" value="通过" />
												<input type="button" class="del-pb" value="驳回" />
												<table class="table table-striped table-bordered table-hover" id="dataTables-example">
													<thead>
														<tr>
															<th>教师编号</th>
															<th>教师姓名</th>
															<th>性别</th>
															<th>邮件</th>
															<th>状态</th>
														</tr>
													</thead>
													<tbody>
														<tr class="odd gradeX">
															<td>1</td>
															<td>孙天民</td>
															<td>男</td>
															<td>182644501@qq.com</td>
															<td>正式</td>
														</tr>
														<tr class="even gradeC">
															<td>2</td>
															<td>钱汉祥</td>
															<td>男</td>
															<td>ww1556121@outlook.com</td>
															<td>正式</td>
														</tr>
														<tr class="odd gradeA">
															<td>--</td>
															<td>李秉贵</td>
															<td>男</td>
															<td>4892151@163.com</td>
															<td>待审</td>
														</tr>
														<tr class="even gradeA">
															<td>4</td>
															<td>关玉和</td>
															<td>女</td>
															<td>454518453@126.com</td>
															<td>正式</td>
														</tr>
														<tr class="even gradeA">
															<td>--</td>
															<td>王仁兴</td>
															<td>男</td>
															<td>alwayChina@gmail.com</td>
															<td>待审</td>
														</tr>
													</tbody>
												</table>
											</div>
										</div>
									</div>
									<!--End Advanced Tables -->
								</div>
							</div>
							<!-- /. ROW  -->
						</div>
					</div>
					<!-- row end -->
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../js/index_teacher/blockUI.js"></script>
<!-- Bootstrap Js -->
<script src="../js/bootstrap.min.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="../js/problems/jquery.dataTables.js"></script>
<script src="../js/problems/dataTables.bootstrap.js"></script>
<script src="../js/admin/t_manage.js"></script>
</html>
