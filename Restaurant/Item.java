package Restaurantoppgave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item {
	
	private List<String> allergies;
	private int price;
	private String name;
	
	
	public Item(String name, int price, String...strings){
		if (strings[0].equals("None")){
			allergies = new ArrayList<>();
		}
		else{allergies = new ArrayList<>(Arrays.asList(strings));}
		this.price = price;
		this.name = name;	
	}
	

	public List<String> getAllergies() {
		return allergies;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}
	
	public String toString(){
		String out = "";
		
		out += this.getName() + ": " + this.getPrice() +" - ";
		for (String s : allergies){
			out += s + " ";
		}
		return out.trim();
	}

}
