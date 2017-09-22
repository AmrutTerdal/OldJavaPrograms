import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class EvenOdd {

	public static void main(String[] args) {
		
		
		 Scanner in = new Scanner(System.in);
		 
		 System.out.println("Enter number");
		 
		int a =  in.nextInt();
		
		if(a % 2==0){
			
			System.out.println(a+" number is even");
			
		}
		else{
			System.out.println(a+" is odd");
		}
		
	}
	
}
