package oving3;
import java.util.ArrayList;

import oving3.Card;

public class CardDeck {
	ArrayList<String> deck;
	
	public CardDeck(int n){
		if (n>13 || n<1){
			throw new IllegalArgumentException("Cannot be lower than 1 or higher than 13");
		}
		ArrayList<String> deck = new ArrayList<>(n*4);
		for (int i = 1; i <= n; i++){
			Card card = new Card('S', i);
			String a = card.toString();
			deck.add(a);
		}
		for (int i = 1; i <= n; i++){
			Card card = new Card('H', i);
			String a = card.toString();
			deck.add(a);
		}
		for (int i = 1; i <= n; i++){
			Card card = new Card('D', i);
			String a = card.toString();
			deck.add(a);
		}
		for (int i = 1; i <= n; i++){
			Card card = new Card('C', i);
			String a = card.toString();
			deck.add(a);
		}
		this.deck = deck;
	}
	
	public int getCardCount(){
		return deck.size();
	}
	
	public String getCard(int n){
		if (n>deck.size() && n< deck.size()){
			throw new IllegalArgumentException("Must be a valid cardnumber");
		}
		String c = deck.get(n-1);
		return c;
	}
	
	public static void main(String[] args) {
		CardDeck axels = new CardDeck(5);
		int a = axels.deck.size();
		System.out.println(a);
		CardDeck henriks = new CardDeck(10);
		int b = henriks.getCardCount();
		System.out.println(b);
		String shit = henriks.getCard(1);
		System.out.println(shit);
	}

}
