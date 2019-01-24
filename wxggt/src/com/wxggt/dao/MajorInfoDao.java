package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.MajorInfo;
import com.wxggt.util.DBUtil;

public class MajorInfoDao {
	//
	public List<MajorInfo> showMajorInfo() throws SQLException{
		List<MajorInfo> list=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			list = new ArrayList<MajorInfo>();
			conn = DBUtil.getConnection();
			String sql ="select * from majorinfo";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				//list.add(new MajorInfo(rs.getString("mNo"),rs.getString("mName"),rs.getString("mDesc")));
				list.add(new MajorInfo(rs.getString(1),rs.getString(2),rs.getString(3)));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return list;
	}
	
	
	public static void main(String[] args) throws SQLException {
		MajorInfoDao m =new MajorInfoDao();
		System.out.println(m.showMajorInfo());
	}
}
