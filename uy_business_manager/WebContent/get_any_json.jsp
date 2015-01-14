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
function get_json(url){
var a;
//url json source url
$.ajax({
		url : "get_json",
		type : "post",
       data:{
         url:url//"http://127.0.0.1:8080/uy_business_manager/admin/get_all_users"
        },
		
		async : false,
		success : function(e) {
			//console.log(e);
			//a= [e];
       a=JSON.parse([e]);
       console.log(a)
		}

	});
return a;
}

$(document).ready(function(){
	$(".search").click(function(){
		var urlstr=$(".source").val();
		aa=get_json(urlstr);
		/*
		for(var i in aa.items){
		$(".result").append("<div style='width:100px;height:30px;float:left;border:1px solid; '>"+aa.items[i].useremail);
		}
		*/
		
	});
});


</script>
</head>
<body>

<input type="text" class="source" /> <a  class="btn btn-default search">get</a>
<div class="result" style="width:100%;height:100px;border:1px solid;">

</div>
</body>
</html>