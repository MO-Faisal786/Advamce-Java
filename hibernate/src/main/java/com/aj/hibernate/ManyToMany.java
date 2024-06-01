package com.aj.hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyToMany {
    public static void main(String[] args) {
        Session session = ForSession.getSession();
        Transaction transection = ForSession.getTransection();
        // Creating
        // Docter docter = new Docter();
        // docter.setName("Mitra");

        // Patient patient1 = new Patient();
        // patient1.setPname("Rahul");
        // docter.getPatients().add(patient1);

        // Patient patient2 = new Patient();
        // patient2.setPname("Faisal");
        // docter.getPatients().add(patient2);

        // session.persist(docter);

        // Reading
        // Docter docter = session.get(Docter.class, 2);
        // System.out.println("====================================");
        // System.out.println(docter);
        // Set<Patient> patients = docter.getPatients();
        // for (Patient patient : patients) {
        //     System.out.println(patient);
        // }
        // System.out.println("====================================");


        // For Patient 
        // Creating
        // Patient patient = new Patient();
        // patient.setPname("Rajiv");

        // Docter docter1 = new Docter();
        // docter1.setName("Rahul");
        // patient.getDocters().add(docter1);

        // Docter docter2 = new Docter();
        // docter2.setName("Kumar");
        // patient.getDocters().add(docter2);

        // session.persist(patient);

        // Reading
        Patient patient = session.get(Patient.class, 5);
        System.out.println(patient);
        Set<Docter> docters = patient.getDocters();
        System.out.println(docters);
        for (Docter docter : docters) {
            System.out.println(docter);
        }


        transection.commit();
        ForSession.closeSession();
        
    }
}
 