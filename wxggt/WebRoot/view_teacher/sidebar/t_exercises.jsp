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
<link rel="stylesheet" href="../../css/problems/bootstrap.css" />
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />

<!-- TABLE STYLES-->
<link rel="stylesheet" href="../../css/problems/dataTables.bootstrap.css" />
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

table.dataTable tbody tr.selected {
	background-color: #B0BED9;
}

.select-all {
	background-color: rgb(109, 199, 77);
	color: #fff;
	border: rgb(165, 218, 93) 1px solid;
	padding: 4px 7px 4px 7px;
	position: relative;
	left: 820px;
	top: 30px;
}

.edit-pb {
	background-color: rgb(113, 182, 249);
	color: #fff;
	border: #B0BED9 1px solid;
	padding: 4px 7px 4px 7px;
	position: relative;
	left: 840px;
	top: 30px;
}

.del-pb {
	background-color: rgb(249, 119, 108);
	color: #fff;
	border: rgb(230, 116, 106) 1px solid;
	padding: 4px 7px 4px 7px;
	position: relative;
	left: 860px;
	top: 30px;
}



a {
	color: #797979;
}

a:hover {
	color: #797979;
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
					<!-- 副标题---教学管理-->
					<li class="admin-parent">
						<a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}">
							<span class="am-icon-book"></span> 教学管理 <span class="am-icon-angle-right am-fr am-margin-right"></span>
						</a>
						<ul class="am-list admin-sidebar-sub am-collapse am-in" id="collapse-nav1" style="">
							<li>
								<a href="t_course.jsp">课程管理</a>
							</li>
							<li>
								<a href="t_resource.jsp">资料管理</a>
							</li>
							<li>
								<a href="t_exercises.jsp" class="am-cf">习题管理</a>
							</li>
							<li>
								<a href="t_audio.jsp">音频管理</a>
							</li>
						</ul>
					</li>
					<!-- 副标题---资金管理-->
					<li class="admin-parent">
						<a class="am-cf am-collapsed" data-am-collapse="{target: '#collapse-nav2'}">
							<span class="am-icon-briefcase"></span> 资金管理 <span class="am-icon-angle-right am-fr am-margin-right"></span>
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
							<span class="am-icon-user"></span> 个人中心 <span class="am-icon-angle-right am-fr am-margin-right"></span>
						</a>
						<ul class="am-list admin-sidebar-sub am-collapse" id="collapse-nav5" style="height: 0px;">
							<li>
								<a href="../resetInfo.jsp" class="am-cf">信息管理</a>
							</li>
						</ul>
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
				<!-- row start -->
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
<script>
	$(document).ready(function() {
		$('#dataTables-example').dataTable();

		/* 将搜索出来的内容标红 */
		var str;
		$("[type='search']").on("keyup", function() {
			str = $(this).val();
			if (str != "") {
				$('td').html(function(i, oldHTML) {
					return oldHTML.replace(new RegExp(str, "g"), '<font color="red">' + str + '</font>');
				});
			} else {
				$("font").attr("color", "#797979")
			}
		});

		/* 选择删除行 */
		var table = $('#dataTables-example').DataTable();

		$('#dataTables-example tbody').on('click', 'tr', function() {
			$(this).toggleClass('selected');
		});

		$('.del-pb').click(function() {
			table.row('.selected').remove().draw(false);
		});
		
		$('.select-all').click(function() {
			$("tr").toggleClass('selected');
		});
		
		$('.edit-pb').click(function() {
			/* 获得题目序号 */
			var pNum=$(".selected:eq(0)").find("td:eq(0)").html();
			console.log("编辑"+pNum);
		});
	});
</script>
</html>
