package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.wxggt.dto.EvaluateResult;
import com.wxggt.util.DBUtil;

public class EvaluateResultDAO {
    // 锟斤拷锟斤拷锟窖э拷锟斤拷锟斤拷锟斤拷锟铰�
    public boolean insertEvaluateResult(EvaluateResult evaluateResult) {
        Connection conn = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            conn = DBUtil.getConnection();
            String sql = "insert into evaluateresult(tNo,cNo,rank) values(?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, evaluateResult.gettNo());
            ps.setString(2, evaluateResult.getcNo());
            ps.setDouble(3, evaluateResult.getRank());
            rs = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if (rs > 0)
            return true;
        else
            return false;
    }

    /* 杩欐槸瀵硅�璇勭粨鏋滅殑鎿嶄綔 */
    // 鏄剧ず鑰冭瘎鎵�湁缁撴灉淇℃伅
    public List<EvaluateResult> showEvaluateResult(int page, int pageSize) throws SQLException {
        List<EvaluateResult> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            list = new ArrayList<EvaluateResult>();
            conn = DBUtil.getConnection();
            String sql = "select * from evaluateResult order by rank limit ?,?";

            ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize * (page - 1));
            ps.setInt(2, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                EvaluateResult eve = new EvaluateResult();
                eve.setcNo(rs.getString(2));
                eve.setRank(rs.getDouble(3));
                eve.settNo(rs.getString(1));
                list.add(eve);
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

    // 鎸夌収鑰佸笀缂栧彿鏌ヨ璇勪环琛ㄨ瘎浠疯〃鎸夌収鎴愮哗闄嶅簭
    public List<EvaluateResult> queryByTno(String id) throws SQLException {
        List<EvaluateResult> list = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            ps = conn.prepareStatement("select * from evaluateresult where tno=? order by rank desc");
            ps.setString(1, id);
            // ps.setInt(2, page*(pageSize-1));
            // ps.setInt(3, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                EvaluateResult e = new EvaluateResult();
                e.settNo(rs.getString(1));
                e.setcNo(rs.getString(2));
                e.setRank(rs.getDouble(3));
                list.add(e);
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

    public static void main(String[] args) {
        EvaluateResultDAO dao = new EvaluateResultDAO();
        EvaluateResult evaluateResult = new EvaluateResult("34567", "78915", 4.0);
        boolean result = dao.insertEvaluateResult(evaluateResult);
        System.out.println(result);
    }

}
