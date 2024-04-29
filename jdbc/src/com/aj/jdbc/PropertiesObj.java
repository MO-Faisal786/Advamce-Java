package com.aj.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesObj {
	final private static String user = "root";
	final private static String password = "faisal1234";
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver is connected successfully...");
			// Second way to establish connection
//			FileReader reader = new FileReader("D:\\AdvanceJava\\jdbc\\db.properties");
//			Properties properties = new Properties();
//			properties.load(reader);
//			System.out.println(properties.get("user"));
//			System.out.println(properties.get("password"));
//			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", properties);
//			System.out.println("Database Connected Successfully...");
			
//			Last way to connect database server
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);
			System.out.println("Database Connected Successfully...");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
