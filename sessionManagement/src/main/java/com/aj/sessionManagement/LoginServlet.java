package com.aj.sessionManagement;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		if(name.trim().equals("faisal") && password.trim().equals("12345")) {
			// Sanitize the cookie value before setting it
            String sanitizedValue = URLEncoder.encode(name, "UTF-8");
			Cookie cookie = new Cookie("user", sanitizedValue);
			response.addCookie(cookie);
			pd.print("Login success...");
		} else {
			pd.print("Invalid credientials...");
		}
	}
}
