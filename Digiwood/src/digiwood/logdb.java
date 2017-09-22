package digiwood;



import java.sql.*;

import javax.swing.JOptionPane;

class logdb{  
	Connection con=null;
public static  Connection dbConnector(){  
try{  
  
Connection con=DriverManager.getConnection(  
"jdbc:mysql://localhost:3307/digywoodads","root","madhu");  

return con;

  
}catch(Exception e)
{ System.out.println(e);
return null;}
  
}  
}  

