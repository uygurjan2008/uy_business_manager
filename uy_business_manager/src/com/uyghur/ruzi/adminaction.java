package com.uyghur.ruzi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.uyghur.ruzi.dao.admindao;
import com.uyghur.ruzi.dao.goodsdao;
import com.uyghur.ruzi.resource.URLReader;

public class adminaction {
	private String url;
	
	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String get_all_users() throws IOException{
		// JSON格式数据解析对象
				
				HttpServletResponse response = ServletActionContext.getResponse();
				HttpServletRequest request = ServletActionContext.getRequest();
				request.setCharacterEncoding("UTF-8");
				response.setCharacterEncoding("UTF-8");
				PrintWriter out;
				out = response.getWriter();
				// 将要被返回到客户端的对象

				

				
				
				admindao ad = new admindao();
				List l1 = ad.users_R();

				JSONArray ja3 = JSONArray.fromObject(l1);

				JSONObject jo=new JSONObject(); 

				// 将Bean转换为JSONArray数据

				//System.out.println("JSONArray对象数据格式：");

				//System.out.println(ja3.toString());

				// 构造Json数据，包括一个map和一个Employee对象

				// jo.put("AAA", ja3);
				jo.put("info", "users in data base");
				jo.put("success", true); 
				jo.put("items", ja3);

				jo.write(out);

				//System.out.println("\n最终构造的JSON数据格式：");
				System.out.println(jo.toString());

				out.flush();
				out.close();

				return "success";// jo;
		
	}	
	
	 
	
	
}
