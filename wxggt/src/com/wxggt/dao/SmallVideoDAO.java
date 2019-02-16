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
			String sql = "select svid,uid,uName,Surname,Pageview,sdescribe,imageUrl from smallvideo where sdescribe like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				SmallVideo s = new SmallVideo();
				s.setSvid(rs.getInt(1));
				s.setUid(rs.getString(2));
				s.setuName(rs.getString(3));
				s.setSurname(rs.getInt(4));
				s.setPageview(rs.getInt(5));
				s.setSdescribe(rs.getString(6));
				s.setImageUrl(rs.getString(7));
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
	
	/*微信端讨论区模糊补全输入*/
	public List<String> CompleteInput(String str){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();//不new出来报错
 		try{
			conn = DBUtil.getConnection();
			String sql = "select sdescribe from smallvideo where sdescribe like ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, str+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				list.add(rs.getString(1));
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
		SmallVideoDAO dao = new SmallVideoDAO();
		List<SmallVideo> list = dao.searchFrontAllSvideo("骚");
		for (SmallVideo s : list){
			System.out.println(s.getUid()+' '+s.getSurname()+' '+s.getPageview()+' '+s.getSdescribe());
		}
	}

}
