package com.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PreparedStatementDemo {
	final private static String user = "root";
	final private static String password = "faisal1234";
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is connected successfully...");
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
			PreparedStatement preparedStatement = connection.prepareStatement("insert into students values(?, ?, ?)");
			// generic dynamic query, ? called placeholder
			preparedStatement.setInt(1, 104);
			preparedStatement.setString(2, "malik");
			preparedStatement.setInt(3, 34);
			int update = preparedStatement.executeUpdate();
			System.out.println(update);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
