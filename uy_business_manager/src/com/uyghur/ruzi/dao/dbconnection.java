package com.uyghur.ruzi.dao;

public class dbconnection {
	
	public dbconnection() {

	}
	
	public String getconnection()
	{
		String username="root";
		String userpass="root";
		String url="jdbc:mysql://127.0.0.1:3306/goods";
		
		String urls=url+","+username+","+userpass;
		
		return urls;
				
	}
	public String driver(){
		return "com.mysql.jdbc.Driver";
	}
	
	
}
