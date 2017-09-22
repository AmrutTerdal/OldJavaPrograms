package inhertance;

public class InheriDemoA {

	
		
		int i,j;

	
	
	void showij()
	{
		System.out.println("i and j:"+ i +" " +j);
		
		
	}

}

class B extends InheriDemoA{
	int k;
	
	void showk()
	{
		System.out.println("K:"+k);
		
	}
	
	void sum()
	{
		System.out.println("i+j+k:"+ (i+j+k) );
		
	}
	
	}
class SimpleInheritance{
	public static void main(String args[])
	{
		InheriDemoA superOb=new InheriDemoA();
		B subOb=new B();
		superOb.i=10;
		subOb.j=20;
		
		System.out.println("Contents of superOb: ");
		superOb.showij();
		System.out.println();
		
		subOb.i=7;
		subOb.j=8;
		subOb.k=9;
		System.out.println("Contents of subOb: ");
		subOb.showij();
		subOb.showk();
		System.out.println("Sum of i j and k in subOb: ");
		
		subOb.sum();
	}

	
	}
	


