package oving9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CardContainerImpl implements CardContainer{
	
	protected List<Card> liste;
	private int maxCardCount;
	
	public CardContainerImpl(ArrayList<Card> liste, int maxCardCount){
		if(liste.size() > maxCardCount){
			throw new IllegalStateException("Ikke lov med så mange kort");
		}
		this.liste = liste;
		this.maxCardCount = maxCardCount;
		
	}

	@Override
	public Iterator<Card> iterator() {
		return new CardContainerIterator(this);
		
	}

	@Override
	public int getCardCount() {
		return liste.size();
	}

	@Override
	public Card getCard(int n) {
		if (n>liste.size()){
			throw new IllegalArgumentException("Kortet finnes ikke");
		}
		return liste.get(n);
	}

	public int getMaxCardCount() {
		return maxCardCount;
	}
	
	public void addCard(Card card){
		if(liste.size() == maxCardCount){
			throw new IllegalStateException("Ikke lov med så mange kort 2");
		}
		liste.add(card);
	}


	

}
