package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver") ;
			String url = "jdbc:mysql://localhost:3306/BookStore" ;    
		     String username = "root" ;   
		     String password = "" ;   
		     
		    con =DriverManager.getConnection(url , username , password ) ;    
			return con;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection conn = getConnection();
			System.out.println("连接成功！");
		}
		catch(Exception e) {
			System.out.println("连接失败！");
		}
	}

}
