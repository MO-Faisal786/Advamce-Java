package com.aj.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStaatementDemo {
	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "faisal1234");
			System.out.println("Database Connected...");
			
////			inserting data using procedure
//			CallableStatement call = conn.prepareCall("call test.insertData(?,?,?)");
//			call.setInt(1, 105);
//			call.setString(2, "samiya");
//			call.setInt(3, 24);
//			int executeUpdate = call.executeUpdate();
//			System.out.println(executeUpdate);
//			fetching data using procedure
			CallableStatement call = conn.prepareCall("call test.fetchData(?,?,?)");
			call.registerOutParameter(1, Types.INTEGER);
			call.registerOutParameter(2, Types.VARCHAR);
			call.registerOutParameter(3, Types.INTEGER);
			ResultSet result = call.executeQuery();
			while(result.next()) {
				System.out.println(result.getInt("id")+" "+result.getString("name")+" "+result.getInt("age"));
			}
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
