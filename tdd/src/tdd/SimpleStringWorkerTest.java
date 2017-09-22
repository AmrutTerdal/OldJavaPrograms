package tdd;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SimpleStringWorkerTest {

	private SimpleStringWorker subject;
	
	@Before
	public void setup(){
		
		subject = new SimpleStringWorker();
	}
	
	@Test
	public void test() {
		subject.append("hello");
	}
	
	

}
