package com.aj.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		
		// Create operation
//		Product product = new Product();
//		product.setId(108);
//		product.setProdName("Laptop");
//		product.setCompName("hp");
//		product.setType("electronics");
//		product.setProdPrice(150000);
//		product.setProdDetails("This is the laptop of hp company.");
//		
//		session.save(product);
//		session.beginTransaction().commit();//by default auto commit is disabled
		
//		Read operation
//		Product product = session.get(Product.class, 108);
//		System.out.println(product);
		
		// update product
//		Product product = session.get(Product.class, 108);
//		product.setProdPrice(100000);
//		session.saveOrUpdate(product);
//		session.beginTransaction().commit();
		
		// Delete operation
		Product product = session.get(Product.class, 108);
		session.delete(product);
		session.beginTransaction().commit();
		
		session.close(); // close the seesion
		sf.close(); // close the session factory
	}
}
