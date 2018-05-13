package csaFreeResponse;

public class Tdeck {
	public static void main(String[] args) {
		Deck testdeck=new Deck(10);
		System.out.println(testdeck.inOrder());
		System.out.println(testdeck.reorderingCount());
	}
}
class Deck {
	private int[] cards;
	
	public Deck (int numCards) {
		cards=new int[numCards];
		for (int i=0;i<numCards;i++) {
			cards[i]=i;
		}
	}
	public boolean inOrder() {
		for (int i=0;i<cards.length;i++) {
			if (cards[i]!=i) {
				return false;
			}
		}
		return true;
	}
	public void shuffle() {
		int mid=cards.length/2;
		int[] newcards=new int[cards.length];
		for (int i=0;i<mid;i++) {
			newcards[i*2]=cards[i];
			newcards[i*2+1]=cards[mid+i];
		}
		this.cards=newcards;
	}
	public int reorderingCount () {
		int count=1;
		this.shuffle();
		while (!this.inOrder()) {
			this.shuffle();
			count++;
		}
		return count;
	}
}