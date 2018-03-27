package csaFreeResponse;

public class TestScreen {
	public final static void main(String[] args) {
		Screen myScreen=new Screen(1280,720);
		myScreen.pixelOn(300, 300);
		System.out.println(myScreen.pixelAt(300, 300)); //Screen
		System.out.println(myScreen.pixelAt(123, 456)); //null
	}
}
