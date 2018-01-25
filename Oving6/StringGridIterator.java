package oving6;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StringGridIterator implements Iterator<String>{
	
	int rowpos;
	int colpos;
	boolean rowMajor;
	StringGrid sg;
	
	public StringGridIterator(StringGrid sg, boolean rowMajor){
		this.sg = sg;
		this.rowMajor = rowMajor;
		colpos = 0;
		rowpos = 0;
		
	}

	@Override
	public boolean hasNext() {
		return rowpos < sg.getRowCount() && colpos < sg.getColumnCount();
	}

	@Override
	public String next() {
		if (hasNext()){
			String element = sg.getElement(rowpos, colpos);
			if (rowMajor){
				if (colpos == sg.getColumnCount()-1){
					rowpos+= 1;
					colpos = 0;
				}
				else{
					colpos+=1;
				}
			}
			
			if (!rowMajor){
				if (rowpos == sg.getRowCount()-1){
					rowpos = 0;
					colpos+=1;
				}
				else{
					rowpos+=1;
				}	
			}
			return element;
		}
		throw new NoSuchElementException();
	}

	@Override
	public void remove(){
		throw new UnsupportedOperationException();
		
	}
	
}
