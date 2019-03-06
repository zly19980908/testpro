var accessid = 'LTAIxKZFw0nQWQQf';
var accesskey = 'JTwlPRxFwZuWZpFyijyGoXRcBr1vlo';
var host = 'http://wxggt.oss-cn-beijing.aliyuncs.com';

var g_dirname = '';
var g_object_name = '';
var now = timestamp = Date.parse(new Date()) / 1000;

var policyText = {
	"expiration" : "2020-01-01T12:00:00.000Z", // 设置该Policy的失效时间，超过这个失效时间之后，就没有办法通过这个policy上传文件了
	"conditions" : [ [ "content-length-range", 0, 524288000 ] // 设置上传文件的大小限制为500M
	]
};

var policyBase64 = Base64.encode(JSON.stringify(policyText));
message = policyBase64;
var bytes = Crypto.HMAC(Crypto.SHA1, message, accesskey, {
	asBytes : true
});
var signature = Crypto.util.bytesToBase64(bytes);
/* 获得路径名 */
function get_dirname() {
	console.log("get_dirname " + "获得路径名");
	dir = document.getElementById("cNo").value;
	if (dir != '' && dir.indexOf('/') != dir.length - 1) {
		dir = "courseVideo/" + dir + '/';
	}
	g_dirname = dir;
}
/* 生成随机字符串 */
function random_string(len) {
	console.log("random_string " + "生成随机字符串");
	len = len || 32;
	var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
	var maxPos = chars.length;
	var pwd = '';
	for (var i = 0; i < len; i++) {
		pwd += chars.charAt(Math.floor(Math.random() * maxPos));
	}
	return pwd;
}
/* 获取后缀 */
function get_suffix(filename) {
	console.log("get_suffix " + "获取后缀");
	pos = filename.lastIndexOf('.');
	suffix = '';
	if (pos != -1) {
		suffix = filename.substring(pos);
	}
	return suffix;
}
/* 计算文件名 */
function calculate_object_name(filename) {
	console.log("calculate_object_name " + "计算文件名");
	suffix = get_suffix(filename);
	g_object_name = g_dirname + random_string(8) + suffix;
	return '';
}
/* 设置上传参数 */
function set_upload_param(up, filename, ret) {
	console.log("set_upload_param " + "设置上传参数");
	g_object_name = g_dirname;
	if (filename != '') {
		suffix = get_suffix(filename);
		calculate_object_name(filename);
	}
	new_multipart_params = {
		'key' : g_object_name,
		'policy' : policyBase64,
		'OSSAccessKeyId' : accessid,
		'success_action_status' : '200', // 让服务端返回200,不然，默认会返回204
		'signature' : signature,
	};

	up.setOption({
		'url' : host,
		'multipart_params' : new_multipart_params
	});
	up.start();
}
/*----------------------------------------------------------------------------------------------*/
function getUploader(part_panel){
	var uploader = new plupload.Uploader({
		runtimes : 'html5,flash,silverlight,html4',
		browse_button : 'selectfiles',
		// multi_selection: false,
		container : document.getElementById('container'),
		url : 'http://oss.aliyuncs.com',
		filters : {
			mime_types : [ // 只允许上传图片和zip,rar文件
			{
				title : "Video files",
				extensions : "mp4,flv,wmv,avi,mkv,mov"
			}, ],
			max_file_size : '500mb', // 最大只能上传10mb的文件
			prevent_duplicates : true
		// 不允许选取重复文件
		},
		/* 初始化 */
		init : {
			PostInit : function() {
				console.log("PostInit " + "Post初始化");
				document.getElementById('ossfile').innerHTML = '';
			},

			FilesAdded : function(up, files) {
				/* 删除前面的文件 */
				console.log("FilesAdded " + "添加文件");
				document.getElementById('ossfile').innerHTML = '';
				set_upload_param(uploader, '', false);
				plupload.each(files, function(file, index) {
					document.getElementById('ossfile').innerHTML = '<div id="' + file.id + '" style="position:absolute;top:0px;">' + '<b class="upload-result"></b>' + '<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>' + '</div>';
					console.log("上传文件名及大小: "+file.name+"---"+plupload.formatSize(file.size));
				});
			},

			BeforeUpload : function(up, file) {
				console.log("BeforeUpload " + "上传前");
				get_dirname();
				set_upload_param(up, file.name, true);
			},

			UploadProgress : function(up, file) {
				console.log("UploadProgress " + "上传过程");
				var d = document.getElementById(file.id);
				d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
				var prog = d.getElementsByTagName('div')[0];
				var progBar = prog.getElementsByTagName('div')[0];
				progBar.style.width = 2 * file.percent + 'px';
				progBar.setAttribute('aria-valuenow', file.percent);
			},

			FileUploaded : function(up, file, info) {
				console.log("FileUploaded " + "上传后");
				if (info.status == 200) {
					document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '上传成功';
					var now_date=getTime();
					var add_html="视频名:<span class='part_title_'></span>&nbsp;&nbsp;上传时间:<span class='part_upload_time'></span>";
					part_panel.find('.video_box').html(add_html);
					part_panel.find('.part_title_').text(random_string(8) + suffix);
					part_panel.find('.part_upload_time').text(now_date);
					part_panel.find('.upload_real_path').val("http://wxggt.oss-cn-beijing.aliyuncs.com/"+g_object_name);
				} else {
					document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = info.response;
				}
			},
			Error : function(up, err) {
				if (err.code == -600) {
					alert('选择的文件太大了!');
				} else if (err.code == -601) {
					alert('选择的文件后缀不对!');
				} else if (err.code == -602) {
					alert('文件已经上传过一遍了!');
				} else {
					alert("上传过程中发生错误,请稍后再试");
				}
			}
		}
	});
	return uploader;
}

function getTime(){
	var now_date=new Date();
	var now_year=now_date.getFullYear();
	var now_month=now_date.getMonth()+1;
	var now_day=now_date.getDate();
	now_month=now_month>10?now_month:"0"+now_month;
	now_day=now_day>10?now_day:"0"+now_day;
	return now_year+"-"+now_month+"-"+now_day;
}
/*----------------------------------------------------------------------------------------------*/
// uploader.init();
