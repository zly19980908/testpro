package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.wxggt.dto.Attention;
import com.wxggt.util.DBUtil;

public class AttentionDAO {
	public boolean insertAttention(Attention attention){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into attention(Uid,attendUid,createTime) values(?,?,CURRENT_TIME())";
			ps = conn.prepareStatement(sql);
			ps.setString(1, attention.getUid());
			ps.setString(2, attention.getAttendUid());
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
		AttentionDAO dao = new AttentionDAO();
		Attention attention = new Attention("201601090143", "201601090148");
		boolean result = dao.insertAttention(attention);
		System.out.println(result);
	}

}
