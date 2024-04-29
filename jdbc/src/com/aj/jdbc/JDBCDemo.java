package com.aj.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		// follow the steps to connect databases
		// 1. load and register the driver 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is connected successfully...");
			
			// step 2.connect database   
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=faisal1234");
			System.out.println("Database connected successfully...");
			
			
			statement = connection.createStatement();
//			boolean b = statement.execute("create table students(id int(2), name varchar(20), age int(2))");
//			boolean b = statement.execute("insert into students values(101, 'faisal', 22)");
//			System.out.println(b);
			resultSet = statement.executeQuery("select * from students");
			while(resultSet.next()) { // 5. Process Data
				System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name")+" "+resultSet.getInt("age"));
			}
			
//			int updateCount = statement.executeUpdate("update students set name = 'hasan' where id = 102");
//			System.out.println(updateCount);
			int deleteCount = statement.executeUpdate("delete from students where id = 102");
			System.out.println(deleteCount); //step 4 query executed
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
				System.out.println("step 6 close all resources...");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
