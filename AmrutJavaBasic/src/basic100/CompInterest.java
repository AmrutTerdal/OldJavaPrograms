package basic100;

public class CompInterest {

	public static void main (String args[])
	{
		double a,p,r,n,ci;
		
		p=Double.parseDouble(args[0]);
		r=Double.parseDouble(args[1]);
		n=Double.parseDouble(args[1]);
		
		a=p*Math.pow((1+(r/100.0)), n);
		ci = a-p;
		System.out.println("Amount = "+a);
		System.out.println("Compound Interest  = "+ci);
		
	}
}
