package csaFreeResponse;

public class TestBinaryInt {
	public static void main(String[] args) {
		BinaryInt bin1=new BinaryInt(127);
		bin1.dump();
		BinaryInt one=new BinaryInt(1);
		one.dump();
		BinaryInt bin2=new BinaryInt(128);
		bin1.add(one);
		bin1.dump();
		System.out.println(bin1.compareTo(bin2));
	}
}
