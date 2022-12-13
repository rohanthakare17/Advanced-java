package example.hibernate.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import example.hibernate.entity.Movie;

public class HibernateCourseUtils {
	public static SessionFactory buildSessionFactory() {
		Configuration conf =new Configuration().configure();

		Class<Movie> courseType=Movie.class;
		conf.addAnnotatedClass(courseType);
		
		SessionFactory sf= conf.buildSessionFactory();
		return sf;
	}
	
	public HibernateCourseUtils() {
		// TODO Auto-generated constructor stub
	}

}
