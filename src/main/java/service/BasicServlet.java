package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Very simple servlet as a prove of concept
public class BasicServlet extends HttpServlet {
	  @Override
	  public void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		try {
			out.println("This is a servlet...just to illustrate we know how it works");	
			
		} finally {
			out.close();
		}
		
	  }
}
