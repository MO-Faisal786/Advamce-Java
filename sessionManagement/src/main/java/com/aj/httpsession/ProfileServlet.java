package com.aj.httpsession;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		HttpSession session = request.getSession(false);
		if(session != null) {
			Object attribute = session.getAttribute("user");
			pd.print("<h1> Welcome "+attribute+"!</h1>");
		} else {
			pd.print("<h>Please log in first...</h>");
		}
	}

}
