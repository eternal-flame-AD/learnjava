package csaFreeResponse;

import java.util.ArrayList;

public class MarbleCollection {
	private ArrayList<MarbleSet> sets;
	public MarbleCollection() {
		sets=new ArrayList<MarbleSet>();
	}
	public void addSet(MarbleSet theSet) {
		sets.add(theSet);
	}
	public int getTotalMarbles() {
		int s=0;
		for (MarbleSet now:this.sets) {
			s+=now.getNumber();
		}
		return s;
	}
	public int removeColor(String marbleCol) {
		int i=0;
		int s=0;
		while (i<sets.size()) {
			if (sets.get(i).getColor()==marbleCol) {
				s+=sets.get(i).getNumber();
				sets.remove(i);
			} else {
				i++;
			}
		}
		return s;
	}
}
