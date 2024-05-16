package com.aj.sessionManagement;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			Cookie ck = cookies[0];
			pd.print("<h1> Welcome "+ck.getValue()+"!</h1>");
		} else {
			pd.print("<h>Please log in first...</h>");
		}
	}
}
