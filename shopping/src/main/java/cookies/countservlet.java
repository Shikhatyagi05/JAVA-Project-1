package cookies;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie; 



@WebServlet("/formcok")
public class countservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter Out=response.getWriter();
		int cnt=0;
		Cookie[] allc= request.getCookies();
		for(Cookie c:allc)
		{
			if(c.getName().equals("vcount"))
			{
				cnt=Integer.parseInt(c.getValue());
			}
	
		}
		cnt++;
		Cookie cookie=new Cookie("vcount",cnt+"");
		response.addCookie(cookie);
		Out.print("visitcount :"+cnt);
		Out.print("<a href='formcok'>REFRESH</a><br/>");	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
