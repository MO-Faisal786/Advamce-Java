package com.aj.dboperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DB {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet result = null;
	
	public DB() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
//		 System.out.println("Connection success...");
	}
	
	public void addProduct(String prodName, String compName, String typeOf, double prodPrice, String prodDetails) throws SQLException {	
		
		this.stmt = this.conn.prepareStatement("insert into products values(?,?,?,?,?)");
		this.stmt.setString(1, prodName);
		this.stmt.setString(2, compName);;
		this.stmt.setString(3, typeOf);
		this.stmt.setDouble(4, prodPrice);
		this.stmt.setString(5, prodDetails);
		this.stmt.execute();
		this.stmt.close();
	}
	
	public ResultSet getProducts() throws SQLException {
		this.stmt = this.conn.prepareStatement("select * from products");
		ResultSet result = this.stmt.executeQuery();
		return result;
	}
	
	public void closeConnection() throws SQLException{
		this.conn.close();
	}
}
