package com.wxggt.dto;

import java.util.Date;

public class Sound {
	private int soundId;
	private String uName;
	private String soundPath;
	private int surname;
	private int pageview;
	private int reward;
	private String uploadid;
	private Date sTime;
	private String sDescribe;
	private String title;

	public int getSoundId() {
		return soundId;
	}

	public void setSoundId(int soundId) {
		this.soundId = soundId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getSoundPath() {
		return soundPath;
	}

	public void setSoundPath(String soundPath) {
		this.soundPath = soundPath;
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

	public String getUploadid() {
		return uploadid;
	}

	public void setUploadid(String uploadid) {
		this.uploadid = uploadid;
	}

	public Date getsTime() {
		return sTime;
	}

	public void setsTime(Date sTime) {
		this.sTime = sTime;
	}

	public String getsDescribe() {
		return sDescribe;
	}

	public void setsDescribe(String sDescribe) {
		this.sDescribe = sDescribe;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
