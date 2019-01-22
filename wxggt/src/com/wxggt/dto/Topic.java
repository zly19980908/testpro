package com.wxggt.dto;

import java.util.Date;

public class Topic {
	private int topicId;
	private String initiator;
	private String TopicDetail;
	private int Pv;
	private Date openTime;
	private String cNo;
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
}
