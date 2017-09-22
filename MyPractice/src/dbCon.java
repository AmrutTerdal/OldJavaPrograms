




import java.sql.*;


import javax.swing.JOptionPane;

class dbCon{  
	Connection con=null;
public static  Connection dbConnector(){  
try{  
  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3307/customer_module","root","root");  
JOptionPane.showMessageDialog(null, "connection succesful");
return con;

  
}catch(Exception e)
{ System.out.println(e);
return null;}
  
}  
}  
