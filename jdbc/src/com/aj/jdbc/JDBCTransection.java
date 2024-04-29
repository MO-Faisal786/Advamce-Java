package com.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTransection {
	public static void main(String[] args) {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
			Statement statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.execute("update bankacc set bal = bal-500 where accno = 1234");
			System.out.println("Query 1 executed...");
			statement.execute("update bankacc set bal = bal+500 where accno = 1235");
			System.out.println("Query 2 executed...");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback();
				System.out.println("Data rolback successfully...");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
}
