package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.Topic;

/**
 * Servlet implementation class AddTopicServlet
 */
@WebServlet("/AddTopicServlet")
public class AddTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTopicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        TopicDAO dao = new TopicDAO();
        String initiator = request.getParameter("initiator");//发布人
        String uid = request.getParameter("uid");//编号
        String title = request.getParameter("title");//话题标题
        String TopicDetail = request.getParameter("content");//话题详细
        String cNO = request.getParameter("cNO");//话题相关课程号
        String returnData = "";//返回微信端的信息
        boolean result = dao.searchTopicByHeader(title);//判断是否已有该标题的话题
        if(result){//没有就新增
        Topic topic = new Topic(initiator,uid,title, TopicDetail, cNO);
        boolean result1 = dao.insertTopic(topic);//判断sql是否正常执行
        	if(result1){
        		returnData = "发布成功";
        	}else{
        		returnData = "发布失败，数据库异常";
        	}
        }else{//有就返回错误信息
            returnData = "已存在该话题，请勿重复发布";
        }
        //返回值给微信小程序
        Writer out = response.getWriter();
        //存值到缓冲区
        out.write(returnData);
        System.out.println(returnData);
		// flush()表示强制将缓冲区中的数据发送出去,不必等到缓冲区满
        out.flush();
        	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
