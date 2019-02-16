package com.wxggt.dto;

import java.util.Date;

public class Topic {
	private int topicId;//话题编号，代理主键
	private String uid;//话题发起人编号
	private String initiator;//话题发起人
	private String TopicDetail;//话题内容
	private int Pv;//话题评论量
	private String openTime;//话题发起时间
	private String cNo;//话题相关课程编号
	private int pageview;//话题访问量
	private int liked;//点赞量
	private int share;//分享量
	private String title;//话题标题
	private String imageUrl;//话题内容图片路径
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
