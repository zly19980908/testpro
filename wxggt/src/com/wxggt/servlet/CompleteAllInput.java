package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wxggt.dao.CourseDAO;
import com.wxggt.dao.SmallVideoDAO;
import com.wxggt.dao.SoundDAO;
import com.wxggt.dao.TopicDAO;
import com.wxggt.formbean.CSTSinputComplete;

/**
 * Servlet implementation class CompleteAllInput
 */
@WebServlet("/CompleteAllInput")
public class CompleteAllInput extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompleteAllInput() {
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
        System.out.println(str);
        CourseDAO coursedao = new CourseDAO();
        SmallVideoDAO smallvideodao = new SmallVideoDAO();
        SoundDAO sounddao = new SoundDAO();
        TopicDAO topicdao = new TopicDAO();
        //�ֱ�鿴�����������������ݵļ���
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        list = coursedao.CompleteInput(str);//�����ַ���ģ����ѯ�����
        list1 = smallvideodao.CompleteInput(str);
        list2 = sounddao.CompleteInput(str);
        list3 = topicdao.CompleteInput(str);
        //���ظ�����
        list.removeAll(list1);//ȥ��list�е�list1��Ԫ��
		list.addAll(list1);//���list1������Ԫ��
		list.removeAll(list2);
		list.addAll(list2);
		list.removeAll(list3);
		list.addAll(list3);
        Iterator<String> it=list1.iterator();
        while (it.hasNext()) {
         System.out.println(it.next());
         
        }
        Gson gson = new Gson();
        String json = gson.toJson(list);
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
