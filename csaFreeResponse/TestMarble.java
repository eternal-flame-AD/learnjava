package csaFreeResponse;

public class TestMarble {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MarbleCollection myCollection=new MarbleCollection();
		myCollection.addSet(new MarbleSet("red",2));
		myCollection.addSet(new MarbleSet("blue",3));
		myCollection.addSet(new MarbleSet("green",3));
		myCollection.addSet(new MarbleSet("red",1));
		myCollection.removeColor("red");
		System.out.println(myCollection.getTotalMarbles()); //6
	}

}
