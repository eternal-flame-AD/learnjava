package csaFreeResponse;

public class MarbleSet {
	private int number;
	private String color;
	public MarbleSet(String color, int numMarbles) {
		this.color=color;
		this.number=numMarbles;
	}
	public String getColor() {
		return this.color;
	}
	public int getNumber() {
		return this.number;
	}
}
