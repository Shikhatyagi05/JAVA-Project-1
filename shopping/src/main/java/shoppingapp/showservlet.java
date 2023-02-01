package shoppingapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/showcart")
public class showservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection con;
	public void init(ServletConfig config) throws ServletException {
		con = (Connection)config.getServletContext().getAttribute("jdbccon");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		HttpSession s =request.getSession();
		List<Integer> prod = (List<Integer>)s.getAttribute("cart");
		if(prod == null)
		{
			out.println("<h3>No Products selected</h3>");
		}
		else
		{

			int cnt=0;
			
			PreparedStatement ps = null;
			ResultSet rs = null;
			try {
			out.print("<table border='1'>");
			out.print("<tr>");
			out.print("<th> Sr.No.</th>");
			out.print("<th>Name</th>");
			out.print("<th>Description </th>");
			out.print("<th>Price</th>");
			out.print("</tr>");
			
			 ps= con.prepareStatement("select * from product where p_id = ?");
				float total = 0;
				for(int n : prod)
				{
					ps.setInt(1, n);
					rs = ps.executeQuery();
					if(rs.next())
					{
						out.print("<tr>");
						out.print("<td>"+(++cnt)+"</td>");
						out.print("<td>"+rs.getString(2)+"</td>");
						out.print("<td>"+rs.getString(3)+"</td>");
						out.print("<td>"+rs.getString(4)+"</td>");
						out.print("<td> <a href='delete?pid="+n+"'> delete </a> </td>");
						total += Float.parseFloat(rs.getString(4));
						out.print("</tr>");
						
					}
				}
				out.print("<tr>");
				out.print("<td colspan=3>Total Price</td>");
				out.print("<td>"+total+"</td>");
				out.print("</tr>");				
				out.print("</table>");
				
				s.setAttribute("tprice", total);
				out.print("<br/><a href='home'> Go For Further Selection </a>");
				out.print("<br/><a href='confirmation'> Confirm Cart </a>");
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
