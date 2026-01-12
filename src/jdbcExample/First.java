package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class First {

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Please enter the id : ");
		int id = sc.nextInt();
		
		System.out.println("Please enter the name : ");
		String name = sc.next();
		
		Properties prop = new Properties();
		prop.put("user","root");
		prop.put("password", "@nushka123");
		
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc",prop);
				Statement stmt = con.createStatement();){
			System.out.println("Connection opened !");
			
			int n = stmt.executeUpdate("insert into students values()");
			
			System.out.println("no of rows affected...."+n);
			
			Integer i1 = 128;
			Integer i2 = 128;
			
			System.out.println(i1 == i2);
		}
		catch(Throwable e)
		{
			e.printStackTrace();
		}
		sc.close();
		
		
	}
}