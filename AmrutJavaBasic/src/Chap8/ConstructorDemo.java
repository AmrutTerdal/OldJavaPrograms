package Chap8;

public class ConstructorDemo {
	String name;
	


 ConstructorDemo(){
        System.out.println("This is the Constructor Demo");
        ConstructorDemo c1=new ConstructorDemo();
        
       

     try
     {
    	 c1.name="This is the constructor object try cathc block";
    	 System.out.println("Printing the Object \n");
    	 System.out.println(c1.name);
     }
     catch(Exception e)
     {
    	 System.out.println("Inside the Block");
     }
 

	
 }
}
