$(document)
			.ready(
					function() {

						// 当一个图片被选中时，打开图片预览界面

						$(".img1")
								.click(
										function() {
											/*
											 * console.log($(this).find(".img1"),
											 * $(this).find(
											 * ".img1").context.currentSrc,
											 * $(this).find(
											 * ".img1").context.outerHTML);
											 */
											var src = $(this).find(".img1").context.currentSrc;

											console.log(src, $(this).find(
													".img1"), $(this).index());

											var srcs = $(".img1");
											// console.log(src, srcs,
											// srcs.length);

											/*
											 * if ($("#win").find("img").length >
											 * 0) {
											 * 
											 * $("#win .loginform")
											 * .find("div").remove();
											 * 
											 * $(".loginform") .append( "<div
											 * class='base'
											 * style='width:100%;height:80px;border:1px
											 * solid;overflow:scroll;'><div
											 * style='width:200%;'>"); for (var
											 * i = 0; i < srcs.length; i++) {
											 * $(".loginform .base") .append( "<div
											 * style='float:left;width:120px;height:60px;'><img
											 * src='" + srcs[i].src + "'
											 * width='100%' height='100%' >"); }
											 * 
											 * $("#win").hide();
											 * 
											 * $("#win").show(); } else {
											 * 
											 */

											// console.log("ok");
											// 图片预览界面内容
											// 图片状态--大
											$(".loginform")
													.append(
															"<div  style='width: 100%;top: 0px;height: 100%;position: fixed;display: block;'>"
																	+ "<div class='left' style='float:left;width:9%;"
																	+ "height: 100%;'>"
																	+ "</div>"
																	+ "<div class='imgdiv' style='float:left;width:80%;height:100%;'>"
																	+ "<img class='centerimg' imgindex='"
																	+ $(this)
																			.index()
																	+ "' src='"
																	+ src
																	+ "' width='100%' height='100%'  >"
																	+ "</div>"
																	+ "<div class='right' style='float:left;width:9%;height:100%;'>"
																	+ "</div>"
																	+"<div class='col-lg-12' align='center'><font color='white' size='4'>this picture is not the original picture,if you want to se the original picture</font></div>"
																	+"</div>");

											// 图片缩略图
											/*
											 * $(".loginform") .append( "<div
											 * class='base' " + "
											 * style='width:100%;height:80px;" +
											 * "border:1px
											 * solid;overflow-x:scroll;'><div
											 * class='ok'
											 * style='width:200%;'>");
											 * 
											 * for (var i = 0; i < srcs.length;
											 * i++) { $(".loginform .base .ok")
											 * .append( "<div
											 * style='float:left;'><img
											 * class='img2 ' imgindex='"+i+"'
											 * src='" + srcs[i].src + "'
											 * width='120' height='60' >"); }
											 * 
											 */
											
											
											$("#win").show();

											// }

											// 当整个界面被点击时
											$("#win").click(function() {
												$("#win .loginform").find("div").remove();
												$("#win").hide();

											});
												
											
											/*
											 * //向左 var index = 0;
											 * 
											 * var name;
											 * 
											 * $(".win .left") .click(
											 * function(e) { var src =
											 * $(".img2");
											 * 
											 * var current = $( ".loginform
											 * .centerimg") .attr( "imgindex");
											 * 
											 * var nn = parseInt(current);
											 * 
											 * if (nn > 0) { $(".loginform
											 * .centerimg")[0].src =
											 * src[--nn].src; $(".loginform
											 * .centerimg")[0] .setAttribute(
											 * "imgindex", nn); }
											 * 
											 * if (nn == 0) { console .log(
											 * "first one", nn); var s =
											 * confirm("已经是第一个了，是否关闭？");
											 * 
											 * if (s == true) {
											 *  $( ".win .loginform") .find(
											 * "div") .remove(); $( ".win")
											 * .hide(); }
											 *  }
											 * 
											 * index = name;
											 * 
											 * console .log( name, index,
											 * src[nn]);
											 * 
											 * e .preventDefault();
											 * 
											 * e .stopPropagation(); });
											 * 
											 * //向右
											 * 
											 * $(".win .right") .click(
											 * function(e) { var src =
											 * $(".img2");
											 * 
											 * var current = $( ".loginform
											 * .centerimg") .attr( "imgindex");
											 * 
											 * var nn = parseInt(current);
											 * 
											 * if (nn < src.length - 1) {
											 * $(".loginform .centerimg")[0].src =
											 * src[++nn].src; $(".loginform
											 * .centerimg")[0] .setAttribute(
											 * "imgindex", nn); } console .log(
											 * nn, src.length);
											 * 
											 * if (nn >= src.length - 1) {
											 * 
											 * console .log( "last one",
											 * src[nn], nn);
											 * 
											 * var s = confirm("都看完了，预览关闭"); if
											 * (s == true) {
											 *  $( ".win .loginform") .find(
											 * "div") .remove(); $( ".win")
											 * .hide(); }
											 *  }
											 * 
											 * //console.log(src[nn]);
											 * 
											 * e .preventDefault();
											 * 
											 * e .stopPropagation(); });
											 * 
											 * 
											 * 
											 */
											// 当缩略图中的图片被点击时
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

																// name =
																// $(this)[0].getAttribute("imgindex");

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

														// var close = div
														// .prepend("<div
														// ><label class='close'
														// style='border: 1px
														// solid;"
																// +"border-radius:
																// 50px'>close");

													});
											$(".centerimg").mouseout(
													function() {
														console.log("out");

													});

										});
						$(".win").mouseout(function() {
							// console.log("win out");
							// var div = $(".win .close");
							// div.remove();

						});

						$(".close label").click(function() {

							$(".win .loginform").find("div").remove();
							console.log("close", $(".win .loginform").html());

							$(".win").hide();

						});// 以上都是当图片预览界面打开时才能用的功能

						// 关于界面部分的js

						var left = 50;
						var id;
						// id=setInterval("countdown()",1000);

						function countdown() {

							if (left <= 0) {
								clearInterval(id);

							} else {
								left--;
								console.log(left);
							}

						}

					});