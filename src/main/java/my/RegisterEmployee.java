package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RegisterEmployee extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("emp_id");
			String f=req.getParameter("First Name");
			String l=req.getParameter("Last Name");
			String d=req.getParameter("Designation");
			int sd=Integer.parseInt(req.getParameter("Start Date"));
			String de=req.getParameter("Department");
			int ed=Integer.parseInt(req.getParameter("End Date"));
			String s=req.getParameter("status");
			int db=Integer.parseInt(req.getParameter("dob"));
			String r=req.getParameter("Reporting Manager");
			String g=req.getParameter("Gender");
			String bg=req.getParameter("Blood Group");
			String ad=req.getParameter("Address");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Shiv@250000");
			Statement st=c.createStatement();
			int executeUpdate = st.executeUpdate("insert into emp (empid,First Name,Last Name,Designation,Start Date,Department,End Date,status,dob,"
			+ "Reporting Manager,Gender,Blood Group,Address) values ('"+e+"','"+f+"','"+l+"','"+d+"','"+sd+"','"+de+"','"+ed+"','"+s+"','"+db+"','"+r+"','"+g+"','"+bg+"','"+ad+"')");
			resp.sendRedirect("success.html");
		}catch (SQLIntegrityConstraintViolationException e) {
			resp.sendRedirect("error.html");
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
