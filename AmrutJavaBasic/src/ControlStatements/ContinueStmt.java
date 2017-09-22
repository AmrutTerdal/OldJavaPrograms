package ControlStatements;

public class ContinueStmt {

	public static void main(String[] args)
	{
		
		for(int i=1;i<=10;i++)
		{
			if(i==5)
			{
				continue;
			}
			++i;
			System.out.println("i = "+i);
		}
	}
}
