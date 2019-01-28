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
import com.google.gson.GsonBuilder;
import com.wxggt.dao.TeacherInfoDAO;
import com.wxggt.dto.TeacherInfo;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class Test extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Test() {
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
       
        //获取微信小程序get的参数值并打印
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        TeacherInfoDAO dao = new TeacherInfoDAO();
        List<TeacherInfo> l = dao.getAllTeacherInfo();
        for(TeacherInfo t : l){
        	System.out.println(t.gettNo()+' '+t.gettName());
        }
        Gson gson = new Gson();
        String json = gson.toJson(l);
        System.out.println(json);
        
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        //存值到缓冲区
        out.write(json);
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
