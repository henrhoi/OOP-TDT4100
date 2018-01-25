package Restaurantoppgave;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Restaurant {
	
	private double income;
	private Menu foodMenu;
	private Menu drinkMenu;
	private List<Collection<Guest>> queue;	
	private Collection<Table> availableTables;
	private Collection<Table> occupiedTables;
	private List<Waiter> waiters;
	private int pos = 0;
	
		
	public Restaurant(){
		income = 0;
		this.availableTables = new ArrayList<>();
		this.occupiedTables = new ArrayList<>();
		this.waiters = new ArrayList<>();
		this.foodMenu = new Menu();
		this.drinkMenu = new Menu();
		
	}
	
	public void addWaiter(Waiter waiter){
		waiters.add(waiter);
	}
	
	public void addTable(Table table){
		 availableTables.add(table);
	}
	public void setFoodMenu(Menu menu){
		this.foodMenu = menu;
	}
	
	public void setDrinkMenu(Menu menu){
		this.drinkMenu = menu;
	}
	
	public void addtoQueue(Collection<Guest> guests){
		int seated = 0;
		for (Table table : availableTables){
			if(table.getSize() >= guests.size()){
				table.addGuest(guests);
				this.changeTableState(table);
				this.addTableToWaiter(table);
				seated++;
				break;
			}
		}
		if (seated == 0){
			queue.add(guests);			
		}
	}
	
	public void changeTableState(Table table){
		if (availableTables.contains(table)){
			availableTables.remove(table);
			occupiedTables.add(table);
		}
		else if (occupiedTables.contains(table)){
			occupiedTables.remove(table);
			availableTables.add(table);
		}
		
	}
	
	public double getIncome() {
		return this.income;
	}
	
	
	public void takePayment(int payment, Table table){
		income +=payment;
		changeTableState(table);
		addGuests();
	}

	private void addGuests() {
		for (Collection<Guest> guests : queue){
			for (Table table : availableTables){
				if(table.getSize() >= guests.size()){
					table.addGuest(guests);
					this.changeTableState(table);
					this.addTableToWaiter(table);
					break;
				}				
			}
		}
	}

	public Menu getFoodMenu() {
		return this.foodMenu;
	}

	public Menu getDrinkMenu() {
		return this.drinkMenu;
	}
	
	public void addTableToWaiter(Table table){
		Waiter waiter = waiters.get(pos);
		waiter.addTable(table);
		this.pos++;
		
		if(pos == waiters.size()){
			this.pos = 0;
		}
	}
	
	public Menu loadMenu(String fileName) throws IOException{
		Menu menu = new Menu();
		
		String filePath = new File("").getAbsolutePath();
		filePath += "/src/Restaurantoppgave/" + fileName;
		
		Scanner scanner = new Scanner(new File(filePath));
		//Vet at hvert Item kommer i 3 linjer, så når vi skjekker etter nextLine så vet vi at det er 2 etterfølgede linjer
		while (scanner.hasNextLine()){
			String name = scanner.nextLine();
			String line2 = scanner.nextLine();
			int price = Integer.parseInt(line2.split(" ")[0]);
			String[] allergies = line2.split(" ")[1].split(",");
			
			
			menu.addItem(new Item(name, price, allergies));
			scanner.nextLine();
		}
		scanner.close();
		return menu;
	}
	
	
	public static void main(String[] args) throws IOException {
		Restaurant res = new Restaurant();
		Menu meny = res.loadMenu("Meny.txt");
		res.setFoodMenu(meny);
		
		Table table = new Table(3);
		res.addTable(table);
		Waiter vilde = new Waiter(res, "Vilde");
		//Vilde som servitør
		res.addWaiter(vilde);
		Guest henrik = new Guest();
		List<Guest> gjester = Arrays.asList(henrik);
		res.addtoQueue(gjester);
		
		Item item1 = new Item("Pølse",200, "Gluten");
		Item item2 = new Item("Pølser", 300, "Melk");
		vilde.takeOrder(henrik, item1);
		vilde.takeOrder(henrik, item2);
		vilde.printReceipt(henrik, System.out);
		
		
		
		
		
	}
}
	
	


	

