package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.SmallVideo;
import com.wxggt.util.DBUtil;

public class SmallVideoDAO {
	/*根据小视频描述模糊查询小视频*/
	public List<SmallVideo> searchFrontAllSvideo(String str){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<SmallVideo> list = new ArrayList<SmallVideo>();
		try{
			conn = DBUtil.getConnection();
			String sql = "select svid,uid,Surname,Pageview,sdescribe from smallvideo where sdescribe like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				SmallVideo s = new SmallVideo();
				s.setSvid(rs.getInt(1));
				s.setUid(rs.getString(2));
				s.setSurname(rs.getInt(3));
				s.setPageview(rs.getInt(4));
				s.setSdescribe(rs.getString(5));
				list.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}
	public static void main(String[] args) {
		SmallVideoDAO dao = new SmallVideoDAO();
		List<SmallVideo> list = dao.searchFrontAllSvideo("骚");
		for (SmallVideo s : list){
			System.out.println(s.getUid()+' '+s.getSurname()+' '+s.getPageview()+' '+s.getSdescribe());
		}
	}

}
