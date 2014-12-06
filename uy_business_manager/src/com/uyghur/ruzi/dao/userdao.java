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
				System.out.println(gd.goodname+","+gd.goodprice+","+gd.goodpic);
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}

		
		

		System.out.println("my cart out ....mycart");
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
	
	
	public static List<userdao> rd(){


		
		
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
				System.out.println(gd.goodname+","+gd.goodprice+","+gd.goodpic);
				goods.add(gd);
				


			}

		} catch (Exception  e) {

			e.printStackTrace();
		}

		
		
		
		
		
		return goods;
	
		
		
	}
	
	

	 public static JSONObject readJson() throws Exception {

	        // JSON格式数据解析对象
	        JSONObject jo = new JSONObject();
	        
	        
	        List l1=rd();
	       

	        
	        JSONArray ja3 = JSONArray.fromObject(l1);
	        
	        // 将Bean转换为JSONArray数据

	        System.out.println("JSONArray对象数据格式：");
	        
	        System.out.println(ja3.toString());

	        // 构造Json数据，包括一个map和一个Employee对象
	        jo.put("items", ja3);
	        jo.put("info", "json_test");
	        jo.put("success", true);
	        jo.put("tablename", "userinfo");
	        
	        System.out.println("\n最终构造的JSON数据格式：");
	        System.out.println(jo.toString());
	        
	        
	        
	        
	       
	        HttpServletResponse response=ServletActionContext.getResponse();
	      
	        response.setContentType("text/json");
	        PrintWriter out = null;
	        try {
				out = response.getWriter();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        //将要被返回到客户端的对象
	        
	       out.println(jo.toString());
	       out.flush();
	        
	      System.out.println(response.isCommitted());
	        if(response.isCommitted()==true){
	        	System.out.println("in true");
	        	out.close();
	        }
	        out.close();
	        return jo;//jo;
	        
	        
	        
	        
	        
	        
	        
	        
	    }
	 
	 
	 
	 public String readjson_success() throws Exception{
		 String result="";
		 if(readJson().size()>0)
		 {
			 result="success";
		 }
		 else
		 {
			 result="fail";
		 }
		 return result;
	 
	 }
	
	

	
}
