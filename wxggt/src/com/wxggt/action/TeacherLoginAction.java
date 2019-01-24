package com.wxggt.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.TeacherInfoDAO;

public class TeacherLoginAction extends ActionSupport{
	private String tno;
	private String pwd;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		TeacherInfoDAO t =new TeacherInfoDAO();
		boolean r = t.findBy(getTno(), getPwd());
		if(r){
			return SUCCESS;
		}
		return ERROR;
	}
	
	

}
