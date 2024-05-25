package com.aj.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main(String[] args) {
		Configuration conf = new Configuration();
		conf.configure();
		SessionFactory sf = conf.buildSessionFactory();
		Session session = sf.openSession();
		Transaction ts = session.beginTransaction();

		// Create operation
		// Product product = new Product();
		// product.setId(101);
		// product.setProdName("Phone");
		// product.setCompName("Samsung");
		// product.setType("Electronics");
		// product.setProdPrice(105000);
		// product.setProdDetails("This is the Phone of Samsung company.");
		// System.out.println("The record is added to your database...");

		// session.save(product);
		// ts.commit();//by default auto commit is disabled

		// Read operation
		// Product product = session.get(Product.class, 108);
		// System.out.println(product);

		// update product
		// Product product = session.get(Product.class, 108);
		// product.setProdPrice(100000);
		// session.saveOrUpdate(product);
		// ts.commit();

		// Delete operation
		// Product product = session.get(Product.class, 108);
		// session.delete(product);
		// ts.commit();

		// Create query object
		// Query query = session.createQuery("from Product");
		// List<Product> list = query.list();
		// for (Product product : list) {
		// System.out.println(product);
		// }

		// for unique product
		// Query query = session.createQuery("from Product where id = 101");
		// System.out.println("This is the query result... "+query);
		// Product product = (Product) query.uniqueResult();
		// System.out.println(product);

		// for dynamic and generic query in hql
		// Query query = session.createQuery("from Product where id = :productId");
		// query.setParameter("productId", 101);
		// System.out.println("This is the query result... "+query);
		// Product product = (Product) query.uniqueResult();
		// System.out.println(product);

		// update product 
		// Query query = session.createQuery("update Product set prodPrice=:price where id =: productId");
		// query.setParameter("price", 37000);
		// query.setParameter("productId", 101);
		// int result = query.executeUpdate();
		// System.out.println("Number of effected rows... "+result);
		// ts.commit();

		// Delete product
		Query query = session.createQuery("delete from Product where id =:productId");
		query.setParameter("productId", 101);
		int result = query.executeUpdate();
		System.out.println("Number of effected rows... "+result);
		ts.commit();
		


		session.close(); // close the seesion
		sf.close(); // close the session factory
		System.out.println("Done the program...");
	}
}
