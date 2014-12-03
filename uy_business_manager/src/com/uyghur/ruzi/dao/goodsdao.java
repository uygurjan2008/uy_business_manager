package com.uyghur.ruzi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class goodsdao {

	private String userpass;
	private String username;

	private String name;
	private int price;
	private String description;
	private int index;

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

		boolean succes = false;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/goods";
		username = "root";
		userpass = "root";

		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username,
					userpass);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `goods_in` (`name`, `price`, `description`) VALUES ('"
					+ name + "', '" + price + "', '" + description + "')";
			boolean rs = stmt.execute(sql);
			if (rs == true) {
				succes = true;
				System.out.println("next" + succes);

			} else {
				succes = false;
				System.out.println("else" + succes);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("return " + succes);
		return succes;

	}

	public List<Map> read() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/goods";
		username = "root";
		userpass = "root";
		Map<String, String> map = new LinkedHashMap<String, String>();
		ArrayList<Map> list = new ArrayList<Map>();
		ArrayList<Object> list2 = new ArrayList<Object>();
		String[] a=null;
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username,
					userpass);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `goods_in`";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sql" + sql);
			index=0;
			while (rs.next()) {
				
				
				map.put("name", rs.getString("name"));
				map.put("price", rs.getString("price"));
				map.put("description", rs.getString("description"));
				list.add(index, map);
			
				index++;
				
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		for (int i = 0; i < list.size(); i++) {
			
			System.out.println(i + "," + list.get(i));
			
		}
		
		 
		 
		  
		
		
		
		
		
		return list;

	}

}
