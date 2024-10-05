<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
<h2>Edit Customer</h2>
<hr/>
<form method="post" action="UpdateCustomer.jsp">
    <%
    String customerId = request.getParameter("id");
    if (customerId != null) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer", "root", "jneccse");
            String sql = "SELECT * FROM customers WHERE id = ?";
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(customerId));
            rs = pstmt.executeQuery();
            
            if (rs.next()) {
    %>
            ID: <input type="text" name="id" value="<%=rs.getInt("id") %>" readonly/><br>
            Name: <input type="text" name="name" value="<%=rs.getString("name") %>"/><br>
            Address: <input type="text" name="address" value="<%=rs.getString("address") %>"/><br>
            <input type="Submit" name="submit" value="Update"/>
    <%
            } else {
    %>
            <p>Customer not found.</p>
    <%
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("Database driver not found.");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Database error occurred.");
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        out.println("No customer ID provided.");
    }
    %>
</form>
</body>
</html>
