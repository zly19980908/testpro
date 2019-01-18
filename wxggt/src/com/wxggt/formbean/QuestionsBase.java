package com.wxggt.formbean;

import java.util.List;

import com.wxggt.dto.Practisequestion;

public class QuestionsBase {
	private int Pid;
	private String cNo;
	private int pType;
	private List<Practisequestion> practisequestion;

	public int getPid() {
		return Pid;
	}

	public void setPid(int pid) {
		Pid = pid;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}

	public int getpType() {
		return pType;
	}

	public void setpType(int pType) {
		this.pType = pType;
	}

	public List<Practisequestion> getPractisequestion() {
		return practisequestion;
	}

	public void setPractisequestion(List<Practisequestion> practisequestion) {
		this.practisequestion = practisequestion;
	}

}
