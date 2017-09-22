package first.basic.been;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {
	
	public static void main(String[] args){
		
		//object construction done by developer
		Employee eRef = new Employee();
		eRef.setId(25);
		eRef.setName("Don");
		eRef.setAddress("Banglore");
		 
		
		System.out.println("Employee details"+eRef);	
		
		Resource resource = new ClassPathResource("employee.xml");
		BeanFactory factory = new XmlBeanFactory(resource); //spring constructor which shall parse xml file construct objects
		Employee e0 = (Employee) factory.getBean("emp");
		Employee e2 = (Employee) factory.getBean("emp2");
		Employee e3 =  (Employee) factory.getBean("emp2", Employee.class);
		
		System.out.println("Employee Details:  "+e0);
		System.out.println("Employee Details:  "+e2);
		
		
	}
}
