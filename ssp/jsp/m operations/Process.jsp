<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<%@ page errorPage = "Error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%= new Date() %>
	<%
		int c1 = Integer.parseInt(request.getParameter("n1"));
		int c2 = Integer.parseInt(request.getParameter("n2"));
		int c3 = c1/c2;
		out.println("Division is"+ c3);
	%>
</body>
</html>