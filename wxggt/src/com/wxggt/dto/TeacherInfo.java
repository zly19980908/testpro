package com.wxggt.dto;

/*��ʦ��Ϣʵ��*/
public class TeacherInfo {
	private String tNo;
	private String pwd;
	private String tName;
	private String tSex;
	private String TeacherLicense;
	private String tDesc;
	private String facePic;

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getFacePic() {
		return facePic;
	}

	public void setFacePic(String facePic) {
		this.facePic = facePic;
	}

}
