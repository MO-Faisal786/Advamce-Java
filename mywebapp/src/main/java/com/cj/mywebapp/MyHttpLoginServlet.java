package com.cj.mywebapp;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyHttpLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		String userName = req.getParameter("username");
		String password = req.getParameter("password");
		PrintWriter pd = resp.getWriter();
		if (userName.trim().equals("faisal") && password.trim().equals("1234")) {
			pd.print("<h1>User login successfull...httpServlet<h1/>");
		} else {
			pd.print("<h1>User login unsuccessfull...from httpServlet<h1/>");
		}
	}
}
