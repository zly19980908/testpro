package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Sound;
import com.wxggt.util.DBUtil;

public class SoundDAO {

	/* 这是关于音频的DAO */

	/* 上传音频 */
	public boolean uploadSound(Sound sound) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO sound(uName,soundPath,uploadid,sTime,Sdescribe,title) VALUES(?,?,?,CURRENT_TIME(),?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sound.getuName());
			ps.setString(2, sound.getSoundPath());
			ps.setString(3, sound.getUploadid());
			ps.setString(4, sound.getsDescribe());
			ps.setString(5, sound.getTitle());
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

	public static void main(String[] args) {
		/* 上传音频 */
		SoundDAO dao = new SoundDAO();
		Sound sound = new Sound();
		sound.setuName("汪伟");
		sound.setSoundPath("path");
		sound.setUploadid("2016010901");
		sound.setsDescribe("方歌");
		sound.setTitle("方剂方歌");
		if (dao.uploadSound(sound)) {
			System.out.println("上传成功");
		} else {
			System.out.println("上传失败");
		}
	}

}
