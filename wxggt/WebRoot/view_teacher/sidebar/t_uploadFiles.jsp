<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>后台模板</title>
<link rel="stylesheet" href="../../css/problems/bootstrap.css" />
<link rel="stylesheet" href="../../css/index_teacher/amazeui.css" />
<link rel="stylesheet" href="../../css/index_teacher/core.css" />
<link rel="stylesheet" href="../../css/index_teacher/menu.css" />
<link rel="stylesheet" href="../../css/index_teacher/index.css" />
<link rel="stylesheet" href="../../css/index_teacher/admin.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/typography.css" />
<link rel="stylesheet" href="../../css/index_teacher/page/form.css" />
<!-- TABLE STYLES-->
<link rel="stylesheet" href="../../css/problems/dataTables.bootstrap.css" />
<link rel="stylesheet" href="../../css/problems/problems.css" />
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
					<li class="admin-parent"></li>
					<li class="admin-parent">
						<a class="am-cf" href="t_course.jsp">
							<span class="am-icon-file"></span>
							课程管理
							<span class="am-fr am-margin-right"></span>
						</a>
					</li>
					<li class="admin-parent">
						<a class="am-cf page-on" style="color:#fff;" href="t_resource.jsp">
							<span class="am-icon-files-o"></span>
							资料管理
							<span class="am-fr am-margin-right"></span>
						</a>
					<li class="admin-parent">
						<a class="am-cf" href="t_exercisesRepositories.jsp">
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
				<div class="am-g">
					<!-- Row start -->
					<div id="wrapper">
						<div id="page-inner">
							<div class="row">
								<div class="am-u-sm-10" style="left:76px;">
									<div class="card-box">
										<form action="" class="am-form" data-am-validator onsubmit="autoCompleteDesc()">
											<fieldset>
												<legend>上传资源</legend>
												<div class="am-form-group">
													<label for="doc-vld-name-2">教师姓名：</label>
													<input type="text" name="tname" placeholder="输入用户名（至少 3 个字符）" required value="汪大伟" readonly="readonly" />
												</div>
												<div class="am-form-group">
													<label>资源类别： </label>
													<label class="am-radio-inline">
														<input type="radio" value="" name="docVlGender" required="" class="am-field-valid" checked="checked">
														课程资源
													</label>
													<label class="am-radio-inline">
														<input type="radio" name="docVlGender" class="am-field-valid">
														课外资源
													</label>
												</div>
												<div class="am-form-group">
													<label for="doc-select-1">所属专业</label>
													<select id="doc-select-1">
														<option value="" id="cno">-=请选择一项=-</option>
														<option value="01" id="cno">信管</option>
														<option value="02" id="cno">中西</option>
														<option value="03" id="cno">针灸推拿</option>
													</select>
													<span class="am-form-caret"></span>
												</div>
												<div class="am-form-group">
													<label for="doc-select-1">所属课程</label>
													<select id="doc-select-1">
														<option value="" id="cno">-=请选择一项=-</option>
														<option value="1" id="cName">药剂学</option>
														<option value="2" id="cName">生理学</option>
														<option value="3" id="cName">解剖学</option>
													</select>
													<span class="am-form-caret"></span>
												</div>
												<div class="am-form-group">
													<label for="doc-vld-ta-2">文件列表：</label>
													<div id="ossfile"></div>
													<br />
													<div id="container">
														<a id="selectfiles" href="javascript:void(0);" class='btn'>选择文件</a>
														<a id="postfiles" href="javascript:void(0);" class='btn'>开始上传</a>
													</div>
												</div>
												<div class="am-form-group">
													<label for="doc-vld-ta-2">资源描述：</label>
													<textarea id="doc-vld-ta-2" name="cintro" maxlength="100" rows="5"></textarea>
												</div>
												<a id="submit_files" class="am-btn am-btn-secondary" style="border-radius:5px;">保存</a>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- row end -->
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../lib/crypto1/crypto/crypto.js"></script>
<script type="text/javascript" src="../../lib/crypto1/hmac/hmac.js"></script>
<script type="text/javascript" src="../../lib/crypto1/sha1/sha1.js"></script>
<script type="text/javascript" src="../../lib/base64.js"></script>
<script type="text/javascript" src="../../lib/plupload-2.1.2/js/plupload.full.min.js"></script>
<script type="text/javascript" src="../../js/MyPopup.js"></script>
<script type="text/javascript" src="../../js/resource/uploadFiles.js"></script>
<script type="text/javascript">
/*提交按钮*/
$('#submit_files').click(function() {
	MP.successAlert('上传成功!');
});
</script>
</html>
