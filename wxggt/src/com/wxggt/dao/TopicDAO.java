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
	/*���ݻ��������ѯ*/
	public List<Topic> searchFrontAllSound(String str){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Topic> list = new ArrayList<Topic>();//��new��������
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
	
	/*΢�Ŷ˷�������*/
	public boolean insertTopic(Topic topic){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into topic(topicId,initiator,TopicDetail,openTime,cNO) values(?,?,?,CURRENT_TIME(),?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, topic.getTopicId());
			ps.setString(2, topic.getInitiator());
			ps.setString(3, topic.getTopicDetail());
			ps.setString(4, topic.getcNo());
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
	/*΢�Ŷ˻ظ����ۼ�һ*/
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
	
	/*΢�Ŷ˻ظ�����*/
	public boolean insertTopicReply(TopicReply reward){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into topicreply(topicId,uid,Reply,Type,openTime) values(?,?,?,?,CURRENT_TIME())";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reward.getTopicId());
			ps.setString(2, reward.getUid());
			ps.setString(3, reward.getReply());
			ps.setString(4, reward.getType());
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
		List<Topic> list = dao.searchFrontAllSound("��");
		Topic topic = new Topic("�����", "�����������", "2016010901");
		TopicReply reward = new TopicReply(1111111, "2016010901", "��û�֣��������", "��У��");
		boolean result1 = dao.insertTopicReply(reward);
		boolean result = dao.insertTopic(topic);
		boolean result2 = dao.updateTopicPv(1);
		System.out.println(result+" "+result1+" "+result2);
		for (Topic t : list){
			System.out.println(t.getTopicId()+' '+t.getInitiator()+' '+t.getTopicDetail()+' '+t.getPv());
		}
	}

}
