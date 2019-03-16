/*这里填写oss服务器的相关信息*/
var accessid = 'LTAIxKZFw0nQWQQf';
var accesskey = 'JTwlPRxFwZuWZpFyijyGoXRcBr1vlo';
var host = 'http://wxggt.oss-cn-beijing.aliyuncs.com';

var g_dirname = 'testUploadFile/'
var g_object_name = ''
var g_object_name_type = 'local_name'
var now = timestamp = Date.parse(new Date()) / 1000;

var policyText = {
	"expiration" : "2020-01-01T12:00:00.000Z", //设置该Policy的失效时间，超过这个失效时间之后，就没有办法通过这个policy上传文件了
	"conditions" : [
		["content-length-range", 0, 104857600] // 设置上传文件的大小限制50M
	]
};

var policyBase64 = Base64.encode(JSON.stringify(policyText))
message = policyBase64
var bytes = Crypto.HMAC(Crypto.SHA1, message, accesskey, {
	asBytes : true
});
var signature = Crypto.util.bytesToBase64(bytes);

function get_suffix(filename) {
	pos = filename.lastIndexOf('.')
	suffix = ''
	if (pos != -1) {
		suffix = filename.substring(pos)
	}
	return suffix;
}

function calculate_object_name(filename) {
	g_object_name += "${filename}"
	return '';
}

function get_uploaded_object_name(filename) {
	tmp_name = g_object_name
	tmp_name = tmp_name.replace("${filename}", filename);
	return tmp_name
}

function set_upload_param(up, filename, ret) {
	g_object_name = g_dirname;
	if (filename != '') {
		suffix = get_suffix(filename);
		calculate_object_name(filename);
	}
	new_multipart_params = {
		'key' : g_object_name,
		'policy' : policyBase64,
		'OSSAccessKeyId' : accessid,
		'success_action_status' : '200', //让服务端返回200,不然，默认会返回204
		'signature' : signature,
	};
	up.setOption({
		'url' : host,
		'multipart_params' : new_multipart_params
	});
	up.start();
}

var uploader = new plupload.Uploader({
	runtimes : 'html5,flash,silverlight,html4',
	browse_button : 'selectfiles',
	//multi_selection: false,
	container : document.getElementById('container'),
	flash_swf_url : 'lib/plupload-2.1.2/js/Moxie.swf',
	silverlight_xap_url : 'lib/plupload-2.1.2/js/Moxie.xap',
	url : 'http://oss.aliyuncs.com',
	filters : {
		mime_types : [ // 只允许上传图片和zip,rar文件
			{
				title : "Test files",
				extensions : "txt"
			},],
		max_file_size : '50mb', // 最大只能上传10mb的文件
		prevent_duplicates : true
	// 不允许选取重复文件
	},

	init : {
		PostInit : function() {
			document.getElementById('ossfile').innerHTML = '';
			document.getElementById('postfiles').onclick = function() {
				set_upload_param(uploader, '', false);
				return false;
			};
		},

		FilesAdded : function(up, files) {
			plupload.each(files, function(file) {
				document.getElementById('ossfile').innerHTML += '<div id="' + file.id + '">' + file.name + ' (' + plupload.formatSize(file.size) + ')<b></b>'
					+ '<div class="progress"><div class="progress-bar" style="width: 0%"></div></div>'
					+ '</div>';
			});
		},

		BeforeUpload : function(up, file) {
			g_object_name_type = 'local_name';
			set_upload_param(up, file.name, true);
		},

		UploadProgress : function(up, file) {
			var d = document.getElementById(file.id);
			d.getElementsByTagName('b')[0].innerHTML = '<span>' + file.percent + "%</span>";
			var prog = d.getElementsByTagName('div')[0];
			var progBar = prog.getElementsByTagName('div')[0]
			progBar.style.width = 2 * file.percent + 'px';
			progBar.setAttribute('aria-valuenow', file.percent);
		},

		FileUploaded : function(up, file, info) {
			if (info.status == 200) {
				document.getElementById(file.id).getElementsByTagName('b')[0].innerHTML = '上传成功, 文件名:' + get_uploaded_object_name(file.name).replace(g_dirname, "");
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
uploader.init();