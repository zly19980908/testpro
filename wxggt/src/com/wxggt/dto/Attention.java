package com.wxggt.dto;

import java.util.Date;

public class Attention {
	private int attentionId;//��ע��ţ���������
	private String Uid;//��˿���
	private String attendUid;//��עĿ����
	private Date createTime;//��עʱ��
	private int fensCount;//��˿��
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
