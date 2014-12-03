<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="css/bootstrap-3.2.0/dist/css/bootstrap.min.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>

<style type="text/css">
.loginform {
	width: 500px;
	height: 350px;
	margin-top: 10%;
	border: 1px solid;
	box-shadow: 0 0 26px 30px #B8B6B4;
	border-radius: 50px;
	padding-top: 60px;
	margin-top: 10%;
	border: 1px solid;
	box-shadow: 0 0 26px 30px #1D1712;
	border-radius: 50px;
}

.btn-lg {
	width: 255px;
	border: 1px solid;
	margin-top: 45px;
	/* margin-left: -85px; */
}

.gap {
	margin-top: 20px;
}

.close1 {
	border: 1px solid;
	margin-top: 43px;
	margin-right: 10px;
	height: 43px;
}

input {
	outline: none;
}

label {
	color: white;
}

a {
	color: white;
}
</style>


<script type="text/javascript">
	function openwindow() {
		var b = document.getElementById("win");
		b.style.display = "block";
	}

	function closewin() {
		this.window.close();
		console.log("close");
		var b = document.getElementById("win");
		b.style.display = "none";
	}

	$(document).ready(function() {

		openwindow();

		$(".submit").click(function() {
			var loginform = $("#login");
			var data = loginform.serialize();
		
			$.ajax({
				url : "login",
				type : "post",
				async : false,
				data : data,
				success : function(data) {

					window.location.replace("index.jsp");
				}

			});

			
		});

		

	});
</script>
</head>
<body>
	<div align="center" id="win"
		style="width: 100%; top: 0; height: 100%; position: absolute; background: url('img/bg.jpg'); display: none;">

		<div align="center" class="loginform">
			<form id="login" action="login">
			
					<label for="" class="info">user name</label> <input type="text"
						class="input-lg" name="username" id="username"
						placeholder="type user name" />
				<div>
					<p></p>
				</div>
					<label for="">pass word</label> <input class="input-lg"
						type="password" name="userpass" id="userpass" />
				<div style="margin-top: 20px;">
					<a class="btn close1" onclick="closewin()">close</a> <a
						class="btn btn-lg submit">submit</a>
				</div>
			</form>

		</div>
	</div>
</body>
</html>