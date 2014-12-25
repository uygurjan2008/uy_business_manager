package com.uyghur.ruzi.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;

import db.Dbdriver;




public class 	goodsdao  implements RequestAware{

	private String userpass;
	private String username;

	private String name;
	private String price;
	private String pic;
	


	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

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

	 
 
	public goodsdao() {

	}

	public boolean insert(String name, int price, String pic) {

		boolean succes = false;
		Dbdriver db=new Dbdriver();
		Connection conn =null;
		try {
			Class.forName(db.driver());
			conn= db.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `goods` (`name`, `price`, `pic`) VALUES ('"
					+ name + "', '" + price + "', '" + pic + "')";
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
		
		return succes;

	}

	public String read() {

		
		
		List<goodsdao> goods=new ArrayList<goodsdao>();
		Dbdriver db=new Dbdriver();
		
		try {
			Class.forName(db.driver());
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `goods`";
			ResultSet rs = stmt.executeQuery(sql);
			
		 
			while (rs.next()) {
				
				goodsdao gd=new goodsdao();
				gd.setName(rs.getString("name"));
				gd.setPrice(rs.getString("price")); 
				gd.setPic(rs.getString("pic"));
				//System.out.println("pic:"+gd.pic);
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}



		requestMap.put("goodss", goods);
		JSONObject jo=new JSONObject();
		jo.put("status", "success");
		jo.put("myjson", goods);
		
		
		
		
		
		return "success";

	}

	@Override
	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		
	}

}
