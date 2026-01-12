package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Second {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("id : ");
		int id = sc.nextInt();
		
		System.out.println("name : ");
		String name = sc.next();
		
		PreparedStatement ptmt = con.prepareStatement("insert into students values(?,?)");
		
		ptmt.setInt(1, id);
		ptmt.setString(2, name);
		
		System.out.println("rows changed : "+ptmt.executeUpdate());
		
		sc.close();
		con.close();
		ptmt.close();
	}
}
