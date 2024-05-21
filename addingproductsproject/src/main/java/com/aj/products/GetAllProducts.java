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
				pd.print("<table align=\"center\" style=\"border: 1px solid black; border-collapse: collapse;\">"

						+ "<thead>" 
						+ "   <tr>"
						+ "     <th style=\"border: 1px solid black; border-collapse: collapse;\">Product Name</th>"
						+ "     <th style=\"border: 1px solid black; border-collapse: collapse;\">Company Name</th>"
						+ "     <th style=\"border: 1px solid black; border-collapse: collapse;\">Type of Product</th>"
						+ "     <th style=\"border: 1px solid black; border-collapse: collapse;\">Price</th>"
						+ "		<th style=\"border: 1px solid black; border-collapse: collapse;\">Details</th>"
						+ "		<th style=\"border: 1px solid black; border-collapse: collapse;\">Update</th>"
						+ "		<th style=\"border: 1px solid black; border-collapse: collapse;\">Delete</th>"
						+ "   </tr>" 
						+ "</thead>");
				while (products.next()) {
					pd.print("<tbody> <tr>" + "<td style=\"border: 1px solid black; border-collapse: collapse;\">"
							+ products.getString("prod_name") + "</td>" + " "
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\">"
							+ products.getString("comp_name") + "</td>" + " "
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\">"
							+ products.getString("type") + "</td>" + " "
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\">"
							+ products.getDouble("prod_price") + "</td>" + " "
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\">"
							+ products.getString("prod_details") + "</td>"
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\"><a href='UpdateServlet1?id="+products.getInt("id")+"'>Update</a></td>"
							+ "<td style=\"border: 1px solid black; border-collapse: collapse;\"><a href='DeleteServlet?id="+products.getInt("id")+"'>Delete</a></td>"

							+ "</tr></tbody>");
				}

				pd.print("</table>");
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
