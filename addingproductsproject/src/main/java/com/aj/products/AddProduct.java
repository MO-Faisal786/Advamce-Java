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

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		String prodName = request.getParameter("productName");
		String compName = request.getParameter("compName");
		String typeOf = request.getParameter("typeOf");
		double prodPrice = Double.parseDouble(request.getParameter("productPrice"));
		String prodDetails = request.getParameter("prodDetails");
		
		DB db = null;
		try {
			db = new DB();
//			System.out.println("DB created successfully...");
			db.addProduct(prodName, compName, typeOf, prodPrice, prodDetails);
			pd.print("<h1 align=\"center\">The product added Successfullly...<h1>");
		} catch (SQLException e) {
			pd.print("<h1 align=\"center\">The product adding failed...<h1>");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
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
