package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wxggt.dao.AttentionDAO;
import com.wxggt.dto.Attention;

/**
 * Servlet implementation class AddAttentionServlet
 */
@WebServlet("/AddAttentionServlet")
public class AddAttentionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAttentionServlet() {
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
        AttentionDAO dao = new AttentionDAO();
        String Uid = request.getParameter("Uid");
        String AttendUid = request.getParameter("AttendUid");
        String returnString = null;
        Attention attention = new Attention(Uid, AttendUid);
        boolean result1 = dao.insertAttention(attention);
        if(result1){
        	returnString = "添加失败，请检查网络是否异常!";
        }else{
        	returnString = "添加成功!";
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
