package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class Third {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please enter the query : ");
		String str = sc.nextLine();
		
		Properties prop = new Properties();
		
		prop.put("user", "root");
		prop.put("password", "@nushka123");
		
		//Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc",prop);
		
		Statement stmt = con.createStatement();
		
		boolean set = stmt.execute(str);
		System.out.println(set);
		
		if(!set)
		{
			System.out.println("no of rows affected.. not needed but data added or changed...");
		}
		else
		{
			ResultSet rs = stmt.executeQuery(str);
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1));
				System.out.println(rs.getString(2));
			}
		}
		con.close();
	}
}
