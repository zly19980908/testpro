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
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");  
       
        //获取微信小程序get的参数值并打印
        String str = request.getParameter("str");//获取输入字符串
        System.out.println(str);
        CourseDAO coursedao = new CourseDAO();
        SmallVideoDAO smallvideodao = new SmallVideoDAO();
        SoundDAO sounddao = new SoundDAO();
        TopicDAO topicdao = new TopicDAO();
        //分别查看四种类型中搜索内容的集合
        List<String> list = new ArrayList<String>();
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        List<String> list3 = new ArrayList<String>();
        list = coursedao.CompleteInput(str);//根据字符串模糊查询出结果
        list1 = smallvideodao.CompleteInput(str);
        list2 = sounddao.CompleteInput(str);
        list3 = topicdao.CompleteInput(str);
        //求不重复并集
        list.removeAll(list1);//去掉list中的list1的元素
		list.addAll(list1);//添加list1的所有元素
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
