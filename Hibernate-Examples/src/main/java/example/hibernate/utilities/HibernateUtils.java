package example.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Movie;

public class HibernateUtils {
	public static SessionFactory buildSessionFactory() {
		Configuration conf =new Configuration().configure();
		//Registering Movie entity with Configuration
		
		Class<Movie> movieType=Movie.class;
		conf.addAnnotatedClass(movieType);
//		conf.addAnnotatedClass(Movie.class);
		SessionFactory sf= conf.buildSessionFactory();
		return sf;
		
	}

}
