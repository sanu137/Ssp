<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Purchase Product</title>
</head>
<body>
<h4>Purchase Product</h4>
<%
    Connection con = null;
    PreparedStatement pstmt = null;

    String productId = request.getParameter("id");

    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "jneccse");
        
        String sql = "INSERT INTO purchase (p_id, user_id, purchase_date) VALUES (?, ?, NOW())"; 
        pstmt = con.prepareStatement(sql);
        
        int userId = 1; 
        pstmt.setInt(1, Integer.parseInt(productId));
        pstmt.setInt(2, userId);
        
        int rowsAffected = pstmt.executeUpdate();
        
        if (rowsAffected > 0) {
            out.println("<p>Purchase successful!</p>");
        } else {
            out.println("<p>Purchase failed.</p>");
        }
    } catch (SQLException e) {
        out.println("<p>Error: " + e.getMessage() + "</p>");
    } finally {
        try {
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            out.println("<p>Error closing resources: " + e.getMessage() + "</p>");
        }
    }
%>
<a href="Product.jsp">Back to Products</a>
<a href="index.jsp">Home</a>
</body>
</html>
