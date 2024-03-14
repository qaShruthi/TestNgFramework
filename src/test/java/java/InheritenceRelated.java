package java;

public class InheritenceRelated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//ChildAClass ca = new ChildAClass();
		B b = new B(8);
		
	}

}

class FatherClass
{
	String fName;
	FatherClass()
	{
		
		System.out.println("I am in the father class constructor");
	}
	
	FatherClass(String fatherName)
	{
		this.fName = fatherName;
		System.out.println("I am in the father class constructor" + fatherName);
	}
	
	void fatherClassMethod()
	{
		System.out.println("I am in the father class");
	}
	
}

class ChildAClass extends FatherClass
{
	String cName;
	
	ChildAClass()
	{
		super();
		//System.out.println("I am in the Child class construcotr");
	}
	
	ChildAClass(String childAName)
	{
		this.cName = childAName;
		System.out.println("I am in the child class constructor" + childAName);
	}
	
	void childClassMethod()
	{
		System.out.println("I am in the child class");
	}
}


class A {
    A() { 
    	System.out.println(" I am in cnstr" );
    }          // Constructor
    A(int a) { 
    	System.out.print(a + 2 );
    }     // Constructor
    A(boolean c) { } // Constructor
}

class B {
    B() {
        this(3, 7);
    }
    B(int a) {
        super();
        System.out.print(a);
    }
    B(String b) {
        super();
    }
    B(int a, int c) { // Calls super() implicitly
    	
    	System.out.print(a + " " + c);
    }
}


