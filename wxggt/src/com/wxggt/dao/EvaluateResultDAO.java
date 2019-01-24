package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Activity;
import com.wxggt.dto.EvaluateResult;
import com.wxggt.util.DBUtil;

public class EvaluateResultDAO {
	/* 这是对考评结果的操作 */
	//显示考评所有结果信息
	public List<EvaluateResult> showEvaluateResult(int page,int pageSize) throws SQLException{
		List<EvaluateResult> list=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			list = new ArrayList<EvaluateResult>();
			conn = DBUtil.getConnection();
			String sql ="select * from evaluateResult order by rank limit ?,?";
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pageSize*(page-1));
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				EvaluateResult eve=new EvaluateResult();
				eve.setcNo(rs.getString(2));
				eve.setRank(rs.getInt(3));
				eve.settNo(rs.getString(1));
				list.add(eve);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		
		return list;
	}
	
	//按照老师编号查询评价表评价表按照成绩降序
	public List<EvaluateResult> queryByTno(String id) throws SQLException{
		List <EvaluateResult> list =null;
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs= null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select * from evaluateresult where tno=? order by rank desc");
			ps.setString(1, id);
//			ps.setInt(2, page*(pageSize-1));
//			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			while(rs.next()){
				EvaluateResult e = new EvaluateResult();
				e.settNo(rs.getString(1));
				e.setcNo(rs.getString(2));
				e.setRank(rs.getInt(3));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return list;
	}
	public static void main(String[] args) throws SQLException {
		EvaluateResultDAO eva = new EvaluateResultDAO();
		List<EvaluateResult> list =eva.showEvaluateResult(1,2);
		for(EvaluateResult t:list){
			System.out.println("评价结果:"+t.gettNo()+"  "+t.getcNo()+"  "+t.getRank());
		}
	}
	
}
