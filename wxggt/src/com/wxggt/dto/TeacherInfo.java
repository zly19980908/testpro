package com.wxggt.dto;

/*老师信息实体*/
public class TeacherInfo {
	private String tNo;
	private String tName;
	private String pwd;
	private String tSex;
	private String TeacherLicense;
	private String tDesc;
	private String tel;
	private String facePic;
	private String email;
	public TeacherInfo() {
		// TODO Auto-generated constructor stub
	}

	public TeacherInfo(String tNo, String tName, String pwd, String tSex,
			String teacherLicense, String tDesc, String tel, String facePic, String email) {
		super();
		this.tNo = tNo;
		this.tName = tName;
		this.pwd = pwd;
		this.tSex = tSex;
		this.TeacherLicense = teacherLicense;
		this.tDesc = tDesc;
		this.tel = tel;
		this.facePic = facePic;
		this.email = email;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFacePic() {
		return facePic;
	}

	public void setFacePic(String facePic) {
		this.facePic = facePic;
	}

}
