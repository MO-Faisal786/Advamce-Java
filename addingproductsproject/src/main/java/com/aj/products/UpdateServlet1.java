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

@WebServlet("/UpdateServlet1")
public class UpdateServlet1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pd = response.getWriter();
		String id = request.getParameter("id");
//		System.out.println(id);
		int pid = Integer.parseInt(id);

		DB db = null;
		try {
			db = new DB();
			ResultSet product = db.getProductByID(pid);
			if (product.next()) {
				pd.print("<h1 align=\"center\">Update Productd in to list...</h1>");
				pd.print("<h1 align=\"center\">");
				pd.print("<form action=\"UpdateServlet2\" method=\"post\">");
				pd.print("<input type=\"hidden\" name=\"id\" value=" + product.getInt("id") + " ><br>");
				pd.print("<input type=\"text\" name=\"productName\" placeholder=\"Product Name...\" value="+product.getString("prod_name")+"><br>");
				pd.print("<input type=\"text\" name=\"compName\" placeholder=\"Componey Name...\" value="+product.getString("comp_name")+"><br>");
				pd.print("<input type=\"text\" name=\"typeOf\" placeholder=\"Type of product...\"  value="+product.getString("type")+"><br>");
				pd.print("<input type=\"number\" name=\"productPrice\" placeholder=\"Price...\"  value="+product.getInt("prod_price")+"><br><br>");
				pd.print(
						"<textarea rows=\"6\" cols=\"23\" name=\"prodDetails\" placeholder=\"Details...\" ></textarea><br>");
				pd.print("<input type='submit' value='Update'>");
				pd.print("</form>");
				pd.print("</h1>");
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
