<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



aa	
<s:iterator value="#request.mycart" >
			
			<div class=""><s:property value="Goodname" /></div>
			<div class=""><s:property value="Goodprice" /></div>
			<div class=""><s:property value="Goodpic" /></div>
			
	</s:iterator>
aa

 
<s:iterator value="{'1','2','3','4','5'}" id='number'> 
    <s:property value='#number'/>
</s:iterator>
 









</body>
</html>