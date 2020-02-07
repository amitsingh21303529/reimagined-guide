import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class LogoutServlet extends HttpServlet
{
	public void service(HttpServletRequest sreq,HttpServletResponse sres)
	{
		PrintWriter out=null;
		try
		{
			sres.setContentType("text/html");
			out=sres.getWriter();
			HttpSession session=sreq.getSession(false);
			session.invalidate();
			sres.sendRedirect("login.html");
			
		}
		catch(Exception ex)
		{
			out.print(ex);
		}
	}
}