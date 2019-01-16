package com.wxggt.formbean;

public class AccessCount_ByMonth {
	private int aid;
	private String year_;
	private String month_;
	
	public String getYear_() {
		return year_;
	}

	public void setYear_(String year_) {
		this.year_ = year_;
	}

	public String getMonth_() {
		return month_;
	}

	public void setMonth_(String month_) {
		this.month_ = month_;
	}

	private int accessCount;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public int getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}

}
