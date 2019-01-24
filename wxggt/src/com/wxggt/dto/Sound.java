package com.wxggt.dto;

import java.util.Date;

public class Sound {
	private int soundId;
	private String uId;
	private String sound;
	private int surname;
	private int pageview;
	private int reward;
	private int Uploadid;
	private Date sTime;
	private String describe;
	private String title;

	public int getSoundId() {
		return soundId;
	}

	public void setSoundId(int soundId) {
		this.soundId = soundId;
	}

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getSound() {
		return sound;
	}

	public void setSound(String sound) {
		this.sound = sound;
	}

	public int getSurname() {
		return surname;
	}

	public void setSurname(int surname) {
		this.surname = surname;
	}

	public int getPageview() {
		return pageview;
	}

	public void setPageview(int pageview) {
		this.pageview = pageview;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}

	public int getUploadid() {
		return Uploadid;
	}

	public void setUploadid(int uploadid) {
		Uploadid = uploadid;
	}

	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
