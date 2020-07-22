package _01_HelloServletWorld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/HelloServletWorld")
public class HelloServletWorld extends HttpServlet {

	private static final long serialVersionUID = 1L;
       

	
	public HelloServletWorld() {
        super();
    
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		Date today = new Date();
		String msg = "HelloServletWorld";

		pw.print("<html><body> <h1>" + msg + "</h1>");
		pw.print("<p>today:" + today + "<p>");
		pw.print("<a href=	http://www.injavawetrust.com/>injavawetrust </a>");
		pw.print("</body></html>");
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
