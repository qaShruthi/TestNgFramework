package java;

class DifferentClass 
{
//	void show()
//	{
//		System.out.print(" 1 ");
//	}
	int show() // throws error - since we can not achieve method overloading by changing the return type of method 
	{
		System.out.print(" 2 ");
		return 2;
	}
	
	//From Java 5.0 onwards it is possible to have different return type for overriding methods
	Object show(String a)
	{
		System.out.print(" Diffrent Class" + a + " \n");
		return null;
	}
	
	final void show(String a, int b)
	{
		System.out.print(a+b);
	}
}

public class OverriddingConcepts extends DifferentClass {

	public int show()
	{
		 System.out.print(" 2 ");
		 return 1;
	}
	
	String show(String b)
	{
		System.out.print(" Overridding Concept class" + b + " \n");
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DifferentClass dc = new DifferentClass();
		dc.show();
		dc.show(" Object Return Type");
		dc.show(" Final Method will be shown ", 1002);
		OverriddingConcepts oc = new OverriddingConcepts();
		oc.show();
		
		oc.show(" String Return Type");
	}

}
