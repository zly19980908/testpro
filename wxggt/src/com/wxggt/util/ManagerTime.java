package com.wxggt.util;

public class ManagerTime {
	public String jisuanTime(Long second){
		//�洫����ַ���
		String time = null;
		//���С��һ������ʾ��
		if(second<60){
			time = second.toString()+"��";
		}else if(second>=60 && second<3600){//ʱ�䳬��һ���ӵ�С��һСʱ��ʾСʱ
			second = second/60;
			time = second.toString()+"����";
		}else{
			second = second/3600;//����Сʱ
			if(second<24){
				time = second.toString()+"Сʱ";
			}else{
				second = second/24;//������
				time = second.toString()+"��";
			}
		}
		return time;
	}
}
