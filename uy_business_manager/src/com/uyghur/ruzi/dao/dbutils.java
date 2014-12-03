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
		dbconnection db=new dbconnection();
		System.out.println(db.getconnection());
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(db.getconnection());
			Statement stmt=conn.createStatement();
			String sql="select * from dbusers where username='"+uname+"' and userpass='"+upass+"'";
			System.out.println(sql);
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
