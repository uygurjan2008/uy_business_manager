<%@page import="java.util.Map"%>
<%@page import="com.uyghur.ruzi.dao.goodsdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods_in">
		name <input type="text" name="name" /><br /> price <input
			type="text" name="price" /><br /> description <input type="text"  name="description"/>
		<br /> <input type="submit" />
	</form>
	
	<div align="center" style="height:30px;float:left;border:1px solid;">
	
	<div align="center" style="width: 120px;float:left;border-right:1px solid;"> 
	<label for="">name</label>
	 </div> 
	 <div align="center" style="width: 120px;float:left;border-right:1px solid;"> 
	<label for="">price</label>
	  </div>
	  <div align="center" style="width: 120px;float:left;"> 
	<label for="">description</label>
	</div>
	</div>
	
	<%
	goodsdao gd=new goodsdao();
	Map<String,String> map=gd.read();		
			
	%>
	name:<%=map.get("name") %>
	length:<%=map.size() %>
	<%
	
	for(int i=0;i<map.size();i++)
	{
		%>
		
		<div>
	<div align="center" style="width: 120px;float:left;border-right:1px solid;"> 
	<label for=""><%=map.get("name") %></label>
	 </div> 
	 <div align="center" style="width: 120px;float:left;border-right:1px solid;"> 
	<label for=""><%=map.get("price") %></label>
	  </div>
	  <div align="center" style="width: 120px;float:left;"> 
	<label for=""><%=map.get("description") %></label>
	</div></div>
	
		
		<%
	}
	%>
	
	
	
</body>
</html>