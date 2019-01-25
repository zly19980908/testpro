package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Attention;
import com.wxggt.dto.Reward;
import com.wxggt.util.DBUtil;

public class RewardDAO {
	public boolean insertReward(Reward reward){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into reward(Targetid,Uid,Money,Rtime) values(?,?,?,CURRENT_TIME())";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reward.getTargetid());
			ps.setString(2, reward.getUid());
			ps.setInt(3, reward.getMoney());
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
		RewardDAO dao = new RewardDAO();
		Reward reward = new Reward(55555, "201601090143", 5);
		boolean result = dao.insertReward(reward);
		System.out.println(result);
	}

}
