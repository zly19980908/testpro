package com.wxggt.action;

import com.opensymphony.xwork2.ActionSupport;

public class ModifyCourseAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String courseTime;
    private String cno;

    public String getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(String courseTime) {
        this.courseTime = courseTime;
    }

    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub

        return super.execute();
    }

}
