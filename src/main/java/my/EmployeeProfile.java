package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class EmployeeProfile extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("email");
			String f=(String)req.getAttribute("First Name");
			String l=(String)req.getAttribute("Last Name");
			String g=(String)req.getAttribute("Gender");
			Integer db=(Integer)req.getAttribute("DOB");
			String re=(String)req.getAttribute("Relationship");
			String eq=(String)req.getAttribute("Educational Qualification");
			Integer sd=(Integer)req.getAttribute("Start Date");
			Integer ed=(Integer)req.getAttribute("End Date");
			String I=(String)req.getAttribute("Institition");
			String ad=(String)req.getAttribute("Address");
			Integer p=(Integer)req.getAttribute("Percentage");
			out.print("<html><body>");
			out.print("<h1>Employee Details:</h1>");
			out.print("<p>Employee Email <b>"+e+"</b></p>");
			out.print("<p>First Name: <b>"+f+"</b></p>");
			out.print("<p>Last Name <b>"+l+"</b></p>");
			out.print("<p>DOB: <b>"+db+"</b></p>");
			out.print("<p>Relationship: <b>"+re+"</b></p>");
			out.print("<p>Educational Qualification: <b>"+eq+"</b></p>");
			out.print("<p>Start Date: <b>"+sd+"</b></p>");
			out.print("<p>End Date: <b>"+ed+"</b></p>");
			out.print("<p>Institition: <b>"+I+"</b></p>");
			out.print("<p>Address: <b>"+ad+"</b></p>");
			out.print("<p>Percentage: <b>"+p+"</b></p>");
			out.print("</body></html>");
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
