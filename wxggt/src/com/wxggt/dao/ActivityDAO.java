package com.wxggt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.wxggt.dto.Activity;
import com.wxggt.dto.StudentInfo;
import com.wxggt.util.DBUtil;

public class ActivityDAO {
	/*
	 * 主要功能 1.增加活动(打折A，免费B) 2.删除过期活动
	 */
	//增加活动
	public boolean addEvent(Activity a) throws SQLException{
		boolean flag= false;
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("insert into activity(activityname,pricetype,poster,discount,scopeType,typeid,startTime,endTime) values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
			//ps.setInt(1, a.getActivityid());
			ps.setString(1, a.getActivityName());
			ps.setString(2, a.getPriceType());
			ps.setString(3, a.getPoster());
			ps.setDouble(4, a.getDiscount());
			ps.setInt(5, a.getScopeType());
			ps.setInt(6, a.getTypeid());
			ps.setTimestamp(7,  new java.sql.Timestamp(a.getStartTime().getTime()));
			ps.setDate(8, new java.sql.Date(a.getEndTime().getTime()));
			int result = ps.executeUpdate();
			System.out.println("影响行数"+result);
			rs = ps.getGeneratedKeys();
			if(rs.next()){
				System.out.println("主键id:"+rs.getInt(1));
			}
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
	//活动过期则删除
	public boolean delEvent(String id) throws SQLException{
		boolean flag=false;
		Connection conn=null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement("select endtime from activity where activityid=?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()){
				if(new Date().compareTo(rs.getDate("endtime"))>0){
					ps = conn.prepareStatement("delete from activity where activityid=?");
					ps.setString(1, id);
					int result = ps.executeUpdate();
					if(result>0){
						flag =true;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ps.close();
			conn.close();
		}
		return flag;
	}
	//查询某段时间内的活动信息
	public List<Activity> queryByTime(Date t1,Date t2) throws SQLException{
		List<Activity> list1=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			list1 = new ArrayList<Activity>();
			conn = DBUtil.getConnection();
			String sql ="select * from activity where startTime >?and startTime < ?";
			ps.setDate(1, new java.sql.Date( t1.getTime()));
			ps.setDate(2, new java.sql.Date( t2.getTime()));
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Activity eve=new Activity();
				eve.setActivityid(rs.getInt(1));
				eve.setActivityName(rs.getString(2));
				eve.setPriceType(rs.getString(3));
				eve.setPoster(rs.getString(4));
				eve.setDiscount(rs.getDouble(5));
				eve.setScopeType(rs.getInt(6));
				eve.setTypeid(rs.getInt(7));
				eve.setStartTime(rs.getDate(9));
			    eve.setEndTime(rs.getDate(10));
				list1.add(eve);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return list1;
	}
	//查询所有活动
	public List<Activity> queryEvent() throws SQLException{
		List<Activity> list=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			list = new ArrayList<Activity>();
			conn = DBUtil.getConnection();
			String sql ="select * from activity";
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Activity eve=new Activity();
				eve.setActivityid(rs.getInt(1));
				eve.setActivityName(rs.getString(2));
				eve.setPriceType(rs.getString(3));
				eve.setPoster(rs.getString(4));
				eve.setDiscount(rs.getDouble(5));
				eve.setScopeType(rs.getInt(6));
				eve.setTypeid(rs.getInt(7));
				eve.setStartTime(rs.getDate(9));
			    eve.setEndTime(rs.getDate(10));
				list.add(eve);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			rs.close();
			ps.close();
			conn.close();
		}
		return list;
	}
	
	public boolean mdiaod(){
		Connection conn=null;
		PreparedStatement ps=null;
		boolean flag=false;
		return flag;
	}
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws SQLException {
		ActivityDAO adao = new ActivityDAO();
//		Activity a = new Activity("新年","A","jingdong.com",0.5,2,4,new Date(),new Date());
//		System.out.println(adao.addEvent(a));
//		System.out.println(Integer.MAX_VALUE);
//		System.outprintln(Integer.MIN_VALUE);
//		System.out.println(Long.MAX_VALUE);
//		System.out.println(Long.MIN_VALUE);
//		System.out.println(new Date().getTime());
//		System.out.println(new Date().getTimezoneOffset());
//		System.out.println(new Date().getTime()/86400/365);
//		System.out.println(Double.MAX_EXPONENT);
//		System.out.println(Double.MAX_VALUE);
//		System.out.println(Double.MIN_NORMAL);
//		System.out.println(Double.MIN_VALUE);
//		System.out.println(Double.MIN_EXPONENT);
		//System.out.println(adao.delEvent("2039223"));
		
		//System.out.println(new Date());
		System.out.println(adao.queryByTime(new Date("2018-01-09 09:08:23"), new Date("2019-01-20 12:23:34")));
		
	}

}
