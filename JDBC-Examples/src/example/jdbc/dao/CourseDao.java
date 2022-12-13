package example.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.mysql.cj.jdbc.JdbcConnection;

import example.jdbc.JdbcUtils;
import example.jdbc.entity.Course;

public class CourseDao implements IDao<Course, String> 
{
	//**Create**
	@Override
	public void create(Course crs) {//This object will be stored as a record into the database table
		//Extract the data available in the Course object: crs using getters
		String id=crs.getCourse_id();
		String title=crs.getCourse_title();
		int duration=crs.getCourse_duration();
		int fees=crs.getCourse_fees();
		
		String sqlQuery="insert into course values(?,?,?,?)";
		
		try(Connection conn=JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery))
		{
			pstmt.setString(1, id);
			pstmt.setString(2, title);
			pstmt.setInt(3, duration);
			pstmt.setInt(4, fees);
			
			int insertCount = pstmt.executeUpdate();
			System.out.println("Record inserted. Count is " + insertCount);
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
//-------------------------------------------------------------------------------------------------------
	//**getAll**
	@Override
	public Collection<Course> getAll() 
	{
		Collection<Course> allCourses = new ArrayList<Course>();
		try(Connection conn = JdbcUtils.buildConnection();
				Statement stmt = conn.createStatement();
				ResultSet recordSet = stmt.executeQuery("select * from course"))
		{
				while(recordSet.next()) {
					String courseTitle = recordSet.getString(2);//Reads a String at column index 1 : Title
					String courseId = recordSet.getString(1);
					int courseFees = recordSet.getInt(4);
					int courseDuration = recordSet.getInt(3);
					//Building a Course object based upon the data fetched from ResultSet
					Course crs = new Course(courseId, courseTitle, courseDuration, courseFees);
					//Adding the Course object into the Collection: allCourses
					allCourses.add(crs);
				}	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return allCourses;
	}
	
	
//-------------------------------------------------------------------------------------------------------
	//**GET ONE**
	
	@Override
	public Course getOne(String key) {
		
		return null;
	}
	
	
//---------------------------------------------------------------------------------------------------
	//**UPDATE**
	@Override
	public void update(Course updatedCourse) 
	{
		//Extract values for all the fields except ID
		String title=updatedCourse.getCourse_title();
		int duration=updatedCourse.getCourse_duration();
		int fees=updatedCourse.getCourse_fees();
		
	//Build SQL Query
		String sqlQuery=
				"update course set course_title=?, course_duration=?,course_fees=? where course_id";
		try(Connection conn=JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery))
		{
			//Substituting values for unknown parameters
			// Index is depends on the how query is pass
			pstmt.setString(1, title);
			pstmt.setInt(2, duration);
			pstmt.setInt(3, fees);
			
			String courseID=updatedCourse.getCourse_id();
			pstmt.setString(4, courseID);
			
			int updateCount=pstmt.executeUpdate();
			System.out.println("Record Update Count: "+updateCount);	
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
//-------------------------------------------------------------------------------------------------------
	//**DeleteOne**
	@Override
	public void deleteOne(String courseId) {
		String sqlQuery="delete from course where course_id=?";
		try(Connection conn=JdbcUtils.buildConnection();
				PreparedStatement pstmt = conn.prepareStatement(sqlQuery))
		{
			pstmt.setString(1, courseId);
			int deleteCount=pstmt.executeUpdate();
			System.out.println("Record delete. Count: "+deleteCount);
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
