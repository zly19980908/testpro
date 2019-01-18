package com.wxggt.dto;

public class Practisequestion {
	private int QuestionId;
	private int pid;
	private String Question;
	private String A;
	private String B;
	private String C;
	private String D;
	private String rightAnswer;
	private String qType;
	private String qAnalyze;
	private String qPic;

	public int getQuestionId() {
		return QuestionId;
	}

	public void setQuestionId(int questionId) {
		QuestionId = questionId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getQuestion() {
		return Question;
	}

	public void setQuestion(String question) {
		Question = question;
	}

	public String getA() {
		return A;
	}

	public void setA(String a) {
		A = a;
	}

	public String getB() {
		return B;
	}

	public void setB(String b) {
		B = b;
	}

	public String getC() {
		return C;
	}

	public void setC(String c) {
		C = c;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public String getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

	public String getqType() {
		return qType;
	}

	public void setqType(String qType) {
		this.qType = qType;
	}

	public String getqAnalyze() {
		return qAnalyze;
	}

	public void setqAnalyze(String qAnalyze) {
		this.qAnalyze = qAnalyze;
	}

	public String getqPic() {
		return qPic;
	}

	public void setqPic(String qPic) {
		this.qPic = qPic;
	}

}
