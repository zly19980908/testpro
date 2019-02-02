!(function(window, document) {
	function GVerify(options) { //创建一个图形验证码对象，接收options对象为参数
		this.options = { //默认options参数值
			id : "", //容器Id
			canvasId : '', //canvas的ID
			width : "", //默认canvas宽度
			height : "", //默认canvas高度
			type : "blend", //图形验证码默认类型blend:数字字母混合类型、number:纯数字、letter:纯字母
			code : ""
		};

		if (Object.prototype.toString.call(options) == "[object Object]") { //判断传入参数类型
			for (var i in options) { //根据传入的参数，修改默认参数值
				this.options[i] = options[i];
			}
		} else { //传入单个对象就是id
			this.options.id = options;
		}
		this.options.numArr = "0,1,2,3,4,5,6,7,8,9".split(","); //数字
		this.options.letterArr = getAllLetter(); //生成字母数组
		this._init(); //初始化
		this.refresh(); //生成验证码
	}

	GVerify.prototype = {
		/**版本号**/
		version : '1.0.0',

		/**初始化方法**/
		_init : function() {
			var con = document.getElementById(this.options.id);
			var canvas = document.getElementById(this.options.canvasId); //获得画布   IE不能支持canvas，可以增加excanvas.js插件，但是还是不支持createelement()的形式
			//如果有宽度就使用自己的，没有就默认100
			//this.options.width = con.offsetWidth > 0 ? con.offsetWidth : "100";
			//如果有长度就使用自己的，没有就默认30
			//this.options.height = con.offsetHeight > 0 ? con.offsetHeight : "30";
			/*让验证码铺满画布*/
			this.options.width = 300;
			this.options.height = 150;
			var parent = this; //把this赋值parent
			//验证码点击切换刷新
			canvas.onclick = function() {
				parent.refresh();
			};
		},

		/**生成验证码**/
		refresh : function() {
			this.options.code = ""; //定义验证码为""
			var canvas = document.getElementById(this.options.canvasId); //获得验证码画布
			if (canvas.getContext) { //
				var ctx = canvas.getContext('2d'); //获得绘画对象
			} else { //
				return;
			}
			ctx.textBaseline = "middle";
			ctx.fillStyle = randomColor(180, 240);
			//ctx.roundRect(0, 0, this.options.width, this.options.height, 10 * 1 || 0);
			ctx.fillRect(0, 0, this.options.width, this.options.height); //绘制矩形  
			/* x:矩形起点横坐标（坐标原点为canvas的左上角，当然确切的来说是原始原点，后面写到变形的时候你就懂了，现在暂时不用关系）
			 y:矩形起点纵坐标
			 width:矩形长度
			 height:矩形高度*/
			if (this.options.type == "blend") { //判断验证码类型 blend:数字字母混合类型、number:纯数字、letter:纯字母
				var txtArr = this.options.numArr
					.concat(this.options.letterArr);
			} else if (this.options.type == "number") {
				var txtArr = this.options.numArr;
			} else {
				var txtArr = this.options.letterArr;
			}
			for (var i = 1; i <= 4; i++) {
				var txt = txtArr[randomNum(0, txtArr.length)]; //取得一个字符
				this.options.code += txt; //连接验证码
				ctx.font = randomNum(this.options.height / 2,
						this.options.height)
					+ 'px SimHei'; //随机生成字体大小
				ctx.fillStyle = randomColor(50, 160); //填充的样式 随机生成字体颜色        
				ctx.shadowOffsetX = randomNum(-3, 3); //阴影的横向位移量
				ctx.shadowOffsetY = randomNum(-3, 3); //阴影的纵向位移量
				ctx.shadowBlur = randomNum(-3, 3); //阴影的模糊范围（值越大越模糊）
				ctx.shadowColor = "rgba(0, 0, 0, 0.3)"; //阴影的颜色
				var x = this.options.width / 5 * i;
				var y = this.options.height / 2;
				var deg = randomNum(-30, 30);
				/**设置旋转角度和坐标原点
				 * 
				 *  平移context.translate(x,y)
				 *    x:坐标原点向x轴方向平移x
				 *    y:坐标原点向y轴方向平移y
				 * 
				 * **/
				ctx.translate(x, y);
				ctx.rotate(deg * Math.PI / 180); //旋转context.rotate(angle)
				ctx.fillText(txt, 0, 0); //context.fillText(text,x,y)  
				/**恢复旋转角度和坐标原点**/
				ctx.rotate(-deg * Math.PI / 180);
				ctx.translate(-x, -y);
			}
			/**绘制干扰线**/
			for (var i = 0; i < 4; i++) {
				ctx.strokeStyle = randomColor(40, 180); //随机颜色
				ctx.beginPath(); //路径  context.beginPath()
				ctx.moveTo(randomNum(0, this.options.width), randomNum(0, this.options.height)); //绘制线段 context.moveTo(x,y)  context.lineTo(x,y)
				ctx.lineTo(randomNum(0, this.options.width), randomNum(0, this.options.height));
				ctx.stroke();
			}
			/**绘制干扰点**/
			for (var i = 0; i < this.options.width / 4; i++) {
				ctx.fillStyle = randomColor(0, 255);
				ctx.beginPath();
				// 圆弧context.arc(x, y, radius, starAngle,endAngle, anticlockwise)
				ctx.arc(randomNum(0, this.options.width), randomNum(0, this.options.height), 1, 0, 2 * Math.PI);
				ctx.fill();
			}
		},

		/**验证验证码**/
		validate : function(code) {
			var code = code.toLowerCase();
			var v_code = this.options.code.toLowerCase();
			if (code == v_code) {
				return true;
			} else {
				this.refresh();
				return false;
			}
		}
	};
	/**生成字母数组**/
	function getAllLetter() {
		var letterStr = "a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z,A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
		return letterStr.split(",");
	}
	/**生成一个随机数**/
	function randomNum(min, max) {
		return Math.floor(Math.random() * (max - min) + min);
	}
	/**生成一个随机色**/
	function randomColor(min, max) {
		var r = randomNum(min, max);
		var g = randomNum(min, max);
		var b = randomNum(min, max);
		return "rgb(" + r + "," + g + "," + b + ")";
	}
	window.GVerify = GVerify; //设置为window对象
})(window, document);

