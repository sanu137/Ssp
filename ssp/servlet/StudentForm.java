package p1;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class StudentForm extends HttpServlet {
private static final long serialVersionUID = 1L;
        public StudentForm() {
        super();
        // TODO Auto-generated constructor stub
    }


protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.getWriter().append("Served at: ").append(request.getContextPath());

response.setContentType("text/html");

String name = request.getParameter("txtName");

        int sspMarks = Integer.parseInt(request.getParameter("ssp"));
        int osMarks = Integer.parseInt(request.getParameter("os"));
        int ccMarks = Integer.parseInt(request.getParameter("cc"));

        // Calculate total marks and percentage
        int totalMarks = sspMarks + osMarks + ccMarks;
        double percentage = (totalMarks / 300.0) * 100;

        boolean pass = percentage > 30;

 
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Result</title></head><body>");
        out.println("<h2>Result</h2>");
       
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>SSP Marks: " + sspMarks + "</p>");
        out.println("<p>OS Marks: " + osMarks + "</p>");
        out.println("<p>Third Subject Marks: " + ccMarks + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
       
        if (pass) {
            out.println("<p><strong>Congratulations! You have passed.</strong></p>");
        } else {
            out.println("<p>Sorry, you have not passed.</p>");
        }
       
        out.println("</body></html>");
}


protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request, response);
}

}
