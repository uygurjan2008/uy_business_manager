package com.uyghur.ruzi.resource;

import java.net.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;
import com.uyghur.ruzi.dao.goodsdao;

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
		// TODO Auto-generated constructor stub
	}

	public String URLReader_json() throws Exception {
		System.out.println("url read "+getUrl());
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		JSONObject jo = new JSONObject();

		URL oracle = new URL(getUrl());
		BufferedReader in = new BufferedReader(new InputStreamReader(
				oracle.openStream()));
		
		String inputLine;
		JSONObject aa =new JSONObject();
		while ((inputLine = in.readLine()) != null) {
			// System.out.println(inputLine);
			// m.put(key, value);
			aa.put(aa.size(), inputLine);

		}
		
		in.close();
		System.out.println("ss:" + aa.toString());
		
		String myJsonString = "{\"phonetype\":\"N95\",\"cat\":\"WP\"}";
		System.out.println("myJsonString"+myJsonString);
		JSONObject jso = JSONObject.fromObject(myJsonString);
		
		
		JSONObject j1 = JSONObject.fromObject(aa);
		//System.out.println("json:"+j.toString());
		//json.write(out);
		j1.write(out);
		//out.write(aa);
		//jo.put("tt", aa);
		//jo.accumulate("items", aa);
		//jo.write(out);
		out.flush();
		out.close();
		return "success";

	}

	

}
