package java;

public class StaticVariables {
	
	static 
	{
		System.out.println(" I am in my Static Variables Class block" );
	}

	public static void main(String[] args) {
		
		// to call static method you dont have to create an object
		Student.changeCollege();
		
		StaticTestBlock stb = new StaticTestBlock();
		
Student student1 = new Student("Shruthi", 100, "EnC");
Student student2 = new Student("Raghu", 101, "CS ");
student1.display();
student2.display();
	}

}

class Student
{
	
	static 
	{
		System.out.println(" I am in my  Student class block" );
	}
	String stuName;
	int stuID;
	String stuDept;
	// define static variable when it will be same for all the student so memory allocation is less
	static String collegeName = "SJMIT";
	
	Student(String stuName, int stuID)
	{
		this.stuName = stuName;
		this.stuID= stuID;
		
	}
	
	Student(String stuName, int stuID, String stuDept)
	{
		this(stuName, stuID);
		this.stuDept = stuDept;
	}
	
	void display()
	{
		System.out.println("Student Name: " + stuName + " Student ID: " + stuID + "  " +  stuDept + "  " +collegeName);
	}
	
	static void changeCollege()
	{
		collegeName= "BIET" ;
	}
}

class StaticTestBlock
{
	static 
	{
		System.out.println(" I am in my  static test class block" );
	}

}
