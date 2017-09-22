package basic100;

import java.util.Scanner;

public class CompareString {

	public static void main(String args[])
	{
		String s1,s2;
		
		Scanner in = new Scanner (System.in);
		
		System.out.println("Enter the first String");
		s1=in.nextLine();
		
		System.out.println("Enter the second String");
		s2=in.nextLine();
		
		if(s1.compareTo(s2)>0)
			System.out.println("The first sitring is greater than second");
			
			
			
		
		
		else if(s1.compareTo(s2)<0)
			System.out.println("The first sitring is Lesser than second");
			
		else
			System.out.println("Both are equal");
		}
	}

