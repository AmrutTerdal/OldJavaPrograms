package basic100;

import java.util.Scanner;

public class Factorial {
 
	public static void main(String args[])
	{
 
		int n,c, fact = 1;
		
		System.out.println("Enter the integer to calculate its Factorial ");
		Scanner in = new Scanner (System.in);
		
		n = in.nextInt();
		
		if(n<0)
			System.out.println("Entered number should be positive");
		else
		{
			for(c=1;c<=n;c++)
			fact = fact*c;
		
		System.out.println("The factorial of  "+n+"  is"+fact);
		
		}
	}
	
}
