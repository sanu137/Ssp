package p1;
import java.sql.*;
import java.util.Enumeration;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class LoginDatabse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDatabse() {
        super();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
    	String user1 = request.getParameter("txtName");
        String password1 = request.getParameter("txtPassword");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
        //	Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gayatri", "root", "jneccse");

            PreparedStatement stmt = con.prepareStatement("select * from authentication_db where username=? and password=?");
            stmt.setString(1, user1);
            stmt.setString(2, password1);
            ResultSet rset = stmt.executeQuery();
     
            if (rset.next()) {
                // Display welcome message
                out.println("<html><body>");
                out.println("<h2>Welcome, " + user1 + "!</h2>");
                out.println("</body></html>");

                // Request header information
                String title = "Request Header Information";

   			 response.addHeader("Refresh", "20");

   			 out.println(new Date().toString());

   			 out.println("<HTML>" +

   			     "<BODY BGCOLOR=\"#FDF5E6\">\n" +

   			     "<HEAD><TITLE>" + title + "</TITLE></HEAD>\n" +

   			     "<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" +

   			     "<B>Request Method: </B>" + request.getMethod() + "<BR>\n" +

   			     "<B>Request URI: </B>" + request.getRequestURI() + "<BR>\n" +

   			     "<B>Request Protocol: </B>" + request.getProtocol() + "<BR><BR>\n" +

   			     "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +

   			     "<TR BGCOLOR=\"#FFAD00\">\n" +

   			     "<TH>Header Name</TH><TH>Header Value</TH>\n");

   			 Enumeration<String> headerNames = request.getHeaderNames();

   			 while (headerNames.hasMoreElements()) {

   			     String headerName = headerNames.nextElement();

   			     String headerValue = request.getHeader(headerName);

   			     out.println("<TR><TD>" + headerName + "</TD><TD>" + headerValue + "</TD></TR>\n");

   			 }

   			 out.println("</TABLE>\n</BODY>\n</HTML>");

   		 }
 else {
              
                out.println("<html><body>");
                out.println("<h2><b>Invalid username and password!</b></h2><br>");
                out.println("<a href='Login.html'>Back to Login</a>");
                out.println("</body></html>");
                
            }

            con.close();
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        } finally {
            out.close();
        }
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
