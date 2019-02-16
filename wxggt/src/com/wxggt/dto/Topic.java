package com.wxggt.dto;

import java.util.Date;

public class Topic {
	private int topicId;//�����ţ���������
	private String uid;//���ⷢ���˱��
	private String initiator;//���ⷢ����
	private String TopicDetail;//��������
	private int Pv;//����������
	private String openTime;//���ⷢ��ʱ��
	private String cNo;//������ؿγ̱��
	private int pageview;//���������
	private int liked;//������
	private int share;//������
	private String title;//�������
	private String imageUrl;//��������ͼƬ·��
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public int getLiked() {
		return liked;
	}
	public void setLike(int liked) {
		this.liked = liked;
	}
	public int getShare() {
		return share;
	}
	public void setShare(int share) {
		this.share = share;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public int getPageview() {
		return pageview;
	}
	public void setPageview(int pageview) {
		this.pageview = pageview;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getInitiator() {
		return initiator;
	}
	public void setInitiator(String initiator) {
		this.initiator = initiator;
	}
	public String getTopicDetail() {
		return TopicDetail;
	}
	public void setTopicDetail(String topicDetail) {
		TopicDetail = topicDetail;
	}
	public int getPv() {
		return Pv;
	}
	public void setPv(int pv) {
		Pv = pv;
	}
	public String getOpenTime() {
		return openTime;
	}
	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}
	public String getcNo() {
		return cNo;
	}
	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	public Topic(){
		
	}
	public Topic(String initiator,String uid, String title, String topicDetail, String cNo) {
		super();
		this.initiator = initiator;
		this.uid = uid;
		this.title = title;
		TopicDetail = topicDetail;
		this.cNo = cNo;
	}
	public Topic(String initiator,String uid, String title, String topicDetail, String cNo,String imageUrl) {
		super();
		this.initiator = initiator;
		this.uid = uid;
		this.title = title;
		TopicDetail = topicDetail;
		this.cNo = cNo;
		this.imageUrl = imageUrl;
	}
}
