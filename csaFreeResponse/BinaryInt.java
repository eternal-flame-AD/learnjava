package csaFreeResponse;

import java.util.ArrayList;

public class BinaryInt implements Comparable<BinaryInt> {
	private ArrayList<Boolean> binaryNumber;
	public BinaryInt() {
		binaryNumber=new ArrayList<Boolean>();
		binaryNumber.add(false);
	}
	public BinaryInt(int target) {
		binaryNumber=new ArrayList<Boolean>();
		while (target>0) {
			binaryNumber.add(0,(target%2==1)?true:false);
			target/=2;
		}
	}
	public String toString() {
		String result="";
		for (boolean thisdigit:this.binaryNumber) {
			result+=((thisdigit)?1:0);
		}
		if (result.length()==0)
				result="0";
		return result;
	}
	public int compareTo(BinaryInt oper) {
		// TODO Auto-generated method stub
		if (this.binaryNumber.size()==oper.binaryNumber.size()) {
			int i=0;
			while (i<this.binaryNumber.size()) {
				if (this.binaryNumber.get(i) && !(oper.binaryNumber.get(i))) {
					return 1;
				} else if (!(this.binaryNumber.get(i)) && oper.binaryNumber.get(i)) {
					return -1;
				} else {
					i++;
				}
			}
			return 0;
		} else {
			return (this.binaryNumber.size()>oper.binaryNumber.size())?1:-1;
		}
	}
}
