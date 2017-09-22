package ControlStatements;

public class BrealStmt {
	public static void main(String args)
	{
		int i=0;
		for(i=0;i<=10;i++){
		
			System.out.println(i);
			++i;
			if(i==5){
			 break;
			}
		}
	}

}
