package com.uyghur.ruzi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
		// JSON��ʽ���ݽ�������
				HttpServletResponse response = ServletActionContext.getResponse();
				
				PrintWriter out;
				out = response.getWriter();
				// ��Ҫ�����ص��ͻ��˵Ķ���

				

				
				
				admindao ad = new admindao();
				List l1 = ad.users_R();

				JSONArray ja3 = JSONArray.fromObject(l1);

				JSONObject jo=new JSONObject(); 

				// ��Beanת��ΪJSONArray����

				//System.out.println("JSONArray�������ݸ�ʽ��");

				//System.out.println(ja3.toString());

				// ����Json���ݣ�����һ��map��һ��Employee����

				// jo.put("AAA", ja3);
				jo.put("info", "users in data base");
				jo.put("success", true); 
				jo.put("items", ja3);

				jo.write(out);

				//System.out.println("\n���չ����JSON���ݸ�ʽ��");
				//System.out.println(jo.toString());

				out.flush();
				out.close();

				return "success";// jo;
		
	}	
	
	 
	
	
}
