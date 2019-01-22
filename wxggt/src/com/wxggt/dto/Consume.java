package com.wxggt.dto;

import java.util.Date;

public class Consume {
	private int consumeid;
	private String Uid;
	private int Money;
	private Date consumetime;
	private String Type;
	private int Costid;
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
	public Date getConsumetime() {
		return consumetime;
	}
	public void setConsumetime(Date consumetime) {
		this.consumetime = consumetime;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public int getCostid() {
		return Costid;
	}
	public void setCostid(int costid) {
		Costid = costid;
	}
	public Consume (){
		
	}
	public Consume(String uid, int money, String type, int costid) {
		super();
		Uid = uid;
		Money = money;
		Type = type;
		Costid = costid;
	}
}
