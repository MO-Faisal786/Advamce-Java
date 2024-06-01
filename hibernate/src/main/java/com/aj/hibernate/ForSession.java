package com.aj.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ForSession {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;


    public static Session getSession() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }

    public static Transaction getTransection() {
        transaction = session.beginTransaction();
        return transaction;
    }

    public static void closeSession(){
        session.close();
        sessionFactory.close();
    }

}
