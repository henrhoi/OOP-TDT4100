package oving9;

import java.util.ArrayList;
import java.util.Iterator;

public class CardHand extends CardContainerImpl implements CardContainer, Iterable<Card>{
	
	
	public CardHand(int maxCardCount){
		super(new ArrayList<Card>(),maxCardCount);
		
	}
	public void addCard(Card card){
		super.addCard(card);
	}
	
	public int getCardCount(){
		return super.getCardCount();
	}
	
	public Card getCard(int n){
		return super.getCard(n);
	}
	public Card play(int n){
		Card card = getCard(n);
		super.liste.remove(n);
		return card;
	}
	
	@Override
	public Iterator<Card> iterator() {
		return super.iterator();
		
	}

}
