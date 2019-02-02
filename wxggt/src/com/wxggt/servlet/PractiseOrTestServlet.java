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
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String str = "课程练习";
        String sourceName = "";
        String courseName = "";
        List<Practisequestion> questionList = new ArrayList<Practisequestion>();
        PractisequestionDAO questiondao = new PractisequestionDAO();
        //根据类型返回不同题数的习题集，随堂10道，课堂练习与期末考试都是50道
        if(str == "随堂练习"){
        	questionList = questiondao.inclassTest(sourceName);
        }else{
        	questionList = questiondao.termsTest(courseName);
        }
        Gson gson = new Gson();
        String Json = gson.toJson(questionList);
        //返回值给微信小程序
        Writer out = response.getWriter(); 
        //存值到缓冲区
        out.write(Json);
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
