package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wxggt.dao.TeacherInfoDAO;
import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.TeacherInfo;
import com.wxggt.formbean.CSTSinputComplete;

/**
 * Servlet implementation class CompleteTopicInput
 */
@WebServlet("/CompleteTopicInput")
public class CompleteTopicInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteTopicInput() {
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
       
        //��ȡ΢��С����get�Ĳ���ֵ����ӡ
        String str = request.getParameter("str");//��ȡ�����ַ���
        TopicDAO topicdao = new TopicDAO();
        List<CSTSinputComplete> l = topicdao.completeInput(str);//�����ַ���ģ����ѯ�����
        Gson gson = new Gson();
        String json = gson.toJson(l);
        System.out.println(json);
        
        //����ֵ��΢��С����
        Writer out = response.getWriter(); 
        //��ֵ��������
        out.write(json);
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
