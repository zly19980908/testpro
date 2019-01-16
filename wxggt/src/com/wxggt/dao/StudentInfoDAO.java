package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.formbean.RegisterCount;
import com.wxggt.util.DBUtil;

/*����ѧ����Ϣ��DAO*/
public class StudentInfoDAO {

	/* ע��������ͳ�� */
	public List<RegisterCount> showDateByDay() {
		List<RegisterCount> list = new ArrayList<RegisterCount>();
		String sql = "SELECT DATE_FORMAT(registerDate,'%Y-%m-%d') day_,COUNT(*) FROM studentinfo GROUP BY day_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RegisterCount registerCount = new RegisterCount();
				registerCount.setYear_(rs.getString(1).substring(0, 4));
				registerCount.setMonth_(rs.getString(1).substring(5, 7));
				registerCount.setDay_(rs.getString(1).substring(8, 10));
				registerCount.setRegisterCount_(rs.getInt(2));
				list.add(registerCount);
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

	/* ע��������ͳ�� */
	public List<RegisterCount> showDateByMouth() {
		List<RegisterCount> list = new ArrayList<RegisterCount>();
		String sql = "SELECT DATE_FORMAT(registerDate,'%Y-%m') month_,COUNT(*) FROM studentinfo GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				RegisterCount registerCount = new RegisterCount();
				registerCount.setYear_(rs.getString(1).substring(0, 4));
				registerCount.setMonth_(rs.getString(1).substring(5, 7));
				registerCount.setRegisterCount_(rs.getInt(2));
				list.add(registerCount);
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
		/* ע��������ͳ�� */
		StudentInfoDAO dao = new StudentInfoDAO();
		List<RegisterCount> list = dao.showDateByDay();
		for (RegisterCount r : list) {
			System.out
					.println(r.getYear_() + "��" + r.getMonth_() + "��" + r.getDay_() + "��,ע����" + r.getRegisterCount_());
		}

		/* ע��������ͳ�� */
		// StudentInfoDAO dao = new StudentInfoDAO();
		// List<RegisterCount> list = dao.showDateByMouth();
		// for (RegisterCount r : list) {
		// System.out.println(r.getYear_() + "��" + r.getMonth_() + "��,ע����" +
		// r.getRegisterCount_());
		// }

	}

}
