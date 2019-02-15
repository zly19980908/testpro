package com.wxggt.action;

import com.opensymphony.xwork2.ActionSupport;
import com.wxggt.util.UploadTool;

public class ChangeHeadFaceAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private String base64;

	@Override
	public String execute() throws Exception {
		try {
			String uId="201601090127";
			String fileUrl = UploadTool.upload(uId,base64);
			System.out.println("上传文件路径是：upload/"+uId+"/" + fileUrl);
		} catch (Exception e) {
			System.out.println(e);
		}
		return SUCCESS;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
}