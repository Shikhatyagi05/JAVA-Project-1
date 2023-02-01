package shoppingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Addtocart")
public class cartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter Out=response.getWriter();
		int choosedp=Integer.parseInt(request.getParameter("p"));
		HttpSession s=request.getSession();
		List<Integer> prod=null;
		prod= (List<Integer>)s.getAttribute("cart");
		if(prod == null)
			prod = new ArrayList<>();
		prod.add(choosedp);
		s.setAttribute("cart", prod);
		prod.add(choosedp);
		Out.print("Select product id : "+choosedp+" is added in the cart <br/>");
		Out.print("No of selected products : "+prod.size());
		Out.print("<br/><a href='showcart'> show Cart </a>");
		Out.print("<br/><a href='home'>  selction page </a>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
