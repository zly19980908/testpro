package com.action;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class photoAction extends ActionSupport{
	  private static final long serialVersionUID = 1L;
		
	    private File image; //上传的文件
	    private String imageFileName; //文件名称
	    private String imageContentType; //文件类型
		
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
	    	String realpath = ServletActionContext.getServletContext().getRealPath("/images");//获取工作空间下images的路径
	        if(image != null){
	        	File savefile = new File(new File(realpath), imageFileName);
	        	String path=realpath+ "\\"+imageFileName;
	        	System.out.println(savefile);
	        	System.out.println(path);
	        	if(savefile.getParentFile().exists()){
	        		try {
						savefile.getParentFile().mkdirs();
						FileUtils.copyFile(image, savefile);//将文件写入指定的文件夹
					} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
	        }
	        /**
	         * 若要存入数据库
	         * fileName是在entity实体类中声明存放文件名称的变量
	         * yu.setFileName(imageFileName) 这样将文件名称存入数据库
	         * 文件路径为：savefile
	         */
			return SUCCESS;
	    }
	}