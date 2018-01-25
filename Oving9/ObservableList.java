package oving9;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableList {
	protected List<Object> results;
	protected List<ObservableListListener> listeners;
	
	public ObservableList(){
		results = new ArrayList<>();
		listeners = new ArrayList<>();
		
	}
	public abstract boolean acceptsElement(Object o);
	
	public int size(){
		return results.size();
	}
	
	public Object getElement(int n){
		if (n>=0 || n<results.size()){
			return results.get(n);
		}else{
			throw new IllegalArgumentException("No element at this index");
		}
	}
	
	public void addElement(int n, Object o){
		if (n<0 || n>results.size()-1){
			throw new IndexOutOfBoundsException("Not legal index");
		}
		if (acceptsElement(o)){
			results.add(n,o);
			notifyListeners(n);
		}
		else{
			throw new IllegalArgumentException("Not legal object");
			
		}
	}
	
	public void addElement(Object o){
		if (acceptsElement(o)){
			results.add(o);			
		}
		else{
			throw new IllegalArgumentException("Not legal object");
			
		}
	}
	
	void removeElement(int n){
		if (n<0 || n>results.size()-1){
			throw new IndexOutOfBoundsException("Not legal index");
		}
		results.remove(n);	
		}
	
	public void addObservableListListener(ObservableListListener listener){
		if(!listeners.contains(listener)){
			listeners.add(listener);
		}
	}
	
	public void removeObservableListListener(ObservableListListener listener){
		if(listeners.contains(listener)){
			listeners.remove(listener);
		}
	}
	
	public void notifyListeners(int n){
		for (ObservableListListener lister : listeners){
			lister.listChanged(this, n);
		}
	}
	
	
	
	


}
