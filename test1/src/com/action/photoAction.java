package com.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class photoAction extends ActionSupport{
	  private static final long serialVersionUID = 1L;
		
	    private File image; //�ϴ����ļ�
	    private String imageFileName; //�ļ�����
	    private String imageContentType; //�ļ�����
		
	    public File getImage() {
			return image;
		}
		public void setImage(File image) {
			this.image = image;
		}
		public String getImageFileName() {
			return imageFileName;
		}
		public void setImageFileName(String imageFileName) {
			this.imageFileName = imageFileName;
		}
		public String getImageContentType() {
			return imageContentType;
		}
		public void setImageContentType(String imageContentType) {
			this.imageContentType = imageContentType;
		}
	    
	    public String execute(){
	    	String realpath = ServletActionContext.getServletContext().getRealPath("/images");//��ȡ�����ռ���images��·��
	        if(image != null){
	        	File savefile = new File(new File(realpath), imageFileName);
	        	String path=realpath+ "\\"+imageFileName;
	        	System.out.println(savefile);
	        	System.out.println(path);
	        	if(savefile.getParentFile().exists()){
	        		try {
						savefile.getParentFile().mkdirs();
						FileUtils.copyFile(image, savefile);//���ļ�д��ָ�����ļ���
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
	        }
	        /**
	         * ��Ҫ�������ݿ�
	         * fileName����entityʵ��������������ļ����Ƶı���
	         * yu.setFileName(imageFileName) �������ļ����ƴ������ݿ�
	         * �ļ�·��Ϊ��savefile
	         */
			return SUCCESS;
	    }
	}