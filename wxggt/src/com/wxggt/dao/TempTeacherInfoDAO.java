package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wxggt.dto.TempTeacherInfo;
import com.wxggt.util.DBUtil;

/* 处理老师注册时信息的DAO */
/*
 * 主要功能：
 * 1.注册一个临时老师
 * 2.审核通过，先把信息添加到老师表，然后确认成功后在临时表中删除这条记录，发送一条成功信息？
 * 3.审核不通过，发送一条失败信息？
 */
public class TempTeacherInfoDAO {

    // 注册一个临时老师
    public boolean tmpTeacher(TempTeacherInfo tmp) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn
                    .prepareStatement("insert into tempteacherinfo(tno,tname,tsex,teacherlicense,tdesc) values(?,?,?,?,?)");
            ps.setString(1, tmp.gettNo());
            ps.setString(2, tmp.gettName());
            ps.setString(3, tmp.gettSex());
            ps.setString(4, tmp.getTeacherLicense());
            ps.setString(5, tmp.gettDesc());
            int result = ps.executeUpdate();
            System.out.println(result);
            if (result > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
        return flag;
    }

    // 审核通过，删除临时表信息
    public boolean delTmp(String id) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        // ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("delete from tempteacherinfo where tno=?");
            ps.setString(1, id);
            int result = ps.executeUpdate();
            System.out.println(result);
            if (result > 0) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ps.close();
            conn.close();
        }
        return flag;
    }

    public static void main(String[] args) {

    }

}
