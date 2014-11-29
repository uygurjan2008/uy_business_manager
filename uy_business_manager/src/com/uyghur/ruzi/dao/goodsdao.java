package com.uyghur.ruzi.dao;

import java.sql.*;

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

	public goodsdao(String name, int price, String description) {

		Connection conn = null;
		String result = "";

		try {
			Class.forName("com.mysql.jdbc");

			String url = "mysql:jdbc:127.0.0.1/3306/goods";
			username = "root";
			userpass = "root";
			conn = DriverManager.getConnection(url, username, userpass);
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `goods_in` (`name`, `price`, `description`, `etc`) VALUES ('"
					+ name + "', '" + price + "', '" + description + "', '')";
			boolean rs = stmt.execute(sql);
			if (rs == true) {

				result = "in";

			} else {

				result = "no";

			}

		} catch (Exception e) {

		} finally {

		}

	}

}
