package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Course;
import com.wxggt.dto.SourceInfo;
import com.wxggt.formbean.CourseInfoWithsource;
import com.wxggt.util.CreateCno;
import com.wxggt.util.DBUtil;

public class CourseDAO {

	/* 创建一门课程 */
	public boolean createCourse(Course course) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO course(cno,cName,tNo,specialtyid,courseDesc) VALUES(?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			course.setcNo(CreateCno.CreateCno_(course.getSpecialtyid()));
			ps.setString(1, course.getcNo());
			ps.setString(2, course.getcName());
			ps.setString(3, course.gettNo());
			ps.setInt(4, course.getSpecialtyid());
			ps.setString(5, course.getCourseDesc());
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

	/* 查看一门上传课程及其相关信息 */
	public List<CourseInfoWithsource> getSingleCourseInfo(String tNo, String cName) {
		List<CourseInfoWithsource> list = new ArrayList<CourseInfoWithsource>();
		String sql = "SELECT cNo,pageview,studyquantity,price,specialtyid,courseDesc FROM course WHERE tno=? AND cName=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tNo);
			ps.setString(2, cName);
			rs = ps.executeQuery();
			while (rs.next()) {
				CourseInfoWithsource csw = new CourseInfoWithsource();
				String cno = rs.getString(1);
				csw.setcNo(cno);
				SourceInfoDAO dao = new SourceInfoDAO();
				List<SourceInfo> list_ = dao.getSourcesByCno(cno);
				csw.setcName(cName);
				csw.settNo(tNo);
				csw.setPageview(rs.getInt(2));
				csw.setStudyquantity(rs.getInt(3));
				csw.setPrice(rs.getInt(4));
				csw.setSpecialtyid(rs.getInt(5));
				csw.setCourseDesc(rs.getString(6));
				csw.setSources(list_);
				list.add(csw);
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

	/* 查看一个老师所有上传课程及其相关信息 */
	public List<CourseInfoWithsource> getAllCourseInfo(String tNo) {
		List<CourseInfoWithsource> list = new ArrayList<CourseInfoWithsource>();
		String sql = "SELECT cNo,cName,pageview,studyquantity,price,specialtyid,courseDesc FROM course WHERE tno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				CourseInfoWithsource csw = new CourseInfoWithsource();
				String cno = rs.getString(1);
				csw.setcNo(cno);
				SourceInfoDAO dao = new SourceInfoDAO();
				List<SourceInfo> list_ = dao.getSourcesByCno(cno);
				csw.setcName(rs.getString(2));
				csw.settNo(tNo);
				csw.setPageview(rs.getInt(3));
				csw.setStudyquantity(rs.getInt(4));
				csw.setPrice(rs.getInt(5));
				csw.setSpecialtyid(rs.getInt(6));
				csw.setCourseDesc(rs.getString(7));
				csw.setSources(list_);
				list.add(csw);
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

		/* 查看一门上传课程及其相关信息 */
		// CourseDAO dao = new CourseDAO();
		// String tNo = "2016010901";
		// String cName = "中基";
		// List<CourseInfoWithsource> list = dao.getSingleCourseInfo(tNo,
		// cName);
		// for (CourseInfoWithsource c : list) {
		// System.out.println(c.getcNo() + " " + c.getcName() + " " +
		// c.getPageview() + " " + c.getPrice() + " "
		// + c.getCourseDesc());
		// for (SourceInfo s : c.getSources()) {
		// System.out.println(s.getSourceName() + " " + s.getSourceDesc());
		// }
		// }
		
		/* 查看所有上传课程及其相关信息 */
		CourseDAO dao = new CourseDAO();
		String tNo = "2016010901";
		List<CourseInfoWithsource> list = dao.getAllCourseInfo(tNo);
		for (CourseInfoWithsource c : list) {
			System.out.println(c.getcNo() + " " + c.getcName() + " " + c.getPageview() + " " + c.getPrice() + " "
					+ c.getCourseDesc());
			for (SourceInfo s : c.getSources()) {
				System.out.println(s.getSourceName() + " " + s.getSourceDesc());
			}
		}

		/* 创建一门课程 */
		// CourseDAO dao = new CourseDAO();
		// Course course = new Course();
		// course.setcName("中诊");
		// course.settNo("2016010901");
		// course.setSpecialtyid(2);
		// course.setCourseDesc("哈哈");
		// if (dao.createCourse(course)) {
		// System.out.println("创建成功");
		// } else {
		// System.out.println("创建失败");
		// }
	}

}
