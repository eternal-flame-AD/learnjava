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
	private boolean addDigit(boolean a,boolean b,int pos,boolean add_num) {
		if (add_num) {
			if (a&&b) {
				this.binaryNumber.set(pos, true);
				return true;
			} else if (a||b) {
				this.binaryNumber.set(pos, false);
				return true;
			} else {
				this.binaryNumber.set(pos, true);
				return false;
			}
		}
		if (a^b) {
			this.binaryNumber.set(pos, true);
			return false;
		} else {
			this.binaryNumber.set(pos, false);
			return (a&&b);
		}
	}
	public BinaryInt add(BinaryInt oper) {
		int len1=this.binaryNumber.size();
		int len2=oper.binaryNumber.size();
		if (len1<len2) {
			int i;
			boolean add_num=false;
			for (i=len1-1;i>=0;i--) {
				add_num=addDigit(this.binaryNumber.get(i),oper.binaryNumber.get(i+len2-len1),i,add_num);
			}
			for (i=len2-len1-1;i>=0;i--) {
				this.binaryNumber.add(0,oper.binaryNumber.get(i));
			}
		} else {
			int i;
			boolean add_num=false;
			for (i=len2-1;i>=0;i--) {
				add_num=addDigit(this.binaryNumber.get(i+len1-len2),oper.binaryNumber.get(i),i+len1-len2,add_num);
			}
			i=i+len1-len2;
			while ((add_num) && (i>=0)) {
				add_num=addDigit(this.binaryNumber.get(i),false,i,add_num);
				i--;
			}
			if (add_num)
				this.binaryNumber.add(0, true);
		}
		return this;
	}
	public void dump() {
		for (boolean digit:this.binaryNumber) {
			System.out.print(digit?1:0);
		}
		System.out.println();
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
