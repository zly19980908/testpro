package com.wxggt.dto;

import java.util.Date;

/*活动实体*/
public class Activity {
	private int Activityid;
	private String ActivityName;
	private String priceType;
	private String poster;
	private double discount;
	private int scopeType;
	private int Typeid;
	
	private Date startTime;
	private Date endTime;
	public Activity() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Activity( String activityName, String priceType,
			String poster, double discount, int scopeType, int typeid,Date start,Date end) {
		super();
		//Activityid = activityid;
		ActivityName = activityName;
		this.priceType = priceType;
		this.poster = poster;
		this.discount = discount;
		this.scopeType = scopeType;
		Typeid = typeid;
		this.startTime=start;
		this.endTime=end;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getEndTime() {
		return endTime;
	}


	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}


	public int getActivityid() {
		return Activityid;
	}

	public void setActivityid(int activityid) {
		Activityid = activityid;
	}

	public String getActivityName() {
		return ActivityName;
	}

	public void setActivityName(String activityName) {
		ActivityName = activityName;
	}

	public String getPriceType() {
		return priceType;
	}

	public void setPriceType(String priceType) {
		this.priceType = priceType;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getScopeType() {
		return scopeType;
	}

	public void setScopeType(int scopeType) {
		this.scopeType = scopeType;
	}

	public int getTypeid() {
		return Typeid;
	}

	public void setTypeid(int typeid) {
		Typeid = typeid;
	}

}
