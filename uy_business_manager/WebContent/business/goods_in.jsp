<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.uyghur.ruzi.dao.goodsdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="goods_in">
		name <input type="text" name="name" /><br /> price <input
			type="text" name="price" /><br /> description <input type="text"
			name="description" /> <br /> <input type="submit" />
	</form>

	<div align="center"
		style="height: 30px; float: left; border: 1px solid;">

		<div align="center"
			style="width: 120px; float: left; border-right: 1px solid;">
			<label for="">name</label>
		</div>
		<div align="center"
			style="width: 120px; float: left; border-right: 1px solid;">
			<label for="">price</label>
		</div>
		<div align="center" style="width: 120px; float: left;">
			<label for="">description</label>
		</div>
	</div>



	<div>
		<div align="center"
			style="width: 120px; float: left; border-right: 1px solid;">
			<label for=""></label>
		</div>
		<div align="center"
			style="width: 120px; float: left; border-right: 1px solid;">
			<label for=""></label>
		</div>
		<div align="center" style="width: 120px; float: left;">
			<label for=""></label>
		</div>
	</div>


	

aa	
<s:iterator value="#request.goods" >
			
			<div class=""><s:property value="name" /></div>
		
	</s:iterator>
aa

 
<s:iterator value="{'1','2','3','4','5'}" id='number'> 
    <s:property value='#number'/>
</s:iterator>
 


</body>
</html>