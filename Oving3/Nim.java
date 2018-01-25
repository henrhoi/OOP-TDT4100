package oving3;
import java.util.HashMap;

public class Nim {
	
	HashMap<Integer,Integer> piles = new HashMap<Integer,Integer>();
	
	public Nim(){
		piles.put(0, 10);
		piles.put(1, 10);
		piles.put(2, 10);
	}
	
	public Nim(int pileSize){
		piles.put(0, pileSize);
		piles.put(1, pileSize);
		piles.put(2, pileSize);
	}
	
	public void removePieces(int number, int targetPile){
		boolean over = isGameOver();
		if (over == true){
			throw new IllegalStateException("Game is over");
		}
		boolean valid = isValidMove(number, targetPile);
		if (valid == false) {
			throw new IllegalArgumentException("Not a valid move");
		}
		else{
			piles.put(targetPile, piles.get(targetPile)-number);
		}
	}
	
	public boolean isGameOver(){
		if (piles.get(0) == 0){
			return true;
		}
		else if (piles.get(1) == 0){
			return true;
		}
		else if (piles.get(2) == 0){
			return true;
		}
		return false;
	}
	
	public boolean isValidMove(int number, int targetPile){
		if (number < 1){
			return false;
		}
		else if((targetPile != 0) && (targetPile != 1) && (targetPile != 2)){
			return false;
		}
		else if(number > piles.get(targetPile)){
			return false;
		}
		return true;
	}
	
	public int getPile(int targetPile){
		return piles.get(targetPile);
	}
	
	public String toString(){
		String a = String.format("Pile 1: %s, Pile 2: %s, Pile 3: %s", piles.get(0),piles.get(1),piles.get(2));
		return a;
	}
	public static void main(String[] args){
		Nim kissa = new Nim(5);
		System.out.println(kissa);
		kissa.removePieces(5, 0);
		System.out.println(kissa);
	}
}
