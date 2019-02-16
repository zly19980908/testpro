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
import com.wxggt.dao.CourseDAO;
import com.wxggt.dto.Course;

/**
 * Servlet implementation class ShowCourseOfTeacherServlet
 */
@WebServlet("/ShowCourseOfTeacherServlet")
public class ShowCourseOfTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCourseOfTeacherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");          
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String tid = "2016010901";
        CourseDAO coursedao = new CourseDAO();
        List<Course> list = coursedao.findAllCourseByTno(tid);
        //将数据转化为Json字符串
        Gson gson = new Gson();
        String Json = gson.toJson(list);
        Writer out = response.getWriter();
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
