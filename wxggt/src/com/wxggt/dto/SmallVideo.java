package com.wxggt.dto;

public class SmallVideo {
	private int svid;//小视频编号
	private String uid;//发布人编号
	private String uName;//发布人姓名
	private String video;//视频名
	private int Surname;//点赞量
	private int Pageview;//访问量
	private int Reward;//打赏金额
	private String sdescribe;//视频描述
	private String imageUrl;//视频封页路径
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getSvid() {
		return svid;
	}
	public void setSvid(int svid) {
		this.svid = svid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getVideo() {
		return video;
	}
	public void setVideo(String video) {
		this.video = video;
	}
	public int getSurname() {
		return Surname;
	}
	public void setSurname(int surname) {
		Surname = surname;
	}
	public int getPageview() {
		return Pageview;
	}
	public void setPageview(int pageview) {
		Pageview = pageview;
	}
	public int getReward() {
		return Reward;
	}
	public void setReward(int reward) {
		Reward = reward;
	}
	public String getSdescribe() {
		return sdescribe;
	}
	public void setSdescribe(String sdescribe) {
		this.sdescribe = sdescribe;
	}
}
