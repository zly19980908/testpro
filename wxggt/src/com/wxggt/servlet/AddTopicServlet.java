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
        /* ������Ӧͷ����ajax������� */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        TopicDAO dao = new TopicDAO();
        String initiator = request.getParameter("initiator");//������
        String uid = request.getParameter("uid");//���
        String title = request.getParameter("title");//�������
        String TopicDetail = request.getParameter("content");//������ϸ
        String cNO = request.getParameter("cNO");//������ؿγ̺�
        String returnData = "";//����΢�Ŷ˵���Ϣ
        boolean result = dao.searchTopicByHeader(title);//�ж��Ƿ����иñ���Ļ���
        if(result){//û�о�����
        Topic topic = new Topic(initiator,uid,title, TopicDetail, cNO);
        boolean result1 = dao.insertTopic(topic);//�ж�sql�Ƿ�����ִ��
        	if(result1){
        		returnData = "�����ɹ�";
        	}else{
        		returnData = "����ʧ�ܣ����ݿ��쳣";
        	}
        }else{//�оͷ��ش�����Ϣ
            returnData = "�Ѵ��ڸû��⣬�����ظ�����";
        }
        //����ֵ��΢��С����
        Writer out = response.getWriter();
        //��ֵ��������
        out.write(returnData);
        System.out.println(returnData);
		// flush()��ʾǿ�ƽ��������е����ݷ��ͳ�ȥ,���صȵ���������
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
