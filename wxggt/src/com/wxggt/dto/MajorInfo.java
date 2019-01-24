package com.wxggt.dto;
//专业信息
public class MajorInfo {

	private String Mno;
	private String mName;
	private String Desc;
	
	public MajorInfo(String Mno,String mName,String Desc) {
		this.Desc=Desc;
		this.mName=mName;
		this.Mno=Mno;
		
	}
	public String getMno() {
		return Mno;
	}
	public void setMno(String mno) {
		Mno = mno;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getDesc() {
		return Desc;
	}
	public void setDesc(String desc) {
		Desc = desc;
	}
	
	
}
