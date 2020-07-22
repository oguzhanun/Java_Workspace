package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.oguzhanun.hibernate.demo.entity.StudentDatabase;



public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(StudentDatabase.class)
				.buildSessionFactory();
	
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
		
			//start a transaction
			session.beginTransaction();
			
			System.out.println("//////////////////////////////\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
			System.out.println("silme işlemleri başladı....");
			
			session.createQuery("delete from StudentDatabase where id=4").executeUpdate();
			
			//1 numaralı id'ye sahip olan nesneyi sil.
			session.delete(session.get(StudentDatabase.class, 1));
			
			System.out.println("silme işlemleri tamamlandı....");
			
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
	}
}
