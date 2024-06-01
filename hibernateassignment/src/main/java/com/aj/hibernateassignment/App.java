package com.aj.hibernateassignment;

import com.aj.DB.DB;



public class App {
    public static void main(String[] args) {
        DB db = new DB();
        
        if (db.getStatus() && db.varifyUser()) {
            db.showDetails();
        } else{
            System.out.println("You are not existing user. Please enter details to open your account...");
            db.createUser();
        }

        db.closeSession();
        
    }
}
