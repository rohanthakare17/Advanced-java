package example.hibernate.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import example.hibernate.beans.MovieTitleAndYear;
import example.hibernate.entity.Movie;
import example.hibernate.utilities.HibernateUtils;

public class MovieExample {
	

	
		//create()
		private static void create(){
			
		Configuration conf =new Configuration();//Looks for hibernate properties
		conf=conf.configure();//Looks for hibernate.cfg.xml
		
		//Building a SessionFactory
		SessionFactory factory =HibernateUtils.buildSessionFactory();
		
		//Building a Session
		Session session=factory.openSession();
			Movie currentMovie=new Movie("M5","Border","Inspiration",1997);
		Transaction tx =session.beginTransaction();
			session.save(currentMovie);
			tx.commit();//Committing the Transaction
			session.close();
			factory.close();
			System.out.println("Its Rohan Bhau");
	}
		
		//UsingSelectClause()
		private static void hqlUsingSelectClause() {
			SessionFactory factory =HibernateUtils.buildSessionFactory();
			Session session=factory.openSession();
			
			//Building a query string
			String hqlQuery="select m.title, m.year from Movie m";
			//Obtain the reference of type Query
			Query<Object[]> qrMovie=session.createQuery(hqlQuery);
			List<Object[]> movieList=qrMovie.list();
			System.out.println("Print the title and year of all movies: ");
			for(Object[] movieData : movieList) {
				System.out.println("Title: "+movieData[0]+ "Year: "+movieData[1]);
			}
				
		}
		
		//UsingFromClause() 
		private static void hqlUsingFromClause() {
			SessionFactory factory =HibernateUtils.buildSessionFactory();
			Session session=factory.openSession();
			
			//Building a query string
			String hqlQuery="from Movie m";
			//Obtain the reference of type Query
			Query<Movie> qrMovie=session.createQuery(hqlQuery);
			
			List<Movie> allMovie=qrMovie.list();// its from javautil package
			System.out.println("Printing all the movies: ");
			for(Movie currentMovie : allMovie)
				System.out.println(currentMovie);
		}
		
		//UsingConstrutorExpression()
		private static void hqlUsingConstrutorExpression()
		{
			SessionFactory factory =HibernateUtils.buildSessionFactory();
			Session session=factory.openSession();
			
			String hqlQuery="select new example.hibernate.beans.MovieTitleAndYear(m.title,m.year) from Movie m";
			
			Query<MovieTitleAndYear> qr=session.createQuery(hqlQuery);
			
			List<MovieTitleAndYear> movieData=qr.list();// its from javautil package
			for(MovieTitleAndYear movie: movieData)
				System.out.println(movie.getTitle()+", "+movie.getYear());
			
		}
		
		//UsingCriteria()
		private static void hqlUsingCriteria()
		{
			SessionFactory factory =HibernateUtils.buildSessionFactory();
			Session session=factory.openSession();
			//Obtaining a reference of the type Criteria
			Criteria cr=session.createCriteria(Movie.class);
			List<Movie> allMovie= cr.list();
			for(Movie m:allMovie) {
				System.out.println(m);
			}
		
		}
		
		
		//UsingCriteriaWithRestriction()
		private static void hqlUsingCriteriaWithRestriction()
		{
			SessionFactory factory =HibernateUtils.buildSessionFactory();
			Session session=factory.openSession();
			
			Criteria cr=session.createCriteria(Movie.class);
			//Adding some restriction to fetch those movies released between 1965 and 1999
			cr.add(Restrictions.between("year", 1965, 1999));
			List<Movie> allMovie= cr.list();
			for(Movie m:allMovie) {
				System.out.println(m);
			}
			
		}
		public static void main(String[] args) {
			
//			create();
//			hqlUsingFromClause();
//			hqlUsingSelectClause();
//			hqlUsingConstrutorExpression();
//			hqlUsingCriteria();
			hqlUsingCriteriaWithRestriction();
	}

}
