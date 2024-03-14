package java;

public class ThisKeywordConstructorRelated {
	
	ThisKeywordConstructorRelated()
	{
	System.out.println("This is No Argument constructor");
	}
	public static void main(String[] args) {
		//by method
		Employee empObject = new Employee();
		empObject.empName ="Shruthi";
		empObject.empAge = 38;
		
		System.out.println("New Employee added by Method: " + " " + empObject.empName + " " + empObject.empAge); 
		//By Constructor
		ThisKeywordConstructorRelated cr = new ThisKeywordConstructorRelated();
		Employee e1 = new Employee("Raghu", 43);
		System.out.println("New Employee added by parameterized constructor: " + " " + e1.empName + " " + e1.empAge);

		Employee e2 = new Employee("TestMale", 43, "Male");
		System.out.println("New Employee added by Reusing overloaded constructor: " + " " + e2.empName + "  " + e2.empAge +   "  " + e2.empGender);
	}

}
class Employee {
	String empName;
	int empAge;
	String empGender;
	
	Employee()
	{
		System.out.println("This is No Argument constructor of EMployee object");
	}
	
	Employee(String eName, int eAge)
	{
		empName = eName;
		empAge=eAge;
	}
	
	Employee(String empName, int empAge, String empGender)
	{
		//Reusing constructor, call to this should be the first call 
		this(empName, empAge);
		this.empGender = empGender;
	}
	
}
