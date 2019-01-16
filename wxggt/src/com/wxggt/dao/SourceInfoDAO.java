package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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

	public static void main(String[] args) {
		/* 上传一个资源 */
		SourceInfoDAO dao = new SourceInfoDAO();
		SourceInfo sourceInfo = new SourceInfo();
		sourceInfo.setcNo("126263347916");
		sourceInfo.setSourceName("中基视频-二");
		sourceInfo.setSourceSort("中基");
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
