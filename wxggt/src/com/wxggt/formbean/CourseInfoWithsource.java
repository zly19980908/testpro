package com.wxggt.formbean;

import java.util.List;

import com.wxggt.dto.SourceInfo;

/*一门课程带有一个视频集的信息*/
public class CourseInfoWithsource {
	private String cNo;
	private String cName;
	private String tNo;
	private int pageview;
	private int Studyquantity;
	private int Price;
	private int Specialtyid;
	private String courseDesc;
	private List<SourceInfo> sources;

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public int getPageview() {
		return pageview;
	}

	public void setPageview(int pageview) {
		this.pageview = pageview;
	}

	public int getStudyquantity() {
		return Studyquantity;
	}

	public void setStudyquantity(int studyquantity) {
		Studyquantity = studyquantity;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}

	public int getSpecialtyid() {
		return Specialtyid;
	}

	public void setSpecialtyid(int specialtyid) {
		Specialtyid = specialtyid;
	}

	public String getCourseDesc() {
		return courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		this.courseDesc = courseDesc;
	}

	public List<SourceInfo> getSources() {
		return sources;
	}

	public void setSources(List<SourceInfo> sources) {
		this.sources = sources;
	}

}
