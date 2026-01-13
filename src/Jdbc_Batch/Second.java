package Jdbc_Batch;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class Second {

	public static void main(String[] args) throws ClassNotFoundException,SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		PreparedStatement ps = con.prepareStatement("insert into students values(?,?)");
		
		int count = 1;
		
		while(count < 150)
		{
			ps.setInt(1, count);
			ps.setString(2, "A"+count);
			ps.addBatch();
			count++;
			
			if(count % 15 == 0)
			{
				System.out.println("Batch full...executing the batch....");
				
				long[] arr = ps.executeLargeBatch();
				
				for(long l : arr)
				{
					System.out.println(l);
				}
			}
		}
		
		con.close();
		ps.close();
		
	}
	
}
