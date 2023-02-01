package shoppingapp;

import javax.servlet.RequestDispatcher;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;

import javax.servlet.http.Cookie;
@WebServlet("/logincheck")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		 con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}
  

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		String uid = request.getParameter("uname");
		String pwd = request.getParameter("pswd");
		ps = con.prepareStatement("select * from users where u_id = ? and password = ?");
		ps.setString(1, uid);
		ps.setString(2, pwd);
		rs = ps.executeQuery();
		if(rs.next())
		{
			Cookie [] all = request.getCookies();
			if(all != null)
			{
				for(Cookie c : all)
				{
					if(c.getName().equals("loginerror"))
					{
						c.setMaxAge(0);
						
						response.addCookie(c);
					}
				}
			}
			HttpSession s = request.getSession();
			
			User u = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7));
			s.setAttribute("loggedinuser", u);
			
			RequestDispatcher rd = request.getRequestDispatcher("/home");
			rd.forward(request, response);
			
			
			
			
			
		}
		else 
		{
			Cookie cokie = new Cookie("loginerror","invaliddetail");
			response.addCookie(cokie);
			response.sendRedirect("/shopping/form.jsp");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
			rs.close();
			ps.close();
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
}
}	
	

	


