package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Evaluate;
import com.wxggt.util.DBUtil;

public class EvaluateDAO {
	/*这是对学生评价内容的操作*/

	/*查看各课程用户评价*/
	public List<Evaluate> getEvaluateBycNo(String tNo,String cNo){
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
				Evaluate evaluate=new Evaluate();
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
	
	public static void main(String[] args) {
		/*查看各课程用户评价*/
		EvaluateDAO dao=new EvaluateDAO();
		String tNo="2016010901";
		String cNo="126263347916";
		List<Evaluate> list=dao.getEvaluateBycNo(tNo, cNo);
		for(Evaluate e:list){
			System.out.println(e.gettNo()+" "+e.getcNo()+" "+e.getsNo()+" "+e.getContext()+" "+e.getGrade());
		}
	}

}
