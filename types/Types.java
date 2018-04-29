package types;
/*
 A brief introduction of several types
 */

import java.util.ArrayList;

public class Types {
	public static void main(String[] args) {
		
		// int(integer) -2147483648 - 2147483647
		int numofStudents=30;
		numofStudents++; //add another student
		System.out.print("THe number of students in my class is:");
		System.out.println(numofStudents);
		
		// double
		int totalScore=2900;
		double averageScore1=totalScore/numofStudents; // int/int==int and int is converted into double 
		System.out.print("The average score of this exam is:");
		System.out.println(averageScore1); //this is resulting in 96.0 the decimal part is cut off not rounded so 96.667->96
		
		float averageScore2=(float)totalScore/numofStudents; // float is single precision
		averageScore2++; // double are also able to self increment
		averageScore2--;
		System.out.print("Sorry...The actual score is:");
		System.out.println(averageScore2); //96.66666666666667
		
		boolean passTest=averageScore2>=90;
		System.out.print("Did the class pass?");
		System.out.println(passTest);
		
		char grade='A'; //'A' is a char but "A" is a string
		grade++; //'A' to 'B'
		System.out.print("The grade of the class is:");
		System.out.println(grade);
		
		ArrayList<Integer> scorelist=new ArrayList<Integer>();
		scorelist.add(97);
		scorelist.add(0,100);
		scorelist.set(0, 95);
		scorelist.add(98);
		scorelist.remove(scorelist.size()-1);
		System.out.println(scorelist.get(0)); //97
		
		String[] namelist;
		namelist=new String[]{"John", "Mike"};
		System.out.println("There are " + namelist.length + " students in the class");
		for (String name:namelist) {
			System.out.println(name);
		}
		
	}
}
