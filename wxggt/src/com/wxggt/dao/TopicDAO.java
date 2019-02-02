package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Topic;
import com.wxggt.dto.TopicReply;
import com.wxggt.util.DBUtil;

public class TopicDAO {
	/*根据话题详情模糊查询*/
	public List<Topic> searchFrontAllSound(String str){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Topic> list = new ArrayList<Topic>();//不new出来报错
 		try{
			conn = DBUtil.getConnection();
			String sql = "select topicId,uid,initiator,TopicDetail,Pv,imageUrl,pageview,liked,title,share from topic where TopicDetail like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Topic topic = new Topic();
				topic.setTopicId(rs.getInt(1));
				topic.setUid(rs.getString(2));
				topic.setInitiator(rs.getString(3));
				topic.setTopicDetail(rs.getString(4));
				topic.setPv(rs.getInt(5));
				topic.setImageUrl(rs.getString(6));
				topic.setPageview(rs.getInt(7));
				topic.setLike(rs.getInt(8));
				topic.setTitle(rs.getString(9));
				topic.setShare(rs.getInt(10));
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
	
	/*根据话题标题判断是否重复发表文章*/
	public boolean searchTopicByHeader(String Header){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
 		try{
			conn = DBUtil.getConnection();
			String sql = "select count(*) from topic where TopicHeader = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, Header);
			rs = ps.executeQuery();
			while(rs.next()){
				int count = rs.getInt(1);
				System.out.println(count);
				return false;
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
 		return true;
	}
	
	/*微信端发布话题*/
	public boolean insertTopic(Topic topic){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into topic(initiator,uid,title,TopicDetail,imageUrl,openTime,cNO) values(?,?,?,CURRENT_TIME(),?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, topic.getInitiator());
			ps.setString(2, topic.getUid());
			ps.setString(3, topic.getTitle());
			ps.setString(4, topic.getImageUrl());
			ps.setString(5, topic.getTopicDetail());
			ps.setString(6, topic.getcNo());
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	/*微信端回复评论加一*/
	public boolean updateTopicPv(int tid){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "update topic set Pv=Pv+1 where topicId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, tid);
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	/*微信端回复讨论*/
	public boolean insertTopicReply(TopicReply reward){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into topicreply(topicId,uid,uName,Reply,Type,openTime) values(?,?,?,?,?,CURRENT_TIME())";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reward.getTopicId());
			ps.setString(2, reward.getUid());
			ps.setString(3, reward.getuName());
			ps.setString(4, reward.getReply());
			ps.setString(5, reward.getType());
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	/*微信端访问访问量加一*/
	public boolean updateTopicPageview(int topicId){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "update topic set pageview=pageview+1 where topicId = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, topicId);
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		TopicDAO dao = new TopicDAO();
		List<Topic> list = dao.searchFrontAllSound("我");
		Topic topic = new Topic("伍嘉晖","111", "你胖了吗", "你今天胖了嘛", "2016010901");
		TopicReply reward = new TopicReply(1111111, "2016010901", "汪伟" , "我没胖，你才胖了", "贵校的");
		boolean result1 = dao.insertTopicReply(reward);
		boolean result = dao.insertTopic(topic);
		boolean result2 = dao.updateTopicPv(1);
		System.out.println(result+" "+result1+" "+result2);
		for (Topic t : list){
			System.out.println(t.getTopicId()+' '+t.getInitiator()+' '+t.getTopicDetail()+' '+t.getPv());
		}
	}

}
