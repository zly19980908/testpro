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

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.wxggt.dao.AttentionDAO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AttentionTeacherIsCheckServlet
 */
@WebServlet("/AttentionTeacherIsCheckServlet")
public class AttentionTeacherIsCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttentionTeacherIsCheckServlet() {
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
        Writer out = response.getWriter();
        //�γ���Ƶ��Դ��֤�Ƿ��ѹ�ע
        String Uid = request.getParameter("Uid");
        String AttendUid = request.getParameter("AttendUid");
        String returnString = null;
        boolean result1 = dao.searchAttentionByUidAndAUid(Uid, AttendUid);
        if(result1){
        	returnString = "2";
        }else{
        	returnString = "1";
        }
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
