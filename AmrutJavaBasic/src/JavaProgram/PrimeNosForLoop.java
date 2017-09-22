package JavaProgram;

public class PrimeNosForLoop {
	
	 public static void main (String[] args)
	   {
		 int counter=0;
		 
		 System.out.println("Printing the prime numbers");
		 for(int i=0;i<=100;i++)
		 {
			 for(int j=1;j<=i;j++)
			 {
				 if(i%j==0)
				 counter++;
			 }
			 if(counter==2)
				 System.out.println(i);
			 counter=0;
			 
		 }
	   }
}
