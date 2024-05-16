package com.aj.products;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aj.dboperation.DB;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetAllProducts")
public class GetAllProducts extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		DB db = null;

		try {
			db = new DB();
			ResultSet products = db.getProducts();
			if (products != null) {
				pd.print("<h1 align=\"center\">All Products Lists...</h1>");
				while (products.next()) {
					pd.print("<h3>" + products.getString("prod_name") + " " + products.getString("comp_name") + " "
							+ products.getString("type") + " " + products.getDouble("prod_price") + " "
							+ products.getString("prod_details") + "</h3>");
				}
			} else {
				pd.print("<h1>No products found...</h>");
			}
		} catch (ClassNotFoundException | SQLException e) {

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
