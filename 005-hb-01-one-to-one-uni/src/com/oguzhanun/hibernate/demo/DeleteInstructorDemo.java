package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;



public class DeleteInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
	
		
		//create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			//start a transaction
			session.beginTransaction();

			
			Instructor instructor = session.get(Instructor.class, 1);
			
			if(instructor != null) {

				session.delete(instructor);
			}

			/* BURADA BİRBİRİNE BAĞLI TABLOLARDAKİ NESNELER SİLİNMEK İSTERSE QUERY SEÇENEĞİNİN KULLANILDIĞI DURUMDA
			 * BAĞLI TABLODAKİ NESNE SİLİNMİYOR. YALNIZCA SORGULAMANIN YAPILDIĞI TABLODAKİ NESNE CASCADE TİPİNE BAKILMAKSIZIN
			 * SİLİNİYOR...
			session.createQuery("delete from InstructorDetail where id=2").executeUpdate();
			*/
			
			//commit the transaction
			session.getTransaction().commit();
			//System.out.println(instructor);
			System.out.println("Done!");
			
		} finally {
			
			sessionFactory.close();
		}
	}
}
