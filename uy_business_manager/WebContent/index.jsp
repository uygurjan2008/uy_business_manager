<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>cart</title>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>


</head>
<body>
	
	
	<div align="center">
		<a href="order.jsp" class="btn btn-info">check my orders</a>
	</div>	
	<div align="center" style="float: left;
	margin-left: 10%;">
	<div align="center">
	
	<div align="center">


<s:iterator value="#request.goods">

		<div style="float: left;">

			<div class="ok" id="<s:property value="name" />">

				<img id="pic" src="<s:property value="pic" />" width="300px" height="100px">
				<p>
					<label for="" id="name"><s:property value="name" /> 
					</label>|<label for="" id="price">
						<s:property value="price" /></label>
				</p>


				<a href="/user/usercart?name=<s:property value="name" />&price=<s:property value="price" />&pic=<s:property value="pic" />"
					class="btn btn-info">加入购物车</a>





			</div>
		</div>



	</s:iterator>

	</div>



</div>

</div>
<s:iterator value="#request.mycart" >
			
			<div class=""><s:property value="Goodname" /></div>
			<div class=""><s:property value="Goodprice" /></div>
			<div class=""><s:property value="Goodpic" /></div>
			
	</s:iterator>

</body>
</html>