package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Topic;
import com.wxggt.util.DBUtil;

public class TopicDAO {
	/*根据话题详情查询*/
	public List<Topic> searchFrontAllSound(String str){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Topic> list = new ArrayList<Topic>();//不new出来报错
 		try{
			conn = DBUtil.getConnection();
			String sql = "select topicId,initiator,TopicDetail,Pv from topic where TopicDetail like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				topic.setTopicId(rs.getInt(1));
				topic.setInitiator(rs.getString(2));
				topic.setTopicDetail(rs.getString(3));
				topic.setPv(rs.getInt(4));
				list.add(topic);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
 		return list;
	}
	public static void main(String[] args) {
		TopicDAO dao = new TopicDAO();
		List<Topic> list = dao.searchFrontAllSound("我");
		for (Topic t : list){
			System.out.println(t.getTopicId()+' '+t.getInitiator()+' '+t.getTopicDetail()+' '+t.getPv());
		}
	}

}
