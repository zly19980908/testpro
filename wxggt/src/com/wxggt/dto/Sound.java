package com.wxggt.dto;

import java.util.Date;

public class Sound {
	private int soundId;//音频编号
	private String uName;//发布人姓名
	private String soundPath;//音频路径
	private int surname;//点赞量
	private int pageview;//访问量
	private int reward;//打赏金额
	private String uploadid;//上传者编号
	private Date sTime;//发布时间
	private String sDescribe;//音频描述
	private String title;//标题
	private String imageUrl;//音频封页路径

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

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
