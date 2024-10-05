package p1;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Enumeration;

/**
 * Servlet implementation class LoginDatabase
 */
public class LoginDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDatabase() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 try
		 {
		 String username=request.getParameter("txtName");
		 String password=request.getParameter("txtPassword");
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 out.println(username + password);
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sarvesh","root","jneccse");
		 PreparedStatement stmt=con.prepareStatement("select * from login where username=? and password=?");
		 stmt.setString(1,username);
		 stmt.setString(2,password);
		 ResultSet rset=stmt.executeQuery();
		 if(rset.next())
		 {
			 out.println("Welcome," +username);
			 String title = "Request Header Information";
			 response.addHeader("Refresh", "1");
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
		 else
		 {
		 out.println("<b>Invalid username and password !</b><br>");
		 RequestDispatcher rd=request.getRequestDispatcher("Login.html");
		 rd.include(request,response);
		 }
		 out.close();con.close();
		 }
		 catch(Exception e)

		 {
		 // out.println("Invalid user" );
		 System.out.println(e);
		 }

		 response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
