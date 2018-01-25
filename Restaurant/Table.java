package Restaurantoppgave;

import java.util.ArrayList;

import java.util.Collection;


public class Table {
	private int size;
	private Collection<Guest> guests;
	
	
	public Table (int size){
		this.size = size;
		guests = new ArrayList<>();
	}
	
	public void addGuest(Collection<Guest> guests){
		this.guests = guests;
	}
	
	
	
	public int getSize(){
		return this.size;
	}
	
	public Collection<Guest> getGuests(){
		return guests;
	}
	
	public void removeGuests(){
		this.guests = new ArrayList<>();
	}
	

}
