package ifcondition;
import java.util.Scanner;
public class LogicalOperators {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("What's Alice's score?");
		int alice=input.nextInt();
		System.out.print("What's Bob's score?");
		int bob=input.nextInt();
		if (alice>=60 && bob>=60) { // && is lower that comparison operators so this can run correctly
			System.out.println("They all passed the exam");
		}
		if (alice==bob) {
			System.out.println("They have the same score.");
		}
		if (alice!=bob) {
			System.out.println("They don't have the same score.");
		}
		if (alice>=60 || bob>=60) {
			System.out.println("At least one of them passed.");
		}
		if (!(bob>=60)) {    //here a inner parenesis is necessary because ! is higher than comparison operators
			System.out.println("Bob failed the exam.");
		}
		input.close();
	}
}
