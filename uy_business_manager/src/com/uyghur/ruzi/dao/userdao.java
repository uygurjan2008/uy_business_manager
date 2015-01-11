package com.uyghur.ruzi.dao;

import db.Dbdriver;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;

/**
 * @author admin
 *
 */
public class userdao implements RequestAware {

	private String username;
	private String userpassword;
	private String useremail;
	private Integer userid;
	private Integer tel;
	private String loginip;
	private String gender;

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String execute() {

		return "";
	}

	

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub

	}

	public boolean user_insert(String username, String userpassword,
			String useremail, int tel, String loginip, String gender) {

		boolean succes = false;
		Dbdriver db = new Dbdriver();
		Connection conn = null;
		try {
			Class.forName(db.driver());
			conn = db.getConn();

			Statement stmt = conn.createStatement();

			String sql = " INSERT INTO `users`(`username`,`userpassword`,`useremail`,`tel`,`loginip`,`gender`) VALUES ( '"
					+ username
					+ "','"
					+ userpassword
					+ "','"
					+ useremail
					+ "','" + tel + "','" + loginip + "','" + gender + "');";
			System.out.println("insert sql :"+sql);
			boolean rs = stmt.execute(sql);
			
			if (rs == false) {
				succes = true;
				System.out.println("next " + succes);

			} else {
				succes = false;
				System.out.println("else " + succes);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("return " + succes);
		return succes;

	}

	public boolean user_update(String userpassword,
			String useremail, int tel, String gender,int userid) {

		boolean succes = false;
		Dbdriver db = new Dbdriver();
		Connection conn = null;
		try {
			Class.forName(db.driver());
			conn = db.getConn();

			Statement stmt = conn.createStatement();
			String sql = "UPDATE `users` SET " + "`userpassword` = '" + userpassword
					+ "', `useremail` = '" + useremail + "', `tel` = '"
					+ tel + "', `gender` = '"+gender+"     WHERE `userid` = " + userid + ";";
			boolean rs = stmt.execute(sql);
			System.out.println(sql + "," + rs);
			if (rs == false) {
				succes = true;
				System.out.println("next" + succes);

			} else {
				succes = false;
				System.out.println("else " + succes);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("return " + succes);
		return succes;

	}

	public boolean user_delete(int userid) {

		boolean succes = false;
		Dbdriver db = new Dbdriver();
		Connection conn = null;
		try {
			Class.forName(db.driver());
			conn = db.getConn();

			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM `users` WHERE `id`=" + userid + ";";
			boolean rs = stmt.execute(sql);
			System.out.println(sql + "," + rs);
			if (rs == false) {
				succes = true;
				System.out.println("next" + succes);

			} else {
				succes = false;
				System.out.println("else " + succes);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
		System.out.println("return " + succes);
		return succes;

	}

}
