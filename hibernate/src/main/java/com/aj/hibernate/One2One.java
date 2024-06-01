package com.aj.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class One2One {
    public static void main(String[] args) {
        Session session = ForSession.getSession();
        Transaction transection = ForSession.getTransection();
        // CountryDTO country = new CountryDTO();
        // country.setCname("India");
        // PMDTO pmdto = new PMDTO();
        // pmdto.setName("Modi");
        // country.setPmdto(pmdto);
        // session.persist(country);


        // CountryDTO countryDTO = session.get(CountryDTO.class, 1);
        // PMDTO pmdto = countryDTO.getPmdto();
        // System.out.println(countryDTO);
        // System.out.println(pmdto);

        // CountryDTO countryDTO = session.get(CountryDTO.class, 1);
        // countryDTO.setCname("USA");
        // PMDTO pmdto = countryDTO.getPmdto();
        // pmdto.setName("Baiden");
        // session.persist(countryDTO);
        // System.out.println("Data updated...");

        CountryDTO countryDTO = session.get(CountryDTO.class, 1);
        session.remove(countryDTO);
        transection.commit();
        System.out.println("Data deleted...");

        ForSession.closeSession();
        System.out.println("Done the program...");
    }
}
