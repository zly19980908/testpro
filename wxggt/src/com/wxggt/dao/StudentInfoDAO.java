package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.formbean.RegisterCount;
import com.wxggt.util.DBUtil;

/*处理学生信息的DAO*/
public class StudentInfoDAO {

	/* 注册量按天统计 */
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

	/* 注册量按月统计 */
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
	
	/*微信端学生购买课程根据学生编号减少学生金额*/
	public boolean descMoney(int money,String Sno){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "update studentinfo set balance=balance-? where Sno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, Sno);
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
		/* 注册量按天统计 */
		StudentInfoDAO dao = new StudentInfoDAO();
		List<RegisterCount> list = dao.showDateByDay();
		for (RegisterCount r : list) {
			System.out
					.println(r.getYear_() + "年" + r.getMonth_() + "月" + r.getDay_() + "日,注册量" + r.getRegisterCount_());
		}
		boolean result = dao.descMoney(50, "2016010901");
		System.out.println(result);

		/* 注册量按月统计 */
		// StudentInfoDAO dao = new StudentInfoDAO();
		// List<RegisterCount> list = dao.showDateByMouth();
		// for (RegisterCount r : list) {
		// System.out.println(r.getYear_() + "年" + r.getMonth_() + "月,注册量" +
		// r.getRegisterCount_());
		// }

	}

}
