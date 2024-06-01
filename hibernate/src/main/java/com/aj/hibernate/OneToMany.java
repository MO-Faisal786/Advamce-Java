package com.aj.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class OneToMany {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Session session = ForSession.getSession();
        Transaction transection = ForSession.getTransection();

        // Vender vender = new Vender();
        // vender.setName("Jorden");

        // Customer customer1 = new Customer();
        // customer1.setName("Faisal");
        // vender.addCustomer(customer1);

        // Customer customer2 = new Customer();
        // customer2.setName("Malik");
        // vender.addCustomer(customer2);

        // Customer customer3 = new Customer();
        // customer2.setName("Azam Sir");
        // vender.addCustomer(customer3);

        // session.persist(vender);
        // transection.commit();

        // Getting Data...
        // Vender vender = session.get(Vender.class, 1);
        // Set<Customer> customers = vender.getCustomers();
        // System.out.println(vender);
        // System.out.println("=======================================");
        // for (Customer customer : customers) {
        //     System.out.println(customer);
        // }
        // System.out.println("=======================================");
        // transection.commit();

        // Update Data...
        // Vender vender = session.get(Vender.class, 1);
        // vender.setName("Brenden");
        // Set<Customer> customers = vender.getCustomers();
        // for (Customer customer : customers) {
        //     if(customer.getName().equals("Azam Sir")){
        //         customer.setName("Deepak Sir");
        //     }
        // }
        // transection.commit();

        //Delete Data...
        Vender vender = session.get(Vender.class, 1);
        session.remove(vender);
        transection.commit();


        ForSession.closeSession();

        System.out.println("The program is done...");
    }
}
