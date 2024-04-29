package com.aj.Assignment;

import java.sql.SQLException;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		DBOperations operations = null;
		Scanner sc = new Scanner(System.in);
		try {
			operations = new DBOperations();
			System.out.println("Are you registered or not? Enter 'yes' or 'no'");
			while(true) {
				String status = sc.next();
				if(status.equals("no")) {
					operations.register();
					break;
					} 
				else if(status.equals("yes")) {
					if(!operations.varifyUserPrintDetails()) {
							System.out.println("You are not registered... Please register...");
							operations.register();
					}
					break;
				} else {
					System.out.println("Please enter a valid input... 'yes' or 'no' ");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
				operations.closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
