package com.wxggt.dto;

public class SmallVideo {
	private int svid;//С��Ƶ���
	private String uid;//�����˱��
	private String uName;//����������
	private String video;//��Ƶ��
	private int Surname;//������
	private int Pageview;//������
	private int Reward;//���ͽ��
	private String sdescribe;//��Ƶ����
	private String imageUrl;//��Ƶ��ҳ·��
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
