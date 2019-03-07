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
	-
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
								<a href="t_exercises.jsp">习题管理</a>
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
							<form action="" class="am-form" data-am-validator onsubmit="autoCompleteDesc()">
								<fieldset>
									<legend>创建一门新课程</legend>
									<div class="am-form-group">
										<label for="doc-vld-name-2">课程名称：</label>
										<input type="text" name="cname" id="doc-vld-name-2" value="" minlength="1" maxlength="20" placeholder="输入课程名字（20个字以内）" autocomplete="off" required />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-name-2">教师姓名：</label>
										<input type="text" name="tname" placeholder="输入用户名（至少 3 个字符）" required value="" readonly="readonly" />
									</div>
									<div class="am-form-group">
										<label for="doc-select-1">所属专业</label>
										<select id="doc-select-1" required>
											<option value="" name="cno">-=请选择一项=-</option>
										</select>
										<span class="am-form-caret"></span>
									</div>
									<div class="am-form-group">
										<label for="doc-vld-age-2">价格：</label>
										<input type="number" name="price" value="" id="doc-vld-age-2" placeholder="输入价格" min="0" max="10000" required />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-ta-2">课程封面：</label>
										<br />
										<button class="am-btn am-btn-secondary" style="border-radius:5px;" onclick="document.getElementById('course_img_file').click()">选择图片</button>
										<input id="course_img_file" name="file" type="file" style="display:none;" accept=".jpg,.png" />
										<input type="text" id="show_course_img" name="filename" placeholder="未选择任何图片" required readonly="readonly" />
									</div>
									<div class="am-form-group">
										<label for="doc-vld-ta-2">课程描述：</label>
										<textarea id="doc-vld-ta-2" name="cintro" maxlength="100" rows="5"></textarea>
									</div>
									<button class="am-btn am-btn-secondary" type="submit" style="border-radius:5px;">保存</button>
								</fieldset>
							</form>
						</div>
					</div>
					<!-- Row end -->
					<!-- 创建一门新的课程结束 -->
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../../js/index_teacher/jquery-2.1.0.js"></script>
<script type="text/javascript" src="../../js/index_teacher/amazeui.min.js"></script>
<script type="text/javascript" src="../../js/index_teacher/blockUI.js"></script>
<script type="text/javascript" src="../../js/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		/* 动态生成专业信息 */
		$.ajax({
			url : "../../php/t_getMajorInfo.php",
			type : "GET",
			dataType : "json",
			cache : false,
			beforeSend : LoadFunction, //加载执行方法  
			error : errorFunction, //错误执行方法  
			success : succseFunction
		//成功执行方法  
		});
		function LoadFunction() {
			$("#list").html('加载中...');
		}
		function errorFunction() {
			alert("error");
		}
		function succseFunction(tt) {
			var datalist = $('#doc-select-1');
			var majorInfo = eval(tt); //数组       
			$.each(majorInfo, function(index, item) {
				//循环获取数据  
				var mNo_ = majorInfo[index].mNo;
				var mName_ = majorInfo[index].mName;
				datalist.append("<option value=" + mNo_ + ">" + mName_ + "</option>");
			});
		}
	});
	/* 当老师没有填写描述时自动填写描述 */
	autoCompleteDesc = function() {
		var textarea_ = $('#doc-vld-ta-2');
		if (textarea_.val() == "") {
			textarea_.val("老师没有添加描述哦~");
		}
	};
	/* 选择文件后显示文件名 */
	$('#course_img_file').change(function() {
		$('#show_course_img').val($('#course_img_file').val());
	});
</script>
</html>
