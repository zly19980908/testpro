package com.wxggt.dto;

public class EvaluateResult {

	private String tNo;
	private String cNo;
	private Double rank;

	public void setRank(Double rank) {
		this.rank = rank;
	}
	
	public Double getRank(){
		return rank;
	}

	public String gettNo() {
		return tNo;
	}

	public void settNo(String tNo) {
		this.tNo = tNo;
	}

	public String getcNo() {
		return cNo;
	}

	public void setcNo(String cNo) {
		this.cNo = cNo;
	}
	
	public EvaluateResult(){
		
	}

	public EvaluateResult(String tNo, String cNo, Double rank) {
		super();
		this.tNo = tNo;
		this.cNo = cNo;
		this.rank = rank;
	}
	
	

}
