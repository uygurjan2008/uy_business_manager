
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>cart</title>

<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="bootstrap-3.2.0-dist/css/bootstrap.min.css" />
<script type="text/javascript" src="jquery.min.js"></script>


</head>
<body>
	
	
	<div align="center">
		<a href="order.jsp" class="btn btn-info">check my orders</a>
	</div>	
	<div align="center" style="float: left;
	margin-left: 10%;">
	<div align="center">
	
	<div align="center">

		<%
			String username = "root";
			String password = "root";

			String Driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://127.0.0.1:3306/cart";

			try {
				Class.forName(Driver);
				//Connection conn=DriverManager.getConnection(url,username,password);
				//Connection conn=DriverManager.getConnection(url);

				//Statement stmt=conn.createStatement();
				String sql = "select * from cart";
				//ResultSet rs=stmt.executeQuery(sql);
				Connection conn = DriverManager.getConnection(url, username,
						password);

				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while (rs.next()) {
					String id = rs.getString("id");
					String name = rs.getString("name");
					String price = rs.getString("price");
					String pic = rs.getString("pic");
		%>

		<div style="float: left;">

			<div class="ok" id="<%=id%>">

				<img id="pic" src="<%=pic%>" width="300px" height="100px">
				<p>
					<label for="" id="name"><%=name%> </label>|<label for="" id="price">
						<%=price%></label>
				</p>


				<a href="add.jsp?name=<%=name%>&price=<%=price%>&pic=<%=pic%>"
					class="btn btn-info">加入购物车</a>





			</div>
		</div>



		<%
			}

			} catch (Exception e) {

				System.out.println(e);

			}
		%>

	</div>



</div>

</div>


</body>
</html>