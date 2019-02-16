package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import com.wxggt.dto.SourceInfo;
import com.wxggt.util.DBUtil;
import com.wxggt.util.ManagerTime;
public class SourceInfoDAO {
	/* ���ǹ�����Ƶ��Դ��DAO */

	/* �ϴ�һ����Դ����Ҫ�ȴ����γ� */
	public boolean uploadSource(SourceInfo sourceInfo) {
		Connection conn = null;
		PreparedStatement ps = null;
		int rs = 0;
		String sql = "INSERT INTO sourceinfo(cNo,sourceName,sourceSort,sourceTime,downloadDate,sourceOrgin,isMajorType,sourceDesc) VALUES(?,?,?,?,CURRENT_TIME(),?,?,?)";
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sourceInfo.getcNo());
			ps.setString(2, sourceInfo.getSourceName());
			ps.setString(3, sourceInfo.getSourceSort());
			ps.setInt(4, sourceInfo.getSourceTime());
			ps.setString(5, sourceInfo.getSourceOrgin());
			ps.setInt(6, sourceInfo.getIsMajorType());
			ps.setString(7, sourceInfo.getSourceDesc());
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

	/* ���ݿγ̺Ų��������Ƶ��Դ(����Ƶ��ŵ���) */
	public List<SourceInfo> getSourcesByCno(String cno) {
		List<SourceInfo> list = new ArrayList<SourceInfo>();
		//TIMESTAMPDIFF(SECOND,downloadDate,CURRENT_TIME())����Ϊ��λ��ȡ���ݿ���ʱ���뵱ǰʱ���
		String sql = "SELECT id,cNo,sourceName,sourceSort,sourceTime,TIMESTAMPDIFF(SECOND,downloadDate,CURRENT_TIME()),sourceOrgin,isMajorType,sourceDesc FROM sourceinfo WHERE cno=? order by id ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ManagerTime manager = new ManagerTime();
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, cno);
			rs = ps.executeQuery();
			while (rs.next()) {
				SourceInfo sourceInfo = new SourceInfo();
				sourceInfo.setId(rs.getInt(1));
				sourceInfo.setcNo(rs.getString(2));
				sourceInfo.setSourceName(rs.getString(3));
				sourceInfo.setSourceSort(rs.getString(4));
				sourceInfo.setSourceTime(rs.getInt(5));
				String time = manager.jisuanTime(rs.getLong(6));
				sourceInfo.setDownloadDate(time);
				sourceInfo.setSourceOrgin(rs.getString(7));
				sourceInfo.setIsMajorType(rs.getInt(8));
				sourceInfo.setSourceDesc(rs.getString(9));
				list.add(sourceInfo);
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

		/* ���ݿγ̺Ų��������Ƶ��Դ(����Ƶ��ŵ���) */
//		SourceInfoDAO dao = new SourceInfoDAO();
//		String cno = "126263347916";
//		List<SourceInfo> list = dao.getSourcesByCno(cno);
//		for (SourceInfo s : list) {
//			System.out.println(s.getcNo() + " " + s.getSourceName());
//		}

		/* �ϴ�һ����Դ */
		 SourceInfoDAO dao = new SourceInfoDAO();
		 SourceInfo sourceInfo = new SourceInfo();
		 sourceInfo.setcNo("226322545460");
		 sourceInfo.setSourceName("�����");
		 sourceInfo.setSourceSort("����");
		 sourceInfo.setSourceTime(60);
		 sourceInfo.setSourceOrgin("path");
		 sourceInfo.setIsMajorType(1);
		 sourceInfo.setSourceDesc("hahah");
		 if (dao.uploadSource(sourceInfo)) {
		 System.out.println("�ϴ��ɹ�");
		 } else {
		 System.out.println("�ϴ�ʧ��");
		 }
	}
}
