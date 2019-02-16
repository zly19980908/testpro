package com.wxggt.formbean;

public class CSTSinputComplete {
	private int id;//查询记录的编号
	private String name;//讨论或音频号或视频号补全的名字
	private String cName;//课程号
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
