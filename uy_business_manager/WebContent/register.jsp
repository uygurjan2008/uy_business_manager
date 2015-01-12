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
<style type="text/css">
.cl {
	margin-bottom: 5px;
}
</style>
<script type="text/javascript">
	function checkuser() {

		var msg;
		var username = $(".username").val();

		console.log("user:", username);
		if (username.length > 0) {
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
						//alert("user " + username + " already exist");
						msg = "exist";

					} else {

						msg = "username available";
					}
				}
			});
		} else {
			msg = "username is empty";
		}
		console.log("msg ", msg);
		return msg;

	}

	function checkuseremail() {

		var msg;
		var useremail = $(".useremail").val();
		console.log("user:", useremail);
		if (useremail.length > 0) {
			var url = "user/user_email_check";
			$.ajax({
				url : url,
				type : "post",
				async : false,
				dataType : "json",
				data : {
					useremail : useremail
				},
				success : function(e) {
					console.log(url, e, e.success);
					if (e.success == true) {
						//alert("user " + username + " already exist");
						msg = "exist";

					} else {

						msg = "useremail available";
					}
				}
			});
		} else {
			msg = "user email is empty";
		}
		console.log("msg ", msg);
		return msg;

	}

	$(document)
			.ready(
					function() {

						var result;
						$(".username")
								.focusout(
										function() {
											result = checkuser();
											console.log("result ", result);
											//console.log($(this).parent(),$(this).parent().parent().find(".message").append("<b>"+result+"</b>")); 

											if (result == "exist") {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='red' size='4'>"
														+ result + "</font>";
											} else {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='green' size='4'>"
														+ result + "</font>";

											}
										});

						$(".userpassword")
								.keyup(
										function() {

											//result=checkuser();
											var length = $(".userpassword")
													.val().length;

											if (length < 10) {
												$(this)
														.parent()
														.parent()
														.find(
																".message .progress-bar")
														.removeClass(
																"progress-bar-success");
												$(this)
														.parent()
														.parent()
														.find(
																".message .progress-bar")
														.addClass(
																"progress-bar-danger");
												$(this)
														.parent()
														.parent()
														.find(
																".message .progress-bar")
														.css(
																"width",
																length * 10
																		+ "%");

												//progress-bar-success

											}
											if (length >= 10) {
												$(this)
														.parent()
														.parent()
														.find(
																".message .progress-bar")
														.removeClass(
																"progress-bar-danger");
												$(this)
														.parent()
														.parent()
														.find(
																".message .progress-bar")
														.addClass(
																"progress-bar-success");
											}
										});
						$(".useremail")
								.focusout(
										function() {

											result = checkuseremail();
											console.log("result ", result);
											//console.log($(this).parent(),$(this).parent().parent().find(".message").append("<b>"+result+"</b>")); 

											if (result == "exist") {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='red' size='4'>"
														+ result + "</font>";
											} else {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='green' size='4'>"
														+ result + "</font>";

											}

										});

						$(".tel")
								.focusout(
										function() {
											var tel = $(".tel").val();
											if (tel.length == 0) {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='red' size='4'>"
														+ "can be null"
														+ "</font>";
											} else if (tel.length > 11
													|| tel.length < 11) {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='red' size='4'>"
														+ "try to control it under 11 digit "
														+ "</font>";
											} else {
												$(this).parent().parent().find(
														".message")[0].innerHTML = "<font color='green' size='4'>"
														+ "correct phone format "
														+ "</font>";
											}
										});
						$(".gender").focusout(function() {

							//result=checkuser();

						});

						$(".submit").click(
								function() {

									if (result != "exist") {
										var form = $(".form").serialize();

										$.ajax({
											url : "user/user_I",
											type : "post",
											data : form,
											async:false,
											success : function(e) {
												console.log(e);

												$(".result").append(
														"<p>" + e + "</p>");
												$(".result").css("background",
														"green");

											}

										});
									} else {
										alert("please verify the message");
									}
								});

					});
</script>
</head>
<body>
	<div align="center">
		<div class="row" align="center"
			style="width: 600px; height: auto; margin-top: 60px; border: 1px solid; border-radius: 10px;">
			<form class="form">
				<div class="col-lg-12 cl cl" style="margin-top: 5px;">
					<div class="col-md-4">username</div>
					<div class="col-md-4">
						<input type="text" class="username" style="width: 100%;"
							name="username" place-holder="pick a user name" />
					</div>
					<div class="col-md-4 message"></div>
				</div>
				<div class="col-lg-12 cl">
					<div class="col-md-4">userpassword</div>
					<div class="col-md-4">
						<input type="password" style="width: 100%;" class="userpassword"
							name="userpassword" />
					</div>
					<div class="col-md-4 message">
						<div class="progress-bar progress-bar-success"
							style="width: 0%; height: 30px"></div>
					</div>
				</div>
				<div class="col-lg-12 cl">
					<div class="col-md-4">useremail</div>
					<div class="col-md-4">
						<input type="text" style="width: 100%;" name="useremail"
							class="useremail" />
					</div>
					<div class="col-md-4 message"></div>
				</div>
				<div class="col-lg-12 cl">
					<div class="col-md-4">tel</div>
					<div class="col-md-4">
						<input type="text" style="width: 100%;" class="tel" name="tel" />
					</div>
					<div class="col-md-4 message"></div>
				</div>
				<div class="col-lg-12 cl">
					<div class="col-md-4">gender</div>
					<div class="col-md-4">
						<input type="radio" name="gender" value="male" class="gender" />男
						<input type="radio" name="gender" value="female" class="gender" />女
					</div>
					<div class="col-md-4 message"></div>
				</div>
				<div class="col-lg-12 cl">

					<a class="btn btn-info submit">signup</a> <input type="reset"
						class="btn btn-info" lang="en" />
				</div>
			</form>
		</div>
		<div class="result" style="width: 100%; height: 60px;"></div>
	</div>
</body>
</html>