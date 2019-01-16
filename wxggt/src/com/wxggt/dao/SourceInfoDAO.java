package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.SourceInfo;
import com.wxggt.util.DBUtil;

public class SourceInfoDAO {
	/* 这是关于视频资源的DAO */

	/* 上传一个资源集需要先创建课程 */
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

	/* 根据课程号查出所有视频资源(按视频序号递增) */
	public List<SourceInfo> getSourcesByCno(String cno) {
		List<SourceInfo> list = new ArrayList<SourceInfo>();
		String sql = "SELECT id,cNo,sourceName,sourceSort,sourceTime,downloadDate,sourceOrgin,isMajorType,sourceDesc FROM sourceinfo WHERE cno=? order by id ASC";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
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
				sourceInfo.setDownloadDate(rs.getDate(6));
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

		/* 根据课程号查出所有视频资源(按视频序号递增) */
//		SourceInfoDAO dao = new SourceInfoDAO();
//		String cno = "126263347916";
//		List<SourceInfo> list = dao.getSourcesByCno(cno);
//		for (SourceInfo s : list) {
//			System.out.println(s.getcNo() + " " + s.getSourceName());
//		}

		/* 上传一个资源 */
		 SourceInfoDAO dao = new SourceInfoDAO();
		 SourceInfo sourceInfo = new SourceInfo();
		 sourceInfo.setcNo("226322545460");
		 sourceInfo.setSourceName("中诊二");
		 sourceInfo.setSourceSort("中诊");
		 sourceInfo.setSourceTime(60);
		 sourceInfo.setSourceOrgin("path");
		 sourceInfo.setIsMajorType(1);
		 sourceInfo.setSourceDesc("hahah");
		 if (dao.uploadSource(sourceInfo)) {
		 System.out.println("上传成功");
		 } else {
		 System.out.println("上传失败");
		 }
	}
}
