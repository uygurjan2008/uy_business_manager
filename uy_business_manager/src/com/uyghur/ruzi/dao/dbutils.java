package com.uyghur.ruzi.dao;

import java.sql.*;

public class dbutils {

	private String username;
	private String userpass;
	private String url;

	Connection conn = null;

	public dbutils() {
		
		
		
	}
	
	public boolean getConnection(String uname,String upass) {
		
		boolean succes=false;
		String driver="com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/goods";
		username="root";
		userpass="root";
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,userpass);
			Statement stmt=conn.createStatement();
			String sql="select * from dbusers where uname='"+uname+"' and upass='"+upass+"'";
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				succes=true;
				System.out.println("next"+succes);
				
			}
			else{
				succes=false;
				System.out.println("else"+succes);
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("return "+succes);
		return succes;
		
		
		
		
		
		
		
		
		
	}
 

}
