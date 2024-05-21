package com.aj.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.aj.dboperation.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		DB db = null;
		try {
			db = new DB();
			int count = db.deleteProduct(id);
			if(count>0) {
				pd.print("<h1 align='center'>Product deleted successfully...</h1>");
			} else {
				pd.print("<h1 align='center'>Product not deleted...</h1>");
			}
		} catch (ClassNotFoundException | SQLException e) {
			pd.print("<h1 align='center'>Product not deleted...</h1>");
			e.printStackTrace();
		} finally {
			try {
				db.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
