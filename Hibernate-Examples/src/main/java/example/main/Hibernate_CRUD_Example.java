package example.main;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Course;

public class Hibernate_CRUD_Example {
	
	private static void create() {
		Configuration conf =new Configuration();//Looks for hibernate properties
		conf=conf.configure();//Looks for hibernate.cfg.xml
		
		//Building a SessionFactory
		SessionFactory factory =conf.buildSessionFactory();
		
		//Building a Session
		Session session=factory.openSession();
		
		//Building a Transaction
		Transaction tx =session.beginTransaction();
			Course crs=new Course("Ad", "Adavance Java",8,18000);
			session.save(crs);//This results into DML INSERT
		tx.commit();//Committing the Transaction
		session.close();
		factory.close();
		System.out.println("Its Rohan Bhau");
	}
	
	private static void retrive() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
//		System.out.println(sf);
		Session session = sf.openSession();
		
		Class<Course> courseType=Course.class;//Specific which Entity type is required
		
		Serializable course_id="Ad";//new Integer(Ad)
		Course foundCourse=session.load(courseType, course_id); //load is //Here the instance is directly Per
		
		System.out.println("Found Course");
		System.out.println(foundCourse);
	}
	
	
	private static void update() {
SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
//		System.out.println(sf);
		Session session = sf.openSession();
		
		Class<Course> courseType=Course.class;//Specific which Entity type is required
		
		Serializable course_id="Ad";//new Integer(Ad)
		Course foundCourse=session.load(courseType, course_id); //load is 
		
		Transaction tx=session.beginTransaction();
		//Making some change in the course that has beans loaded
		foundCourse.setFees(25000);
		foundCourse.setDuration(10);
		tx.commit();//Committing the Transaction
		session.close();
		
		System.out.println("Its Rohan Bhau");
		
	}
	
	private static void delete() {
		SessionFactory sf=new Configuration().configure().buildSessionFactory();
				
//				System.out.println(sf);
				Session session = sf.openSession();
				
				Class<Course> courseType=Course.class;//Specific which Entity type is required
				
				Serializable course_id="Ad";//new Integer(Ad)
				Course foundCourse=session.load(courseType, course_id); //load is 
				
				Transaction tx=session.beginTransaction();        //Transaction State
				//Making some change in the course that has beans loaded
				session.delete(foundCourse);                      //Persistence State
				tx.commit();//Committing the Transaction
				session.close();                                  //Detached state
				sf.close();
				
				System.out.println("Its Rohan Bhau");
				
			}
	private static void retrieveOnceAngain(){
SessionFactory sf=new Configuration().configure().buildSessionFactory();
		
//		System.out.println(sf);
		Session session = sf.openSession();
		
		Class<Course> courseType=Course.class;
		
		
	}
	
				
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create();
		//retrive();
		//update();
		delete();
	}

}
