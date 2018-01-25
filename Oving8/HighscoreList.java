package oving8;

import java.util.ArrayList;
import java.util.List;

public class HighscoreList {
	int maxSize;
	List<Integer> results;
	List<HighscoreListListener> listeners;
	
	public HighscoreList(int maxSize){
		this.maxSize = maxSize;
		results = new ArrayList<>();
		listeners = new ArrayList<>();
	}
	
	public int size(){
		return results.size();
	}
	
	public int getElement(int n){
		if(!results.isEmpty() && n<results.size() && n>=0){
			return results.get(n);
		}
		else{
			throw new IllegalArgumentException("List is empty or n is to big or below 0");
		}
	}
	
	public void addResult(int n){
		if(results.isEmpty()){
			results.add(n);
			this.notifyListeners(0);
		}
		
		else if (n<results.get(0)){
			results.add(0, n);
			this.notifyListeners(0);
			if(results.size() > maxSize){
				results.remove(maxSize);
			}
		}
		else if (results.size()<maxSize && n>=results.get(results.size()-1)){
			results.add(results.size(), n);
			this.notifyListeners(results.size()-1);
		}
		else{
			int k =  results.size() -2;
			for (int i = results.size()-1; i>0; i--){
				if (n == results.get(i)){
					results.add(i+1, n);
					this.notifyListeners(i+1);
					if(results.size() > maxSize){
						results.remove(maxSize);
					}
					break;
					
				}
				else if (n>=results.get(k) && n<results.get(i)){
					results.add(i, n);
					this.notifyListeners(i);
					if(results.size() > maxSize){
						results.remove(maxSize);
					}
					break;

				}
				k--;
			}			
		}
	}
	
	public void addHighscoreListListener(HighscoreListListener HighscoreListener){
		if (!listeners.contains(HighscoreListener)){
			listeners.add(HighscoreListener);			
		}
	}
	
	public void removeHighscoreListListener(HighscoreListListener HighscoreListener){
		if (listeners.contains(HighscoreListener)){
			listeners.remove(HighscoreListener);			
		}
	}
	
	public void notifyListeners(int n){
		for (HighscoreListListener lister : listeners){
			lister.listChanged(this, n);
		}
	}
	
	
	
	
	
	

}
