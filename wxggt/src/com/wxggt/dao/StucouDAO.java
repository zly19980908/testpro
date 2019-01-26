package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Stucou;
import com.wxggt.util.DBUtil;

public class StucouDAO {
	//选课表添入记录
	public boolean insertStucou(String sNo,String cNo){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into `stu-cou`(sNo,cNo) values(?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, sNo);
			ps.setString(2, cNo);
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
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
		StucouDAO dao = new StucouDAO();
		boolean result = dao.insertStucou("201601090143", "19980701");
		System.out.println(result);
	}

}
