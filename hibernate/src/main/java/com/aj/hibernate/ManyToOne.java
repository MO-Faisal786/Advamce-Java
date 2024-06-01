package com.aj.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ManyToOne {

    public static void main(String[] args) {
        Session session = ForSession.getSession();
        Transaction transection = ForSession.getTransection();
        
        // Teacher teacher1 = new Teacher();        
        // teacher1.setName("Azam");

        // Student student1 = new Student();
        // student1.setSname("Faisal");
        // student1.setTeacher(teacher1);

        // Student student2 = new Student();
        // student2.setSname("Ravi");
        // student2.setTeacher(teacher1);

        // Student student3 = new Student();
        // student3.setSname("Ravi");
        // student3.setTeacher(teacher1);

        // session.persist(student1);
        // session.persist(student2);
        // session.persist(student3);

        // Student student1 = session.get(Student.class, 1);
        // System.out.println("====================================");
        // System.out.println(student1);
        // Teacher teacher1 = student1.getTeacher();
        // System.out.println(teacher1);
        // System.out.println("====================================");

        // Student student2 = session.get(Student.class, 2);
        // System.out.println("====================================");
        // System.out.println(student2);
        // Teacher teacher2 = student2.getTeacher();
        // System.out.println(teacher2);
        // System.out.println("====================================");

        // Student student3 = session.get(Student.class, 3);
        // System.out.println("====================================");
        // System.out.println(student3);
        // Teacher teacher3 = student3.getTeacher();
        // System.out.println(teacher3);
        // System.out.println("====================================");

        Student student1 = session.get(Student.class, 1);
        session.remove(student1);

        // Student student2 = session.get(Student.class, 2);
        // session.remove(student1);

        // Student student3 = session.get(Student.class, 3);
        // session.remove(student1);

        transection.commit();

        ForSession.closeSession();

        
    }
}
