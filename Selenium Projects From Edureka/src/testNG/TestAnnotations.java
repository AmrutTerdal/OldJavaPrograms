package testNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestAnnotations {
	@Test
	public void f1() {

		System.out.println("Inside f1");

	}

	@Test

	public void f2() {
		System.out.println("Inside f2");

	}
	
	@BeforeTest
	
	public void beforeAnyTest(){
		System.out.println("inside Before any Test");
	}
	
	@AfterTest
	
	public void afterAllTheTest(){
		System.out.println("Insid AfterAll The Test");
		
	}
	
	@BeforeMethod
	public void beforeAveryMethod(){
		
		System.out.println("Insid Before Every Method");
		
	}
	
	@BeforeClass
	
	public void beforeClass(){
		System.out.println("Inside Before Class");
	}
	
	@AfterClass
	
	public void afterClass(){
		
		System.out.println("Inside After Class");
	}

}
