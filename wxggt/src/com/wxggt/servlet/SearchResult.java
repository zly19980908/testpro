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
import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.Course;
import com.wxggt.dto.SmallVideo;
import com.wxggt.dto.Sound;
import com.wxggt.dto.Topic;

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
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
        String str = request.getParameter("str");
        String str1 = request.getParameter("str1");
        String str2 = request.getParameter("str2");
        String str3 = request.getParameter("str3");
        CourseDAO coursedao = new CourseDAO();
        SoundDAO soundao = new SoundDAO();
        SmallVideoDAO svideodao = new SmallVideoDAO();
        TopicDAO topicdao = new TopicDAO();
        List<Course> list = coursedao.getFrontAllCourseInfo(str);
        List<Sound> list1 = soundao.getSingleSound(str1);
        List<SmallVideo> list2 = svideodao.searchFrontAllSvideo(str2);
        List<Topic> list3 = topicdao.searchFrontAllSound(str3);
        //用Map存键值对，将每个数组都做一个键
        Map map = new HashMap();
        map.put("CourseResult", list);
        map.put("SoundResult", list1);
        map.put("SmallVideoResult",list2);
        map.put("TopicResult",list3);
        JSONObject json = JSONObject.fromObject(map);
        /*String json = gson.toJson(list);
        System.out.println("\"CourseResult\":"+json);
        System.out.println("-------------------");
        String json1 = gson.toJson(list1);
        System.out.println(json1);
        System.out.println("-------------------");
        String json2 = gson.toJson(list2);
        System.out.println(json2);*/
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        //存值到缓冲区
        out.write(json.toString());
		// flush()表示强制将缓冲区中的数据发送出去,不必等到缓冲区满
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
