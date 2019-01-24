package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wxggt.dto.TeacherInfo;
import com.wxggt.util.DBUtil;


/*������ʦ��Ϣ��DAO*/
public class TeacherInfoDAO {
	
	//ͨ���˺������½
	public boolean findBy(String account,String password) throws SQLException{
		boolean flag = false;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet result=null;
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from teacherinfo where tno=? and pwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, account);
			ps.setString(2, password);
			result = ps.executeQuery();
			if(result.next()){
				flag =true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			result.close();
			ps.close();
			conn.close();
		}
		return flag;
	}
	
	//ע��һ����ʦ(�ȴ���ʱ��ɾ����¼�������)
	public boolean addTeacher(TeacherInfo t) throws SQLException{
		TempTeacherInfoDAO tmp =new TempTeacherInfoDAO();
		boolean flag = false;
		if(tmp.delTmp(t.gettNo())){
			
			Connection conn = null;
			PreparedStatement ps = null;
			int result=0;
			try {
				conn = DBUtil.getConnection();
				String sql = "insert into teacherinfo(tno,pwd,tname,tsex,tdesc,teacherlicense,facepic) values(?,?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, t.gettNo());
				ps.setString(2, t.getPwd());
				ps.setString(3, t.gettName());
				ps.setString(4, t.gettSex());
				ps.setString(5, t.gettDesc());
				ps.setString(6, t.getTeacherLicense());
				ps.setString(7, t.getFacePic());
				result = ps.executeUpdate();
				if(result>0){
					flag =true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				ps.close();
				conn.close();
			}
	    }
		return flag;
	}
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		TeacherInfoDAO t = new TeacherInfoDAO();
		System.out.println(t.findBy("2016090127", "54321"));
	}

}
