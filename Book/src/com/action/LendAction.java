package com.action;

import com.opensymphony.xwork2.ActionSupport;

public class LendAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Lend lend;
	LendDao lendDao=new LendDao();
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Lend getLend() {
		return lend;
	}
	public void setLend(Lend lend) {
		this.lend = lend;
	}
	
}
