package example.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleSELECTQueryExample {

	public static void main(String[] args) {
//		This class name varies from DB to DB
		String driverClassName="com.mysql.cj.jdbc.Driver";//package name.package name.class name
//		oracle.jdbc.OracleDriver
		String connectionURL="jdbc:mysql://localhost:3306/rohan";
		//jdbc:oracle:thin:@localhost:1521/xe;
		//Main Protocol:Sub Protocol://IP Address:Port No/Schema Name
		//Every time main protocol is jdbc, sub protocol may be very its depends on database
		
		String userId="root";
		String password="rohan1415";
		
		try {
			//Load the Driver
			// class.forName work as path 
			Class.forName(driverClassName);//This method is used to load the class explicitly
			System.out.println("Driver Loaded.");
			
			//Establish Connection
			Connection conn=DriverManager.getConnection(connectionURL, userId, password);
			System.out.println("Connect to DB");
			
			//Obtain the Statement
			Statement stmt = conn.createStatement();//Simple Query
			
			//Execute SQL Query
			String sqlQuery="select * from cardinfo";
			ResultSet recordSet= stmt.executeQuery(sqlQuery);
			
			//Navigating through the ResultSet:recordSet
			while(recordSet.next())
			{
				System.out.println("Card Id: "+recordSet.getInt(1)+ "\tCard Number: "+recordSet.getString(2)+"\tCard Expery: "+recordSet.getDate(3)+"\tName on Card: "+recordSet.getString(4)+"\tEmail Id: "+recordSet.getString(5));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
