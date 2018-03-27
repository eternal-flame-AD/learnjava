package classes;


public class Notebook {

	private String content="";
	
	public String owner="";
	
	public static int id;   //all instances are sharing this int
	
	public static void sayAccessDenied() {
		System.out.println("This is not your notebook!");
		// this is not accessible here
	}
	
	public void sayOwner() {
		/*
		 * These are all acceptabe
		 * unlike python, this can be omitted here
		 */
		System.out.println(owner);
		System.out.println(this.owner);
	}
	
	public String readContent(String reader) {
		if (reader.equals(this.owner)) {
			return this.content;
		} else {
			sayAccessDenied();
			return "Not your note!";
		}
	}
	
	public void setOwner(String owner) {
		if (this.owner.equals("")) {
			this.owner=owner;
		} else {
			System.out.println("Owner already set!");
		}
	}
	
	public void writeContent(String writer,String content) {
		if (writer.equals(this.owner)) {
			this.content+=content;
		} else {
			sayAccessDenied();
		}
	}

}

