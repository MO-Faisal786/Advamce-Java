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
	
	public void addProduct(String prodName, String compName, String typeOf, double prodPrice, String prodDetails, int id) throws SQLException {	
		
		this.stmt = this.conn.prepareStatement("insert into products values(?,?,?,?,?,?)");
		this.stmt.setString(1, prodName);
		this.stmt.setString(2, compName);;
		this.stmt.setString(3, typeOf);
		this.stmt.setDouble(4, prodPrice);
		this.stmt.setString(5, prodDetails);
		this.stmt.setInt(6, id);
		this.stmt.execute();
		this.stmt.close();
	}
	
	public ResultSet getProducts() throws SQLException {
		this.stmt = this.conn.prepareStatement("select * from products");
		this.result = this.stmt.executeQuery();
		return result;
	}
	

	public ResultSet getProductByID(int pid) throws SQLException {
		// Get the product detail by id
		this.stmt = this.conn.prepareStatement("select * from products where id=?");
		this.stmt.setInt(1, pid);
		this.result = this.stmt.executeQuery();
		return result;
	}
	
	public int updateProduct(String prodName, String compName, String typeOf, double prodPrice, String prodDetails, int id) throws SQLException {
		this.stmt = this.conn.prepareStatement("update products set prod_name=?,comp_name=?,type=?,prod_price=?,prod_details=? where id=?");
		this.stmt.setString(1, prodName);
		this.stmt.setString(2, compName);;
		this.stmt.setString(3, typeOf);
		this.stmt.setDouble(4, prodPrice);
		this.stmt.setString(5, prodDetails);
		this.stmt.setInt(6, id);
		int count = this.stmt.executeUpdate();
		return count;
	}
	
	public int deleteProduct(int id) throws SQLException {
		this.stmt = this.conn.prepareStatement("delete from products where id=?");
		this.stmt.setInt(1, id);
		int count = this.stmt.executeUpdate();
		return count;
	}
	
	
	public void closeConnection() throws SQLException{
		this.stmt.close();
		this.conn.close();
	}
}
