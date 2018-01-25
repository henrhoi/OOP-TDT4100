package Restaurantoppgave;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Menu {
	
	private List<Item> menu;
	
	public Menu(Item...items){
		menu = new ArrayList<>(Arrays.asList(items));
	}
	
	public Menu(){
		menu = new ArrayList<>();
	}
	
	public List<Item> getMenu(){
		return this.menu;
	}
	
	
	public void addItem(Item i){
		if (!menu.contains(i)){
			menu.add(i);
		}
		
	}
	
	public void removeItem(Item i){
		if (menu.contains(i)){
			menu.remove(i);
		}	
	}
}
