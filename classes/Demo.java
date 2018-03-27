package classes;

public class Demo {
	public static void main(String[] args) {
		Notebook note1=new Notebook();
		Notebook note2=new Notebook();
		note1.setOwner("John");
		note2.setOwner("Mike");
		note1.sayOwner();
		note2.sayOwner();
		System.out.println(note1.readContent("John"));
		note1.writeContent("Me", "Whose notebook is this?");
		note1.writeContent("John", "Feeling bored...");
		System.out.println(note1.readContent("John"));
		//note1.content is private so you cant read this
	}
}
