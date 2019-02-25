package com.wxggt.dto;

public class Course {
    private String cNo;
    private String cName;
    private String tNo;
    private int pageview = 0;
    private int Studyquantity = 0;
    private int Price;
    private int Specialtyid;
    private String courseDesc;
    private String tName;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

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

}
