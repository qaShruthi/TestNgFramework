package java;

interface FirstInterface
{
	public void myMethod();
}

interface SecondInterface
{
	public void firstMethod();
}

public class InterfaceConcepts implements FirstInterface, SecondInterface {

	public static void main(String[] args) {
		InterfaceConcepts ic = new InterfaceConcepts();
		ic.firstMethod();
		ic.myMethod();

	}

	@Override
	public void firstMethod() {
		// TODO Auto-generated method stub
		System.out.println("First Method");
	}

	@Override
	public void myMethod() {
		// TODO Auto-generated method stub
		System.out.println("Second Method");
	}

}
