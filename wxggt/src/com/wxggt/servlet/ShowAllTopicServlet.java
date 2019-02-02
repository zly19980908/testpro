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
import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.Topic;

/**
 * Servlet implementation class ShowAllTopicServlet
 */
@WebServlet("/ShowAllTopicServlet")
public class ShowAllTopicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllTopicServlet() {
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
        String topicdetail = request.getParameter("topicdetail");
        TopicDAO topicdao = new TopicDAO();
        List<Topic> list = topicdao.searchFrontAllSound(topicdetail);
        Gson gson = new Gson();
        String Json = gson.toJson(list);
        Writer out = response.getWriter();
        System.out.println(Json);
        out.write(Json);
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
