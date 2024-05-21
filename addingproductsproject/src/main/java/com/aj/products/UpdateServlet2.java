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

@WebServlet("/UpdateServlet2")
public class UpdateServlet2 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String prodName = request.getParameter("productName");
		String compName = request.getParameter("compName");
		String typeOf = request.getParameter("typeOf");
		double prodPrice = Double.parseDouble(request.getParameter("productPrice"));
		String prodDetails = request.getParameter("prodDetails");
		
		DB db = null;
		try {
			db = new DB();
//			System.out.println("DB created successfully...");
			int count = db.updateProduct(prodName, compName, typeOf, prodPrice, prodDetails, id);
			if(count>0) {
				pd.print("<h1 align=\"center\">The product Updated Successfullly...<h1>");
			} else {
				pd.print("<h1 align=\"center\">The product not Updated Successfully...<h1>");
			}
		} catch (SQLException e) {
			pd.print("<h1 align=\"center\">The product updation failed...<h1>");
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
