package com.aj.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null) {
			
			pd.print("<h1>"+session.getAttribute("user")+"logout successfully...</h1>");
			session.invalidate();
		} else {
			pd.print("<h>Please log in first...</h>");
		}
	}

}
