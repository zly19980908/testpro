package com.wxggt.dto;

import java.util.Date;

public class SourceInfo {
	private String sourceName;
	private String sourceSort;
	private int sourceTime;
	private Date downloadDate;
	private String sourceOrgin;
	private int sourceId;
	private String isMajorType;
	
	public String getSourceName() {
		return sourceName;
	}
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
	public String getSourceSort() {
		return sourceSort;
	}
	public void setSourceSort(String sourceSort) {
		this.sourceSort = sourceSort;
	}
	public int getSourceTime() {
		return sourceTime;
	}
	public void setSourceTime(int sourceTime) {
		this.sourceTime = sourceTime;
	}
	public Date getDownloadDate() {
		return downloadDate;
	}
	public void setDownloadDate(Date downloadDate) {
		this.downloadDate = downloadDate;
	}
	public String getSourceOrgin() {
		return sourceOrgin;
	}
	public void setSourceOrgin(String sourceOrgin) {
		this.sourceOrgin = sourceOrgin;
	}
	public int getSourceId() {
		return sourceId;
	}
	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getIsMajorType() {
		return isMajorType;
	}
	public void setIsMajorType(String isMajorType) {
		this.isMajorType = isMajorType;
	}

	
}
