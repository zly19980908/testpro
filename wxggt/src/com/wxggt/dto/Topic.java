package com.wxggt.dto;

import java.util.Date;

public class Topic {
	private int topicId;//�����ţ���������
	private String initiator;//���ⷢ����
	private String TopicDetail;//��������
	private int Pv;//����������
	private Date openTime;//���ⷢ��ʱ��
	private String cNo;//������ؿγ̱��
	private int pageview;//���������
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
