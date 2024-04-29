package com.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class BatchDemo {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
			Statement statement = conn.createStatement();
			statement.addBatch("insert into students values(107, 'kumar', 67)");
			System.out.println("Query added one...");
			statement.addBatch("update students set name = 'hasan' where id = 103");
			System.out.println("Query added two...");
			statement.addBatch("delete from students where id = 104");
			System.out.println("Query added three...");
			int[] batch = statement.executeBatch();
			System.out.println(Arrays.toString(batch));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
