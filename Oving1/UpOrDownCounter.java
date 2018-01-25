package oving1;

public class UpOrDownCounter {
	
	int start;
	int end;
	
	public void checkValues(int start, int end) throws IllegalArgumentException {
		if (start == end){
			throw new IllegalArgumentException("Start og slutt kan ikke være like");
		}
		
	}
	
	public UpOrDownCounter(int start, int end){
		checkValues(start, end);
		this.start = start;
		this.end = end;
	}
	
	public int getCounter(){
		return start;
		
	}
	
	public boolean count(){
		if (start > end) {
			start -=1;
			if (start == end){
				return false;
			}
			return true;
		}
		else if (start < end) {
			start +=1;
			if (start == end) {
				return false;
			}
			return true;
			
		}
		return false;
	}

}
