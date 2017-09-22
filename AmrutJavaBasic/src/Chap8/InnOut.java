package Chap8;

class outer_demo{
	int num;
	


private class inner_demo{
	
	public void print(){
	
		System.out.println("This is the inner class");
	}
}

void display_inner(){
	inner_demo inner = new inner_demo();
	inner.print();
}
}



public class InnOut {

	public static void main(String args[])
	{
		outer_demo outer = outer_demo();
		outer.display_inner();
	}
}
