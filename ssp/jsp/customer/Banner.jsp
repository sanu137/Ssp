<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Banner</title>
		<style>
			a 
			{
				color: #007BFF;
				text-decoration: none; 
				padding: 8px 16px; 
				border-radius: 4px; 
				transition: background-color 0.3s, color 0.3s; 
			}
			a:hover 
			{
				color: #ffffff; 
				background-color: #0056b3; 
			}
			a:visited 
			{
				color: #6c757d;
			}

			a:active 
			{
				color: #003d79; 
			}
			.bottom-message 
			{
				position: fixed;
				bottom: 0;			
				width: 100%;			
				text-align: center;			
				background-color: #f1f1f1;			
				padding: 10px; 
				box-shadow: 0 -2px 5px rgba(0,0,0,0.1);			
			}		
		</style>
	</head>
	<body>
		<a href="Customer.jsp" >Customer</a>&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="Product.jsp"> Product</a> &nbsp;&nbsp;&nbsp;&nbsp;
		<br><br><br>
		<div class="bottom-message">
			<%@ include file="HitCount.jsp" %>
		</div>
	</body>
</html>