package Callable_Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class First 
{

	public static void main(String[] args) throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/jdbc","root","@nushka123");
		
		CallableStatement call = con.prepareCall("{call getavg(?)}");
		
		call.registerOutParameter(1, Types.DOUBLE);
		
		ResultSet set = call.executeQuery();
		
		while(set.next())
		{
			System.out.println("Average : "+set.getDouble(1));
		}
		
		con.close();
		call.close();
	}
	
}
