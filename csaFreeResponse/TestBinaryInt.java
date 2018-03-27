package csaFreeResponse;

public class TestBinaryInt {
	public static void main(String[] args) {
		BinaryInt bin1=new BinaryInt(127);
		BinaryInt one=new BinaryInt(1);
		BinaryInt bin2=new BinaryInt(128);
		bin1.add(one);
		System.out.println(bin1.compareTo(bin2));
	}
}
