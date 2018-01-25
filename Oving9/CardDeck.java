package oving9;
import java.util.ArrayList;
import java.util.Iterator;

public class CardDeck extends CardContainerImpl implements Iterable<Card>, CardContainer{
	
	protected ArrayList<Card> deck;
	
	
	public CardDeck(int n) {
		super(newDeck(n),52);
		
	}
	
	
	public static ArrayList<Card> newDeck(int n){
		ArrayList<Card> deck = new ArrayList<Card>();
		for (int i = 1; i <= n; i++) {
			Card card = new Card('S', i);
			deck.add(card);	
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('H', i);
			deck.add(card);
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('D', i);
			deck.add(card);	
		}
		for (int i = 1; i <= n; i++) {
			Card card = new Card('C', i);
			deck.add(card);	
		}
		return deck;
	}
	
	
	public int getCardCount() {
		return super.getCardCount();
	}
	
	public Card getCard(int n) {
		return super.getCard(n);
	}
	
	public void shufflePerfectly() {
		int half_index = getCardCount()/2;
		ArrayList<Card> firstHalf = new ArrayList<Card>();
		ArrayList<Card> secondHalf = new ArrayList<Card>();
		for (int i = 0; i <= half_index - 1; i++) {
			firstHalf.add(getCard(i));
			secondHalf.add(getCard(half_index + i));
		}
		System.out.println(firstHalf);
		System.out.println(secondHalf);
		
		ArrayList<Card> shuffled = new ArrayList<Card>();
		for (int i = 0; i < half_index; i++) {
			Card kort1 = firstHalf.get(i);
			shuffled.add(kort1);
			Card kort2 = secondHalf.get(i);
			shuffled.add(kort2);
		}
		this.deck = shuffled;
	}
	
	
	public void deal(CardHand hand, int n){
		for (int i = 0; i < n; i++){
			Card card = deck.get(deck.size()-1);
			deck.remove(deck.size()-1);
			hand.addCard(card);
		}
	}
	
	
	
	
	public String toString() {
		return String.format("%s", deck);
	}

	@Override
	public Iterator<Card> iterator() {
		return super.iterator();
	}


}



		 

		
