package com.wxggt.dto;

import java.util.Date;

public class SourceInfo {
	private int id;
	private String cNo;
	private String sourceName;
	private String sourceSort;
	private int sourceTime;
	private Date downloadDate;
	private String sourceOrgin;
	private int sourceId;
	private int isMajorType;
	private String sourceDesc;

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

	public int getIsMajorType() {
		return isMajorType;
	}

	public void setIsMajorType(int isMajorType) {
		this.isMajorType = isMajorType;
	}

	public String getSourceDesc() {
		return sourceDesc;
	}

	public void setSourceDesc(String sourceDesc) {
		this.sourceDesc = sourceDesc;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
