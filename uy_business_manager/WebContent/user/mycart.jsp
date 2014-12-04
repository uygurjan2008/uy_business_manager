
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>cart</title>

<link rel="stylesheet" href="../css/index.css">
<link rel="stylesheet"
	href="../css/bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="../js/jquery.min.js"></script>


</head>
<body>

<div>


	<s:iterator value="#request.mycart">
		<div align="center">
			<div align="center" style="border: 1px solid;">
				<tr>
					<td><s:property value="goodname" /></td>
					<td><s:property value="goodprice" /></td>
					<td><s:property value="goodpic" /></td>
					<td><a class="btn btn-info">edit</a></td>
					<td><a class="btn btn-danger">delete</a></td>

				</tr>
			</div>
		</div>

	</s:iterator>
</div>


</body>
</html>