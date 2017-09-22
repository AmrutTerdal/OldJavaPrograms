package FirstPrep;

import java.lang.reflect.Array;
import java.util.Scanner;

public class ReverseString {

	static String reverse(String s) {
		int legnth = s.length();
		char[] arrayCh = s.toCharArray();
		int length = 0;
		for (int i = 0; i < length / 2; i++) {
			char ch = s.charAt(i);
			arrayCh[i] = arrayCh[legnth - 1 - i];
			arrayCh[legnth - 1 - i] = ch;
		}
		return new String(arrayCh);
	}

	public static void main(String[] args) {
	
		Scanner in = new Scanner (System.in);
		
    String s = in.next();
    reverse(s);
	

	}

}
