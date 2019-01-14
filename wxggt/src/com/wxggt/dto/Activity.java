package com.wxggt.dto;

/*活动实体*/
public class Activity {
	private int Activityid;
	private String ActivityName;
	private String priceType;
	private String poster;
	private double discount;
	private int scopeType;
	private int Typeid;

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
