package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Consume;
import com.wxggt.util.DBUtil;

public class ConsumeDAO {
	public boolean insertConsume(Consume consume){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into consume(Uid,Money,consumetime,Type,Costid) values(?,?,CURRENT_TIME(),?,?)";//CURRENT_TIME()mysqlʱ�����ں��������ݿ��Զ�����
			ps = conn.prepareStatement(sql);
			ps.setString(1, consume.getUid());
			ps.setInt(2, consume.getMoney());
			ps.setString(3, consume.getType());
			ps.setInt(4, consume.getCostid());
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
		ConsumeDAO dao = new ConsumeDAO();
		Consume consume = new Consume("uid", 50, "����", 1);
		boolean result = dao.insertConsume(consume);
		System.out.println(result);
	}

}
