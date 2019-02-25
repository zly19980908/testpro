package com.wxggt.util;

import java.util.Calendar;

public class TeacherNo {
	//1开头，中间6位为时分秒，最后一位随机
	public static String createTeacherNumber(){
		String tno="1";
		Calendar cal = Calendar.getInstance();
		//int d = cal.get(Calendar.DATE)+10;
		int h = cal.get(Calendar.HOUR_OF_DAY)+10;
		int mi = cal.get(Calendar.MINUTE)+10;
		int s = cal.get(Calendar.SECOND)+10;
		int num=(int)(Math.random()*900+100);
		tno="1"+h+mi+s+num;
		return tno;
	}
	
	public static void main(String[] args) {
		String cno=TeacherNo.createTeacherNumber();
		System.out.println(cno);
	}
}
