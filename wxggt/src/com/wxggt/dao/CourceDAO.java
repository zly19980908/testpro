package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Course;
import com.wxggt.util.CreateCno;
import com.wxggt.util.DBUtil;

public class CourceDAO {

	/* ����һ�ſγ� */
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
		/* ����һ�ſγ� */
		CourceDAO dao = new CourceDAO();
		Course course = new Course();
		course.setcName("�л�");
		course.settNo("2016010901");
		course.setSpecialtyid(1);
		course.setCourseDesc("����");
		if (dao.createCourse(course)) {
			System.out.println("�����ɹ�");
		} else {
			System.out.println("����ʧ��");
		}
	}

}
