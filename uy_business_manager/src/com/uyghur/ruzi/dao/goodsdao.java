package com.uyghur.ruzi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;




public class 	goodsdao  implements RequestAware{

	private String userpass;
	private String username;

	private String name;
	private String price;
	private String description;
	private int index;
	private Map<String, Object> requestMap;

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

	public String getPrice() {
		return price;
	}

	public void setPrice(String string) {
		this.price = string;
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

	public String read() {

		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/goods";
		username = "root";
		userpass = "root";
		
		List<goodsdao> goods=new ArrayList<goodsdao>();
		
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, username,
					userpass);
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `goods_in`";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sql" + sql);
		 
			while (rs.next()) {
				
				goodsdao gd=new goodsdao();
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getString("price"));
				gd.setDescription(rs.getString("description"));
				//System.out.println(rs.getString("name")+","+rs.getString("price")+","+rs.getString("description"));
				System.out.println(gd+","+gd.name);
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}

		
		
		requestMap.put("goods", goods);
//		ActionContext.getContext().getValueStack().push(goods);
		
		
		
		
		return "success";

	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		
	}

}
