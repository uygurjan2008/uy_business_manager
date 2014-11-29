package com.uyghur.ruzi.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class goodsdao {

	private String userpass;
	private String username;

	private String name;
	private int price;
	private String description;

	public String getUserpass() {
		return userpass;
	}

	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public goodsdao() {

	}

	
	
	public boolean insert(String name, int price, String description) {
		
		boolean succes=false;
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/goods";
		username="root";
		userpass="root";
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,userpass);
			Statement stmt=conn.createStatement();
			String sql="INSERT INTO `goods_in` (`name`, `price`, `description`) VALUES ('"+name+"', '"+price+"', '"+description+"')";
			boolean rs=stmt.execute(sql);
			if(rs==true){
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
	
	public Map<String, String> read() {

		
		
		String driver="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/goods";
		username="root";
		userpass="root";
		Map<String, String> map=new LinkedHashMap<String,String>(); 
		
		try {
			Class.forName(driver);
			Connection conn=DriverManager.getConnection(url,username,userpass);
			Statement stmt=conn.createStatement();
			String sql="SELECT * FROM `goods_in`";
			ResultSet rs=stmt.executeQuery(sql);
			System.out.println("sql"+sql);
			
			while(rs.next()){
				
				System.out.println("read data success");
				map.put("name", rs.getString("name"));
				map.put("price", rs.getString("price"));
				map.put("description", rs.getString("description"));
				
				
			}
			
			System.out.println("size:"+map.size()+",map:"+map.get("name"));
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("map1.."+map.get("name"));
		return map;
		
		
		

	}
	

}
