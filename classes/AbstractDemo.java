package classes;
abstract class book {
	public static String material="paper";
	public String ISBN;
	public String title;
	public int pagenow;
	protected book() { //constructor dont have return types
		this.pagenow=1; 
	}
	public void flip_page() {
		pagenow++;
		System.out.println("Flipped to page "+pagenow);
	}
}
abstract class Electronicbook extends book {
	public static String material="Electrical device";
}
class AP_Princeton extends book {
	public String ISBN="978-1-101-91988-0";
	public String title="Cracking the AP CSA Exam";
	private static String Customer_review;
	public void flip_page() {
		System.out.println("FLipping page of:"+this.title);
		super.flip_page();  //Not this.super
	}
	public void write_review(String rev) {
		this.Customer_review=rev;
	}
	public String read_review() {
		return Customer_review;
	}
}
class Python_docs extends Electronicbook {
	public String title="Python docs";
}
public class AbstractDemo {
	public static void main(String[] args) {
		//You can NOT instantiate a book object
		System.out.println(book.material); //paper
		book myAPbook=new AP_Princeton();
		myAPbook.flip_page();
		/*
		 * FLipping page of:Cracking the AP CSA Exam
		 * Flipped to page 2
		 */
		((AP_Princeton)myAPbook).write_review("Sucks..."); //explicitly tell java this is an instance of AP_Princeton or it will NOT compile
		AP_Princeton anotherAPbook=new AP_Princeton();
		System.out.println(anotherAPbook.read_review()); //Sucks...
		book myPythondoc=new Python_docs();
		System.out.println(myPythondoc.material); // paper !!!!
		System.out.println(((Electronicbook)myPythondoc).material); //Electrical device
	}
}
