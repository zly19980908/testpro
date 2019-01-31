<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<title>修改教师信息</title>

<link href="../css/register/normalize.css" rel="stylesheet" />
<link href="../css/register/jquery-ui.css" rel="stylesheet" />
<link href="../css/resetInfo/baseInfo.css" rel="stylesheet" />
<link href="../css/register/jquery.idealforms.min.css" rel="stylesheet"
	media="screen" />
</head>
<body>
	<div class="row">
		<div class="eightcol last">
		
		<s:form name="form01" action="" method="post"
				enctype="multipart/form-data" theme="simple">
				<div style="text-align: center;">
				<%-- img的src取session<s:property value="#session.FilePath" /> --%>
				    <img id="pic" src="../upload/default_attr/xt3.png">
					<!--  这是file,当图片点击时,触发此元素的点击事件 -->
					<input id="upload" type="file" name="uploadFile_"
							style="display: none;"  onchange="submitform()"/>
				</div>
			</s:form>
		
			<!-- Begin Form -->
			<form id="my-form" action="" method="post">

				<section id="第一步">
					<div>
						<label>教师编号:</label><input id="tno" name="" type="text"
							readonly="readonly" value="1234567890" />
					</div>
					<div>
						<label>教师姓名:</label><input id="username" name="" type="text"
							value="哈哈" data-ideal="username" />
					</div>
					<div>
						<label>电&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;话:</label><input
							id="phone" type="tel" name="" data-ideal="phone" />
					</div>
					<div>
						<label>邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱:</label><input
							id="email" name="" data-ideal="email" type="email" />
					</div>
				</section>

				<section id="第二步">
					<div>
						<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别:</label> <label><input
							type="radio" name="radio" checked />男</label> <label><input
							type="radio" name="radio" />女</label>
					</div>
					<div>
						<label>简介:</label>
						<textarea id="comments" name=""></textarea>
					</div>
				</section>
				<div>
					<hr />
				</div>

				<div>
					<button type="submit">提交</button>
					<button id="reset" type="button">重置</button>
				</div>

			</form>
		</div>

	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"></script>
<script type="text/javascript" src="../js/register/jquery-ui.min.js"></script>
<script type="text/javascript" src="../js/register/jquery.idealforms.js"></script>
<script type="text/javascript">
	$(function() {
		$comments = $('#comments')
		$comments.val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
		$comments.click(function() {
			$comments.val('');
		});
		$comments.blur(function() {
			if ($comments.val() == "") {
				$comments.val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
			}
		});
		$("#password").blur(function() {
			$("#repassword").focus();
		});
		var options = {
			onFail : function() {
				alert($myform.getInvalid().length + '个错误.');
			},

			inputs : {
				'tno' : {
					filters : '',
				},
				'username' : {
					filters : 'username',
				},
				'email' : {
					filters : 'email',
				},
				'phone' : {
					filters : 'phone',
				},
				'comments' : {
					filters : 'max',
					data : {
						min : 10,
						max : 200
					}
				},
			}
		};

		var $myform = $('#my-form').idealforms(options).data('idealforms');

		$('#reset').click(function() {
			/*不让tno被重置*/
			var x = $('#tno');
			var tno_val = x.val();
			$myform.reset().fresh().focusFirst();
			x.val(tno_val);
			/*不让comments被清空*/
			$('#comments').val("这个人懒死了,什么都没有写（╯' - ')╯︵ ┻━┻");
		});
	});
</script>
<!-- 修改头像效果 -->
<script type="text/javascript">
	$(function() {
		//alert($("#upload").val());
		/* 点击图片时，触发input:file的点击事件 */
		$("#pic").click(function() {
			$("#upload").click(); //打开本地资源
			//隐藏了input:file样式后，点击头像就可以本地上传
			$("#upload").on("change", function() {
				//alert($("#upload").val());
				var objUrl = getObjectURL(this.files[0]); //获取图片的路径，该路径不是图片在本地的路径
				if (objUrl) {
					$("#pic").attr("src", objUrl); //将图片路径存入src中，显示出图片
					
				}
			});
		});

	});
	//获取图片的路径，该路径不是图片在本地的路径(C:\fakepath,假路径)
	function getObjectURL(file) {
		var url = null;
		if (window.createObjectURL != undefined) { //basic
			url = window.createObjectURL(file);
		} else if (window.URL != undefined) { //mozilla(firefox) 
			url = window.URL.createObjectURL(file);
		} else if (window.webkitURL != undefined) { //webkit or chrome
			url = window.webkitURL.createObjectURL(file);
		}
		return url;
	}
	
	//图片改变时自动提交form表单
	 function submitform(){   
        //document.form01.action="upload.php";   
        document.form01.submit();   
    }  
</script>
</html>
