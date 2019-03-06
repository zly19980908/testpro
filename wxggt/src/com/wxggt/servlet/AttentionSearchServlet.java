package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxggt.dao.AttentionDAO;

/**
 * Servlet implementation class SearchAttentionServlet
 */
@WebServlet("/AttentionSearchServlet")
public class AttentionSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttentionSearchServlet() {
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
        AttentionDAO dao = new AttentionDAO();
        String Uid = request.getParameter("Uid");
        String AttendUid = request.getParameter("AttendUid");
        String returnString = null;
        //��ѯ�Ƿ��ѹ�ע
        boolean result = dao.searchAttentionByUidAndAUid(Uid, AttendUid);
        if(result){
        	//��ע��ʹ�ù�עͼ��
        	returnString = "true";
        }
        else{
        	//δ��ע��ʹ��δ��עͼ��
        	returnString = "false";
        }
        Writer out = response.getWriter();
        out.write(returnString);
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
