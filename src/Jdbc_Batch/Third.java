package Jdbc_Batch;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Third
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		PreparedStatement ps = con.prepareStatement("insert into students values(?,?)");
		
		con.setAutoCommit(false);
		
		Scanner sc = new Scanner(System.in);
		
		try
		{
			int count = 1;
			
			while(count < 4)
			{
				System.out.println("ID : ");
				int id = sc.nextInt();
				
				System.out.println("NAME : ");
				String name = sc.next();
				
				ps.setInt(1, id);
				ps.setString(2, name);
				ps.addBatch();
				
				count++;
			}
			
			ps.executeBatch();
			
			System.out.println("Commitng the changes");
			con.commit();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Initiating rollback....");
			con.rollback();
		}
		
		con.close();
		ps.close();
	}
	
}
