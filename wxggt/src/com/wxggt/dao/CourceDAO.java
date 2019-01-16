package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Course;
import com.wxggt.util.CreateCno;
import com.wxggt.util.DBUtil;

public class CourceDAO {

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

	public static void main(String[] args) {
		/* 创建一门课程 */
		CourceDAO dao = new CourceDAO();
		Course course = new Course();
		course.setcName("中基");
		course.settNo("2016010901");
		course.setSpecialtyid(1);
		course.setCourseDesc("哈哈");
		if (dao.createCourse(course)) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
	}

}
