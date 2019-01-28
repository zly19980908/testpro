package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;  
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wxggt.dao.CourseDAO;
import com.wxggt.dao.SmallVideoDAO;
import com.wxggt.dao.SoundDAO;
import com.wxggt.dto.Course;
import com.wxggt.dto.SmallVideo;
import com.wxggt.dto.Sound;

/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchResult() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");          
        /* ������Ӧͷ����ajax������� */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
        String str = "��";
        String str1 = "��";
        String str2 = "ɧ";
        CourseDAO coursedao = new CourseDAO();
        SoundDAO soundao = new SoundDAO();
        SmallVideoDAO svideodao = new SmallVideoDAO();
        List<Course> list = coursedao.getFrontAllCourseInfo(str);
        List<Sound> list1 = soundao.getSingleSound(str1);
        List<SmallVideo> list2 = svideodao.searchFrontAllSvideo(str2);
        //��Map���ֵ�ԣ���ÿ�����鶼��һ����
        Map map = new HashMap();
        map.put("CourseResult", list);
        map.put("SoundResult", list1);
        map.put("SmallVideoResult",list2);
        JSONObject json = JSONObject.fromObject(map);
        /*String json = gson.toJson(list);
        System.out.println("\"CourseResult\":"+json);
        System.out.println("-------------------");
        String json1 = gson.toJson(list1);
        System.out.println(json1);
        System.out.println("-------------------");
        String json2 = gson.toJson(list2);
        System.out.println(json2);*/
        //����ֵ��΢��С����
        Writer out = response.getWriter();
        //��ֵ��������
        out.write(json.toString());
        System.out.println(json.toString());
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
