package Restaurantoppgave;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Waiter {
	
	private Restaurant restaurant;
	private String name;
	private List<Table> tables;
	private Menu foodMenu;
	private Menu drinkMenu;
	
	
	public Waiter(Restaurant restaurant, String name){
		this.restaurant = restaurant;
		this.name = name;
		this.foodMenu = restaurant.getFoodMenu();
		this.drinkMenu = restaurant.getDrinkMenu();
		this.tables = new ArrayList<>();

	}
	
	public String getName(){
		return this.name;
	}
	
	public void addTable(Table table){
		if (!tables.contains(table)){
			tables.add(table);
		}
	}
	
	public void addtoQueue(Collection<Guest> guests){
		restaurant.addtoQueue(guests);
	}
	
	public void takePayment(Table table){
		int total = 0;
		for (Guest guest : table.getGuests()){
			total+= guest.getCheck();
		}
		table.removeGuests();
		tables.remove(table);
		restaurant.takePayment(total, table);
	}

	
	public void takeOrder(Guest guest, Item...items){
		for (Item i : Arrays.asList(items)){
			guest.addToCheck(i.getPrice());
			guest.addOrder(i);
		}
	}
	
	public void printReceipt(Guest guest, OutputStream os) throws IOException{
		List<Item> orders = guest.getOrders();
		PrintWriter pw = new PrintWriter(os);
		pw.println("RECEIPT:");
		pw.println("Waiter: "+this.getName()+"\n");
		pw.println("Order:			Pris:");
		pw.println("--------------------------------");
		for (Item i : orders){
			pw.println(i.getName() + "			"+i.getPrice()+",-");
		}
		pw.println("--------------------------------");
		pw.println("Sum: 			"+ guest.getCheck());
		pw.println("--------------------------------");
		pw.flush();
		pw.close();
		
	}
	
	

}
