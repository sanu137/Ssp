package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/responseStContent")
public class responseSContent extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Add cookies
        for (int i = 0; i < 3; i++) {
            Cookie sessionCookie = new Cookie("Session-Cookie-" + i, "Cookie-Value-S" + i);
            response.addCookie(sessionCookie);

            Cookie persistentCookie = new Cookie("Persistent-Cookie-" + i, "Cookie-Value-P" + i);
            persistentCookie.setMaxAge(3600); // 1 hour
            response.addCookie(persistentCookie);
        }

        // Create HTML response
        String title = "Differentiating Session Cookies from Persistent Cookies";
        out.println("<html><head><title>" + title + "</title></head>" +
                    "<body bgcolor=\"#FDF5E6\">" +
                    "<h1 align=\"center\">" + title + "</h1>" +
                    "<table border=\"1\" align=\"center\">" +
                    "<tr bgcolor=\"#FFAD00\">" +
                    "<th>Cookie Name</th><th>Cookie Value</th></tr>");

        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            out.println("<tr><td colspan=\"2\">No cookies</td></tr>");
        } else {
            for (Cookie cookie : cookies) {
                out.println("<tr><td>" + cookie.getName() + "</td>" +
                            "<td>" + cookie.getValue() + "</td></tr>");
            }
        }

        out.println("</table></body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
