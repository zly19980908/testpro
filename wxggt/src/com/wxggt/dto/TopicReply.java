package com.wxggt.dto;

import java.util.Date;

public class TopicReply {
	private int ToprId;//���۱��
	private int topicId;//���۶�Ӧ�Ļ�����
	private String uid;//�����߱��
	private String uName;//����������
	private String Reply;//��������
	private String Type;//����
	private Date openTime;//����ʱ��
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getTopicId() {
		return topicId;
	}
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getReply() {
		return Reply;
	}
	public void setReply(String reply) {
		Reply = reply;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public Date getOpenTime() {
		return openTime;
	}
	public void setOpenTime(Date openTime) {
		this.openTime = openTime;
	}
	public TopicReply(){
		
	}
	public TopicReply(int topicId, String uid,String uName, String reply, String type) {
		super();
		this.topicId = topicId;
		this.uid = uid;
		this.uName = uName;
		Reply = reply;
		Type = type;
	}
}
