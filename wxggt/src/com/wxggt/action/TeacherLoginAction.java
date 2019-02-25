package com.wxggt.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.TeacherInfoDAO;

public class TeacherLoginAction extends ActionSupport{

	private String account;
	private String password;
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		TeacherInfoDAO tl = new TeacherInfoDAO();
		System.out.println(getAccount());
		boolean flag =tl.findBy(getAccount(), getPassword());
		System.out.println(flag);
		Map request = (Map)ActionContext.getContext().get("request");
		request.put("list", tl.getTeacherInfo(getAccount()));
		if(flag){
			return "login";
		}
		return ERROR;
	}
	
	
}
