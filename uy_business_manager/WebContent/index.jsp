
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>consumer review page</title>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet"
	href="css/bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>


<script type="text/javascript">
	var goods;
	$.ajax({
		url : "business/goods_R.action",
		type : "get",
		dataType : "json",
		async : false,
		success : function(e) {
			//console.log(e);
			goods = e;
		}

	});

	function d(id) {
		$.ajax({
			url : "business/goods_D.action",
			type : "post",
			async : false,
			data : {
				id : id
			},
			success : function(e) {
				console.log("deleted id ", id);
			}
		});
	}

	$(document).ready(
			function() {

				
				/*
				
				for ( var i in goods.items) {

					$(".centercontent").append(
							"<div class='col-lg-12 tr'  style='border:1px solid;'>"
									+ "<div class='col-md-3'>"
									+ goods.items[i].goodname + "</div>"
									+ "<div class='col-md-3' >"
									+ goods.items[i].goodprice + "</div>"
									+ "<div class='col-md-3' >"
									+ goods.items[i].goodpic + "</div>"
									+ "<div class='col-md-3 hidden id' >"
									+ goods.items[i].id + "</div>"
								+ "<div class='col-md-3'  >"
									+ "<a class='btn btn-info edit'>edit</a>"
									+ "<a class='btn btn-danger delete' disabled='disabled'>delete</a>"
									+ "</div>" + "</div>");
					
				
					
					/* 

				}
		
				
				*/
				
				$(".edit").click(function(){
					console.log($(this).parent().parent().find(".id")[0].innerText);
					
				});
				
				
			});
</script>

</head>
<body>
	<div>
	<a href="login.jsp">login</a>
	</div>
	<div class="all">
		<div class="left"></div>
		<div class="center">
			<div class="centertop">
				<div class="col-lg-12">
					<label for="">goods in data base</label>
				</div>
				<div class="col-md-4">goodname</div>
				<div class="col-md-4">goodprice</div>
				<div class="col-md-4">goodpic</div>
			</div>
			<div class="centercontent"></div>


		</div>
		<div class="right"></div>




	</div>
</body>
</html>