package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class PrintEmployee extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("empid");
			String f=(String)req.getAttribute("First Name");
			String l=(String)req.getAttribute("Last Name");
			String d=(String)req.getAttribute("Designation");
			Integer sd=(Integer)req.getAttribute("Start Date");
			String de=(String)req.getAttribute("Department");
			Integer ed=(Integer)req.getAttribute("End Date");
			String s=(String)req.getAttribute("Status");
			Integer db=(Integer)req.getAttribute("DOB");
			String r=(String)req.getAttribute("Reporting Manager");
			String g=(String)req.getAttribute("Gender");
			String bg=(String)req.getAttribute("Blood Group");
			String ad=(String)req.getAttribute("Address");
			out.print("<html><body>");
			out.print("<h1>Employee Details:</h1>");
			out.print("<p>Employee ID <b>"+e+"</b></p>");
			out.print("<p>First Name: <b>"+f+"</b></p>");
			out.print("<p>Last Name <b>"+l+"</b></p>");
			out.print("<p>Designation: <b>"+d+"</b></p>");
			out.print("<p>Start Date: <b>"+sd+"</b></p>");
			out.print("<p>Department: <b>"+de+"</b></p>");
			out.print("<p>End Date: <b>"+ed+"</b></p>");
			out.print("<p>Status: <b>"+s+"</b></p>");
			out.print("<p>DOB: <b>"+db+"</b></p>");
			out.print("<p>Reporting Manager: <b>"+r+"</b></p>");
			out.print("<p>Gender: <b>"+g+"</b></p>");
			out.print("<p>Blood Group: <b>"+bg+"</b></p>");
			out.print("<p>Address: <b>"+ad+"</b></p>");
			
			//hit counter
			ServletContext ctx=getServletContext();
			Integer c=(Integer)ctx.getAttribute("count");
			if(c==null) {
				c=0;
			}
			ctx.setAttribute("count", ++c);
			
			out.print("<hr/><p>No of Visitor: <b>"+c+"</b></p>");
			
			out.print("</body></html>");
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
