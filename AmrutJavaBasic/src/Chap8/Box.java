package Chap8;

public class Box {
	private double width;
	private double height;
	private double depth;
	
	Box(){
	System.out.println("Constructing Box");
	
	width=10;
	height=10;
	depth=10;
	
	}
	double volume()
	{
		return width*height*depth;
	}

}
class BoxDemo{
	public static void main(String args[])
	{
		Box mybox1=new Box();
		Box mybox2=new Box();
		
		double vol;
		
		vol=mybox1.volume();
		System.out.println("Volume is "+vol);
		
		
		vol=mybox2.volume();
		System.out.println("volume is"+vol);
	}
}
