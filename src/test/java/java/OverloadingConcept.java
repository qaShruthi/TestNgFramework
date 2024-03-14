package java;

import java.util.Arrays;

public class OverloadingConcept {
	
	//Can we achieve method overloading by changing the return type of method only?No
	void show()
	{
		System.out.println("Method 1");
	}
	
	void show(double a)
	{
		System.out.println("Method 2 : " + a);
	}
	//StringBuffer is Mutable means the data stored can be replaced whereas String is immutable
	void show(StringBuffer a)
	{
		System.out.println("StringBuffer Method  " + a);
	}
	
	void show(int a,float f)
	{
		System.out.println("int float show method" + a + f);
	}
	
	void show(float f, int a )
	{
		System.out.println("float int show method" + a + f);
	}
	
	//void show(int... a )
	//{
		//System.out.println("Int Variable Arguments can pass any : " + Arrays.toString(a));
	//}
	
	void show(Object... b )
	{
		System.out.println("Int Variable Arguments can pass any : " + Arrays.toString(b));
	}
	
	//Can we overload main method in Java -- Yes
	public static void main(int a)
	{
		System.out.println("Overloaded main method  " + a);
	}
	
	//Automatic Promotion
	public static void main(String args[])
	   {
		OverloadingConcept pc = new OverloadingConcept();
		pc.show();
		StringBuffer sb= new StringBuffer();
		sb.append("hello");
		pc.show(sb);
		main(10);
		//pc.show(10,10);
		//pc.show("hello", 20);
		pc.show(10,20,30,40,60,70);
		pc.show("hello","Super","MoM","Doing","Great");
	   }
}
