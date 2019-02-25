package com.wxggt.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.dao.TeacherInfoDAO;
import com.wxggt.dto.TeacherInfo;

public class ModifyInfoAction extends ActionSupport{

	private String username;
	private String password;
	private String email;
	private String intro;
	private String phone;
	private String sex;
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
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		TeacherInfo t = new TeacherInfo();
		TeacherInfoDAO tdao = new TeacherInfoDAO();
		t.settNo(password);
		t.settName(getUsername());
		t.setTel(getPhone());
		t.settDesc(getIntro());
		t.setEmail(getEmail());
		t.settSex(getSex());
		if(tdao.changeTeacherInfo(t)){
			return "modify";
		}
		return ERROR;
	}
	
	
}
