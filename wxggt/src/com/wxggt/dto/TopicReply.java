package com.wxggt.dto;

import java.util.Date;

public class TopicReply {
	private int ToprId;//评论编号
	private int topicId;//评论对应的话题编号
	private String uid;//评论者编号
	private String uName;//评论者姓名
	private String Reply;//评论内容
	private String Type;//类型
	private Date openTime;//评论时间
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
