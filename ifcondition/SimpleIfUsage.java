package ifcondition;
import java.util.Scanner;
public class SimpleIfUsage {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.print("What's your score?");
		int score=input.nextInt();
		if (score>=60) {
			System.out.println("You passed the exam");
		} else {
			System.out.println("You failed the exam");
		}
		// Also a more elegant way
		boolean passed=(score>=60)? true : false; //Unlike python, here true starts with a lower-case
		if (passed) { //parenesis is not emittable
			System.out.println("You passed the exam");
		} else {
			System.out.println("You failed the exam");
		}
		if (passed)
			System.out.println("You passed the exam"); //this is also ok
	}
}
