package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.TeacherInfo;
import com.wxggt.util.DBUtil;

/* 处理老师信息的DAO */
public class TeacherInfoDAO {

    // 通过账号密码登陆
    public boolean findBy(String account, String password) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from teacherinfo where tno=? and pwd=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, account);
            ps.setString(2, password);
            result = ps.executeQuery();
            if (result.next()) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            result.close();
            ps.close();
            conn.close();
        }
        return flag;
    }

    // 注册一个教师(先从临时表删除记录，再添加)
    public boolean addTeacher(TeacherInfo t) throws SQLException {
        TempTeacherInfoDAO tmp = new TempTeacherInfoDAO();
        boolean flag = false;
        if (tmp.delTmp(t.gettNo())) {

            Connection conn = null;
            PreparedStatement ps = null;
            int result = 0;
            try {
                conn = DBUtil.getConnection();
                String sql = "insert into teacherinfo(tno,pwd,tname,tsex,tdesc,teacherlicense,phone,facepic,email) values(?,?,?,?,?,?,?,?,?)";
                ps = conn.prepareStatement(sql);
                ps.setString(1, t.gettNo());
                ps.setString(2, t.getPwd());
                ps.setString(3, t.gettName());
                ps.setString(4, t.gettSex());
                ps.setString(5, t.gettDesc());
                ps.setString(6, t.getTeacherLicense());
                ps.setString(7, t.getTel());
                ps.setString(8, t.getFacePic());
                ps.setString(9, t.getEmail());
                result = ps.executeUpdate();
                if (result > 0) {
                    flag = true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ps.close();
                conn.close();
            }
        }
        return flag;
    }

    /* 查看全部教师信息 */
    public List<TeacherInfo> getAllTeacherInfo() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select tNo,tName,tSex,tDesc,facePic from TeacherInfo";
        List<TeacherInfo> list = new ArrayList<TeacherInfo>();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                TeacherInfo teacherInfo = new TeacherInfo();
                teacherInfo.settNo(rs.getString(1));
                teacherInfo.settName(rs.getString(2));
                teacherInfo.settSex(rs.getString(3));
                teacherInfo.settDesc(rs.getString(4));
                teacherInfo.setFacePic(rs.getString(5));
                list.add(teacherInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return list;
    }

    /* 获取单个教师信息 */
    public List<TeacherInfo> getTeacherInfo(String tNo) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select tNo,tName,tSex,tDesc,facePic from TeacherInfo where tNo=?";
        List<TeacherInfo> list = new ArrayList<TeacherInfo>();
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, tNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                TeacherInfo teacherInfo = new TeacherInfo();
                teacherInfo.settNo(rs.getString(1));
                teacherInfo.settName(rs.getString(2));
                teacherInfo.settSex(rs.getString(3));
                teacherInfo.settDesc(rs.getString(4));
                teacherInfo.setFacePic(rs.getString(5));
                list.add(teacherInfo);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                ps.close();
                conn.close();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return list;
    }

    /* 老师修改信息 */
    public boolean changeTeacherInfo(TeacherInfo teacherInfo) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = "update TeacherInfo set tName=?,tSex=?,tDesc=? where tNo=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, teacherInfo.gettName());
            ps.setString(2, teacherInfo.gettSex());
            ps.setString(3, teacherInfo.gettDesc());
            ps.setString(4, teacherInfo.gettNo());
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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

    /* 老师修改头像 */
    public boolean changeTeacherFacePic(String tNo, String newFacePic) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        String sql = "update TeacherInfo set facePic=? where tNo=?";
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newFacePic);
            ps.setString(2, tNo);
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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

    // public static void main(String[] args) {
    /* 获取全部老师信息 */
    /*
     * TeacherInfoDAO dao = new TeacherInfoDAO();
     * List<TeacherInfo> list = new ArrayList<TeacherInfo>();
     * list = dao.getAllTeacherInfo();
     * for (TeacherInfo t : list) {
     * System.out.print(t.gettNo() + " ");
     * System.out.print(t.gettName() + " ");
     * System.out.print(t.gettSex() + " ");
     * System.out.print(t.gettDesc() + " ");
     * System.out.println(t.getFacePic());
     * }
     * }
     */

    public void test() {
        /* 获取单个老师信息 */
        // TeacherInfoDAO dao =new TeacherInfoDAO();
        // String tNo="2016090127";
        // List<TeacherInfo> list = new ArrayList<TeacherInfo>();
        // list=dao.getTeacherInfo(tNo);
        // for(TeacherInfo t:list){
        // System.out.print(t.gettNo()+" ");
        // System.out.print(t.gettName()+" ");
        // System.out.print(t.gettSex()+" ");
        // System.out.print(t.gettDesc()+" ");
        // System.out.print(t.getFacePic());
        // }

        /* 老师修改信息 */
        // TeacherInfoDAO dao = new TeacherInfoDAO();
        // String tName = "张三";
        // String tSex = "女";
        // String tDesc = "一个大学生";
        // String tNo = "2016090127";
        // TeacherInfo teacherInfo = new TeacherInfo();
        // teacherInfo.settName(tName);
        // teacherInfo.settSex(tSex);
        // teacherInfo.settDesc(tDesc);
        // teacherInfo.settNo(tNo);
        // if (dao.changeTeacherInfo(teacherInfo)) {
        // System.out.println("修改成功");
        // } else {
        // System.out.println("修改失败");
        // }

        /* 老师修改头像信息 */
        // TeacherInfoDAO dao = new TeacherInfoDAO();
        // String newFacePic = "newFacePic";
        // String tNo = "2016090127";
        // if (dao.changeTeacherFacePic(tNo, newFacePic)) {
        // System.out.println("头像修改成功");
        // } else {
        // System.out.println("头像修改失败");
        // }
    }
}
