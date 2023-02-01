package shoppingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/confirmation")
public class confirmservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      Connection con;
      public void init(ServletConfig config) throws ServletException 
      {
   		con = (Connection)config.getServletContext().getAttribute("jdbccon");
   	}
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		out.print("<br/>Your order is confirmed");
		out.print("<br/>Thanku Have a Niceday");
		out.print("<br/><a href='logout'> LOGOUT </a>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
