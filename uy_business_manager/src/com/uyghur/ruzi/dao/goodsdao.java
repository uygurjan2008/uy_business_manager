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

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;

import db.Dbdriver;




public class 	goodsdao  implements RequestAware{

	 
	private String goodname;
	private String goodprice;
	private String goodpic;
	private int id;
	

 
	 
 
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public String getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(String goodprice) {
		this.goodprice = goodprice;
	}

	public String getGoodpic() {
		return goodpic;
	}

	public void setGoodpic(String goodpic) {
		this.goodpic = goodpic;
	}

	public goodsdao() {

	}

	public boolean insert(String goodname, int goodprice, String goodpic) {

		boolean succes = false;
		Dbdriver db=new Dbdriver();
		Connection conn =null;
		try {
			Class.forName(db.driver());
			conn= db.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "INSERT INTO `goods` (`goodname`, `goodprice`, `goodpic`) VALUES ('"
					+ goodname + "', '" + goodprice + "', '" + goodpic + "')";
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

	public List<goodsdao> goods_R() {

		

		List<goodsdao> goods=new ArrayList<goodsdao>();
		Dbdriver db=new Dbdriver();
		
		try {
			Class.forName(db.driver());
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `goods`";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sql" + sql);
		 
			while (rs.next()) {
				
				goodsdao gd=new goodsdao();
				gd.setGoodname(rs.getString("goodname"));
				gd.setGoodprice(rs.getString("goodprice"));
				gd.setGoodpic(rs.getString("goodpic"));
				gd.setId(rs.getInt("id"));
				//System.out.println(gd.goodname+","+gd.goodprice+","+gd.goodpic);
				
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}

		
	
		   
		return goods;


	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		
	}
		
	public boolean good_insert(String goodname, int goodprice, String goodpic) {
		
		 
		boolean succes = false;
		Dbdriver db=new Dbdriver();
		Connection conn =null;
		try {
			Class.forName(db.driver());
			conn= db.getConn();
			
			Statement stmt = conn.createStatement();
			
			

			String sql = "INSERT INTO `goods` (`goodname`, `goodprice`, `goodpic`) VALUES ('"
					+ goodname + "', '" + goodprice + "', '" + goodpic + "')";
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
	
	
	
	public boolean good_update(String goodname, int goodprice, String goodpic,int id) {
		
		 
		boolean succes = false;
		Dbdriver db=new Dbdriver();
		Connection conn =null;
		try {
			Class.forName(db.driver());
			conn= db.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "UPDATE `goods` SET "+
			"`goodname` = '"+goodname+"', `goodprice` = '"+goodprice
			+"', `goodpic` = '"+goodpic+"' WHERE `goods`.`id` = "+id+";";
			boolean rs = stmt.execute(sql);
			System.out.println(sql+","+rs);
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
	
	public boolean good_delete(int id) {
		
		 
		boolean succes = false;
		Dbdriver db=new Dbdriver();
		Connection conn =null;
		try {
			Class.forName(db.driver());
			conn= db.getConn();
			
			Statement stmt = conn.createStatement();
			String sql = "DELETE FROM `goods` WHERE `id`="+id+";";
			boolean rs = stmt.execute(sql);
			System.out.println(sql+","+rs);
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
