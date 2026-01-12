package Jdbc_Batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamic_Batch
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		PreparedStatement ptmt = con.prepareStatement("insert into students values(?,?);");
		
		con.setAutoCommit(false);
		
		Scanner sc = new Scanner(System.in);
		
		int count = 1;
		
		while(count < 4)
		{
			System.out.println("Id : ");
			int id = sc.nextInt();
			
			System.out.println("Name : ");
			String name = sc.next();
			
			ptmt.setInt(1, id);
			ptmt.setString(2, name);
			
			ptmt.addBatch();
			
			count++;
		}
		
		int[] arr = ptmt.executeBatch();
		
		Thread.sleep(2500);
		
		System.out.println("Commiting the changes.....");
		
		con.commit();
		
		for(int i : arr)
		{
			System.out.println(i);
		}
		
		con.close();
		ptmt.close();
	}
	
}
