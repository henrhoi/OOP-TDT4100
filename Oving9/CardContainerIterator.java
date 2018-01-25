package oving9;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CardContainerIterator implements Iterator<Card>{
	int pos = 0;
	CardContainer obj;

	public CardContainerIterator(CardContainer ccobject) {
		this.obj = ccobject;
	}

	@Override
	public boolean hasNext() {
		return pos < obj.getCardCount();
	}

	@Override
	public Card next() {
		if (!this.hasNext()){
			throw new NoSuchElementException();
		}
		Card nextItem = obj.getCard(pos);
		pos++; // index = index + 1
		return nextItem;
	}
	

}
