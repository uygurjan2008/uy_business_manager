package com.uyghur.ruzi.resource;

import java.net.*; 
import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
 


import net.sf.json.JSONObject;

public class URLReader {
	
	private  String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public URLReader() { 
		
	}

	public String URLReader_json() throws Exception {
		System.out.println("url read "+getUrl());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		out = response.getWriter();
 
		URL oracle = new URL(getUrl());
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream(),"UTF-8"));
		
		String inputLine;
		String aa ="";
		while ((inputLine = in.readLine()) != null) {
			// System.out.println(inputLine);
			// m.put(key, value);
			aa+=inputLine;

		}
		
		in.close();
		System.out.println("ss:" + aa);
		
		
		 
		
		JSONObject j1 = JSONObject.fromObject(aa);
		//System.out.println("json:"+j.toString());
		//json.write(out);
		
		j1.write(out);
		//out.write(aa);
		//out.write(aa);
		//jo.put("tt", aa);
		//jo.accumulate("items", aa);
		//jo.write(out);
		out.flush();
		out.close();
		return "success";

	}
	
	public String URLReader_page() throws Exception {
		System.out.println("url read page"+getUrl());
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		PrintWriter out;
		out = response.getWriter();
 
		URL oracle = new URL(getUrl());
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream(),"UTF-8"));
		
		String inputLine;
		String aa ="";
		while ((inputLine = in.readLine()) != null) {
			// System.out.println(inputLine);
			// m.put(key, value);
			aa+=inputLine;

		}
		
		in.close();
		System.out.println("ss:" + aa);
		
		
		 /*
		
		JSONObject j1 = JSONObject.fromObject(aa);
		 
		j1.write(out);
		 
		out.flush();
		out.close();
		*/
		
		return "success";

	}
	
	
	
	
	

}
