package ArrayPrograms;

public class ArrayPrimeNum {

	public static void main(String[] args) {
		int size=100;
		int counter=0;
		int[] number=new int[size];
		
		for(int i=0;i<=100;i++)
		 {
			 for(int j=1;j<=i;j++)
			 {
				 if(i%j==0)
				 counter++;
			 }
			 if(counter==2)
				 
				 System.out.println(i);
			 counter=0;
			 
			 
		 }
		

	}

}
