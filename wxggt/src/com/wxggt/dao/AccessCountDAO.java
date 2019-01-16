package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.AccessCount;
import com.wxggt.formbean.AccessCount_ByMonth;
import com.wxggt.util.DBUtil;

public class AccessCountDAO {
	/*
	 * 访问量：前端每天定时存数据进数据库 按月显示数据 按显示数据
	 */

	/* 按天显示数据 */
	public List<AccessCount> showDateByDay() {
		List<AccessCount> list = new ArrayList<AccessCount>();
		String sql = "SELECT aDate,accessCount FROM accesscounttable ORDER BY aDate ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccessCount accessCount = new AccessCount();
				accessCount.setaDate(rs.getDate(1));
				accessCount.setAccessCount(rs.getInt(2));
				list.add(accessCount);
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

	/* 按月显示数据 */
	public List<AccessCount_ByMonth> showDateByMonth() {
		List<AccessCount_ByMonth> list = new ArrayList<AccessCount_ByMonth>();
		String sql = "SELECT DATE_FORMAT(adate,'%Y%m') month_,SUM(accessCount) sum_ FROM accesscounttable,(SELECT DISTINCT DATE_FORMAT(adate,'%Y%m') date_ FROM accesscounttable ) a WHERE DATE_FORMAT(adate,'%Y%m')=a.date_ GROUP BY month_ ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				AccessCount_ByMonth accessCount = new AccessCount_ByMonth();
				accessCount.setYear_(rs.getString(1).substring(0, 4));
				accessCount.setMonth_(rs.getString(1).substring(4, 6));
				accessCount.setAccessCount(rs.getInt(2));
				list.add(accessCount);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
				rs.close();
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}

	public static void main(String[] args) {
		/* 按天显示数据 */
		// AccessCountDAO dao=new AccessCountDAO();
		// List<AccessCount> list=dao.showDateByDay();
		// for(AccessCount a:list){
		// System.out.println(a.getaDate()+" "+a.getAccessCount());
		// }

		/* 按月显示数据 */
		AccessCountDAO dao = new AccessCountDAO();
		List<AccessCount_ByMonth> list = dao.showDateByMonth();
		for (AccessCount_ByMonth a : list) {
			System.out.println(a.getYear_() + "年" + a.getMonth_() + "月" + " " +"访问量："+a.getAccessCount());
		}

	}

}
