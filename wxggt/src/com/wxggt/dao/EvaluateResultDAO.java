package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.wxggt.dto.Evaluate;
import com.wxggt.dto.EvaluateResult;
import com.wxggt.util.DBUtil;

public class EvaluateResultDAO {
	//插入教学考评结果记录
	public boolean insertEvaluateResult(EvaluateResult evaluateResult){
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		try{
			conn = DBUtil.getConnection();
			String sql = "insert into evaluateresult(tNo,cNo,rank) values(?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, evaluateResult.gettNo());
			ps.setString(2, evaluateResult.getcNo());
			ps.setInt(3, evaluateResult.getRank());
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
		EvaluateResultDAO dao = new EvaluateResultDAO();
		EvaluateResult evaluateResult = new EvaluateResult("34567", "78915", 4);
		boolean result = dao.insertEvaluateResult(evaluateResult);
		System.out.println(result);
	}

}
