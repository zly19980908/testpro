package com.wxggt.dto;

import java.util.Date;

public class Reward {
	private int RewardId;//�������������ͱ��
	private int Targetid;//Ŀ����
	private String Uid;//�����˱��
	private int Money;//���ͽ��
	private Date Rtime;//����ʱ��
	public int getTargetid() {
		return Targetid;
	}
	public void setTargetid(int targetid) {
		Targetid = targetid;
	}
	public String getUid() {
		return Uid;
	}
	public void setUid(String uid) {
		Uid = uid;
	}
	public int getMoney() {
		return Money;
	}
	public void setMoney(int money) {
		Money = money;
	}
	public Date getRtime() {
		return Rtime;
	}
	public void setRtime(Date rtime) {
		Rtime = rtime;
	}
	public Reward(){
		
	}
	public Reward(int targetid, String uid, int money) {
		super();
		Targetid = targetid;
		Uid = uid;
		Money = money;
	}
}
