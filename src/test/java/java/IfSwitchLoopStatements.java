package java;

public class IfSwitchLoopStatements {

	public int ageOfEmployee(int age) {
		return age;
	}

	public String deptOFEmployee(String dept) {
		return dept;
	}

	public static void main(String[] args) {
		IfSwitchLoopStatements lp = new IfSwitchLoopStatements();

		// if else statement
		int empAge = lp.ageOfEmployee(14);
		if (empAge > 0 || empAge < 21) {
			System.out.println("You are tooooo young to marry someone");
		} else if (empAge > 21) {
			System.out.println("Perfect age for marriage");
		} else {
			System.out.println("You are ready, All the best");
		}

		// Switch Statement
		String empDept = lp.deptOFEmployee("Comp");
		switch (empDept) {
		case "EnC":
			System.out.println("You are EnC department");
			break;
		case "Info":
			System.out.println("You are Information department");
			break;
		case "Comp":
			System.out.println("You are Computer department");
			break;
		case "Elec":
			System.out.println("You are Electrical department");
			break;
		case "Mech":
			System.out.println("You are Mechanical department");
			break;

		}

		// while loop

		int i = 0;
		while (i < 5) {
			System.out.println("You are while loop: " + i);
			i++;
		}

		// for loop

		for (int j = 0; j <= 4; j++) 
		{
			
		 System.out.println("You are in \" for \" loop : " + j);
			
		}
	}
}
