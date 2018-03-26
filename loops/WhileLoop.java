package loops;
import java.util.Scanner;
public class WhileLoop {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		String password="";
		while (!password.equals("PASSWORD")) {  //WARNING: password!="PASSWORD" is NOT going to work!
			System.out.print("Password please:");
			password=input.next();
			//password="PASSWORD";
			System.out.println(password.length());
			System.out.println("PASSWORD".length());
			System.out.println(password=="PASSWORD"); //always false
		}
		System.out.println("OK. Next challenge:");
		int intpassword=0;
		while (intpassword!=123456) {  //This one is OK
			System.out.print("Password please:");
			intpassword=input.nextInt();
		}
		System.out.print("OK");
	}
}
