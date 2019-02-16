package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Sound;
import com.wxggt.util.DBUtil;

public class SoundDAO {

	/* 这是关于音频的DAO */

	/* 上传音频 */
	public boolean uploadSound(Sound sound) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO sound(uName,soundPath,uploadid,sTime,Sdescribe,title,imageUrl) VALUES(?,?,?,CURRENT_TIME(),?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sound.getuName());
			ps.setString(2, sound.getSoundPath());
			ps.setString(3, sound.getUploadid());
			ps.setString(4, sound.getsDescribe());
			ps.setString(5, sound.getTitle());
			ps.setString(6, sound.getImageUrl());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if (rs > 0) {
			return true;
		} else {
			return false;
		}
	}

	/* 模糊搜索单个音频 */
	public List<Sound> getSingleSound(String uploadid, String str) {
		List<Sound> list = new ArrayList<Sound>();
		String sql = "SELECT soundid,uName,sTime,title,soundPath,sDescribe,surname,Pageview,Reward FROM sound WHERE uploadid=? AND title LIKE ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, uploadid);
			ps.setString(2, "%" + str + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Sound sound = new Sound();
				sound.setSoundId(rs.getInt(1));
				sound.setuName(rs.getString(2));
				sound.setsTime(rs.getDate(3));
				sound.setTitle(rs.getString(4));
				sound.setSoundPath(rs.getString(5));
				sound.setsDescribe(rs.getString(6));
				sound.setSurname(rs.getInt(7));
				sound.setPageview(rs.getInt(8));
				sound.setReward(rs.getInt(9));
				sound.setUploadid(uploadid);
				list.add(sound);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	/*微信端根据音频标题模糊查询音频*/
	public List<Sound> getSingleSound(String str) {
		List<Sound> list = new ArrayList<Sound>();
		String sql = "SELECT uploadid,soundid,uName,title,surname,Pageview,imageUrl FROM sound WHERE title LIKE ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + str + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Sound sound = new Sound();
				sound.setUploadid(rs.getString(1));
				sound.setSoundId(rs.getInt(2));
				sound.setuName(rs.getString(3));
				sound.setTitle(rs.getString(4));
				sound.setSurname(rs.getInt(5));
				sound.setPageview(rs.getInt(6));
				sound.setImageUrl(rs.getString(7));
				list.add(sound);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	/* 显示用户上传的全部音频 */
	public List<Sound> getAllSound(String uploadid) {
		List<Sound> list = new ArrayList<Sound>();
		String sql = "SELECT soundid,uName,sTime,title,soundPath,sDescribe,surname,Pageview,Reward FROM sound WHERE uploadid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, uploadid);
			rs = ps.executeQuery();
			while (rs.next()) {
				Sound sound = new Sound();
				sound.setSoundId(rs.getInt(1));
				sound.setuName(rs.getString(2));
				sound.setsTime(rs.getDate(3));
				sound.setTitle(rs.getString(4));
				sound.setSoundPath(rs.getString(5));
				sound.setsDescribe(rs.getString(6));
				sound.setSurname(rs.getInt(7));
				sound.setPageview(rs.getInt(8));
				sound.setReward(rs.getInt(9));
				sound.setUploadid(uploadid);
				list.add(sound);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e1) {
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
			String sql = "select title from sound where title like ?";
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
		/* 上传音频 */
		// SoundDAO dao = new SoundDAO();
		// Sound sound = new Sound();
		// sound.setuName("汪伟");
		// sound.setSoundPath("path");
		// sound.setUploadid("2016010901");
		// sound.setsDescribe("方歌");
		// sound.setTitle("方剂方歌");
		// if (dao.uploadSound(sound)) {
		// System.out.println("上传成功");
		// } else {
		// System.out.println("上传失败");
		// }

		/* 模糊搜索单个音频 */
		// SoundDAO dao = new SoundDAO();
		// String str="方";
		// String uploadid="2016010901";
		// List<Sound> list=dao.getSingleSound(uploadid, str);
		// for(Sound s:list){
		// System.out.println(s.getSoundId()+" "+s.getTitle()+" "+s.getuName());
		// }

		/* 显示用户上传的全部音频 */
		SoundDAO dao = new SoundDAO();
		String uploadid = "2016010901";
		List<Sound> list = dao.getAllSound(uploadid);
		List<Sound> list2 = dao.getSingleSound("方");
		for (Sound s : list2){
			System.out.println(s.getUploadid() + " " + s.getTitle() + " " + s.getuName());
		}
		for (Sound s : list) {
			System.out.println(s.getSoundId() + " " + s.getTitle() + " " + s.getuName());
		}

	}

}
