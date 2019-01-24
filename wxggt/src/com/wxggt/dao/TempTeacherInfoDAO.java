package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wxggt.dto.TempTeacherInfo;
import com.wxggt.util.DBUtil;

/*������ʦע��ʱ��Ϣ��DAO*/
/*��Ҫ���ܣ�
1.ע��һ����ʱ��ʦ
2.���ͨ�����Ȱ���Ϣ��ӵ���ʦ��Ȼ��ȷ�ϳɹ�������ʱ����ɾ��������¼������һ���ɹ���Ϣ��
3.��˲�ͨ��������һ��ʧ����Ϣ��*/
public class TempTeacherInfoDAO {
	//ע��һ����ʱҽ��
	public boolean tmpTeacher(TempTeacherInfo tmp) throws SQLException{
		boolean flag= false;
		Connection conn=null;
		PreparedStatement ps =null;
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into tempteacherinfo(tno,tname,tsex,teacherlicense,tdesc) values(?,?,?,?,?)");
			ps.setString(1, tmp.gettNo());
			ps.setString(2, tmp.gettName());
			ps.setString(3, tmp.gettSex());
			ps.setString(4, tmp.getTeacherLicense());
			ps.setString(5, tmp.gettDesc());
			int result = ps.executeUpdate();
			System.out.println(result);
			if(result>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ps.close();
			conn.close();
		}
		return flag;
	}
	
	//���ͨ����ɾ����ʱ����Ϣ
	public boolean delTmp(String id) throws SQLException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps =null;
		//ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("delete from tempteacherinfo where tno=?");
			ps.setString(1, id);
			int result = ps.executeUpdate();
			System.out.println(result);
			if(result>0){
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ps.close();
			conn.close();
		}
		return flag;
	}
	
	public static void main(String[] args) throws SQLException {
		TempTeacherInfoDAO d =new TempTeacherInfoDAO();
		TempTeacherInfo t = new TempTeacherInfo("3892393","����","��","https://djlod.com","goodgood");
		System.out.println(d.tmpTeacher(t));
		//d.tmpTeacher(t);
	}

}
