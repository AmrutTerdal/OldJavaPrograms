package basic100;

import java.util.Scanner;

public class ArmStrongNumber {
	
	public static void main(String args[])
	{
		int n,sum = 0,temp,r;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number for check");
		n = in.nextInt();
		
		temp =n;
		
		while(temp!=0)
		{
			r=temp;
			sum = sum +r*r*r;
			temp = temp/10;
			
		}
		
		if(n==sum)
			System.out.println("Entered number is an armstrong number");
		else
			System.out.println("Entered number is not an armstrong number");
		
		
	}

}
