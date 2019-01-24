package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Course;
import com.wxggt.dto.StudentInfo;
import com.wxggt.util.DBUtil;

//课程表操作
public class CourceDAO {
	//修改课程价格
	public boolean updateStatus(int price,String id) throws SQLException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps =null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("update course set price=? where sno=?");
			ps.setInt(1, price);
			ps.setString(2, id);
			int result =ps.executeUpdate();
			if(result>0){
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ps.close();
			conn.close();
		}
		return flag;
	}
	
		
		
		//根据课程名称查看课程信息
		public StudentInfo showStudent(String id) throws SQLException 
		{
			StudentInfo s = null;
			Connection conn=null;
			PreparedStatement ps=null;
			ResultSet rs=null;
			try {
				conn = DBUtil.getConnection();
				String sql ="select * from studentinfo where sno=?";
				ps.setString(1, id);
				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				if(rs.next()){
					return new StudentInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getDate(7),rs.getInt(8),rs.getInt(9),rs.getDate(10));
				}else{
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				rs.close();
				ps.close();
				conn.close();
			}
			return null;
		}
	public static void main(String[] args) {
		
	}

}
