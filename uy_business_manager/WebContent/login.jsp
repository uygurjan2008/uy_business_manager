<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>user login</title>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet"
	href="css/bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	$(function(){
		$(".login").click(function(){
				
			var a=$(".form").serialize();
					console.log("a:",a);
		
		});
		
	});
</script>

</head>
<body>

	<div class="row" style="padding: 0px;">
		<div class="col-md-12">
			<div class="col-xs-4"></div>
			<div class="col-xs-4" style="margin-top:200px;line-height:30px;">
				<form action="" class="form">
					<label for="" class="col-xs-4">username</label><input type="text"
						class="col-xs-8" placeholder="username" name="username"/> <label for=""
						class="col-xs-4">userpass</label><input type="password"
						class="col-xs-8"  name="userpass"/>
						 <a class="btn btn-default col-xs-6 login" style="margin-top:30px;">login</a> <a
						class="btn btn-default col-xs-6 clear" style="margin-top:30px;">clear</a>
				</form>
			</div>
			<div class="col-xs-4"></div>

		</div>
	</div>

</body>
</html>