
import java.util.*;
public class ArrayListEx1 {

	public static void main(String args[]){
		List<String> al = new ArrayList<String>();
		al.add("Sonoo");
		al.add("Michael");
		al.add("James");
		al.add("Andy");
		al.add("vinay");
		Iterator itr = al.iterator();
		while(itr.hasNext()){
		System.out.println(itr.next());
			
		}
	}

}
