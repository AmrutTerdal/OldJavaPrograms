package Chap8;

interface Shape
{
	 void draw();
	
}

class rectangel implements Shape
{
	public void draw(){
		
		System.out.println("Draw Rectangle");
		
	

}
}
public class PolyInterface {

	public static void main(String args[])
	{
		Shape s;
		
		rectangel r = new rectangel();
		s=r;
		s.draw();
		
	}
}
