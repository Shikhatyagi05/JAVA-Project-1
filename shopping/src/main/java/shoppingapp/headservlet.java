package shoppingapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.User;


@WebServlet("/header")
public class headservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession s=request.getSession();
		User user=(User)s.getAttribute("loggedinuser");
		String name = user.getFname()+" "+user.getMname()+" "+user.getLname();
		out.print("<h1> Welcome "+name+"</h1>");
		out.print("<br/> <hr/>");
		
		out.print("<a href='updateform.jsp'> update detail </a>");
		out.print("<br/> <hr/>");
	}

}
