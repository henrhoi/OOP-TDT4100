package Restaurantoppgave;

import java.util.ArrayList;
import java.util.List;

public class Guest {
	
	private int check;
	private List<Item> orders;
	
	public Guest(){
		check = 0;	
		orders = new ArrayList<>();
	}
	
	public void addToCheck(int amount){
		if (amount>0){
			check+=amount;
		}
	}
	
	public int getCheck(){
		return this.check;
	}
	
	public void tip(int amount){
		if (amount > 0){
			check+=amount;			
		}
	}
	
	public void addOrder(Item item){
		orders.add(item);
		
	}
	
	public List<Item> getOrders(){
		return this.orders;
	}
	
}
