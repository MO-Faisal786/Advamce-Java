package com.aj.ecom;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ShoesServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pd = resp.getWriter();
		
//		context is started here
		ServletContext context = getServletContext();
		String offer = context.getInitParameter("festOffer");
		pd.print("<h1 align='center'>"+offer+"</h>");
		
//		Config is started here
		ServletConfig config = getServletConfig();
		String shoffer = config.getInitParameter("shoffer");
		pd.print("<h1 align='center'>"+shoffer+"</h>");
		
//		Attribute is started from here
		String username = (String)context.getAttribute("user");
		pd.print("<h1 align='center'>"+username+" Welcome to ElectronicsServlet</h>");
		
		pd.print("<h1 align='center'> This is the ShoesServlet</h>");
	}

}
