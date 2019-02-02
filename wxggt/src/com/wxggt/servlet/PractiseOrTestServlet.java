package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wxggt.dao.PractisequestionDAO;
import com.wxggt.dto.Practisequestion;

/**
 * Servlet implementation class PractiseOrTestServlet
 */
@WebServlet("/PractiseOrTestServlet")
public class PractiseOrTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PractiseOrTestServlet() {
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
        String str = "�γ���ϰ";
        String sourceName = "";
        String courseName = "";
        List<Practisequestion> questionList = new ArrayList<Practisequestion>();
        PractisequestionDAO questiondao = new PractisequestionDAO();
        //�������ͷ��ز�ͬ������ϰ�⼯������10����������ϰ����ĩ���Զ���50��
        if(str == "������ϰ"){
        	questionList = questiondao.inclassTest(sourceName);
        }else{
        	questionList = questiondao.termsTest(courseName);
        }
        Gson gson = new Gson();
        String Json = gson.toJson(questionList);
        //����ֵ��΢��С����
        Writer out = response.getWriter(); 
        //��ֵ��������
        out.write(Json);
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
