package my;

import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginEmployee extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out=null;
		try {
			out=resp.getWriter();
			String e=req.getParameter("user_email");
			String p=req.getParameter("password");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","Shiv@250000");
			Statement st=c.createStatement();
			ResultSet rs=st.executeQuery("select * from emp_info where email='"+e+"' and password='"+p+"'");
			if(rs.next()) {
				HttpSession session=req.getSession();
				session.setAttribute("First Name", rs.getString("First Name"));
				session.setAttribute("Last Name", rs.getString("Last Name"));
				session.setAttribute("Gender", rs.getString("Designation"));
				session.setAttribute("DOB", rs.getInt("DOB"));
				session.setAttribute("Relationship", rs.getString("Department"));
				session.setAttribute("Educational Qualification", rs.getString("Educational Qualification"));
				session.setAttribute("Start Date", rs.getInt("Start Date"));
				session.setAttribute("End Date", rs.getInt("End Date"));
				session.setAttribute("Institution", rs.getString("Institution"));
				session.setAttribute("Percentage", rs.getString("Percentage"));
				session.setAttribute("Address", rs.getString("Address"));
				RequestDispatcher rd=req.getRequestDispatcher("up");
				rd.forward(req, resp);

			}else {
				resp.sendRedirect("usernotfound.html");
			}
		}catch (Exception e) {
			out.print(e);
		}
	}
	
}
