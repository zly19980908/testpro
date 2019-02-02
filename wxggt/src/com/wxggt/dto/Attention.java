package com.wxggt.dto;

import java.util.Date;

public class Attention {
	private int attentionId;//关注编号，代理主键
	private String Uid;//粉丝编号
	private String attendUid;//关注目标编号
	private Date createTime;//关注时间
	private int fensCount;//粉丝数
	public int getFensCount() {
		return fensCount;
	}
	public void setFensCount(int fensCount) {
		this.fensCount = fensCount;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public String getAttendUid() {
		return attendUid;
	}
	public void setAttendUid(String attendUid) {
		this.attendUid = attendUid;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Attention(){
		
	}
	public Attention(String uid, String attendUid) {
		super();
		Uid = uid;
		this.attendUid = attendUid;
	}
}
