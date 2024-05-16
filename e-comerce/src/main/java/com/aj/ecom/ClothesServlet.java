package com.aj.ecom;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ClothesServlet extends HttpServlet {
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
		String cloffer = config.getInitParameter("cloffer");
		pd.print("<h1 align='center'>"+cloffer+"</h>");
		
//		Attribute is started from here
		String username = "faisal";
		pd.print("<h2 align='center'>"+username+" Welcome to ClothServlet...</h>");
		context.setAttribute("user", username);
		pd.print("<h1 align='center'> This is the ClothesServlet...</h>");
	}
}
