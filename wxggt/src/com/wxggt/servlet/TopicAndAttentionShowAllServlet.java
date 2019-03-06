package com.wxggt.servlet;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.wxggt.dao.AttentionDAO;
import com.wxggt.dao.TopicDAO;
import com.wxggt.dto.Topic;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class TopicAndAttentionShowAllServlet
 */
@WebServlet("/TopicAndAttentionShowAllServlet")
public class TopicAndAttentionShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopicAndAttentionShowAllServlet() {
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
        String topicdetail = request.getParameter("topicdetail");//查询的话题详细
        String Uid = request.getParameter("Uid");//获取正在查询的用户编号
        TopicDAO topicdao = new TopicDAO();
        AttentionDAO attentiondao = new AttentionDAO();
        List<Topic> list = topicdao.searchFrontAllSound(topicdetail);//查询所有话题
        List<String> attentionlist = attentiondao.SearchAllAttendidByUid(Uid);//查询用户关注的人的编号
        List<Integer> attendedlist = new ArrayList<Integer>();
        for(int i = 0;i<list.size();i++){
        	Topic topic = list.get(i);//list的第i个话题
        	for(int j = 0;j<attentionlist.size();j++){
        		if(topic.getUid().equals(attentionlist.get(j))){//如果发布人是用户关注的人就记住这个话题的下标然后退出循环
        			attendedlist.add(i);//加入关注人发布的话题位置
        			break;
        		}
        	}
        }
        Map map = new HashMap();
        map.put("topicResult",list);
        map.put("attendedlist",attendedlist);
        JSONObject json = JSONObject.fromObject(map);
        Writer out = response.getWriter();
        System.out.println(json.toString());
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
