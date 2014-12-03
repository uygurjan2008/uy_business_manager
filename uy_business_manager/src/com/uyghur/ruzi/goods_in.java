package com.uyghur.ruzi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.uyghur.ruzi.dao.dbutils;
import com.uyghur.ruzi.dao.goodsdao;

public class goods_in {
	private String name;
	private int price;
	private String description;

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

		dbutils dbutils = new dbutils();
		String result = null;
		boolean reString = dbutils.getConnection("admin", "123456");

		System.out.println("+++++++:" + reString);
		if (reString == true) {
			System.out.println("authorized user");

			goodsdao gd = new goodsdao();
			boolean rs = gd.insert(name, price, description);
			if (rs == false) {
				result = "in";
			} else {
				result = "else";
			}

		} else {
			
			System.out.println("not authorized user");

		}
		System.out.println("result..."+result);
		return result;

	}
}
