package java;

public class SuperKeywordClass{
	   public static void main(String args[])
	   {
		   Derived obj = new Derived();
	       Derived objpar = new Derived(101,"Shruthi","GA");
	      obj.display();
	      
	       System.out.println( new BClass().m4()  );
	       Card myCard;
	       myCard = new Card("Charlie");
	       myCard = new Holiday("Caitlin");
	       myCard = new AprilFool("Alex");
	       
	       System.out.print(new DSuperClass().m2() + " \n");
	       System.out.print(new DSuperClass().m3()+ " \n");
	       System.out.print(new CSuperClass().m3()+ " \n");
	       
	   }
}
///////////////// Another example of super Keyword////////////////////
class Base{
	int id; String name;
	   Base()
	   {
	       System.out.println("Inside Base class non parameter constructor");
	   }
	   Base(int id, String name)
	   {
		   System.out.println("Inside Base class parameter constructor");
		   this.id = id;
		   this.name = name;
	   }
	}

	class Derived extends Base{
		
	  String address;
	   Derived(){
		   super(10,"DNDNDD");
	       System.out.println("Inside Derived class non parameter constructor");
	      
	   } 
	   
	   Derived(int id, String name, String address){
		   // calls the constructor of parent
		  
		   super(id,name);
		   System.out.println("Inside Derived class parameter constructor");
		   this.address = address;
	   }
	   
	   void display()
	   {
		   System.out.println(id + " " + name );
	   }
	}
	
	///////////// Child class can override the parent class method/////////////
	class AClass
	{
	   int m1() {return m3();}
	   int m2() {return m3();}
	   int m3() {return 1;}
	}

	class BClass extends AClass
	{
	   int m1() {return super.m1();}
	   int m3() {return 6;}
	   int m4() {return m2();}
	}
	
//////// MultiLevel Inheritence/////////////	
	class Card
	{
	   String toWhom;

	   public Card(String name)
	   {
	      toWhom = name;
	      System.out.println("\nDear " + toWhom + "!");
	   }
	}

	class Holiday extends Card
	{
	   public Holiday(String name)
	   {
	      super(name);
	      System.out.println("Season's Greetings!");
	   }
	}

	class AprilFool extends Holiday
	{
	   public AprilFool(String name)
	   {
	      super(name);
	      System.out.println("Just Kidding!");
	   }
	}
	
	///////////////// When super class is called it calls the immediate parent class/////////
	class ASuperClass
	{
	   int m1() {return 1;}
	   int m2() {return m1();}
	   int m4() {return m5();}
	   int m5() {return 4;}
	}
	class BSuperClass extends ASuperClass
	{
	   int m1() {return super.m2();}
	   int m3() {return 7;}
	}
	class CSuperClass extends BSuperClass
	{
	   int m1() {return 2;}
	   int m2() {return super.m1();}
	   int m3() {return super.m2();}
	   int m5() {return 1;}
	}
	class DSuperClass extends CSuperClass
	{
	   int m1() {return 3;}
	   int m2() {return super.m4();}
	   int m3() {return super.m3();}
	   int m4() {return super.m2();}
	}
	
	
	