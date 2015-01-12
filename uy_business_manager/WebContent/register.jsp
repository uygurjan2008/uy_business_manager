<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>new user register</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function checkuser() {
		var a;

		var username = $(".username").val();
		console.log("user:", username);
		var url = "user/user_check";
		$.ajax({
			url : url,
			type : "post",
			async : false,
			dataType : "json",
			data : {
				username : username
			},
			success : function(e) {
				console.log(url, e, e.success);
				if (e.success == true) {
					alert("user " + username + " already exist");
					a = false;
				} else {
					a = true;
					alert("user " + username + "does not  exist,ready to use");
				}
			}
		});

		console.log("sss", a);
		return a;

	}

	$(document).ready(function() {

		var result;
		$(".username").focusout(function() {
			result = checkuser();

		});

		$(".userpassword").focusout(function() {

			//result=checkuser();

		});
		$(".useremail").focusout(function() {

			//result=checkuser();

		});

		$(".tel").focusout(function() {

			//result=checkuser();

		});
		$(".gender").focusout(function() {

			//result=checkuser();

		});

		$(".submit").click(function() {
			if (result == true) {
				var form = $(".form").serialize();

				$.ajax({
					url : "user/user_I",
					type : "post",
					data : form,
					success : function(e) {
						console.log(e);

						$(".result").append("<p>" + e + "</p>");
						$(".result").css("background", "green");
					}

				});
			} else {
				alert("username exists,pick another one");
			}
		});

	});
</script>
</head>
<body>
	<div>
		<form class="form" method="post">
			username<input type="text" class="username" name="username"
				place-holder="pick a user name" /> userpassword<input
				type="password" class="userpassword" name="userpassword" />
			useremail<input type="text" name="useremail" class="useremail" />
			tel<input type="text" class="tel" name="tel" /> gender<input
				type="text" name="gender" class="gender" /> <a
				class="btn btn-info submit">submit</a>
		</form>
	</div>
	<div class="result" style="width: 100%; height: 60px;"></div>
</body>
</html>