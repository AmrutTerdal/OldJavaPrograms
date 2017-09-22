package string;

import java.util.Scanner;

public class VowelCountDemo {
	
public static void main(String[] args){
	
	System.out.println("Enter the String");
	
	Scanner in = new Scanner(System.in);
	String str = in.nextLine();
	char [] chars = str.toCharArray();
	
	int counter = 0;
	
	for(char c:chars ){
		
		switch(c){
		case'a':
		case'A':
		case'e':
		case'E':
		case'i':
		case'I':
		case'O':
		case'o':
		case'U':
		case'u':
			
		counter++;
		break;
		
		}
	}
	
	System.out.println("The Vovels count is " +counter);
	
}

}
