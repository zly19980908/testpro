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
        /* ������Ӧͷ����ajax������� */  
        response.setHeader("Access-Control-Allow-Origin", "*");  
        /* �Ǻű�ʾ���е��������󶼿��Խ��ܣ� */  
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");
        String topicdetail = request.getParameter("topicdetail");//��ѯ�Ļ�����ϸ
        String Uid = request.getParameter("Uid");//��ȡ���ڲ�ѯ���û����
        TopicDAO topicdao = new TopicDAO();
        AttentionDAO attentiondao = new AttentionDAO();
        List<Topic> list = topicdao.searchFrontAllSound(topicdetail);//��ѯ���л���
        List<String> attentionlist = attentiondao.SearchAllAttendidByUid(Uid);//��ѯ�û���ע���˵ı��
        List<Integer> attendedlist = new ArrayList<Integer>();
        for(int i = 0;i<list.size();i++){
        	Topic topic = list.get(i);//list�ĵ�i������
        	for(int j = 0;j<attentionlist.size();j++){
        		if(topic.getUid().equals(attentionlist.get(j))){//������������û���ע���˾ͼ�ס���������±�Ȼ���˳�ѭ��
        			attendedlist.add(i);//�����ע�˷����Ļ���λ��
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
