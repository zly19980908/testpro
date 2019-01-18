package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Practise;
import com.wxggt.dto.Practisequestion;
import com.wxggt.formbean.QuestionsBase;
import com.wxggt.util.DBUtil;

public class PractiseDAO {
	/* 这是操作练习题库表的dao */

	/* 新建一个题库 */
	public boolean createQuestionBase(Practise practise) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO Practise(cno,pType) VALUES(?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, practise.getcNo());
			ps.setInt(2, practise.getpType());
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

	/* 查找一个题库 */
	public List<QuestionsBase> getSingleQuestionBase(int pid) {
		List<QuestionsBase> list = new ArrayList<QuestionsBase>();
		String sql = "select cNo,pType FROM practise where pid=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionsBase qb = new QuestionsBase();
				PractisequestionDAO dao_1 = new PractisequestionDAO();
				qb.setPid(pid);
				qb.setcNo(rs.getString(1));
				qb.setpType(rs.getInt(2));
				qb.setPractisequestion(dao_1.showQuestionsByPid(pid));
				list.add(qb);
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

	/* 查找所有题库 */
	public List<QuestionsBase> getAllQuestionBase() {
		List<QuestionsBase> list = new ArrayList<QuestionsBase>();
		String sql = "select pid,cNo,pType FROM practise";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				QuestionsBase qb = new QuestionsBase();
				PractisequestionDAO dao_1 = new PractisequestionDAO();
				int pid = rs.getInt(1);
				qb.setPid(pid);
				qb.setcNo(rs.getString(2));
				qb.setpType(rs.getInt(3));
				qb.setPractisequestion(dao_1.showQuestionsByPid(pid));
				list.add(qb);
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

	/* 删除一个题库 */
	public boolean deleteSingleQuestionBath(int pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "delete from Practise where pid=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pid);
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
		/* 查找一个题库 */
		// PractiseDAO dao = new PractiseDAO();
		// int pid = 1;
		// List<QuestionsBase> list = dao.getSingleQuestionBase(pid);
		// for (QuestionsBase q : list) {
		// System.out.println(q.getPid() + " " + q.getcNo() + " " +
		// q.getpType());
		// for (Practisequestion p : q.getPractisequestion()) {
		// System.out.println(p.getQuestionId() + " " + p.getQuestion() + " " +
		// p.getPid() + " " + p.getqPic());
		// }
		// }
		/* 查找所有题库 */
		PractiseDAO dao = new PractiseDAO();
		List<QuestionsBase> list = dao.getAllQuestionBase();
		for (QuestionsBase q : list) {
			System.out.println(q.getPid() + " " + q.getcNo() + " " + q.getpType());
			for (Practisequestion p : q.getPractisequestion()) {
				System.out.println(p.getQuestionId() + " " + p.getQuestion() + " " + p.getPid() + " " + p.getqPic());
			}
		}
		
		// dao.test();
	}

	public void test() {
		/* 删除一个题库 */
		// PractiseDAO dao = new PractiseDAO();
		// int pid = 2;
		// if (dao.deleteSingleQuestionBath(pid)) {
		// System.out.println("删除成功");
		// } else {
		// System.out.println("删除失败");
		// }
		/* 新建一个题库 */
		PractiseDAO dao = new PractiseDAO();
		Practise practise = new Practise();
		practise.setcNo("126263347916");
		practise.setpType(1);
		if (dao.createQuestionBase(practise)) {
			System.out.println("创建成功");
		} else {
			System.out.println("创建失败");
		}
	}
}
