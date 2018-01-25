package oving9;

public class ObservableHighscoreList extends ObservableList{
	
	private int maxSize;
	
	public ObservableHighscoreList(int maxSize){
		super();
		this.maxSize = maxSize;
	}
	
	public int size(){
		return super.size();
	}
	
	
	public void addResult(int n){
		if(super.results.isEmpty()){
			super.results.add(n);
			this.notifyListeners(0);
		}
		
		else if (n<(int)super.results.get(0)){
			results.add(0, n);
			this.notifyListeners(0);
			if(results.size() > maxSize){
				results.remove(maxSize);
			}
		}
		else if (super.results.size()<maxSize && n>=(int)super.results.get(results.size()-1)){
			results.add(results.size(), n);
			this.notifyListeners(results.size()-1);
		}
		else{
			int k =  results.size() -2;
			for (int i = results.size()-1; i>0; i--){
				if (n == (int)super.results.get(i)){
					results.add(i+1, n);
					this.notifyListeners(i+1);
					if(results.size() > maxSize){
						results.remove(maxSize);
					}
					break;
					
				}
				else if (n>=(int)super.results.get(k) && n<(int)super.results.get(i)){
					super.addElement(i, n);
					if(results.size() > maxSize){
						results.remove(maxSize);
					}
					break;

				}
				k--;
			}			
		}
	}
	
	public void addObservableListListener(ObservableListListener listener){
		super.addObservableListListener(listener);
	}
	
	public void removeObservableListListener(ObservableListListener listener){
		super.removeObservableListListener(listener);
	}

	@Override
	public boolean acceptsElement(Object o) {
		if (o instanceof Integer){
			return true;
		}
		return false;
	}
	
	

}
