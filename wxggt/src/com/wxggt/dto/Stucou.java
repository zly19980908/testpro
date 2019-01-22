package com.wxggt.dto;

import java.util.Date;

public class Stucou {
	private String sNo;
	private String cNo;
	private int grate;
	private Date selectTime;
	public String getsNo() {
		return sNo;
	}
	public void setsNo(String sNo) {
		this.sNo = sNo;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public int getGrate() {
		return grate;
	}
	public void setGrate(int grate) {
		this.grate = grate;
	}
	public Date getSelectTime() {
		return selectTime;
	}
	public void setSelectTime(Date selectTime) {
		this.selectTime = selectTime;
	}
}
