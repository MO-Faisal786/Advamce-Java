package com.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SavePointDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Savepoint savepoint = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
			System.out.println("connection");
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.execute("insert into bankacc values(4321, 'azam', 3000)");
			System.out.println("Queery 1 is executed...");
			statement.execute("update bankacc set bal = bal+1000 where accno = 4321");
			System.out.println("Query 2 is executed...");
			savepoint = connection.setSavepoint("Save two queries...");
			statement.execute("update bankacc set bal = bal-500 where accno = 1234");
			System.out.println("Query 3 is executed...");
			statement.execute("update bankacc set bal = bal+500 where accno = 1235");
			System.out.println("Query 4 is executed...");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
				System.out.println("Queries are rolled back after savepoint...");
				connection.commit();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
