package com.wxggt.action;

import java.io.File;

import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.CourseDAO;
import com.wxggt.dto.Course;
import com.wxggt.util.UploadTool;

public class CreateCourseAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String cname;
    private String tname;
    private String cno;
    private String cintro;
    private int price;
    private File file;
    private String filename;

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        String imgUri = UploadTool.upload(getCno(), getFilename());
        CourseDAO cdao = new CourseDAO();
        Course c = new Course();
        c.setcName(getCname());
        c.settName(getTname());
        c.setCourseDesc(getCintro());
        c.setImageUrl("dodood");
        c.setPrice(getPrice());
        c.setSpecialtyid(38202);
        if (cdao.createCourse(c)) {
            return SUCCESS;
        }
        return ERROR;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    public String getCintro() {
        return cintro;
    }

    public void setCintro(String cintro) {
        this.cintro = cintro;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

}
