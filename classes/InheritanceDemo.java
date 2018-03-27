package classes;
interface student {	
	//abstract static int studentID=0; // eclipse don't accept this but it does compile
	int studentID=0;
	char grade='A'; //public static final
	public void setGrade(char s); //public abstract
}

class myStudent implements student {
	int studentID=0;
	static int nowID=0;
	public char grade;
	public static void incrementID() {
		nowID++;
	}
	public void getID() {
		myStudent.incrementID();
		this.studentID=nowID;
	}
	public void setGrade(char grade) {
		this.grade=grade;
	}
}

class myStudentwithHobby extends myStudent {
	public String hobby;
}

public class InheritanceDemo {
	private static myStudent addStudent() {
		return new myStudent();
	}
	private static myStudentwithHobby addStudentwithHobby() {
		return new myStudentwithHobby();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myStudent mike=addStudent();
		mike.getID();
		System.out.println(mike.studentID); //1
		myStudentwithHobby john=addStudentwithHobby(); //using myStudent john... would cause hobby to be inaccessible
		john.getID();
		john.hobby="Coding";
		System.out.println(((myStudentwithHobby)((myStudent)john)).hobby); //this one is OK Coding
		/* myStudentwithHobby copyofMike=Mike;
		 * This is unacceptable
		 * myStudent copyofJohn=John;
		 * THis is OK£¬ however reading field hobby requires explicitly converting copyofJohn to myStudentwithHobby
		 */
		System.out.println(mike.studentID); //1
		System.out.println(john.studentID); //2
		System.out.println(mike.nowID); //2
		mike.setGrade('B');
		System.out.println(student.grade); //A
		System.out.println(mike.grade); //B
	}

}
