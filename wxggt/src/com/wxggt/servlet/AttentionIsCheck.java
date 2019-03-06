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
        /* 设置响应头允许ajax跨域访问 */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* 星号表示所有的异域请求都可以接受， */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        AttentionDAO dao = new AttentionDAO();
        Writer out = response.getWriter();
        //话题讨论区筛选已关注
        String newarray = request.getParameter("newarray");//获取数组字符串
        //JSON串转JSON对象
        JSONObject obj = JSONObject.parseObject(newarray);
        //根据key 得到json中的json数组
        JSONArray array = JSONArray.fromObject(obj.getJSONArray("array"));
        //取到用户编号
        String uid = obj.getString("uid");
        //存已关注的记录序号
        List<Integer> list = new ArrayList<Integer>();
        //挨个打印
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
