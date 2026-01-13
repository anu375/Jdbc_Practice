package Jdbc_Batch;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class First 
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		 Statement stmt=con.createStatement();
		 
		 String first="insert into students values(1,'UV'),(4,'Ray');";
		 String second="insert into students values(2,'Monika');";
		 String third="insert into students values(3,'Misti');";
		 
		 
		 
		   stmt.addBatch(first);
		   stmt.addBatch(third);
		   stmt.addBatch(second);
		   
		    int[] arr=stmt.executeBatch();
		    
		    for(int i: arr)
		    {
		    	System.out.println(i);
		    	
		    }
		     
		     con.close();
		     stmt.close();
		   
		 
		
	}

}


class students 
{
	int id;
	String name;
	
	public students(int id, String name)
	{
		this.id=id;
		this.name=name;
	}
}
