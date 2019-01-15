package com.wxggt.dto;

import java.util.Date;

/*学生信息实体*/
public class StudentInfo {
	private String sNo;
	private String sName;
	private String sTel;
	private String sSex;
	private String sBir;
	private int UploadPower;
	private Date FreezeDate;
	private int Vip;
	private int balance;
	private Date registerDate;

	public String getsNo() {
		return sNo;
	}

	public void setsNo(String sNo) {
		this.sNo = sNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsSex() {
		return sSex;
	}

	public void setsSex(String sSex) {
		this.sSex = sSex;
	}

	public String getsBir() {
		return sBir;
	}

	public void setsBir(String sBir) {
		this.sBir = sBir;
	}

	public int getUploadPower() {
		return UploadPower;
	}

	public void setUploadPower(int uploadPower) {
		UploadPower = uploadPower;
	}

	public Date getFreezeDate() {
		return FreezeDate;
	}

	public void setFreezeDate(Date freezeDate) {
		FreezeDate = freezeDate;
	}

	public int getVip() {
		return Vip;
	}

	public void setVip(int vip) {
		Vip = vip;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

}
