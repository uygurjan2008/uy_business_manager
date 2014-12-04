
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"
	href="css/bootstrap-3.2.0/dist/css/bootstrap.min.css" />
<style type="text/css">
.loginform {
	width: 100%;
	height: 100%;
	/*
	margin-top: 10%;
	border: 1px solid;
	/* box-shadow: 0 0 26px 30px #B8B6B4; */
	/*
	border-radius: 50px;
	/* padding-top: 60px; */
	/*margin-top: 15%;
	border: 1px solid;
	box-shadow: 0 0 0 36px #F2DDCC;
	/* border-radius: 50px; */
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

.win label {
	color: white;
}

.win a {
	color: white;
}

.win {
	top: 0;
	/* left: 30%; */
	position: fixed;
	display: none;
	background: rgba(0, 0, 0, .8);
	box-shadow: 0 0 10px 20px #CFABAB;
	border: 1px solid;
	width: 100%;
	height: 100%;
}
</style>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {

						//当一个图片被选中时，打开图片预览界面

						$(".img1")
								.click(
										function() {
											/*
											console.log($(this).find(".img1"),
															$(this).find(
																	".img1").context.currentSrc,
															$(this).find(
																	".img1").context.outerHTML);
											 */
											var src = $(this).find(".img1").context.currentSrc;

											console.log(src, $(this).find(
													".img1"), $(this).index());

											var srcs = $(".img1");
											//console.log(src, srcs, srcs.length);

											/*
											if ($("#win").find("img").length > 0) {

												$("#win .loginform")
														.find("div").remove();

												$(".loginform")
														.append(
																"<div class='base' style='width:100%;height:80px;border:1px solid;overflow:scroll;'><div style='width:200%;'>");
												for (var i = 0; i < srcs.length; i++) {
													$(".loginform .base")
															.append(
																	"<div style='float:left;width:120px;height:60px;'><img src='"
																			+ srcs[i].src
																			+ "' width='100%' height='100%' >");
												}

												$("#win").hide();

												$("#win").show();
											} else {
												
											 */

											//console.log("ok");
											//图片预览界面内容
											//图片状态--大
											$(".loginform")
													.append(
															"<div  style='width: 100%;height:80%;margin-top:30px;'>"
																	+ "<div class='left' style='float:left;width:9%;"
																	+ "background:#eee;height: 100%;'>"
																	+ "</div>"
																	+ "<div class='imgdiv' style='float:left;width:80%;height:100%;'>"
																	+ "<img class='centerimg' imgindex='"
																	+ $(this)
																			.index()
																	+ "' src='"
																	+ src
																	+ "' width='100%' height='100%'  >"
																	+ "</div>"
																	+ "<div class='right' style='float:left;width:9%;height:100%;background:#000;'>"
																	+ "</div></div>");

											//图片缩略图

											$(".loginform")
													.append(
															"<div class='base' "
																	+ " style='width:100%;height:80px;"
																	+ "border:1px solid;overflow-x:scroll;'><div class='ok' style='width:200%;'>");

											for (var i = 0; i < srcs.length; i++) {
												$(".loginform .base .ok")
														.append(
																"<div style='float:left;'><img  class='img2 ' imgindex='"+i+"' src='"
																			+ srcs[i].src
																			+ "' width='120' height='60' >");
											}

											$("#win").show();

											//}

											//当整个界面被点击时
											$("#win").click(function() {
												//$("#win .loginform").find("div").remove();
												//$("#win").hide();

											});

											//向左
											var index = 0;

											var name;

											$(".win .left")
													.click(
															function(e) {
																var src = $(".img2");

																var current = $(
																		".loginform .centerimg")
																		.attr(
																				"imgindex");

																var nn = parseInt(current);

																if (nn > 0) {
																	$(".loginform .centerimg")[0].src = src[--nn].src;
																	$(".loginform .centerimg")[0]
																			.setAttribute(
																					"imgindex",
																					nn);
																}

																if (nn == 0) {
																	console
																			.log(
																					"first one",
																					nn);
																	var s = confirm("已经是第一个了，是否关闭？");

																	if (s == true) {

																		$(
																				".win .loginform")
																				.find(
																						"div")
																				.remove();
																		$(
																				".win")
																				.hide();
																	}

																}

																index = name;

																console
																		.log(
																				name,
																				index,
																				src[nn]);

																e
																		.preventDefault();

																e
																		.stopPropagation();
															});

											//向右

											$(".win .right")
													.click(
															function(e) {
																var src = $(".img2");

																var current = $(
																		".loginform .centerimg")
																		.attr(
																				"imgindex");

																var nn = parseInt(current);

																if (nn < src.length - 1) {
																	$(".loginform .centerimg")[0].src = src[++nn].src;
																	$(".loginform .centerimg")[0]
																			.setAttribute(
																					"imgindex",
																					nn);
																}
																console
																		.log(
																				nn,
																				src.length);

																if (nn >= src.length - 1) {

																	console
																			.log(
																					"last one",
																					src[nn],
																					nn);

																	var s = confirm("都看完了，预览关闭");
																	if (s == true) {

																		$(
																				".win .loginform")
																				.find(
																						"div")
																				.remove();
																		$(
																				".win")
																				.hide();
																	}

																}

																//console.log(src[nn]);

																e
																		.preventDefault();

																e
																		.stopPropagation();
															});

											//当缩略图中的图片被点击时
											$(".loginform .base .ok .img2")
													.click(
															function(e) {
																name = null;
																var src = $(
																		this)
																		.find(
																				".img2").context.currentSrc;

																var ind = $(
																		".img2")
																		.index(
																				$(
																						this)
																						.find(
																								".img2"));

																$(".loginform .centerimg")[0].src = src;
																name = $(this)
																		.attr(
																				"imgindex");

																//name = $(this)[0].getAttribute("imgindex");

																$(".centerimg")
																		.attr(
																				"imgindex",
																				name);

																console
																		.log(
																				"imgindex",
																				name);

																e
																		.preventDefault();

																e
																		.stopPropagation();

															});

											$(".centerimg").mouseenter(
													function() {
														console.log("in");
														var div = $(".win")

														//var close = div
														//	.prepend("<div ><label class='close' style='border: 1px solid;"
																//+"border-radius: 50px'>close");

													});
											$(".centerimg").mouseout(
													function() {
														console.log("out");

													});

										});
						$(".win").mouseout(function() {
							//console.log("win out");
							//var div = $(".win .close");
							//div.remove();

						});

						$(".close label").click(function() {

							$(".win .loginform").find("div").remove();
							console.log("close", $(".win .loginform").html());

							$(".win").hide();

						});//以上都是当图片预览界面打开时才能用的功能

						//关于界面部分的js

						var left = 50;
						var id;
						//id=setInterval("countdown()",1000);

						function countdown() {

							if (left <= 0) {
								clearInterval(id);

							} else {
								left--;
								console.log(left);
							}

						}

					});
</script>


<s:i18n name="message_uy">
		<title><s:text name="username"></s:text></title>
</s:i18n>
	

</head>

<body>
	<%
		String user = (String) session.getAttribute("user");
		System.out.print(user);

		if (user != null) {
			
	%>



	<div align="center">
		<div>
			<label for="">username=<%=user%>
			</label>
		</div>
		<div>
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/1.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/2.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/3.jpg" alt="" width="250" height="200" />
			<img class="img1" src="img/4.jpg" alt="" width="250" height="200" />
		</div>
		<div align="center" id="win" class="win">
			<div align="center" class="loginform"></div>
		</div>

	</div>

	<div>data base
	
	<s:i18n name="message_uy">
	 <s:label key="username"></s:label><s:textfield name="username"></s:textfield> <br />
	 <s:label key="userpass"></s:label><s:password name="userpass"></s:password> <br />
	</s:i18n>
	s<s:property value="username"></s:property>
	 


	
	</div>


	<%
	
	
	
		} else {

			response.sendRedirect("login.jsp");

		}
	%>

</body>
</html>