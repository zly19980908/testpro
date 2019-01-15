package com.wxggt.dto;

import java.util.Date;

public class TeacherIncome {
	private int tid;
	private String cno;
	private String Tno;
	private Date iDate;
	private int Sumary;
	private String Type;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getCno() {
		return cno;
	}

	public void setCno(String cno) {
		this.cno = cno;
	}

	public String getTno() {
		return Tno;
	}

	public void setTno(String tno) {
		Tno = tno;
	}

	public Date getiDate() {
		return iDate;
	}

	public void setiDate(Date iDate) {
		this.iDate = iDate;
	}

	public int getSumary() {
		return Sumary;
	}

	public void setSumary(int sumary) {
		Sumary = sumary;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

}
