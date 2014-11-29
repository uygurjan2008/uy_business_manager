package com.uyghur.ruzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.uyghur.ruzi.dao.goodsdao;

public class goods_in {
	private String name;
	private int price;
	private String description;
	private String username;
	private String userpass;
	

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

	public String execute() {
		
		 

		Connection conn = null;
		String result = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");

			String url = "jdbc:mysql://127.0.0.1:3306/goods";
			

			
			username = "root";
			userpass = "root";
			
			conn = DriverManager.getConnection(url, username, userpass);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `goods_in` (`name`, `price`, `description`, `etc`) VALUES ('"
					+ name + "', '" + price + "', '" + description + "', '')";
			System.out.println(sql);
			boolean rs = stmt.execute(sql);
			System.out.println(rs);
			
			if (rs == false) {

				result = "in";

			} else {

				result = "else";

			}

		} catch (Exception e) {

		} finally {

		}
		return result;

	 
	}

}
