package com.wxggt.dto;

/*临时老师信息实体*/
public class TempTeacherInfo {
	private String tNo;
	private String tName;
	private String tSex;
	private String TeacherLicense;
	private String tDesc;

	public TempTeacherInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public TempTeacherInfo(String tNo, String tName, String tSex,
			String teacherLicense, String tDesc) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.tSex = tSex;
		this.TeacherLicense = teacherLicense;
		this.tDesc = tDesc;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public String gettName() {
		return tName;
	}

	public void settName(String tName) {
		this.tName = tName;
	}

	public String gettSex() {
		return tSex;
	}

	public void settSex(String tSex) {
		this.tSex = tSex;
	}

	public String getTeacherLicense() {
		return TeacherLicense;
	}

	public void setTeacherLicense(String teacherLicense) {
		TeacherLicense = teacherLicense;
	}

	public String gettDesc() {
		return tDesc;
	}

	public void settDesc(String tDesc) {
		this.tDesc = tDesc;
	}

}
