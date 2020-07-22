package _02_ServletLifecycle;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLifecycle extends HttpServlet {

	private static final long serialVersionUID = 1234567890;
	
	
	@Override
	public void init() throws ServletException{
		
		System.out.println("Hello init() method");
		System.out.println("init() methodu bir kez çalışır.");
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException {
		
		PrintWriter pw = res.getWriter();
		Date date = new Date();
		String message = "Servlet Lifecycle";
		
		pw.write("<html><body> <h1>" + message + "</h1>");
		pw.write("<p> Bugün:" + date + "</p>");
		pw.write("<a href= http://www.injavawetrust.com> injavawetrust </a>");
		pw.write("</body></html>");
		
	}

	@Override
	public void destroy() {
		System.out.println("####Destroy");
	}
}
