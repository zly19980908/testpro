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
	
	/*΢�Ŷ˸��ݽ�ʦ�Ų�ѯ�ý�ʦ�����пγ�*/
	public List<Course> findAllCourseByTno(String tno){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Course> list = new ArrayList<Course>();
		try{
			conn = DBUtil.getConnection();
			String sql = "select cNo,cName,tNo,pageview,studyquantity,price,specialtyid,courseDesc from course where tNo =?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			rs = ps.executeQuery();
			while(rs.next()){
				Course course = new Course();
				course.setcNo(rs.getString(1));
				course.setcName(rs.getString(2));
				course.settNo(rs.getString(3));
				course.setPageview(rs.getInt(4));
				course.setStudyquantity(rs.getInt(5));
				course.setPrice(rs.getInt(6));
				course.setSpecialtyid(rs.getInt(7));
				course.setCourseDesc(rs.getString(8));
				list.add(course);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		return list;
	}

	/* �鿴һ���ϴ��γ̼��������Ϣ */
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

	/* �鿴һ����ʦ�����ϴ��γ̼��������Ϣ */
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
	
	/*΢�Ŷ˸��ݿγ���ģ����ѯ�γ���Ϣ*/
	public List<Course> getFrontAllCourseInfo(String cName) {
		List<Course> list = new ArrayList<Course>();
		String sql = "SELECT pageview,price,tNo,tName,cName,cNo,imageUrl FROM course WHERE cName like ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+cName+"%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Course csw = new Course();
				csw.setPageview(rs.getInt(1));
				csw.setPrice(rs.getInt(2));
				csw.settNo(rs.getString(3));
				csw.settName(rs.getString(4));
				csw.setcName(rs.getString(5));
				csw.setcNo(rs.getString(6));
				csw.setImageUrl(rs.getString(7));
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
	
	/*΢�Ŷ˷���һ�θ��ݿγ�id��������һ*/
	public boolean addPageView(String cNo){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "update course set pageview=pageview+1 where cNo = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cNo);
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}
	/*΢�Ŷ˹���һ�θ��ݿγ�id��������һ*/
	public boolean addStudyquantity(String cNo){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "update course set studyquantity=studyquantity+1 where cNo = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, cNo);
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
		if(rs>0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {

		/* �鿴һ���ϴ��γ̼��������Ϣ */
		// CourseDAO dao = new CourseDAO();
		// String tNo = "2016010901";
		// String cName = "�л�";
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
		
		/* �鿴�����ϴ��γ̼��������Ϣ */
		CourseDAO dao = new CourseDAO();
		String tNo = "2016010901";
		boolean result = dao.addPageView("126263347916");
		boolean result2 = dao.addStudyquantity("126263347916");
		System.out.println(result+" "+result2);
		List<CourseInfoWithsource> list = dao.getAllCourseInfo(tNo);
		List<Course> list2 = dao.getFrontAllCourseInfo("��");
		List<Course> list3 = dao.findAllCourseByTno("2016010901");
		for (Course c : list2) {
			System.out.println(c.getcName()+' '+c.getPageview()+' '+c.getPrice()+' '+c.gettNo());
		}
		for (CourseInfoWithsource c : list) {
			System.out.println(c.getcNo() + " " + c.getcName() + " " + c.getPageview() + " " + c.getPrice() + " "
					+ c.getCourseDesc());
			for (SourceInfo s : c.getSources()) {
				System.out.println(s.getSourceName() + " " + s.getSourceDesc());
			}
		}
		for (Course c :list3){
			System.out.println(c.getcNo() + " " + c.getcName() + " " + c.getPageview() + " " + c.getPrice() + " "
					+ c.getCourseDesc());
		}

		/* ����һ�ſγ� */
		// CourseDAO dao = new CourseDAO();
		// Course course = new Course();
		// course.setcName("����");
		// course.settNo("2016010901");
		// course.setSpecialtyid(2);
		// course.setCourseDesc("����");
		// if (dao.createCourse(course)) {
		// System.out.println("�����ɹ�");
		// } else {
		// System.out.println("����ʧ��");
		// }
	}

}
