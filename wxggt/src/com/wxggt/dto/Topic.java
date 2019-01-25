package com.wxggt.dto;

import java.util.Date;

public class Topic {
	private int topicId;//话题编号，代理主键
	private String initiator;//话题发起人
	private String TopicDetail;//话题内容
	private int Pv;//话题评论量
	private Date openTime;//话题发起时间
	private String cNo;//话题相关课程编号
	private int pageview;//话题访问量
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
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
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
	public Topic(String initiator, String topicDetail, String cNo) {
		super();
		this.initiator = initiator;
		TopicDetail = topicDetail;
		this.cNo = cNo;
	}
}
