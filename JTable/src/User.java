
public class User {

	private int id;
	private String firstName;
	private String lastName;
	private int age;
	
	public User(int ID,String FirstName,String LastName,int Age)
	{
		this.id=ID;
		this.firstName = FirstName;
		this.lastName = LastName;
		this.age = Age;
	}
	
	public int getid()
	{
		return id;
	}
	
	public String getfirstName()
	{
		return firstName;
	}
	public String getlastName()
	{
		return lastName;
	}
	
	public int getage()
	{
		return age;
	}
	
}
