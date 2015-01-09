<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>


<script type="text/javascript">


$(document).ready(function(){
	
	$(".submit").click(function(){
		
		var form=$(".form").serializeArray();
		$.ajax({
			url:"goods_I",
			type:"post",
			async:false,
			data:form,
			success:function(e){
				console.log(e);
				$(".result").append("<div><p>"+e+"</p></div>");
			}
		});
		
		
		var a;
		$.ajax({
		url:"xxx.xml",
		type:"get",
		async:false,
		success:function(e){
		console.log(e.firstChild);
		a=e.firstChild;
		}


		});
		
		
		
		
		
		
		
	});
	
});


</script>


<title>Insert title here</title>
</head>
<body>
<div>
	<a href="read">read as json</a>

	<form class="form">

		<label for="">goodname</label><input type="text" name="goodname" /> <label
			for="">goodprice</label><input type="text" name="goodprice" /> <label
			for="">goodpic</label><input type="file" name="goodpic" class="goodpic" /> 
			<a  class="btn -btn-default submit">submit</a>
	</form>
</div>	
	<div class="result" style="width: 100%;height:50px;">
		 
	</div>

</body>
</html>