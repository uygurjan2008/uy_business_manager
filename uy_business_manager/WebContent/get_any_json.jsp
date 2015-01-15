<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" />
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
	var aa;
	function get_json(url) {
		var a;
		//url json source url
		$.ajax({
			url : "get_json",
			type : "post",
			data : {
				url : url
			//"http://127.0.0.1:8080/uy_business_manager/admin/get_all_users"
			},

			async : false,
			success : function(e) {
				//console.log(e);
				//a= [e];
				
				a = JSON.parse(e);
				console.log("var a=get_json(url);",a);
			}

		});
		return a;
	}

	$(document)
			.ready(
					function() {
						$(".search")
								.click(
										function() {
											var urlstr = $(".source").val();
											aa = get_json(urlstr);

											 $(".result")[0].innerHTML=JSON.stringify(aa);

										});
					});
</script>
</head>
<body>
<div style="margin-left:50px;margin-right:50px;">
	<input type="text" class="source" placeholder="url with http:// or file://"/>
	<a class="btn btn-default search" >get json</a>
	<div>result</div>
	<div class="result"
		style="width: 100%; height: auto; border: 1px solid;border-radius:10px;">
		 
		</div>
</div>
</body>
</html>