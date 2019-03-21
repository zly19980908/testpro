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
<link rel="stylesheet" href="../../css/problems/bootstrap.css" />
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<!-- TABLE STYLES-->
<link rel="stylesheet" href="../../css/problems/dataTables.bootstrap.css" />
<link rel="stylesheet" href="../../css/problems/problems.css" />
</head>
<body>
	<!-- Begin page -->
	<header class="am-topbar am-topbar-fixed-top">
		<div class="am-topbar-left am-hide-sm-only">
			<a href="t_course.jsp" class="logo">
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
                            <span class="am-icon-file"></span> 课程管理 <span class="am-fr am-margin-right"></span>
                        </a>
                    </li>
                    <li class="admin-parent">
                        <a class="am-cf" href="t_resource.jsp">
                            <span class="am-icon-files-o"></span> 资料管理 <span class="am-fr am-margin-right"></span>
                        </a>
                    <li class="admin-parent">
                        <a class="am-cf page-on" style="color:#fff;" href="t_exercisesRepositories.jsp">
                            <span class="am-icon-paperclip"></span> 习题管理 <span class="am-fr am-margin-right"></span>
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
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<!-- Row start -->
				<div id="wrapper">
					<div id="page-inner">
						<div class="row">
							<div class="col-md-12">
								<!-- Advanced Tables -->
								<div class="panel panel-default">
									<div class="panel-heading">习题清单</div>
									<div class="panel-body">
										<div class="table-responsive">
											<input type="button" class="select-all" value="全选" />
											<input type="button" class="edit-pb" value="编辑" />
											<input type="button" class="del-pb" value="删除" />

											<table class="table table-striped table-bordered table-hover" id="dataTables-example">
												<thead>
													<tr>
														<th>题目编号</th>
														<th>题目内容</th>
														<th>正确答案</th>
													</tr>
												</thead>
												<tbody>
													<tr class="odd gradeX">
														<td>1</td>
														<td>银环蛇咬伤致死的主要原因是：</td>
														<td>B</td>
													</tr>
													<tr class="even gradeC">
														<td>2</td>
														<td>心脏骤停前最常见的心电图图形是：</td>
														<td>D</td>
													</tr>
													<tr class="odd gradeA">
														<td>3</td>
														<td>对溺水所致呼吸心搏骤停者，其紧急处理措施最重要的是：</td>
														<td>C</td>
													</tr>
													<tr class="even gradeA">
														<td>4</td>
														<td>心脏性猝死最常见的病因是：</td>
														<td>A</td>
													</tr>
													<tr class="even gradeA">
														<td>5</td>
														<td>导致多发伤病人死亡的首要因素是：</td>
														<td>C</td>
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
				<!-- Row end -->
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