/*----------------------------------------分割线----------------------------------------*/

/*第一个canvas选项对象*/
options_1 = { //默认options参数值
	id : "", //容器Id
	canvasId : 'verifyCanvas_1', //canvas的ID
	width : "", //默认canvas宽度
	height : "", //默认canvas高度
	type : "blend", //图形验证码默认类型blend:数字字母混合类型、number:纯数字、letter:纯字母
	code : ""
};

var verifyCode_1 = new GVerify(options_1);
/*校验教师登录的验证码*/
function verify_1() {
	var flag_id;
	var flag_pwd;
	var flag_code;
	if ($("#t_id").attr('class') == 'right') {
		flag_id = true;
	} else {
		flag_id = false;
	}
	if ($("#t_pwd").attr('class') == 'right') {
		flag_pwd = true;
	} else {
		flag_pwd = false;
	}
	if ($("#code_input_1").attr('class') == 'right') {
		flag_code = true;
	} else {
		flag_code = false;
	}
	var res = verifyCode_1.validate($("#code_input_1").val());
	if (flag_id && flag_pwd && flag_code && res) {
		$("#code_input_1").val('')
		alert('校验成功');
		return true;
	} else {
		$("#code_input_1").val('')
		/*这里为了登录方便，直接返回true*/
		alert('输入信息有误,请重新输入');
		return false;
	}
}
;

/*第二个canvas选项对象*/
options_2 = { //默认options参数值
	id : "", //容器Id
	canvasId : 'verifyCanvas_2', //canvas的ID
	width : "", //默认canvas宽度
	height : "", //默认canvas高度
	type : "blend", //图形验证码默认类型blend:数字字母混合类型、number:纯数字、letter:纯字母
	code : ""
};
var verifyCode_2 = new GVerify(options_2);
function verify_2() {
	var flag_id;
	var flag_pwd;
	var flag_code;
	if ($("#a_id").attr('class') == 'right') {
		flag_id = true;
	} else {
		flag_id = false;
	}
	if ($("#a_pwd").attr('class') == 'right') {
		flag_pwd = true;
	} else {
		flag_pwd = false;
	}
	if ($("#code_input_2").attr('class') == 'right') {
		flag_code = true;
	} else {
		flag_code = false;
	}
	var res = verifyCode_2.validate($("#code_input_2").val());
	if (flag_id && flag_pwd && flag_code && res) {
		$("#code_input_2").val('')
		alert('校验成功');
		return true;
	} else {
		$("#code_input_2").val('')
		/*这里为了登录方便，直接返回true*/
		alert('输入信息有误,请重新输入');
		return false;
	}
}
;