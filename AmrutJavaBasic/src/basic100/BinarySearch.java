package basic100;

import java.util.Scanner;

public class BinarySearch {

	public static void main(String args[])
	{
		int counter,num,item,array[],first,last,middle;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the elements");
		num = in.nextInt();
		
		array = new int[num];
		
		System.out.println("Enter " +num+ "integers");
		for(counter=0;counter<num;counter++)
			array[counter]=in.nextInt();
		
		System.out.println("Enter the search value");
		item = in.nextInt();
		first = 0;
		last = num -1;
		middle = (first+last/2);
		
		while(first<=last)
		{
			if(array[middle]<item)
				first =middle+1;
			else if(array[middle]==item)
			{
				System.out.println(item+"Found at Location"+(middle+1)+".");
				break;
			}
			else
			{
				last = middle-1;
			}
			middle=(first+last)/2;
			
		}
		if(first>last)
			System.out.println(item+"is not found.\n");
		
		
	}
	
}
