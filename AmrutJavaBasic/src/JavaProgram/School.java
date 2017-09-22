package JavaProgram;

import java.util.Scanner;

public class School {
	int id;
	String name;
	

}

 class classes extends School
{
	static String classTeacher="Sudha";

	public static void main(String args[])
	{
		
		
		School s1=new School();
		
		s1.id=100;
		s1.name="NMIT";
		
		
		
		
		
		
		System.out.println("School details");
		System.out.println("School ID"+s1.id);
		System.out.println("School Name"+s1.name);
		System.out.println("School Class Teacher"+classTeacher);
		
		
	}
}
