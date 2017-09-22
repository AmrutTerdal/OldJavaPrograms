package JavaProgram;

public class WhileLoopPrimeNos {

	public static void main(String[] args) {
		int count,i=1,a;
		System.out.println("Prime numbers between 1 and 100 using while loop");
		while(i<=100)
		{
			count=0;
			a=1;
			while(a<=i)
			{
				if(i%a==0)
					count++;
				a++;
			}
			if(count==2)
				System.out.println("The numbers are "+i);
			i++;
		}

	}

}
