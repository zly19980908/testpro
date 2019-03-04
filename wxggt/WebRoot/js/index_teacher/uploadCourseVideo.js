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

/*----------------------------------------------------------------------------------------------*/
// uploader.init();
