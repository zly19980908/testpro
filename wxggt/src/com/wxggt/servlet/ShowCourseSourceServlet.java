package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxggt.dao.CourseDAO;
import com.wxggt.dao.SourceInfoDAO;
import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.SourceInfo;
import com.wxggt.dto.Topic;
import com.wxggt.formbean.CourseInfoWithsource;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.JsDateJsonBeanProcessor;
@WebServlet("/ShowCourseSourceSevlet")
public class ShowCourseSourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourseSourceServlet() {
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
        String cno = request.getParameter("cno");
        CourseDAO dao = new CourseDAO();
        TopicDAO topicdao = new TopicDAO();
        //���ݿγ̺Ų�ѯ��ʦ��
        String tNo = dao.SearchTnoByCno(cno);
        //��ѯ�γ����ʦ������Ϣ
        List<CourseInfoWithsource> list = dao.getAllCourseInfo(tNo,cno);
        //���ݿγ̺�ѡȡ�γ�����������
        List<Topic> list1 = topicdao.SearchSomeTopicByCno(cno);
        
        Map map = new HashMap();
        map.put("CourseInfoWithsource",list);
        map.put("TopicResult",list1);
        JsonConfig jsonConfig = new JsonConfig();
        jsonConfig.registerJsonBeanProcessor(java.sql.Date.class, new JsDateJsonBeanProcessor());
        JSONObject json = JSONObject.fromObject(map, jsonConfig);
        System.out.println(json.toString());
        Writer out = response.getWriter();
        out.write(json.toString());
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
