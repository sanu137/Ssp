<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Tax Calculation</title>
</head>
<body>
<h4>Calculate Tax</h4>
<%
    Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String productId = request.getParameter("id");
    double taxRate = 0.10;

    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "jneccse");
        String sql = "SELECT price FROM product WHERE pid = ?";
        pstmt = con.prepareStatement(sql);
        pstmt.setInt(1, Integer.parseInt(productId));
        rs = pstmt.executeQuery();

        if (rs.next()) {
            double price = rs.getDouble("price");
            double taxAmount = price * taxRate;
            double totalAmount = price + taxAmount;
%>
            <h5>Product ID: <%= productId %></h5>
            <p>Price: $<%= price %></p>
            <p>Tax (10%): $<%= taxAmount %></p>
            <p>Total Amount: $<%= totalAmount %></p>
<%
        } else {
            out.println("<p>Product not found.</p>");
        }
    } catch (SQLException e) {
        out.println("<p>Error: " + e.getMessage() + "</p>");
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            out.println("<p>Error closing resources: " + e.getMessage() + "</p>");
        }
    }
%>
<a href="Product.jsp">Back to Products</a>
</body>
</html>
