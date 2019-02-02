package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.Practisequestion;
import com.wxggt.util.DBUtil;

public class PractisequestionDAO {
	/* ���ǶԾ�����Ŀ�Ĳ��� */

	/* �ϴ�һ���� */
	public boolean uploadQuestion(Practisequestion question) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO Practisequestion(pid,question,a,b,c,d,rightAnswer,qType,qAnalyze,qPic) VALUES(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, question.getPid());
			ps.setString(2, question.getQuestion());
			ps.setString(3, question.getA());
			ps.setString(4, question.getB());
			ps.setString(5, question.getC());
			ps.setString(6, question.getD());
			ps.setString(7, question.getRightAnswer());
			ps.setString(8, question.getqType());
			ps.setString(9, question.getqAnalyze());
			ps.setString(10, question.getqPic());
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

	/* ɾ��һ���� */
	public boolean deleteSingleQuestion(int questionId) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "delete from Practisequestion where QuestionId=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, questionId);
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

	/* ɾ��һ���� */
	public boolean deleteQuestionsBypId(int pId) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "delete from Practisequestion where pid=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
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

	/* �޸�һ���� */
	public boolean updateSingleQuestion(Practisequestion question) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "update Practisequestion set Question=?,A=?,B=?,C=?,D=?,rightAnswer=?,qAnalyze=?,qPic=? where QuestionId=?";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, question.getQuestion());
			ps.setString(2, question.getA());
			ps.setString(3, question.getB());
			ps.setString(4, question.getC());
			ps.setString(5, question.getD());
			ps.setString(6, question.getRightAnswer());
			ps.setString(7, question.getqAnalyze());
			ps.setString(8, question.getqPic());
			ps.setInt(9, question.getQuestionId());
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

	/* ��ʾһ���� */
	public List<Practisequestion> showSingleQuestion(int questionId) {
		List<Practisequestion> list = new ArrayList<Practisequestion>();
		String sql = "SELECT pid,question,a,b,c,d,rightAnswer,qType,qAnalyze,qPic FROM practisequestion WHERE questionId=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, questionId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Practisequestion practisequestion = new Practisequestion();
				practisequestion.setQuestionId(questionId);
				practisequestion.setPid(rs.getInt(1));
				practisequestion.setQuestion(rs.getString(2));
				practisequestion.setA(rs.getString(3));
				practisequestion.setB(rs.getString(4));
				practisequestion.setC(rs.getString(5));
				practisequestion.setD(rs.getString(6));
				practisequestion.setRightAnswer(rs.getString(7));
				practisequestion.setqType(rs.getString(8));
				practisequestion.setqAnalyze(rs.getString(9));
				practisequestion.setqPic(rs.getString(10));
				list.add(practisequestion);
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

	/* ��ʾһ���� */
	public List<Practisequestion> showQuestionsByPid(int pId) {
		List<Practisequestion> list = new ArrayList<Practisequestion>();
		String sql = "SELECT pid,question,a,b,c,d,rightAnswer,qType,qAnalyze,questionId,qPic FROM practisequestion WHERE pId=?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pId);
			rs = ps.executeQuery();
			while (rs.next()) {
				Practisequestion practisequestion = new Practisequestion();
				practisequestion.setQuestionId(rs.getInt(10));
				practisequestion.setPid(rs.getInt(1));
				practisequestion.setQuestion(rs.getString(2));
				practisequestion.setA(rs.getString(3));
				practisequestion.setB(rs.getString(4));
				practisequestion.setC(rs.getString(5));
				practisequestion.setD(rs.getString(6));
				practisequestion.setRightAnswer(rs.getString(7));
				practisequestion.setqType(rs.getString(8));
				practisequestion.setqAnalyze(rs.getString(9));
				practisequestion.setqPic(rs.getString(11));
				list.add(practisequestion);
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
	
	/*���ò��Ը�����Ƶ��ģ����ѯ��Ŀʮ��*/
	public List<Practisequestion> inclassTest(String source){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Practisequestion> list = new ArrayList<Practisequestion>();
		try{
			conn = DBUtil.getConnection();
			//�����ȡʮ������
			String sql = "select question,a,b,c,d,rightAnswer,qType,qAnalyze,qPic from practisequestion where question like ? and questionId >= ((SELECT MAX(questionId) FROM practisequestion)-(SELECT MIN(questionId) FROM practisequestion)) * RAND() + (SELECT MIN(questionId) FROM practisequestion)  LIMIT 10";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+source+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Practisequestion question = new Practisequestion();
				question.setQuestion(rs.getString(1));
				question.setA(rs.getString(2));
				question.setB(rs.getString(3));
				question.setC(rs.getString(4));
				question.setD(rs.getString(5));
				question.setRightAnswer(rs.getString(6));
				question.setqType(rs.getString(7));
				question.setqAnalyze(rs.getString(8));
				question.setqPic(rs.getString(9));
				list.add(question);
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
	
	/*���ò��Ը��ݿγ���ģ����ѯ��Ŀ��ʮ��*/
	public List<Practisequestion> termsTest(String course){
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Practisequestion> list = new ArrayList<Practisequestion>();
		try{
			conn = DBUtil.getConnection();
			//�����ȡʮ������
			String sql = "select question,a,b,c,d,rightAnswer,qType,qAnalyze,qPic from practisequestion where question like ? and questionId >= ((SELECT MAX(questionId) FROM practisequestion)-(SELECT MIN(questionId) FROM practisequestion)) * RAND() + (SELECT MIN(questionId) FROM practisequestion)  LIMIT 50";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+course+"%");
			rs = ps.executeQuery();
			while(rs.next()){
				Practisequestion question = new Practisequestion();
				question.setQuestion(rs.getString(1));
				question.setA(rs.getString(2));
				question.setB(rs.getString(3));
				question.setC(rs.getString(4));
				question.setD(rs.getString(5));
				question.setRightAnswer(rs.getString(6));
				question.setqType(rs.getString(7));
				question.setqAnalyze(rs.getString(8));
				question.setqPic(rs.getString(9));
				list.add(question);
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

	public static void main(String[] args) {
		/* ��ʾһ���� */
		PractisequestionDAO dao = new PractisequestionDAO();
		int questionId = 7;
		List<Practisequestion> list1 = dao.inclassTest("��");
		List<Practisequestion> list = dao.showSingleQuestion(questionId);
		for (Practisequestion p : list) {
			System.out.println(p.getQuestionId() + " " + p.getQuestion() + " " + p.getPid() + " " + p.getqPic());
		}
		for (Practisequestion p : list1) {
			System.out.println(p.getqAnalyze()+ " " + p.getQuestion() + " " + p.getPid() + " " + p.getqPic());
		}

		/* ��ʾһ���� */
		// PractisequestionDAO dao = new PractisequestionDAO();
		// int pId = 1;
		// List<Practisequestion> list = dao.showQuestionsByPid(pId);
		// for (Practisequestion p : list) {
		// System.out.println(p.getQuestionId() + " " + p.getQuestion() + " " +
		// p.getPid() + " " + p.getqPic());
		// }

		/* ɾ��һ���� */
		// PractisequestionDAO dao = new PractisequestionDAO();
		// int pId = 1;
		// if (dao.deleteQuestionsBypId(pId)) {
		// System.out.println("ɾ���ɹ�");
		// } else {
		// System.out.println("ɾ��ʧ��");
		// }

		// PractisequestionDAO dao = new PractisequestionDAO();
		// dao.test();
	}

	public void test() {
		/* ɾ��һ���� */
		// PractisequestionDAO dao = new PractisequestionDAO();
		// int questionId =6;
		// if (dao.deleteSingleQuestion(questionId)) {
		// System.out.println("ɾ���ɹ�");
		// } else {
		// System.out.println("ɾ��ʧ��");
		// }

		/* �ϴ�һ���� */
		// PractisequestionDAO dao = new PractisequestionDAO();
		// Practisequestion question = new Practisequestion();
		// question.setQuestionId(1);
		// question.setPid(1);
		// question.setQuestion("2?");
		// question.setA("1");
		// question.setB("2");
		// question.setC("3");
		// question.setD("4");
		// question.setRightAnswer("A");
		// question.setqType("1");
		// question.setqAnalyze("������");
		// question.setqPic("path");
		// if (dao.uploadQuestion(question)) {
		// System.out.println("�ϴ��ɹ�");
		// } else {
		// System.out.println("�ϴ�ʧ��");
		// }

		/* �޸�һ���� */
		PractisequestionDAO dao = new PractisequestionDAO();
		Practisequestion question = new Practisequestion();
		question.setQuestionId(7);
		question.setPid(1);
		question.setQuestion("1?");
		question.setA("A");
		question.setB("B");
		question.setC("C");
		question.setD("D");
		question.setRightAnswer("D");
		question.setqType("1");
		question.setqAnalyze("����");
		question.setqPic("Path_");
		if (dao.updateSingleQuestion(question)) {
			System.out.println("�޸ĳɹ�");
		} else {
			System.out.println("�޸�ʧ��");
		}

	}

}
