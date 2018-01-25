package oving3;

public class Card {
	
	private char suit;
	private int face;
	
	public Card(char suit, int face){
		checkCard(suit, face);
		this.suit = suit;
		this.face = face;
	}
	
	private void checkCard(char suit, int face){
		char a = suit;
		if (a != 'S' && a != 'H' && a != 'D' && a != 'C' ){
			throw new IllegalArgumentException("Must be S, H, D or C");
		}
		else if (face > 13 || face < 1){
			throw new IllegalArgumentException("Must be a number between 1 and 13");
		}
	}
	
	public char getSuit(){
		return suit;
	}
	
	public int getFace(){
		return face;
	}
	
	public String toString(){
		return String.format("%s%s", suit,face);
	}
	
	public static void main(String[] args){
		Card card = new Card('S',3);
		String a = card.toString();
		System.out.println(a);
	}

}
