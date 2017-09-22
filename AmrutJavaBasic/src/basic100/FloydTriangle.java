package basic100;

import java.util.Scanner;

public class FloydTriangle {
	
	public static void main(String args[])
	{
 
		int n,num=1,c,d;
		
		System.out.println("Enter the number of rows of floyd's triangle you want ");
		Scanner in = new Scanner (System.in);
		
		n = in.nextInt();
		
		System.out.println("Floyds Triangle");
	    
		for(c=1;c<=n;c++)
		{
			for(d=1;d<=c;d++)
			{
				System.out.println(num+" ");
				num++;
			}
			System.out.println();
		}
		
	}

}
