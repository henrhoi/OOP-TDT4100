package oving8;

import java.util.ArrayList;
import java.util.List;

public class StockIndex implements StockListener{
	
	private String name;
	private List<Stock> Stocks;
	private double index;

	
	public StockIndex(String name, Stock...Stocks ){
		this.name = name;
		this.Stocks = new ArrayList<>();
		if (Stocks.length == 0){
			this.index = 0;
		}
		else{
			this.index = 0;
			for (int i =0; i<Stocks.length; i++){
				this.Stocks.add(Stocks[i]);
				this.index += Stocks[i].getPrice();
			}
		}
	}
	
	public void addStock(Stock stock){
		if(!Stocks.contains(stock)){
			this.Stocks.add(stock);
			this.updateIndex();			
		}
	}
	
	public void removeStock(Stock stock){
		if (Stocks.contains(stock)){
			this.Stocks.remove(stock);
			this.updateIndex();			
		}
	}
	
	public double getIndex(){
		return this.index;
	}
	
	public void updateIndex(){
		this.index = 0;
		for (Stock stock : Stocks){
			this.index += stock.getPrice();
		}
	}
	
	@Override
	public void stockPriceChanged(Stock stock, double old, double now) {
		if(Stocks.contains(stock)){
			Stock stock2 = new Stock(stock.getTicker(), now);
			Stocks.remove(stock);
			Stocks.add(stock2);
		}
		updateIndex();
	}

}
