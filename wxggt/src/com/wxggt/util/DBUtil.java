package com.wxggt.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection(){
		String className="com.mysql.jdbc.Driver";
		Connection conn=null;
		String url="jdbc:mysql://www.wxggt.xyz:3306/xhxt?useSSL=false";
		String user="root";
		String password="root";
		try {
			Class.forName(className);
			conn=DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		}

	public static void main(String[] args) {
		System.out.println(DBUtil.getConnection());

	}

}
