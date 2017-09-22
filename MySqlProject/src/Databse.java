import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Databse {
	
	public static void main(String args[])throws Exception
	{
		// Class.forName("com.mysql.jdbc.Driver"); //accessing driver from jar
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/compay","root","root");
		
		PreparedStatement statement = con.prepareStatement("select * from customer");
		
		ResultSet result = statement.executeQuery();
		
		while(result.next())
			
		{
			
			System.out.println(result.getString("cnum")+""+result.getString("cname")+""+result.getString("city")+""+result.getString("rating"));
			
		}
		
		
	}

}
