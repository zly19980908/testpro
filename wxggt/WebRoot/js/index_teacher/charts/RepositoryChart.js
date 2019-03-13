(function() {
	var myChart_1 = echarts.init(document.getElementById("widget-chart-box-1"));
	var myChart_2 = echarts.init(document.getElementById("widget-chart-box-2"));
	var myChart_3 = echarts.init(document.getElementById("widget-chart-box-3"));
	var myChart_4 = echarts.init(document.getElementById("widget-chart-box-4"));
	var myChart_5 = echarts.init(document.getElementById("widget-chart-box-5"));

	var labelTop = {
		normal : {
			color:'#61bfbf',
			label : {
				show : true,
				position : 'center',
				formatter : '{b}',
				textStyle : {
					baseline : 'bottom'
				}
			},
			labelLine : {
				show : false
			}
		}
	};
	var labelFromatter = {
		normal : {
			color:'#61bfbf',
			label : {
				formatter : function(params) {
					return 100 - params.value + '%';
				},
				textStyle : {
					/*这里设置圆内文字颜色*/
					color:'#61bfbf',
					baseline : 'center'
				}
			}
		},
	};
	var labelBottom = {
		normal : {
			color : '#ccc',
			label : {
				show : true,
				position : 'center'
			},
			labelLine : {
				show : false
			}
		},
		emphasis : {
			color : '#ccc'
		}
	};
	var radius = [ 40, 35 ];
	function getOption(rate){
		option = {
				legend : {
					x : 'center',
					y : 'center',
				},

				grid : {
					x : 0,
					y : 0,
					x2 : 0,
					y2 : 0
				},

				toolbox : {
					show : true,
					feature : {
						magicType : {
							show : true,
							type : [ 'pie', 'funnel' ],
							option : {
								funnel : {
									width : '20%',
									height : '30%',
									itemStyle : {
										normal : {
											label : {
												formatter : function(params) {
													return 'other\n' + params.value + '%\n';
												},
												textStyle : {
													baseline : 'middle'
												}
											}
										},
									}
								}
							}
						}
					}
				},
				series : [
					{
						type : 'pie',
						radius : radius,
						x : '0%', // for funnel
						itemStyle : labelFromatter,
						data : [
							{
								name : '正确率',
								value : rate,
								itemStyle : labelTop
							},
							{
								name : 'other',
								value : 100-rate,
								itemStyle : labelBottom
							}
							
						]
					}

				],
				animation : false
			};
		return option;
	}
	
	myChart_1.setOption(getOption(54));
	myChart_2.setOption(getOption(60));
	myChart_3.setOption(getOption(30));
	myChart_4.setOption(getOption(40));
	myChart_5.setOption(getOption(70));
	
})();