package example.jdbc;

import java.util.Collection;

import example.jdbc.dao.CourseDao;
import example.jdbc.dao.IDao;
import example.jdbc.entity.Course;

public class CRUD_Eample {
	private static void createNewCourse() {
		IDao<Course, String> idaoRef = new CourseDao();
		Course cr = new Course("JDBC", "JAVA Database", 1, 2000);
		idaoRef.create(cr);
	}

	private static void showAllCourses() {
		//To show courses, it is necessary to obtain the collection from CourseDao through getAll()
		IDao<Course, String> idaoRef = new CourseDao();
		Collection<Course> courseList = idaoRef.getAll();
		for(Course cr : courseList)
			System.out.println(cr);
	}
	
	private static void updateCourses() {
		//To show courses, it is necessary to obtain the collection from CourseDao through getAll()
		IDao<Course, String> idaoRef = new CourseDao();
		Course foundCourse=idaoRef.getOne("ML");
		if(foundCourse!=null)	
		{
			//Trying to update duration fees
			foundCourse.setCourse_duration(7);
			foundCourse.setCourse_fees(25000);
		}
		//Sending the modified state back to DAO
		idaoRef.update(foundCourse);
	
	}
	
	private static void deleteCourse()
	{
		IDao<Course, String> idaoRef = new CourseDao();
		idaoRef.deleteOne("ML");
	}
	
	public static void main(String[] args) 
	{
	//createNewCourse();//Method calling
		
		showAllCourses();
		//updateCourses();
		//deleteCourse();
	}

}
