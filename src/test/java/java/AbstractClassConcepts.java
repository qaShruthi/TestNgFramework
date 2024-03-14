package java;

interface Vehicle
{
	void start();
	void minSpeed();
	void gasEngine();
	void acOrnonAC();
}


abstract class FourSeatCar implements Vehicle
{
	//abstract methods have to implemented in the extended child class
	abstract void colorOfTheSeat();
	public void start()
	{
		System.out.println("Start 4 seat car");
	}
	public void minSpeed()
	{
		System.out.println("Min speed is 30 miles/hour");
	}
	//implemented methods can also be present in abstract classes
	void display()
	{
		System.out.println("display");
	}
}

class SixSeatedCar extends FourSeatCar
{

	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Start the six seated Car vehicle");
	}

	@Override
	public void minSpeed() {
		// TODO Auto-generated method stub
		System.out.println("drive 6 seated car at 30 miles/hour");
	}

	@Override
	public void gasEngine() {
		// TODO Auto-generated method stub
		System.out.println("Six seated car is Petrol Vehicle");
		
	}

	@Override
	public void acOrnonAC() {
		// TODO Auto-generated method stub
		System.out.println("AC vehicle");
	}

	@Override
	void colorOfTheSeat() {
		// TODO Auto-generated method stub
		System.out.println("Color of the seat is black");
	}
	
}

public class AbstractClassConcepts extends FourSeatCar {
	
	
	@Override
	public void start() {
		// TODO Auto-generated method stub
		System.out.println("Start the vehicle");  
	}

	@Override
	public void minSpeed() {
		// TODO Auto-generated method stub
		System.out.println("drive 50 miles/hour");
	}
	
	@Override
	public void gasEngine() {
		// TODO Auto-generated method stub
		System.out.println("Start the vehicle"); 
	}

	@Override
	public void acOrnonAC() {
		// TODO Auto-generated method stub
		System.out.println("AC Car"); 
	}

	@Override
	public void colorOfTheSeat() {
		// TODO Auto-generated method stub
		System.out.println("Red car Seat"); 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AbstractClassConcepts absC = new AbstractClassConcepts();
		absC.start();
		absC.minSpeed();
		
		FourSeatCar car = new SixSeatedCar();
		car.start();
		car.minSpeed();
		car.display();
	}

	

	

}
