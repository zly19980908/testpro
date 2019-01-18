package com.wxggt.dto;

import java.util.Date;

public class TeacherIncome {
	private int tid;
	private String cno;
	private String Tno;
	private Date iDate;
	private int iSumary;
	private String iType;

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

	public int getiSumary() {
		return iSumary;
	}

	public void setiSumary(int iSumary) {
		this.iSumary = iSumary;
	}

	public String getiType() {
		return iType;
	}

	public void setiType(String iType) {
		this.iType = iType;
	}

}
