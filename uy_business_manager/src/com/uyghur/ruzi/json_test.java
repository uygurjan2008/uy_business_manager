package com.uyghur.ruzi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uyghur.ruzi.dao.userdao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class json_test {

	
	public json_test() {
		
	}
	

	 public static JSONObject BuildJson() {

	        // JSON格式数据解析对象
	        JSONObject jo = new JSONObject();

	        // 下面构造两个map、一个list和一个Employee对象
	        Map<String, String> map1 = new HashMap<String, String>();
	        map1.put("name", "Alexia");
	        map1.put("sex", "female");
	        map1.put("age", "23");

	        Map<String, String> map2 = new HashMap<String, String>();
	        map2.put("name", "Edward");
	        map2.put("sex", "male");
	        map2.put("age", "24");

	        List<Map> list = new ArrayList<Map>();
	        list.add(map1);
	        list.add(map2);

	        userdao ud=new userdao();
	        List l1=ud.rd();
	       

	        // 将Map转换为JSONArray数据
	        JSONArray ja1 = JSONArray.fromObject(map1);
	        // 将List转换为JSONArray数据
	        JSONArray ja2 = JSONArray.fromObject(list);
	        
	        JSONArray ja3 = JSONArray.fromObject(l1);
	        
	        // 将Bean转换为JSONArray数据

	        System.out.println("JSONArray对象数据格式：");
	        System.out.println(ja1.toString());
	        System.out.println(ja2.toString());
	        System.out.println(ja3.toString());

	        // 构造Json数据，包括一个map和一个Employee对象
	        jo.put("goodinfo", ja3);
	        
	        System.out.println("\n最终构造的JSON数据格式：");
	        System.out.println(jo.toString());
	        System.out.println("jjj:"+jo.opt("goodinfo"));
	        
	        return jo;
	        
	    }
	 
	 
	
	
	
	public static void main(String[] args) {
		 json_test js=new json_test();
		 JSONObject o=js.BuildJson();
		System.out.println("out:"+o.opt("goodinfo"));
		
	}

}
