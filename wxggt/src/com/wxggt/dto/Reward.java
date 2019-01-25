package com.wxggt.dto;

import java.util.Date;

public class Reward {
	private int RewardId;//代理主键，打赏编号
	private int Targetid;//目标编号
	private String Uid;//打赏人编号
	private int Money;//打赏金额
	private Date Rtime;//打赏时间
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
