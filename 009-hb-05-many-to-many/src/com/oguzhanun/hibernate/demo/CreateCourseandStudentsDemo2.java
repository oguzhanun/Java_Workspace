package com.oguzhanun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oguzhanun.hibernate.demo.entity.Course;
import com.oguzhanun.hibernate.demo.entity.Instructor;
import com.oguzhanun.hibernate.demo.entity.InstructorDetail;
import com.oguzhanun.hibernate.demo.entity.Review;
import com.oguzhanun.hibernate.demo.entity.Student;



public class CreateCourseandStudentsDemo2 {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	
		//Course course1 = new Course("one million points");
		/*course1.AddReview(new Review("Good Job... Well Done!!!"));
		course1.AddReview(new Review("Hey body come on! What the what!"));
		course1.AddReview(new Review("Yeah, I liked that"));
		*/
		
		Course course2 = new Course("Wing Tsun Fighting");
		Course course3 = new Course("Java Excellent Coding");
		Course course4 = new Course("Good Friendship");
		
		//Student student1 = new Student("Jhon","Doe","jhondoe@jhondoe.com");
		Student student2 = new Student("Mary","Public", "marypublic@marypublic.com");
		Student student3 = new Student("Oguzhan", "Un", "oguzhanun@hotmail.com");
		
		//course1.addStudent(student1);
		course2.addStudent(student2);
		course3.addStudent(student3);
		course4.addStudent(student3);
		
		//burada yaptığımız işlem sql tarafından tekrarlı bir işlem olarak algılanıyor... Bunu sormak lazım...
		/*for(Course c: student2.getCourses()) {
			System.out.println(c);
		}*/
		
		//kodun tek tarafa yazılması yeterl oluyor. tersten de kayıt işlemini ikincil bir işlem olarak görüyor.
		//student1.addCourse(course1);
		//student2.addCourse(course2);
		//student3.addCourse(course3);
		//student3.addCourse(course4);
		
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
	
			//session.save(course1);
			session.save(course2);
			session.save(course3);
			session.save(course4);
			
			
			//session.save(student1);
			session.save(student2);
			session.save(student3);
			
			session.getTransaction().commit();
			
			student2.addCourse(course2);
			student3.addCourse(course3);
			student3.addCourse(course4);
			
			System.out.println("Done!");
			
		} finally {
			sessionFactory.close();
		}
	}
}







