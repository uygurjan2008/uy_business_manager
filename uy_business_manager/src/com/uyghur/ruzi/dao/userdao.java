package com.uyghur.ruzi.dao;

import db.Dbdriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionContext;
/**
 * @author admin
 *
 */
public class userdao implements RequestAware{
	
	private String username;
	private String goodname;
	private String goodprice;
	private String goodpic;
	private Map<String, Object> requestMap;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

	public String execute() {
		
		String success=null;
		Dbdriver db=new Dbdriver();
		try {
			Class.forName(db.driver());
			Connection conn=db.getConn();
			String sql="";
			Statement stmt=conn.createStatement();
			boolean rs=stmt.execute(sql);
			if(rs==false)
			{
				success="succes";
			}else
			{
				success="fail";
				
			}
			
		} catch (Exception e) {
			
		}
		
		
		
		return success;
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
		System.out.println("return " + succes);
		return succes;

	}
	
	
public String read() {

		
		
		List<userdao> goods=new ArrayList<userdao>();
		Dbdriver db=new Dbdriver();
		
		try {
			Class.forName(db.driver());
			Connection conn = db.getConn();
			Statement stmt = conn.createStatement();
			String sql = "SELECT * FROM `goods`";
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("sql" + sql);
		 
			while (rs.next()) {
				
				userdao gd=new userdao();
				gd.setGoodname(rs.getString("name"));
				gd.setGoodprice(rs.getString("price"));
				gd.setGoodpic(rs.getString("pic"));
				System.out.println(gd+","+gd.goodname);
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}

		
		

		
		requestMap.put("mycart", goods);
//		ActionContext.getContext().getValueStack().push(goods);
		
		
		
		
		return "success";

	}

	public void setRequest(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		
	}
	
	
	
	public String usercart()
	{
	
		System.out.println(this.getGoodname());
		
		return "success";
		
	}
	
	public String usercarts()
	{
		String result=null;
		result="success";

		System.out.println(result);
		return result;
		
	}
	
	
	
	
	

	
}
