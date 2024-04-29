package com.aj.Assignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DBOperations {
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet result = null;
	private int id = 0;
	private String name = null;
	private int age = 0;
	private String email = null;
	private String password = null;
	private Scanner sc = new Scanner(System.in); 
	
	DBOperations() throws SQLException {
		 this.conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
	}
	
	void register() throws SQLException {
		System.out.println("Enter your details to register...");
		System.out.println("Id : ");
		this.id = sc.nextInt();
		System.out.println("Name : ");
		sc.nextLine();
		this.name = sc.nextLine();
		System.out.println("Age : ");
		this.age = sc.nextInt();
		System.out.println("Email: ");
		this.email = sc.next();
		System.out.println("Password: ");
		this.password = sc.next();	
		
		this.stmt = this.conn.prepareStatement("insert into employees values(?,?,?,?,?)");
		this.stmt.setInt(1, id);
		this.stmt.setString(2, name);
		this.stmt.setInt(3, age);
		this.stmt.setString(4, email);;
		this.stmt.setString(5, password);
		this.stmt.execute();
		System.out.println("You are registered successfully...");
		this.stmt.close();
	}
	
	boolean varifyUserPrintDetails() throws SQLException {
		System.out.println("Enter your email: ");
		this.email = sc.next();
		System.out.println("Enter your password: ");
		this.password = sc.next();
		
		this.stmt = this.conn.prepareStatement("select * from employees where email = ? and password = ?");
		this.stmt.setString(1, this.email);
		this.stmt.setString(2, this.password);
		this.result = this.stmt.executeQuery();
		if(this.result.next()) {
			System.out.println(this.result.getInt("id")+"  "+this.result.getString("name")+" "+this.result.getInt("age")+"  "+this.result.getString("email")+" "+"  "+this.result.getString("password"));
			this.stmt.close();
			this.result.close();
			return true;
		}
		this.stmt.close();
		this.result.close();
		return false;
	}
	
	void closeConnection() throws SQLException{
		this.conn.close();
	}
}
