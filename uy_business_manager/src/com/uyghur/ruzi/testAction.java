package com.uyghur.ruzi;

public class testAction{

	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String execute(){
		if(username.equals("struts2"))
		{
			return "success";
		}
		else{
			return "fail";
		}
		
		
	}
	
	
}
