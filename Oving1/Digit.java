package oving1;

public class Digit {
	
	int numberSystem;
	int value;
	
	public Digit(int numberS){
		numberSystem = numberS;
		value = 0;
	}
	
	public int getValue(){
		return value;
	}
	
	public boolean increment(){
		value+=1;
		if (value == numberSystem){
			value = 0;
			return true;
		}
		else {
			return false;	
		}
	}
	
	public int getBase(){
		return numberSystem;
	}
	
	public String toString(){
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int index = value - 10;
		if (index<0){
			return String.format("%s", value);
		}
		else {
			char character = alphabet.charAt(index);
			return String.format("%s",character);
		}
	}
	
	public static void main(String[] args){
		Digit number = new Digit(16);
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		number.increment();
		System.out.println(number);
	}
	
}
