package com.uyghur.ruzi.resource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;

import javax.servlet.http.HttpServlet;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

public class get_json_resource extends HttpServlet{

	
	public get_json_resource() {

     }
	
	public JSONObject get_json_resource(String url){
		JSONObject jo=new JSONObject();
		//InputStream bais = (InputStream)getServletContext().getResourcePaths(url);
		InputStream in=getServletContext().getResourceAsStream(url);
		System.out.println("in"+in);
		//System.out.println("get page"+bais);
		
		return jo;
		
	}
	public static void main(String[] args) {
		get_json_resource g=new get_json_resource();
		g.get_json_resource("http://tech.chinaunix.net/a2010/0925/1107/000001107436_2.shtml");
	}
	
}
