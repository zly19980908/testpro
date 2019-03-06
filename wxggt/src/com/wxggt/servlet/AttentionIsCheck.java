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

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.wxggt.dao.AttentionDAO;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class CheckIsAttended
 */
@WebServlet("/AttentionIsCheck")
public class AttentionIsCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttentionIsCheck() {
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
        //����������ɸѡ�ѹ�ע
        String newarray = request.getParameter("newarray");//��ȡ�����ַ���
        //JSON��תJSON����
        JSONObject obj = JSONObject.parseObject(newarray);
        //����key �õ�json�е�json����
        JSONArray array = JSONArray.fromObject(obj.getJSONArray("array"));
        //ȡ���û����
        String uid = obj.getString("uid");
        //���ѹ�ע�ļ�¼���
        List<Integer> list = new ArrayList<Integer>();
        //������ӡ
        for (int i = 0; i < array.size(); i++) {
            boolean result = dao.searchAttentionByUidAndAUid(uid, array.getString(i));
            if(result){
            	list.add(i);
            }
        }
        Gson gson = new Gson();
        out.write(gson.toJson(list).toString());
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
