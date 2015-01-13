package com.uyghur.ruzi.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.Dbdriver;

public class admindao {

	private String username;
	private String userpassword;
	private String useremail;
	private int userid;
	private int tel;
	private String loginip;
	private String gender;

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

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getTel() {
		return tel;
	}

	public void setTel(int tel) {
		this.tel = tel;
	}

	public String getLoginip() {
		return loginip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "admindao [username=" + username + ", userpassword="
				+ userpassword + ", useremail=" + useremail + ", userid="
				+ userid + ", tel=" + tel + ", loginip=" + loginip
				+ ", gender=" + gender + "]";
	}

	public List<admindao> users_R() {

		List<admindao> users = new ArrayList<admindao>();
		Dbdriver db = new Dbdriver();

		try {
			Class.forName(db.driver());
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `users`";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sql" + sql);

			while (rs.next()) {

				admindao gd = new admindao();
				gd.setUsername(rs.getString("username"));
				gd.setUserpassword(rs.getString("userpassword"));
				gd.setUseremail(rs.getString("useremail"));
				gd.setUserid(rs.getInt("userid"));
				gd.setTel(rs.getInt("tel"));
				gd.setLoginip(rs.getString("loginip"));
				gd.setGender(rs.getString("gender"));

				users.add(gd);

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return users;

	}

}
