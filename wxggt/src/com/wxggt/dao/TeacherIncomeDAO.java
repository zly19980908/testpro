package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.TeacherIncome;
import com.wxggt.formbean.TeacherIncome_;
import com.wxggt.util.DBUtil;

public class TeacherIncomeDAO {
	/* 这是对老师收益的管理 */

	/* 查看每笔总收益 */
	public List<TeacherIncome> showEveryIncome(String tno) {
		List<TeacherIncome> list = new ArrayList<>();
		String sql = "SELECT cno,iDate,iSumary,iType FROM teacherincome WHERE Tno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome ti = new TeacherIncome();
				ti.setCno(rs.getString(1));
				ti.setiDate(rs.getDate(2));
				ti.setiSumary(rs.getInt(3));
				ti.setiType(rs.getString(4));
				ti.setTno(tno);
				list.add(ti);
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

	/* 查看每个月的总收益 */
	public List<TeacherIncome_> showEveryMonthIncome(String tno) {
		List<TeacherIncome_> list = new ArrayList<>();
		String sql = "SELECT DATE_FORMAT(iDate,'%Y-%m') month_,SUM(iSumary) sum_  FROM teacherincome,(SELECT DISTINCT DATE_FORMAT(iDate,'%Y%m') date_ FROM teacherincome ) a  WHERE DATE_FORMAT(iDate,'%Y%m')=a.date_ AND Tno=? GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome_ ti = new TeacherIncome_();
				ti.setYear_(rs.getString(1).substring(0, 4));
				ti.setMonth_(rs.getString(1).substring(5, 7));
				ti.setIncome_(rs.getString(2));
				list.add(ti);
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

	/* 查看每个月购买课程的收益 */
	public List<TeacherIncome_> showEveryMonthCourseIncome(String tno) {
		List<TeacherIncome_> list = new ArrayList<>();
		String sql = "SELECT DATE_FORMAT(iDate,'%Y-%m') month_,SUM(iSumary) sum_  FROM teacherincome,(SELECT DISTINCT DATE_FORMAT(iDate,'%Y%m') date_ FROM teacherincome ) a  WHERE DATE_FORMAT(iDate,'%Y%m')=a.date_ AND iType='2' AND Tno=? GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome_ ti = new TeacherIncome_();
				ti.setYear_(rs.getString(1).substring(0, 4));
				ti.setMonth_(rs.getString(1).substring(5, 7));
				ti.setIncome_(rs.getString(2));
				list.add(ti);
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

	/* 查看每个月打赏的收益 */
	public List<TeacherIncome_> showEveryMonthRewardIncome(String tno) {
		List<TeacherIncome_> list = new ArrayList<>();
		String sql = "SELECT DATE_FORMAT(iDate,'%Y-%m') month_,SUM(iSumary) sum_  FROM teacherincome,(SELECT DISTINCT DATE_FORMAT(iDate,'%Y%m') date_ FROM teacherincome ) a  WHERE DATE_FORMAT(iDate,'%Y%m')=a.date_ AND iType='1' AND Tno=? GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome_ ti = new TeacherIncome_();
				ti.setYear_(rs.getString(1).substring(0, 4));
				ti.setMonth_(rs.getString(1).substring(5, 7));
				ti.setIncome_(rs.getString(2));
				list.add(ti);
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

	/* 一门课程的每笔收入流水 */
	public List<TeacherIncome> showEverySingleCourseIncome(String tno, String cno) {
		List<TeacherIncome> list = new ArrayList<>();
		String sql = "SELECT iDate,iSumary FROM teacherincome WHERE iType='2' AND Tno=? AND cno=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setString(2, cno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome ti = new TeacherIncome();
				ti.setCno(cno);
				ti.setiDate(rs.getDate(1));
				ti.setiSumary(rs.getInt(2));
				ti.setTno(tno);
				list.add(ti);
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

	/* 一门课程的每月收入流水 */
	public List<TeacherIncome_> showEveryMonthSingleCourseIncome(String tno, String cno) {
		List<TeacherIncome_> list = new ArrayList<>();
		String sql = "SELECT DATE_FORMAT(iDate,'%Y-%m') month_,SUM(iSumary) sum_  FROM teacherincome,(SELECT DISTINCT DATE_FORMAT(iDate,'%Y%m') date_ FROM teacherincome ) a WHERE DATE_FORMAT(iDate,'%Y%m')=a.date_ AND iType='2' AND Tno=? AND cno=? GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tno);
			ps.setString(2, cno);
			rs = ps.executeQuery();
			while (rs.next()) {
				TeacherIncome_ ti = new TeacherIncome_();
				ti.setYear_(rs.getString(1).substring(0, 4));
				ti.setMonth_(rs.getString(1).substring(5, 7));
				ti.setIncome_(rs.getString(2));
				list.add(ti);
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
		/* 一门课程的每月收入流水 */
		TeacherIncomeDAO dao = new TeacherIncomeDAO();
		String tno = "2016010901";
		String cno = "126263347916";
		List<TeacherIncome_> list = dao.showEveryMonthSingleCourseIncome(tno, cno);
		for (TeacherIncome_ t : list) {
			System.out.println(t.getYear_() + " " + t.getMonth_() + " " + t.getIncome_());
		}
	}

	public void test() {
		/* 查看每笔总收益 */
		// TeacherIncomeDAO dao=new TeacherIncomeDAO();
		// String tno="2016010901";
		// List<TeacherIncome> list=dao.showEveryIncome(tno);
		// for(TeacherIncome t:list){
		// System.out.println(t.getCno()+" "+t.getiDate()+" "+t.getiSumary()+"
		// "+t.getiType());
		// }

		/* 查看每个月的总收益 */
		// TeacherIncomeDAO dao = new TeacherIncomeDAO();
		// String tno = "2016010901";
		// List<TeacherIncome_> list = dao.showEveryMonthIncome(tno);
		// for (TeacherIncome_ t : list) {
		// System.out.println(t.getYear_()+" "+t.getMonth_()+"
		// "+t.getIncome_());
		// }

		/* 查看每个月购买课程的收益 */
		// TeacherIncomeDAO dao = new TeacherIncomeDAO();
		// String tno = "2016010901";
		// List<TeacherIncome_> list = dao.showEveryMonthCourseIncome(tno);
		// for (TeacherIncome_ t : list) {
		// System.out.println(t.getYear_() + " " + t.getMonth_() + " " +
		// t.getIncome_());
		// }

		/* 查看每个月打赏的收益 */
		// TeacherIncomeDAO dao = new TeacherIncomeDAO();
		// String tno = "2016010901";
		// List<TeacherIncome_> list = dao.showEveryMonthRewardIncome(tno);
		// for (TeacherIncome_ t : list) {
		// System.out.println(t.getYear_() + " " + t.getMonth_() + " " +
		// t.getIncome_());
		// }

		/* 一门课程的每笔收入流水 */
		// TeacherIncomeDAO dao = new TeacherIncomeDAO();
		// String tno = "2016010901";
		// String cno = "126263347916";
		// List<TeacherIncome> list = dao.showEverySingleCourseIncome(tno, cno);
		// for (TeacherIncome t : list) {
		// System.out.println(t.getCno() + " " + t.getiDate() + " " +
		// t.getiSumary() + " ");
		// }
	}
}
