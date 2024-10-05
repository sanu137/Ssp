<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>JSP Action Tags</title>
</head>
<body>
<jsp:useBean id="student" class="p1.Student" scope="page">
    <jsp:setProperty name="student" property="name" value="Sarvesh"/>
    <jsp:setProperty name="student" property="prn" value="3025"/>
    <jsp:setProperty name="student" property="email" value="sarvesh@gmail.com"/>
    <jsp:setProperty name="student" property="age" value="20"/>
</jsp:useBean>

<h1><u>Student Data</u></h1>
<p>Name: <i><jsp:getProperty name="student" property="name"/></i></p>
<p>PRN: <i><jsp:getProperty name="student" property="prn"/></i></p>
<p>Email ID: <i><jsp:getProperty name="student" property="email"/></i></p>
<p>Age: <i><jsp:getProperty name="student" property="age"/></i></p>

</body>
</html>
