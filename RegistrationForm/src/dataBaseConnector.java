import java.sql.*;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Connection;


public class dataBaseConnector {
	
Connection con = null;
	
	public static Connection dbConnector()
	{
		
		try{
			
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/compay","root","root");
			JOptionPane.showMessageDialog(null, "Connection Successful");
			return con;
			
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
		
		

	}
}



