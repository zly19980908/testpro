
//动态数据+时间坐标轴
(function() {
//	alert("111");
	var trends = echarts.init(document.getElementById("trends"));
	function randomData() {
		now = new Date(+now + oneDay);
		value = value + Math.random() * 21 - 10;
		return {
			name : now.toString(),
			value : [
					[ now.getFullYear(), now.getMonth() + 1, now.getDate() ]
							.join('/'), Math.round(value) ]
		}
	}

	var data = [];
	var now = +new Date(1997, 9, 3);
	var oneDay = 24 * 3600 * 1000;
	var value = Math.random() * 1000;
	for (var i = 0; i < 1000; i++) {
		data.push(randomData());
	}

	option = {
		title : {
			text : '注册量统计'
		},
		tooltip : {
			trigger : 'axis',
			formatter : function(params) {
				params = params[0];
				var date = new Date(params.name);
				return date.getDate() + '/' + (date.getMonth() + 1) + '/'
						+ date.getFullYear() + ' : ' + params.value[1];
			},
			axisPointer : {
				animation : false
			}
		},
		xAxis : {
			type : 'time',
			splitLine : {
				show : false
			}
		},
		yAxis : {
			type : 'value',
			boundaryGap : [ 0, '100%' ],
			splitLine : {
				show : false
			}
		},
		series : [ {
			name : '模拟数据',
			type : 'line',
			showSymbol : false,
			hoverAnimation : false,
			data : data
		} ]
	};

	timeTicket = setInterval(function() {

		for (var i = 0; i < 5; i++) {
			data.shift();
			data.push(randomData());
		}

		trends.setOption({
			series : [ {
				data : data
			} ]
		});
	}, 1000);
	trends.setOption(option);
})();


(function(){
	
	var columnar1 = echarts.init(document.getElementById("page_view"));
	function randomData() {
		now = new Date(+now + oneDay);
		value = value + Math.random() * 21 - 10;
		return {
			name : now.toString(),
			value : [
					[ now.getFullYear(), now.getMonth() + 1, now.getDate() ]
							.join('/') ]
		}
	}

	var data = [];
	var now = +new Date(2018, 12, 3);
	var oneDay = 24 * 3600 * 1000;
	var value = Math.random() * 1000;
	for (var i = 0; i < 1000; i++) {
		data.push(randomData());
	}
	option = {
		
		title: {
			text: "访问量",
			x:'left'
		},
		
	  color: ['#3398DB'],
	  tooltip : {
	      trigger: 'axis',
	      axisPointer : {            // 坐标轴指示器，坐标轴触发有效
	          type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
	      }
	  },
	  toolbox: {
	      feature: {
	          saveAsImage: {}
	      }
	  },
	  grid: {
	      left: '3%',
	      right: '4%',
	      bottom: '3%',
	      containLabel: true
	  },
	  xAxis : [
	      {
	          type : 'category',
	          /*data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],*/
	          data : data,
	          axisTick: {
	              alignWithLabel: true
	          }
	      }
	  ],
	  yAxis : [
	      {
	          type : 'value'
	      }
	  ],
	  series : [
	      {
	          name:'微信访问',
	          type:'bar',
	          barWidth: '60%',
	          data:[10, 52, 200, 334, 390, 330, 220]
	      }
	  ]
	};

	columnar1.setOption(option);
})();

(function(){
	
	var earning = echarts.init(document.getElementById("earning"));

	option = {
	    title : {
	        text: '收益组成',
	        x:'center'
	    },
	    tooltip : {
	        trigger: 'item',
	        formatter: "{a} <br/>{b} : {c} ({d}%)"
	    },
	    toolbox: {
	        show : true,
	        feature : {
	            mark : {show: true},
	            dataView : {show: true, readOnly: false},
	            magicType : {
	                show: true,
	                type: ['pie', 'funnel']
	            },
	            restore : {show: true},
	            saveAsImage : {show: true}
	        }
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	        data: ['会员充值','缴纳押金','购买课程','视频广告','搜索引擎']
	    },
	    series : [
	        {
	            name: '访问来源',
	            type: 'pie',
	            radius : '55%',
	            center: ['50%', '60%'],
	            data:[
	                {value:335, name:'会员充值'},
	                {value:310, name:'缴纳押金'},
	                {value:234, name:'购买课程'},
	                {value:135, name:'视频广告'},
	                {value:1548, name:'搜索引擎'}
	            ],
	            itemStyle: {
	                emphasis: {
	                    shadowBlur: 10,
	                    shadowOffsetX: 0,
	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
	                }
	            }
	        }
	    ]
	};

	earning.setOption(option);
	})();
