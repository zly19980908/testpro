package com.wxggt.util;

import java.util.Calendar;

public class CreateCno {
	/*��һλ��רҵ�ţ��м���λ���쵽���ƴ�ӣ�����λ�������*/
	public static String CreateCno_(int specialtyid){
		String cno="";
		Calendar cal = Calendar.getInstance();
		int d = cal.get(Calendar.DATE)+10;
		int h = cal.get(Calendar.HOUR_OF_DAY)+10;
		int mi = cal.get(Calendar.MINUTE)+10;
		int s = cal.get(Calendar.SECOND)+10;
		int num=(int)(Math.random()*900+100);
		cno=""+specialtyid+d+h+mi+s+num;
		return cno;
	}

	public static void main(String[] args) {
		String cno=CreateCno.CreateCno_(1);
		System.out.println(cno);
	}

}
