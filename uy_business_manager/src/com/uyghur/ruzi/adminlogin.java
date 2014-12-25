package com.uyghur.ruzi;

import java.sql.*;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.opensymphony.xwork2.ActionContext;
 
import db.Dbdriver;

public class adminlogin {
	private String username;
	private String password;

	public adminlogin() {

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String checkadmin(String username, String password) {
		
		String exist = "";
		
		 Dbdriver db=new Dbdriver();
		
		try {
			Class.forName(db.driver());
			
			Connection conn = db.getConn();
			String sql = "select * from admin where username='"+username+"' and userpass='"+password+"'";
			Statement stmt = conn.createStatement();
			System.out.println("sql"+sql);
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				exist = "yes";
			} else {

				exist = "no";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return exist;

	}

	public String execute() {
		String status = checkadmin(username, password);
		if (status.equals("yes")) {
			status = "success";
			Map<String, Object> session =  ActionContext.getContext()
					.getSession();
			session.put("admin", username);
			System.out.println("username:"+session.get("admin"));
			
			
		} else {
			status = "fail";
		}
		return status;

	}
}
