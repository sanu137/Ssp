<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Working with JSP</title>
</head>
<body>
	<h1>Good Morning</h1>
	<%
		java.util.Date d1 = new java.util.Date();
	%>
	<% out.println(d1); %>
	<br>
	<%= d1.getDay() %>
	<br>

</body>
</html>