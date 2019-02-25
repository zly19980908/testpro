package com.wxggt.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.CourseDAO;

public class ShowCourseAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private String tno;
    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    @Override
    public String execute() throws Exception {
        // TODO Auto-generated method stub
        CourseDAO showDao = new CourseDAO();
        @SuppressWarnings("unchecked")
        Map<String, Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
        if (getCname().equals("") || getCname() == null) {
            request.put("showallCourse", showDao.findAllCourseByTno(getTno()));
        } else {
            request.put("showallCourse", showDao.getAllCourseInfo(getTno(), getCname()));
        }
        return SUCCESS;
    }

}
