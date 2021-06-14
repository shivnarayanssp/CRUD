package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class SearchEmployee extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("emp_id");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Shiv@250000");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from emp where empid='"+e+"'");
			if(rs.next()) {
				req.setAttribute("First Name", rs.getString("First Name"));
				req.setAttribute("Last Name", rs.getString("Last Name"));
				req.setAttribute("Designation", rs.getString("Designation"));
				req.setAttribute("Start Date", rs.getInt("Start Date"));
				req.setAttribute("Department", rs.getString("Department"));
				req.setAttribute("End Date", rs.getInt("End Date"));
				req.setAttribute("Status", rs.getString("Status"));
				req.setAttribute("DOB", rs.getInt("DOB"));
				req.setAttribute("Reporting Manager", rs.getString("Reporting Manager"));
				req.setAttribute("Gender", rs.getString("Gender"));
				req.setAttribute("BloodGroup", rs.getString("BloodGroup"));
				req.setAttribute("Address", rs.getString("Address"));
				RequestDispatcher rd=req.getRequestDispatcher("pu");
				rd.forward(req, resp);
			}else {
				resp.sendRedirect("usernotfound.html");
			}
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
