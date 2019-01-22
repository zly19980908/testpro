package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Sound;
import com.wxggt.util.DBUtil;

public class SoundDAO {

	/* ���ǹ�����Ƶ��DAO */

	/* �ϴ���Ƶ */
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

	/* ģ������������Ƶ */
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
	/*΢�Ŷ˸�����Ƶ����ģ����ѯ��Ƶ*/
	public List<Sound> getSingleSound(String str) {
		List<Sound> list = new ArrayList<Sound>();
		String sql = "SELECT uploadid,soundid,uName,title,surname,Pageview FROM sound WHERE title LIKE ?";
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

	/* ��ʾ�û��ϴ���ȫ����Ƶ */
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

	public static void main(String[] args) {
		/* �ϴ���Ƶ */
		// SoundDAO dao = new SoundDAO();
		// Sound sound = new Sound();
		// sound.setuName("��ΰ");
		// sound.setSoundPath("path");
		// sound.setUploadid("2016010901");
		// sound.setsDescribe("����");
		// sound.setTitle("��������");
		// if (dao.uploadSound(sound)) {
		// System.out.println("�ϴ��ɹ�");
		// } else {
		// System.out.println("�ϴ�ʧ��");
		// }

		/* ģ������������Ƶ */
		// SoundDAO dao = new SoundDAO();
		// String str="��";
		// String uploadid="2016010901";
		// List<Sound> list=dao.getSingleSound(uploadid, str);
		// for(Sound s:list){
		// System.out.println(s.getSoundId()+" "+s.getTitle()+" "+s.getuName());
		// }

		/* ��ʾ�û��ϴ���ȫ����Ƶ */
		SoundDAO dao = new SoundDAO();
		String uploadid = "2016010901";
		List<Sound> list = dao.getAllSound(uploadid);
		List<Sound> list2 = dao.getSingleSound("��");
		for (Sound s : list2){
			System.out.println(s.getUploadid() + " " + s.getTitle() + " " + s.getuName());
		}
		for (Sound s : list) {
			System.out.println(s.getSoundId() + " " + s.getTitle() + " " + s.getuName());
		}

	}

}
