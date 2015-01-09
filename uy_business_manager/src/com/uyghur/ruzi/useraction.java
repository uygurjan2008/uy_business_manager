package com.uyghur.ruzi;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.uyghur.ruzi.dao.userdao;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class useraction {
	private String goodname;
	private int goodprice;
	private String goodpic;
	private Map<String, Object> requestMap;

	public String getGoodname() {
		return goodname;
	}

	public void setGoodname(String goodname) {
		this.goodname = goodname;
	}

	public int getGoodprice() {
		return goodprice;
	}

	public void setGoodprice(int goodprice) {
		this.goodprice = goodprice;
	}

	public String getGoodpic() {
		return goodpic;
	}

	public void setGoodpic(String goodpic) {
		this.goodpic = goodpic;
	}

	public useraction() {

	}

	JSONObject jo = new JSONObject();

	public String readJson() throws Exception {

		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();
		// 将要被返回到客户端的对象

		userdao ud = new userdao();
		List l1 = ud.rd();

		JSONArray ja3 = JSONArray.fromObject(l1);

		// JSONObject jso=JSONObject.fromObject(l1);

		// 将Bean转换为JSONArray数据

		System.out.println("JSONArray对象数据格式：");

		System.out.println(ja3.toString());

		// 构造Json数据，包括一个map和一个Employee对象

		// jo.put("AAA", ja3);
		jo.put("info", "json_test");
		jo.put("success", true);
		jo.put("tablename", "userinfo");

		jo.put("items", ja3);

		jo.write(out);

		System.out.println("\n最终构造的JSON数据格式：");
		System.out.println(jo.toString());

		out.flush();
		out.close();

		return "success";// jo;

	}

	public String goods_I() throws Exception {
			
		String status;
		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		boolean ad = ud.good_insert(getGoodname(), getGoodprice(), getGoodpic());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.put("good name", getGoodname());
			o.put("good price", getGoodprice());
			o.put("good pic", getGoodpic());
			o.write(out);
			out.flush();
			out.close();
			status="success";
			
		}else{
			
			status="fail";
			o.put("success", status);
			o.put("info","operation has failed");
			o.write(out);
			out.flush();
			out.close(); 
		}

		return status;

	}

}
