package java;

class Person
{
	private int Emp_id; // Data Hiding by setting it as private
	
	//Getters and Setters 
	public void setEmpId(int Emp_id)
	{
		this.Emp_id = Emp_id;
	}
	
	public int getEmpId()
	{
		return Emp_id;
	}
}

public class EncapsulationConcept {

	
	public static void main(String[] args) {
		
		Person emp = new Person();
		emp.setEmpId(12345);
		System.out.println("Employee ID : " +  emp.getEmpId());

	}

}
