package oving8;

public interface StockListener {
	void stockPriceChanged(Stock stock, double old, double now);

}
