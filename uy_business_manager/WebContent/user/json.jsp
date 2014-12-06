<%@page import="com.uyghur.ruzi.dao.userdao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript">
	
	
console.log("inininin");
var da;
$.ajax({
		url : "http://localhost:81/uy_business_manager/user/json_read",
		type : "get",
		async : false,
		success : function(data) {
			console.log("A", data);
		da=data;
		}

	});  
	


</script>
</head>
<body>json read

 

</body>
</html>