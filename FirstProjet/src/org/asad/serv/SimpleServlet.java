package org.asad.serv;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "a simple servlet", urlPatterns = { "/SimpleServletPath" },
initParams= {@WebInitParam(name="defaultuser",value="abcd efgh")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello from jjjj");
	    response.setContentType("text/html; charset=utf-8");
	    String userName=request.getParameter("name");
		HttpSession session =request.getSession();
	    ServletContext context =request.getServletContext();

	    if(userName!="" && userName!=null) {
	    
		    session.setAttribute("savedUser",userName);
		    context.setAttribute("savedUser",userName);
	    	
	    }
	    
		PrintWriter writer = response.getWriter();
		writer.println("Req parameter has username "+ userName);
		writer.println("session parameter has username "+(String) session.getAttribute("savedUser"));
		writer.println("context parameter has username "+(String) context.getAttribute("savedUser"));
		writer.println(" parameter has default username is  "+getServletConfig().getInitParameter("defaultuser"));
		  
		//	response.getWriter().append("<h3>asad</h3>").append(request.getContextPath());
	}

}
