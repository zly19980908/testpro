package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Evaluate;
import com.wxggt.util.DBUtil;

public class EvaluateDAO {
	/* 这是对学生评价内容的操作 */

	/* 删除管理员删除一个用户的评价 */
	public boolean deleteSingleEvaluate(int eid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "delete from Evaluate where eid=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eid);
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

	/* 查看各课程用户评价 */
	public List<Evaluate> getEvaluateBycNo(String tNo, String cNo) {
		List<Evaluate> list = new ArrayList<Evaluate>();
		String sql = "SELECT sNo,context,grade FROM evaluate WHERE tNo=? AND cNo=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tNo);
			ps.setString(2, cNo);
			rs = ps.executeQuery();
			while (rs.next()) {
				Evaluate evaluate = new Evaluate();
				evaluate.settNo(tNo);
				evaluate.setcNo(cNo);
				evaluate.setsNo(rs.getString(1));
				evaluate.setContext(rs.getString(2));
				evaluate.setGrade(rs.getInt(3));
				list.add(evaluate);
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
	
	/*微信端学生评教添加一条评价*/
	public boolean insertEvaluate(Evaluate evaluate){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into evaluate(tNo,cNo,sNo,context,grade) values(?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, evaluate.gettNo());
			ps.setString(2, evaluate.getcNo());
			ps.setString(3, evaluate.getsNo());
			ps.setString(4, evaluate.getContext());
			ps.setInt(5, evaluate.getGrade());
			rs = ps.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				
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
		/* 查看各课程用户评价 */
		// EvaluateDAO dao = new EvaluateDAO();
		// String tNo = "2016010901";
		// String cNo = "126263347916";
		// List<Evaluate> list = dao.getEvaluateBycNo(tNo, cNo);
		// for (Evaluate e : list) {
		// System.out.println(
		// e.gettNo() + " " + e.getcNo() + " " + e.getsNo() + " " +
		// e.getContext() + " " + e.getGrade());
		// }

		/* 删除管理员删除一个用户的评价 */
		EvaluateDAO dao = new EvaluateDAO();
		int eid = 1;
		Evaluate evaluate = new Evaluate("2016010901", "126263347916", "464643", "较好", 4);
		boolean result = dao.insertEvaluate(evaluate);
		System.out.println(result);
		if (dao.deleteSingleEvaluate(eid)) {
			System.out.println("删除成功");
		} else {
			System.out.println("删除失败");
		}
	}

}
