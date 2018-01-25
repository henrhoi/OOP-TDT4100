package oving8;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	private String ticker;
	private double price;
	private List<StockListener> listeners;
	
	public Stock(String ticker, double price){
		this.ticker = ticker;
		this.price = price;
		listeners = new ArrayList<>();
	}
	
	public void setPrice(double price){
		if (price < 0){
			throw new IllegalArgumentException("Price must be over 0");
		}
		for(StockListener lister : listeners){
			lister.stockPriceChanged(this, this.price, price);
		}
		this.price = price;
		
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void addStockListener(StockListener StockListener){
		listeners.add(StockListener);
	}
	
	public void removeStockListener(StockListener StockListener){
		listeners.remove(StockListener);
	}
	
	

}
