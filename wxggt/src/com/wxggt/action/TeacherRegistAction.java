package com.wxggt.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.TeacherInfoDAO;
import com.wxggt.dao.TempTeacherInfoDAO;
import com.wxggt.dto.TeacherInfo;
import com.wxggt.dto.TempTeacherInfo;
import com.wxggt.util.TeacherNo;
import com.wxggt.util.UploadTool;

public class TeacherRegistAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private String username;
    private String password;
    private String email;
    private String intro;
    private String phone;
    private String sex;
    private String filename;

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        TempTeacherInfo tmp = new TempTeacherInfo();
        String tno = TeacherNo.createTeacherNumber();
        String uri = UploadTool.upload(tno, getFilename());
        tmp.settNo(tno);
        tmp.settName(getUsername());
        tmp.settDesc(getIntro());
        tmp.settSex(getSex());
        tmp.setTeacherLicense("../../upload/headFace/" + tno + "/" + uri);
        System.out.println("路径:../../upload/headFace/" + tno + "/" + uri);
        TempTeacherInfoDAO t = new TempTeacherInfoDAO();
        if (t.tmpTeacher(tmp)) {
            TeacherInfoDAO tdao = new TeacherInfoDAO();
            TeacherInfo tea = new TeacherInfo(tno, getUsername(), getPassword(), getSex(), uri, getIntro(), getPhone(),
                    "", getEmail());
            if (tdao.addTeacher(tea)) {
                return "regist";
            }
        }
        return ERROR;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

}
