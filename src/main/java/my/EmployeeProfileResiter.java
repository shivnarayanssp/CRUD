package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class EmployeeProfileResiter extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("email");
			String pass=req.getParameter("pass");
			String f=req.getParameter("First Name");
			String l=req.getParameter("Last Name");
			String g=req.getParameter("Gender");
			int db=Integer.parseInt(req.getParameter("dob"));
			String re=req.getParameter("Relationship");
			String eq=req.getParameter("Educational Qualification");
			int sd=Integer.parseInt(req.getParameter("Start Date"));
			int ed=Integer.parseInt(req.getParameter("End Date"));
			String I=req.getParameter("Institution");
			String ad=req.getParameter("Address");
			int p=Integer.parseInt(req.getParameter("Percentage"));
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Shiv@250000");
			Statement st=c.createStatement();
			st.executeUpdate("insert into emp_info (email,First Name,Last Name,Gender,dob,Relationship,Educational Qualification,"
					+ "Start Date,End Date,Institution,Address,"
					+ "Percentage) values ('"+e+"','"+f+"''"+l+"','"+g+"','"+db+"','"+re+"','"+eq+"','"+sd+"','"+ed+"','"+I+"','"+ad+"','"+p+"')");
			resp.sendRedirect("success.html");
		}catch (SQLIntegrityConstraintViolationException e) {
			resp.sendRedirect("error.html");
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
