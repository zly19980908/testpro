package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.TeacherInfo;
import com.wxggt.util.DBUtil;

/*处理老师信息的DAO*/
public class TeacherInfoDAO {

	/* 查看全部医生信息 */
	public List<TeacherInfo> getAllTeacherInfo() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tNo,tName,tSex,tDesc,facePic from TeacherInfo";
		List<TeacherInfo> list = new ArrayList<TeacherInfo>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherInfo teacherInfo = new TeacherInfo();
				teacherInfo.settNo(rs.getString(1));
				teacherInfo.settName(rs.getString(2));
				teacherInfo.settSex(rs.getString(3));
				teacherInfo.settDesc(rs.getString(4));
				teacherInfo.setFacePic(rs.getString(5));
				list.add(teacherInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	/* 获取单个医生信息 */
	public List<TeacherInfo> getTeacherInfo(String tNo) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select tNo,tName,tSex,tDesc,facePic from TeacherInfo where tNo=?";
		List<TeacherInfo> list = new ArrayList<TeacherInfo>();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherInfo teacherInfo = new TeacherInfo();
				teacherInfo.settNo(rs.getString(1));
				teacherInfo.settName(rs.getString(2));
				teacherInfo.settSex(rs.getString(3));
				teacherInfo.settDesc(rs.getString(4));
				teacherInfo.setFacePic(rs.getString(5));
				list.add(teacherInfo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	/* 老师修改信息 */
	public boolean changeTeacherInfo(TeacherInfo teacherInfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update TeacherInfo set tName=?,tSex=?,tDesc=? where tNo=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, teacherInfo.gettName());
			ps.setString(2, teacherInfo.gettSex());
			ps.setString(3, teacherInfo.gettDesc());
			ps.setString(4, teacherInfo.gettNo());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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

	/* 老师修改头像 */
	public boolean changeTeacherFacePic(String tNo, String newFacePic) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update TeacherInfo set facePic=? where tNo=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, newFacePic);
			ps.setString(2, tNo);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
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
		/* 获取全部老师信息 */
		TeacherInfoDAO dao = new TeacherInfoDAO();
		List<TeacherInfo> list = new ArrayList<TeacherInfo>();
		list = dao.getAllTeacherInfo();
		for (TeacherInfo t : list) {
			System.out.print(t.gettNo() + " ");
			System.out.print(t.gettName() + " ");
			System.out.print(t.gettSex() + " ");
			System.out.print(t.gettDesc() + " ");
			System.out.println(t.getFacePic());
		}
	}

	public void test() {
		/* 获取单个老师信息 */
		// TeacherInfoDAO dao =new TeacherInfoDAO();
		// String tNo="2016090127";
		// List<TeacherInfo> list = new ArrayList<TeacherInfo>();
		// list=dao.getTeacherInfo(tNo);
		// for(TeacherInfo t:list){
		// System.out.print(t.gettNo()+" ");
		// System.out.print(t.gettName()+" ");
		// System.out.print(t.gettSex()+" ");
		// System.out.print(t.gettDesc()+" ");
		// System.out.print(t.getFacePic());
		// }

		/* 老师修改信息 */
		// TeacherInfoDAO dao = new TeacherInfoDAO();
		// String tName = "张三";
		// String tSex = "女";
		// String tDesc = "一个大学生";
		// String tNo = "2016090127";
		// TeacherInfo teacherInfo = new TeacherInfo();
		// teacherInfo.settName(tName);
		// teacherInfo.settSex(tSex);
		// teacherInfo.settDesc(tDesc);
		// teacherInfo.settNo(tNo);
		// if (dao.changeTeacherInfo(teacherInfo)) {
		// System.out.println("修改成功");
		// } else {
		// System.out.println("修改失败");
		// }

		/* 老师修改头像信息 */
		// TeacherInfoDAO dao = new TeacherInfoDAO();
		// String newFacePic = "newFacePic";
		// String tNo = "2016090127";
		// if (dao.changeTeacherFacePic(tNo, newFacePic)) {
		// System.out.println("头像修改成功");
		// } else {
		// System.out.println("头像修改失败");
		// }
	}
}
