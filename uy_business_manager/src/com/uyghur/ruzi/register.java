package com.uyghur.ruzi;

public class register {
	private String uname;
	private String upass;
	
	
	
	public String getUname() {
		return uname;
	}



	public void setUname(String uname) {
		this.uname = uname;
	}



	public String getUpass() {
		return upass;
	}



	public void setUpass(String upass) {
		this.upass = upass;
	}



	public String execute()
	{
		if(upass.equals(""))
		{
		return "null";
		}
		else if(!uname.equals("")&&!upass.equals("")){
			return "ok";
		}
		else
		{
			return "notnull";
		}
		
	}
	
}
