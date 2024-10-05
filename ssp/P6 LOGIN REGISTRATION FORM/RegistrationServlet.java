package p1;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/RegisterDatabase")
public class RegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("txtName"); 
        String password = request.getParameter("txtPassword"); 

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Gayatri", "root", "jneccse");

            String query = "INSERT INTO authentication_db (username, password) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password); 
            
            int result = stmt.executeUpdate();

            if (result > 0) {
                out.println("<html><body>");
                out.println("<h2>Registration successful! Welcome, " + username + "!</h2>");
                out.println("</body></html>");
                
                
            } else {
                out.println("<html><body>");
                out.println("<h2>Registration failed. Please try again.</h2>");
                out.println("</body></html>");
            }

            con.close();
        } catch (Exception e) {
            out.println("Exception: " + e.getMessage());
        } finally {
            out.close();
        }
    }
}
