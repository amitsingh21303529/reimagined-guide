import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class AboutServlet extends HttpServlet
{
	public void service(HttpServletRequest sreq,HttpServletResponse sres)
	{
		PrintWriter out=null;
		try
		{
			sres.setContentType("text/html");
			out=sres.getWriter();
			HttpSession session=sreq.getSession(false);
			if(session!=null)
			{
				String u=(String)session.getAttribute("uid");
				Class.forName("com.mysql.jdbc.Driver");
			    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","incapp");
			    Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select *from user_info where userid='"+u+"'");
				rs.next();
				out.print("<html><body><center>");
				out.print("<h1>My Login-Logout Web Application</h1>");
				out.print("<a href='LS2'>Logout</a></br></br>");
				out.print("User id:<b>"+rs.getString("userid")+"</br></br></br>");
				out.print("Name:<b>"+rs.getString("name")+"</br></br></br>");
				out.print("Phone:<b>"+rs.getString("phone")+"</br></br></br>");
				out.print("Age:<b>"+rs.getString("age")+"</br></br></br>");
				out.print("</center></body></html>");
				con.close();
			}
			else
			{
				sres.sendRedirect("loginError2.html");
			}
		}
		catch(Exception ex)
		{
			out.print(ex);
		}
	}
}