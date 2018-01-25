package oving6;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand implements CardContainer, Iterable<Card>{
	
	private ArrayList<Card> CardHand;
	
	public CardHand(){
		ArrayList<Card> CardHand = new ArrayList<Card>();
	
		
		this.CardHand = CardHand;
		
	}
	public void addCard(Card card){
		CardHand.add(card);
	}
	
	public int getCardCount(){
		return CardHand.size();
	}
	
	public Card getCard(int n){
		if (n>CardHand.size()){
			throw new IllegalArgumentException("Kortet finnes ikke");
		}
		return CardHand.get(n);
	}
	public Card play(int n){
		Card card = getCard(n);
		CardHand.remove(n);
		return card;
	}
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
		
	}

}
