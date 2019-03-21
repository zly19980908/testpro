
/*饼状图*/
(function(){
	
var pie1 = echarts.init(document.getElementById("pie1"));

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
        data: ['课程','打赏','分红']
    },
    series : [
        {
            name: '访问来源',
            type: 'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[
                 {value:335, name:'课程'},
                 {value:310, name:'打赏'},
                 {value:234, name:'分红'}
               
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

pie1.setOption(option);
})();


/*----------------------柱状图-----------------------*/
//坐标轴刻度与标签对齐
(function(){
	
var columnar1 = echarts.init(document.getElementById("columnar1"));

option = {
	
	title: {
		text: "收入",
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
          data : ['周一', '周二', '周三', '周四', '周五', '周六', '周日'],
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
          name:'直接访问',
          type:'bar',
          barWidth: '60%',
          data:[10, 52, 200, 334, 390, 330, 220]
      }
  ]
};

columnar1.setOption(option);
})();