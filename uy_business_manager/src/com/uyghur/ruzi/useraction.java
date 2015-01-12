package com.uyghur.ruzi;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.uyghur.ruzi.dao.userdao;
import com.uyghur.ruzi.dao.userdao;

public class useraction {

	private String username;
	private String userpassword;
	private String useremail;
	private Integer userid;
	private Integer tel;
	private String loginip;
	private String gender;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getTel() {
		return tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	public String getLoginip() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String ip=request.getRemoteAddr();
		System.out.println("login ip :"+ip);
		return ip;
	}

	public void setLoginip(String loginip) {
		this.loginip = loginip;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	JSONObject jo = new JSONObject();

	public String user_I() throws Exception {

		String status;
		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		System.out.println(getUsername()+","+ getUserpassword()+","+
				getUseremail()+","+ getTel()+","+ getLoginip()+","+ getGender());
		boolean ad = ud.user_insert(getUsername(), getUserpassword(),
				getUseremail(), getTel(), getLoginip(), getGender());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.put("username", getUsername());
			o.put("useremail", getUseremail());
			o.put("tel", getTel());
			o.write(out);
			out.flush();
			out.close();
			status = "success";

		} else {

			status = "fail";
			o.put("success", status);
			o.put("info", "operation has failed");
			o.write(out);
			out.flush();
			out.close();
		}

		return status;

	}

	public String user_U() throws Exception {

		String status;
		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		boolean ad = ud.user_update(getUserpassword(), getUseremail(),
				getTel(), getGender(), getUserid());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.put("username", getUsername());
			o.put("useremail", getUseremail());
			o.write(out);
			out.flush();
			out.close();
			status = "success";

		} else {

			status = "fail";
			o.put("success", status);
			o.put("info", "operation has failed");
			o.write(out);
			out.flush();
			out.close();
		}

		return status;

	}

	public String user_D() throws Exception {

		String status;
		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		boolean ad = ud.user_delete(getUserid());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.put("userid", getUserid());
			o.write(out);
			out.flush();
			out.close();
			status = "success";

		} else {

			status = "fail";
			o.put("success", status);
			o.put("info", "operation has failed");
			o.write(out);
			out.flush();
			out.close();
		}

		return status;

	}
	
	public String user_check() throws Exception {

		String status;
		// JSON格式数据解析对象
		HttpServletResponse response = ServletActionContext.getResponse();

		PrintWriter out;
		out = response.getWriter();

		userdao ud = new userdao();
		System.out.println("username"+getUsername());
		boolean ad = ud.user_check(getUsername());
		JSONObject o = new JSONObject();

		if (ad == true) {
			o.put("success", ad);
			o.write(out);
			out.flush();
			out.close();
			status = "success";

		} else {

			status = "fail";
			o.put("success", status);
			o.put("info", "user does not exist,ready to use");
			o.write(out);
			out.flush();
			out.close();
		}

		return status;

	}
	
	
	
	
	
	

}
