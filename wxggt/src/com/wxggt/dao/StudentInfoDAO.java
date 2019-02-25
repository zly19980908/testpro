package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.StudentInfo;
import com.wxggt.formbean.RegisterCount;
import com.wxggt.util.DBUtil;

/* ����ѧ����Ϣ��DAO */
public class StudentInfoDAO {

    /* ע��������ͳ�� */
    public List<RegisterCount> showDateByDay() {
        List<RegisterCount> list = new ArrayList<RegisterCount>();
        String sql = "SELECT DATE_FORMAT(registerDate,'%Y-%m-%d') day_,COUNT(*) FROM studentinfo GROUP BY day_ ASC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RegisterCount registerCount = new RegisterCount();
                registerCount.setYear_(rs.getString(1).substring(0, 4));
                registerCount.setMonth_(rs.getString(1).substring(5, 7));
                registerCount.setDay_(rs.getString(1).substring(8, 10));
                registerCount.setRegisterCount_(rs.getInt(2));
                list.add(registerCount);
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

    /* ע��������ͳ�� */
    public List<RegisterCount> showDateByMouth() {
        List<RegisterCount> list = new ArrayList<RegisterCount>();
        String sql = "SELECT DATE_FORMAT(registerDate,'%Y-%m') month_,COUNT(*) FROM studentinfo GROUP BY month_ ASC";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                RegisterCount registerCount = new RegisterCount();
                registerCount.setYear_(rs.getString(1).substring(0, 4));
                registerCount.setMonth_(rs.getString(1).substring(5, 7));
                registerCount.setRegisterCount_(rs.getInt(2));
                list.add(registerCount);
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

    /* ΢�Ŷ�ѧ����γ̸��ѧ���ż���ѧ���� */
    public boolean descMoney(int money, String Sno) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "update studentinfo set balance=balance-? where Sno=?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, money);
            ps.setString(2, Sno);
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
        if (rs > 0)
            return true;
        else
            return false;
    }

    // 查看所有学生信息
    public List<StudentInfo> showStudentInfo() throws SQLException {
        List<StudentInfo> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            list = new ArrayList<StudentInfo>();
            conn = DBUtil.getConnection();
            String sql = "select * from studentinfo";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                StudentInfo s = new StudentInfo();
                s.setsNo(rs.getString(1));
                s.setsName(rs.getString(2));
                s.setsTel(rs.getString(3));
                s.setsSex(rs.getString(4));
                s.setsBir(rs.getString(5));
                s.setUploadPower(rs.getInt(6));
                s.setFreezeDate(rs.getDate(7));
                s.setVip(rs.getInt(8));
                s.setBalance(rs.getInt(9));
                s.setRegisterDate(rs.getDate(10));
                list.add(s);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return list;
    }

    // 根据id查看某个用户信息
    public StudentInfo showStudent(String id) throws SQLException {
        StudentInfo s = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "select * from studentinfo where sno=?";
            ps.setString(1, id);
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new StudentInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getInt(8), rs.getInt(9), rs.getDate(10));
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            ps.close();
            conn.close();
        }
        return null;
    }

    // 学生信息解冻
    public boolean updateStatus(String id) throws SQLException {
        boolean flag = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("update studentinfo set freezeDate=? where sno=?");
            // ps.setTimestamp(1, new java.sql.Timestamp(1970-01-01).getTime());
            ps.setString(2, id);
            int result = ps.executeUpdate();
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
        /* ע��������ͳ�� */
        StudentInfoDAO dao = new StudentInfoDAO();
        List<RegisterCount> list = dao.showDateByDay();
        for (RegisterCount r : list) {
            System.out.println(r.getYear_() + "��" + r.getMonth_() + "��" + r.getDay_() + "��,ע����"
                    + r.getRegisterCount_());
        }
        boolean result = dao.descMoney(50, "2016010901");
        System.out.println(result);

        /* ע��������ͳ�� */
        // StudentInfoDAO dao = new StudentInfoDAO();
        // List<RegisterCount> list = dao.showDateByMouth();
        // for (RegisterCount r : list) {
        // System.out.println(r.getYear_() + "��" + r.getMonth_() + "��,ע����" +
        // r.getRegisterCount_());
        // }

    }

}
