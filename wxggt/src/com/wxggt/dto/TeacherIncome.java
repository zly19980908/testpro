package com.wxggt.dto;

import java.util.Date;

public class TeacherIncome {
	private int tid;
	private String cno;
	private String Tno;
	private Date iDate;
	private int Sumary;
	private String Type;

	public TeacherIncome() {
		// TODO Auto-generated constructor stub
	}
	
	
	public TeacherIncome(int tid, String cno, String tno, Date iDate,
			int sumary, String type) {
		super();
		this.tid = tid;
		this.cno = cno;
		this.Tno = tno;
		this.iDate = iDate;
		this.Sumary = sumary;
		this.Type = type;
	}


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
