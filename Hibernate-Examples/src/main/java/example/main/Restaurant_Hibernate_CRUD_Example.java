package example.main;

import java.io.Serializable;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import example.entity.Restaurant;



public class Restaurant_Hibernate_CRUD_Example {
	
	private static void create() {
		Configuration conf =new Configuration();//Looks for hibernate properties
		conf=conf.configure();//Looks for hibernate.cfg.xml
		
		//Building a SessionFactory
		SessionFactory factory =conf.buildSessionFactory();
		
		//Building a Session
		Session session=factory.openSession();
		
		//Building a Transaction
		Transaction tx =session.beginTransaction();
			Restaurant crs=new Restaurant(103, "MCcDonalds","American",20,LocalDate.of(1995, 8, 20));
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
		
		Class<Restaurant> restaurantType=Restaurant.class;//Specific which Entity type is required
		
		Serializable restaurant_id="103";//new Integer(Ad)
		Restaurant foundRestaurant=session.load(restaurantType, restaurant_id); //load is 
		
		System.out.println("Found Restaurant");
		System.out.println(foundRestaurant);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		create();
//		retrive();
	}

}
