package com.wxggt.util;

public class ManagerTime {
	public String jisuanTime(Long second){
		//存传输的字符串
		String time = null;
		//如果小于一分钟显示秒
		if(second<60){
			time = second.toString()+"秒";
		}else if(second>=60 && second<3600){//时间超过一分钟但小于一小时显示小时
			second = second/60;
			time = second.toString()+"分钟";
		}else{
			second = second/3600;//化成小时
			if(second<24){
				time = second.toString()+"小时";
			}else{
				second = second/24;//化成天
				time = second.toString()+"天";
			}
		}
		return time;
	}
}
